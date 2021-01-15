package servlet; /**
 * @author JwZheng
 */

import beans.Photo;
import beans.User;
import dao.PhotoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "ShowPhotoServlet", value = "/ShowPhotoServlet")
public class ShowPhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        List<Photo> list = PhotoDao.queryPhoto(user);
        request.setAttribute("PhotoList", list);

        List<Photo> favList = PhotoDao.queryFavPhoto(user.getId());
        request.setAttribute("FavList", favList);

        request.getRequestDispatcher("Album.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
