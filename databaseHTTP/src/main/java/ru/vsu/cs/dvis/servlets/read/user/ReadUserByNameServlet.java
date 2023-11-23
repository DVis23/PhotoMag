package ru.vsu.cs.dvis.servlets.read.user;

import com.google.gson.Gson;
import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;
import ru.vsu.cs.dvis.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/readUserByName")
public class ReadUserByNameServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        List<User> users = crudService.readUsersByName(name);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(users));
    }
}
