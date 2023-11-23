package ru.vsu.cs.dvis.servlets.create;

import ru.vsu.cs.dvis.Album;
import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/createAlbum")
public class CreateAlbumServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UUID id = UUID.fromString(request.getParameter("id"));
        String name = request.getParameter("name");
        UUID userId = UUID.fromString(request.getParameter("userId"));

        Album album = new Album(id, userId, name);
        crudService.createAlbum(album);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
