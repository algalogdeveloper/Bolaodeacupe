package org.logcod.lojajogos.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.logcod.lojajogos.controller.subcontroller.InvokeSubControllers;
import org.logcod.lojajogos.repository.RecargaRepository;
import org.logcod.lojajogos.service.RecargaService;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected static String sufixo = ".jsp";
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String direcionar = "index.jsp";
            if (Objects.nonNull((String) request.getSession().getAttribute("logado"))) {
                if (request.getSession().getAttribute("logado").equals("admin") || !notificar(request)) {
                    Class<?> instance = Class.forName(getServletContext().getInitParameter("subcontroller") + request.getParameter("operacao"));
                    InvokeSubControllers mvc = (InvokeSubControllers) instance.newInstance();
                    direcionar = mvc.invokePage(request, response);
                } else {
                    direcionar = "bloqueada.jsp";
                }

            } else {
                request.setAttribute("msg", "Sua sessão expirou!");
            }

            request.getRequestDispatcher(direcionar).forward(request, response);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException
                | ServletException ex) {
            request.setAttribute("msg", "Erro controller aplicação: " + ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public boolean notificar(HttpServletRequest request) {
        try {
            RecargaService rs = new RecargaService(new RecargaRepository());
            LocalDate dataUltimaRecarga = rs.ultimaRecarga().getDataRecarga();
            LocalDate dataAtual = LocalDate.now();
            System.out.println("Data atual:"+dataAtual);
            System.out.println("Ultima credito:"+dataUltimaRecarga);
            Period period = Period.between(dataUltimaRecarga, dataAtual);
            System.out.println("Total de dias: "+period.getDays());
            boolean bloquear = false;
            if (period.getDays() >= 13 && period.getDays() <= 15) {
                request.setAttribute("notificar", "Sua plataforma está consumindo muito crédito, faça recarga!");
                bloquear = false;
            } else if (period.getDays() >= 16) {
                request.setAttribute("notificar", "Sua plataforma está bloqueada por falta de recarga. Data " + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now()));
                bloquear = true;
            }
            System.out.println("Status:"+bloquear);
            return bloquear;
        } catch (Exception e) {
            return false;
        }

    }
    
  

}
 