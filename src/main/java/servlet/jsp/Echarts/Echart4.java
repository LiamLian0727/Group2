package servlet.jsp.Echarts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 连仕杰
 */
@WebServlet(urlPatterns = "/Echart4")
public class Echart4 extends HttpServlet {
    private static final String URL = "http://localhost:8080/Group2/analyze/jsp4.jsp";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stauts = "error";
        stauts = "success";
        response.sendRedirect(URL+"?status=" + stauts);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public static void main(String[] args) {

    }
}