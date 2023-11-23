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

@WebServlet("/readAlbumByName")
public class ReadAlbumByNameServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        List<Album> albums = crudService.readAlbumByName(name);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(albums));
    }
}
