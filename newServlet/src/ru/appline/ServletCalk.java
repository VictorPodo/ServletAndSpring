package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/calk")
public class ServletCalk extends HttpServlet {

    private  AtomicInteger counter = new AtomicInteger(5);
    Model model = Model.getInstance();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json;charset=utf-8");

//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        double salary = Double.parseDouble(request.getParameter("salary"));
//
//        String requestString = "{\"name\": \""+name+"\", \"surname\": \""+surname+"\", \"salary\": \""+salary+"\"}";
//        System.out.println(requestString);

        StringBuffer jb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }


        JsonParser jsonParser = new JsonParser();
        JsonObject jobj = jsonParser.parse(String.valueOf(jb)).getAsJsonObject();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
  //      JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");

        double a = jobj.get("a").getAsDouble();
        double b = jobj.get("b").getAsDouble();
        String math = jobj.get("math").getAsString();
        Double result = null;

        switch (math) {
            case "*": result = a * b;
                break;
            case "/": result = a / b;
                break;
            case ":": result = a / b;
                break;
            case "-": result = a - b;
                break;
            case "+": result = a + b;
                break;
            default:
                break;
        }

 //       AtomicInteger counter = new AtomicInteger(1);

        Map<String, Double> calc = new HashMap<>();
        calc.put("result", result);

  //      User user = new User(name, surname, salary);
  //      model.add(user, counter.getAndIncrement());

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(calc));
//        pw.print(gson.toJson());
//        pw.print(gson.toJson(model.getFromList()));

    }

}
