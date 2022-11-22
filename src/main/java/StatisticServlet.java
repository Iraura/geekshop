
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@WebServlet("/statistic")
public class StatisticServlet extends HttpServlet {

    @EJB
    JavaBean javaBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File statisticFile = new File("C:\\Users\\iraur\\Desktop\\GeekShop\\StatFilesDir", "Statistic.txt");
        if(statisticFile.isFile()){
            FileWriter writer = new FileWriter(statisticFile.getAbsolutePath(),false);
            List<Object[]> byProductCount = javaBean.statisticQueryByProductCount();
            List<Object[]> byProductPrice = javaBean.statisticQueryByProductPrice();
            writer.write("Анализ популярности товаров" + "\n");
            for (Object[] obj: byProductCount) {
                writer.write(" id: " + obj[0].toString());
                writer.write(" name: " + obj[1].toString());
                writer.write(" count: " + obj[2].toString());
                writer.write("\n");
            }
            writer.write("Анализ доходности товаров" + "\n");
            for (Object[] obj: byProductPrice) {
                writer.write(" id: " + obj[0].toString());
                writer.write(" name: " + obj[1].toString());
                writer.write(" total profit: " + obj[2].toString());
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }
        resp.sendRedirect("src/lk_admin");
    }
}
