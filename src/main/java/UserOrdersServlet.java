import dto.ShoppingCardElementRecord;
import entities.Element;
import entities.Order;
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

@WebServlet("src/my_orders")
public class UserOrdersServlet extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer clientId = (Integer) req.getSession().getAttribute("currentUserId");
        List<Order> orders  = javaBean.getOrdersForClient(clientId);
        if(!orders.isEmpty()) {
            orders = orders.stream().filter(order -> !order.getStatus().equals("In Progress")).collect(Collectors.toList());
            req.setAttribute("orders", orders);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("my_orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}