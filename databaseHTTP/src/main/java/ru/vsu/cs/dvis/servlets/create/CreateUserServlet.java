package ru.vsu.cs.dvis.servlets.create;

import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;
import ru.vsu.cs.dvis.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        UUID id = UUID.fromString(request.getParameter("id"));
        String name = request.getParameter("name");
        double value = Double.parseDouble(request.getParameter("value"));

        User user = new User(id, name);
        user.setValue(value);
        crudService.createUser(user);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

}
