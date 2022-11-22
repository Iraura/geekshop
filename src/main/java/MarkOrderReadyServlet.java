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


@WebServlet("/markOrderReady")
public class MarkOrderReadyServlet extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = javaBean.findOrderById(Integer.parseInt(req.getParameter("orderId")));
        order.setStatus("Issued");
        javaBean.saveOrder(order);
        resp.sendRedirect("src/main.jsp");
    }
}
