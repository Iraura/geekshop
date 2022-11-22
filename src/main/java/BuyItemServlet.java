import entities.Client;
import entities.Element;
import entities.Order;
import entities.Product;
import liquibase.pro.packaged.D;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/buy_item")
public class BuyItemServlet extends HttpServlet {
    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("productId"));
        Integer currentUserId = (Integer) req.getSession().getAttribute("currentUserId");
        Client client = javaBean.getClient(currentUserId);
        List<Order> orderList = javaBean.getOrdersByUserId(currentUserId);
        Optional<Order> currOrder = orderList.stream().filter(order -> order.getStatus().equals("In Progress")).findFirst();
        Product product = javaBean.findProductById(id);
        if(currOrder.isPresent()){
            Element element = new Element();
            element.setCount(1);
            element.setOrder(currOrder.get());
            element.setProduct(product);
            javaBean.persistElement(element);
        }
        else {
            Order order = new Order();
            order.setClient(client);
            order.setStatus("In Progress");
            order.setCost(0);
            order.setOrderDate(new Date());
            order.setDeliveryDate(new Date());
            javaBean.persistOrder(order);
            req.getSession().setAttribute("currentOrderId", order.getId());
            Element element = new Element();
            element.setCount(1);
            element.setOrder(order);
            element.setProduct(product);
            javaBean.persistElement(element);
        }
        resp.sendRedirect("src/items");

    }
}
