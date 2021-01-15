package servlet; /**
 * @author JwZheng
 */

import beans.Comment;
import beans.User;
import dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "AddCommentsServlet", value = "/AddCommentsServlet")
public class AddCommentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        Long id = Long.valueOf(request.getParameter("photoId"));

        String content = request.getParameter("content");

        String flag = "00";
        request.setAttribute("flag", flag);

        Comment comment = new Comment(id, user.getName(), content);
        CommentDao.addComment(comment);

        request.getRequestDispatcher("AddPhotoCollectionServlet").forward(request, response);
    }
}
