package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {

    private  AtomicInteger counter = new AtomicInteger(5);
    Model model = Model.getInstance();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        model.put(id, name, surname, salary);

        pw.print("<html>" +
           "<h3>Пользователь с id " + id + " успешно обновлён!</h3>" +
           "<a href =\"addUser.html\">Создать нового пользователя</a><br/>" +
                 "<a href =\"index.jsp\">Домой</a>" +
                 "</html>");
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        model.put(id, name, surname, salary);

        pw.print("<html>" +
                "<h3>Пользователь с id " + id + " успешно обновлён!</h3>" +
                "<a href =\"addUser.html\">Создать нового пользователя</a><br/>" +
                "<a href =\"index.jsp\">Домой</a>" +
                "</html>");
    }
}
