import entities.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/test")
public class App extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client client = javaBean.getClient();

        resp.getWriter().println(client.getFirstName());

        client.setFirstName("CHANGED FIRST NAME");

        resp.getWriter().println(client.getFirstName());

        javaBean.saveOrder(new Order(
                client,
                "test1",
                0,
                new Date(),
                new Date()
        ));

        Client secondClient = new Client(
                "Тестовый",
                "Тестович",
                "Тестер",
                "123",
                "test",
                "111",
                new Date(),
                "test@mail",
                "home"
        );

        Order testOrder = new Order(
                secondClient,
                "test2",
                0,
                new Date(),
                new Date()
        );


        javaBean.persistOrder(testOrder);

        Category testCategory = new Category(
                "My Category",
                "тестовая категория"
        );

        javaBean.persistCategory(testCategory);

        Section testSection = new Section(
                "My Section",
                "тестовая секция"
        );

        javaBean.persistSection(testSection);

        Product testProduct = new Product(
                "test",
                "descript",
                100,
                100,
                testCategory,
                testSection,
                "фоточка"
        );

        javaBean.saveProduct(testProduct);

        Element testElem = new Element(
                123,
                testOrder,
                testProduct
        );

        testOrder.addElement(testElem);
        javaBean.saveElement(testElem);

        PromoCode testPromo = new PromoCode(
                "testPromo",
                50,
                new Date(),
                new Date(),
                5
        );

        javaBean.persistPromoCode(testPromo);

        Admin testAdmin = new Admin(
                "Тестовый",
                "Тестович",
                "Тестер",
                "123",
                "test",
                "1111",
                "Admin",
                "10 лет",
                30000
        );

        javaBean.persistAdmin(testAdmin);

        javaBean.deleteOrder(testOrder);

        try {
            resp.getWriter().println("Hello from servlet");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
