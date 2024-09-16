package org.logcod.lojajogos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.controller.sub.Invoke;
public class BuscarPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String entity = "org.logcod.lojajogos.controller.sub." + request.getParameter("invoke");
            Class<?> instance = Class.forName(entity);
            Invoke invoke = (Invoke) instance.newInstance();
            Object mvc = invoke.invokeJson(request);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(mvc);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
        }

    }

}
