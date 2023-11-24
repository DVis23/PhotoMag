package ru.vsu.cs.dvis.servlets.delete;

import ru.vsu.cs.dvis.CRUDService;
import ru.vsu.cs.dvis.DataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    DataBase dataBase = new DataBase();
    CRUDService crudService = new CRUDService(dataBase);

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)  {
        UUID id = UUID.fromString(request.getParameter("id"));

        crudService.deleteUser(id);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

}
