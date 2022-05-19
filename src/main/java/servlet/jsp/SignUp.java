package servlet.jsp;

import model.User;
import servlet.user.IUserService;
import servlet.user.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 连仕杰
 */
@WebServlet(urlPatterns = "/SignUp")
public class SignUp extends HttpServlet {

    static final String URL = "http://localhost:8080/Group2/index.html";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            IUserService userService = new UserServiceImpl();
            User user = new User();
            String name = request.getParameter("UsernameSU");
            boolean equals = request.getParameter("PasswordSU").equals(request.getParameter("ConfirmPassword"));
            boolean exit = userService.userIsExist(name);

            if (equals && !exit && !"".equals(name)) {

                user.setName(name);
                user.setPassword(request.getParameter("PasswordSU"));
                user.setEmail(request.getParameter("EmailSU"));
                userService.saveUser(user);
                response.sendRedirect( URL + "?status=success");
            } else if (!equals) {
                response.sendRedirect( URL + "?error=notEqual");
            } else if (exit) {
                response.sendRedirect( URL + "?error=hasExit");
            } else {
                response.sendRedirect( URL + "?error=UsernameNull");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

}
