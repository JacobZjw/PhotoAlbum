package servlet; /**
 * @author JwZheng
 */

import beans.Comment;
import beans.Photo;
import beans.User;
import dao.CommentDao;
import dao.PhotoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddPhotoCollectionServlet", value = "/AddPhotoCollectionServlet")
public class AddPhotoCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        Long photoId = Long.valueOf(request.getParameter("photoId"));
        Long userId;
        userId = user.getId();

        String flag = request.getParameter("flag");
        if (flag == null) {
            flag = (String) request.getAttribute("flag");
        }
        if ("00".equals(flag)) {
            Photo photo = PhotoDao.getPhotoById(photoId);
            List<Comment> comments = CommentDao.getComments(photoId);
            request.setAttribute("LargePhoto", photo);
            request.setAttribute("Comments", comments);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        } else if ("01".equals(flag)) {
            PhotoDao.collectAPhoto(photoId, userId);
            request.getRequestDispatcher("PhotoWallServlet").forward(request, response);
        } else if ("11".equals(flag)) {
            PhotoDao.cancelCollectionAPhoto(photoId, userId);
            request.getRequestDispatcher("ShowPhotoServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("PhotoWallServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
