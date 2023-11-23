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

@WebServlet("/readUserByValue")
public class ReadUserByValueServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double value = Double.parseDouble(request.getParameter("value"));
        List<User> users = crudService.readUsersByValue(value);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(users));
    }
}
