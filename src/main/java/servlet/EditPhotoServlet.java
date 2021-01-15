package servlet;
/*
  @author JwZheng
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

@WebServlet(name = "EditPhotoServlet", value = "/EditPhotoServlet")
public class EditPhotoServlet extends HttpServlet {
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

        Long id = 0L;
        Long masterId = user.getId();

        String name = null;
        String url = null;

        try {
            id = Long.valueOf(request.getParameter("PhotoId"));
            name = request.getParameter("PhotoName");
            url = request.getParameter("PhotoUrl");
        } catch (Exception ignored) {
        }

        Photo photo = new Photo(id, name, url);
        photo.setMasterId(masterId);

        if (id == 0L) {
            PhotoDao.insertPhoto(photo);
        } else if (name != null) {
            PhotoDao.updatePhoto(photo);
        } else {
            PhotoDao.deletePhoto(photo);
        }

        request.getRequestDispatcher("/ShowPhotoServlet").forward(request, response);
    }
}
