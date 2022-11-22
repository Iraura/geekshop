import entities.Category;
import entities.Product;
import entities.Section;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/src/items")
public class ItemsServlet extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = 0;
        Integer sectionId = 0;
        if (req.getParameter("categoryId") != null) {
            categoryId = Integer.parseInt(req.getParameter("categoryId"));
        }else {
            if(req.getSession().getAttribute("currentCategoryId") != null){
                categoryId = (Integer) req.getSession().getAttribute("currentCategoryId");
            }
        }
        if (req.getParameter("sectionId") != null) {
            sectionId = Integer.parseInt(req.getParameter("sectionId"));
        }
        else{
            if(req.getSession().getAttribute("sectionId") != null){
                sectionId = (Integer) req.getSession().getAttribute("sectionId");
            }
        }

        List<Product> products = javaBean.getProducts();
        if (categoryId != 0) {
            Integer finalCategoryId = categoryId;
            products = products.stream()
                    .filter(product -> product.getCategory().getId().equals(finalCategoryId))
                    .collect(Collectors.toList());
            req.getSession().setAttribute("currentCategoryId", categoryId);
        }
        if (sectionId != 0) {
            Integer finalSectionId = sectionId;
            products = products.stream()
                    .filter(product -> product.getSection().getId().equals(finalSectionId))
                    .collect(Collectors.toList());
            req.getSession().setAttribute("currentSectionId", sectionId);
        }
        req.setAttribute("products", products);

        List<Section> sections = javaBean.getSections();
        req.setAttribute("sections", sections);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("items.jsp");
        requestDispatcher.forward(req, resp);
    }
}
