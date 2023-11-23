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

@WebServlet("/readImageByLocation")
public class ReadImageByLocationServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String location = request.getParameter("location");
        List<Image> images = crudService.readImagesByLocation(location);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(images));
    }
}

