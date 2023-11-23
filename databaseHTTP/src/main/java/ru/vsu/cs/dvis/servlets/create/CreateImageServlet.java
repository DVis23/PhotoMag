package ru.vsu.cs.dvis.servlets.create;

import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;
import ru.vsu.cs.dvis.Image;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/createImage")
public class CreateImageServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UUID id = UUID.fromString(request.getParameter("id"));
        String location = request.getParameter("location");
        UUID albumId = UUID.fromString(request.getParameter("albumId"));

        Image image = new Image(id, albumId, location);
        crudService.createImage(image);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}