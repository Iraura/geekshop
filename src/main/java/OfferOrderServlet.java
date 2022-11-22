import entities.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/offerOrder")
public class OfferOrderServlet extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = javaBean.findOrderById((Integer) req.getSession().getAttribute("currentOrderId"));
        int totalCost = 0;
        for(Element element : order.getElements() ){
            element.setCount(Integer.parseInt(req.getParameter(element.getCode().toString())));
            totalCost += element.getCount() * element.getProduct().getPrice();
            javaBean.saveElement(element);
        }
        order.setStatus("Accepted");
        order.setCost(totalCost);
        javaBean.saveOrder(order);
        req.getSession().removeAttribute("currentOrderId");
        resp.sendRedirect("src/lk_user");
    }
}
