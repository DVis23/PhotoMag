package ru.vsu.cs.dvis.servlets.update.album;

import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/updateAlbumName")
public class UpdateAlbumNameServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UUID id = UUID.fromString(request.getParameter("id"));
        String name = request.getParameter("name");

        crudService.updateAlbumName(id, name);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
