package ru.vsu.cs.dvis.servlets.read.album;

import com.google.gson.Gson;
import ru.vsu.cs.dvis.Album;
import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/readAlbumByUserId")
public class ReadAlbumByUserIdServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID userId = UUID.fromString(request.getParameter("userId"));
        List<Album> albums = crudService.readAlbumByUsersId(userId);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(albums));
    }
}