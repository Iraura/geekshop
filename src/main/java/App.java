import entities.Client;
import entities.Order;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/test")
public class App extends HttpServlet{

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client client = javaBean.getClient();

        javaBean.saveOrder( new Order(
                client,
                "test",
                0,
                new Date(),
                new Date()
        ));

        try {
            resp.getWriter().println("Hello from servlet");
        }catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }
}
