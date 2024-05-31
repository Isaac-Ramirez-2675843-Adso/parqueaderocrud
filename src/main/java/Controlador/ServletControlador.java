/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Vehiculo;
import ModeloDAO.VehiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
    String listar="vistas/listar.jsp";
    String agregar="vistas/agregar.jsp";
    String editar="vistas/editar.jsp";
    Vehiculo v=new Vehiculo();
    VehiculoDAO dao=new VehiculoDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
            acceso=listar;
        }else if (action.equals("agregar")) {
            acceso=agregar;
        }else if (action.equals("Agregar")) {
            String placa=request.getParameter("txtPlaca");
            String tipo=request.getParameter("txtTipo");
            String color=request.getParameter("txtColor");
            String modelo=request.getParameter("txtModelo");
            v.setPlaca(placa);
            v.setTipo(tipo);
            v.setColor(color);
            v.setModelo(modelo);
            dao.agregar(v);
            acceso=listar;
        }
        else if (action.equals("editar")) {
            request.setAttribute("idveh", request.getParameter("id"));
            acceso=editar;
        }
        else if (action.equals("Modificar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String placa=request.getParameter("txtPlaca");
            String tipo=request.getParameter("txtTipo");
            String color=request.getParameter("txtColor");
            String modelo=request.getParameter("txtModelo");
            v.setId(id);
            v.setPlaca(placa);
            v.setTipo(tipo);
            v.setColor(color);
            v.setModelo(modelo);
            dao.editar(v);
            acceso=listar;
        }
        else if (action.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            v.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
