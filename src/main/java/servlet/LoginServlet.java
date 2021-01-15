package servlet;
/*
  @author JwZheng
 */

import beans.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    static final String emailPattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("UserName");
        String password = request.getParameter("Password");

        User loginUser = new User();
        if (Pattern.matches(emailPattern, name)) {
            loginUser.setEmail(name);
        } else {
            loginUser.setName(name);
        }
        loginUser.setPassword(password);

        switch (UserDao.login(loginUser)) {
            case LOGIN_SUCCESS:
                System.out.println(loginUser.getName() + " LOGIN_SUCCESS!");
                HttpSession session = request.getSession();
                session.invalidate();
                session = request.getSession(true);
                session.setAttribute("User", loginUser);
                request.getRequestDispatcher("/PhotoWallServlet").forward(request, response);
                break;
            case WRONG_NAME:
                System.out.println("WRONG_NAME！");
                out.println("<html><body>");
                out.println("<h1>" + "用户名不存在" + "</h1>");
                out.println("<a href=\"login.jsp\">重新登录</a>");
                out.println("</body></html>");
                break;
            case WRONG_PASSWORD:
                System.out.println("WRONG_PASSWORD！");
                out.println("<html><body>");
                out.println("<h1>" + "密码错误" + "</h1>");
                out.println("<a href=\"login.jsp\">重新登录</a>");
                out.println("</body></html>");
                break;
            default:
                System.out.println("default");
                response.sendRedirect("login.jsp");
                break;
        }

    }
}
