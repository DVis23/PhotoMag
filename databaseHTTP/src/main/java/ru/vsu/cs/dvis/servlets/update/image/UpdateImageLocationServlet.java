package ru.vsu.cs.dvis.servlets.update.image;

import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/updateImageLocation")
public class UpdateImageLocationServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UUID id = UUID.fromString(request.getParameter("id"));
        String location = request.getParameter("location");

        crudService.updateImageLocation(id, location);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}