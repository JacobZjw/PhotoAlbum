package servlet;

import beans.User;
import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("UserName");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");

        User newUser = new User(name, password, email);

        switch (UserDao.register(newUser)) {
            case REGISTER_SUCCESS:
                System.out.println("注册成功");
                response.sendRedirect("login.jsp");
                break;
            case REPETITIVE_EMAIL:
                System.out.println("邮箱重复");
                out.println("<html><body>");
                out.println("<h1>" + "邮箱已存在" + "</h1>");
                out.println("<a href=\"register.jsp\">重新注册</a>");
                out.println("</body></html>");
                break;
            case REPETITIVE_NAME:
                System.out.println("用户名重复");
                out.println("<html><body>");
                out.println("<h1>" + "用户名已存在" + "</h1>");
                out.println("<a href=\"register.jsp\">重新注册</a>");
                out.println("</body></html>");
                break;
            default:
                break;
        }

    }
}
