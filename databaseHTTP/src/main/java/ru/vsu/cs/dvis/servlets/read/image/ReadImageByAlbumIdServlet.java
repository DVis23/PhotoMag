package ru.vsu.cs.dvis.servlets.read.image;

import com.google.gson.Gson;
import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;
import ru.vsu.cs.dvis.Image;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/readImageByAlbumId")
public class ReadImageByAlbumIdServlet extends HttpServlet{
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID albumId = UUID.fromString(request.getParameter("albumId"));
        List<Image> images = crudService.readImagesByAlbumId(albumId);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(images));
    }
}