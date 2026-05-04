//package Sevlet;

import Controller.ConsumirApiAutor;
import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/autores"})
public class AutorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion   = req.getParameter("accion");
        String cedula   = req.getParameter("txtCedula")   != null ? req.getParameter("txtCedula")   : "";
        String apellido = req.getParameter("txtApellido") != null ? req.getParameter("txtApellido") : "";

        if (accion == null) {
            JsonArray lista = JsonParser.parseString(ConsumirApiAutor.obtener(cedula, apellido)).getAsJsonArray();
            req.setAttribute("autores", lista);
            req.getRequestDispatcher("/autores.jsp").forward(req, res);
        } else if (accion.equals("irAgregar")) {
            req.getRequestDispatcher("/agregarAutor.jsp").forward(req, res);
        } else if (accion.equals("editar")) {
            req.getRequestDispatcher("/editarAutor.jsp").forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("_method");

        if ("PUT".equals(method)) {
            // ACTUALIZAR
            ConsumirApiAutor.actualizar(
                req.getParameter("cedula"),
                req.getParameter("nombre"),
                req.getParameter("apellido"),
                req.getParameter("pais")
            );
        } else {
            // INSERTAR
            ConsumirApiAutor.insertar(
                req.getParameter("cedula"),
                req.getParameter("nombre"),
                req.getParameter("apellido"),
                req.getParameter("pais")
            );
        }
        res.sendRedirect(req.getContextPath() + "/autores");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ConsumirApiAutor.eliminar(req.getParameter("cedula"));
        res.getWriter().write("ok");
    }
}