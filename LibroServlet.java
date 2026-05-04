//package Sevlet;

import Controller.ConsumirApiLibro;
import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/libros"})
public class LibroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String titulo = req.getParameter("txtTitulo") != null ? req.getParameter("txtTitulo") : "";

        if (accion == null) {
            JsonArray lista = JsonParser.parseString(ConsumirApiLibro.obtener(titulo)).getAsJsonArray();
            req.setAttribute("libros", lista);
            req.getRequestDispatcher("/libros.jsp").forward(req, res);
        } else if (accion.equals("irAgregar")) {
            req.getRequestDispatcher("/agregarLibro.jsp").forward(req, res);
        } else if (accion.equals("editar")) {
            req.getRequestDispatcher("/editarLibro.jsp").forward(req, res);
        }
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String method = req.getParameter("_method");

    if ("PUT".equals(method)) {
        ConsumirApiLibro.actualizar(
            req.getParameter("id"),
            req.getParameter("titulo"),
            req.getParameter("genero"),
            req.getParameter("anio"),
            req.getParameter("autorId")
        );
        res.sendRedirect(req.getContextPath() + "/libros");
    } else {
        ConsumirApiLibro.insertar(
            req.getParameter("titulo"),
            req.getParameter("genero"),
            req.getParameter("anio"),
            req.getParameter("autorId")
        );
        res.sendRedirect(req.getContextPath() + "/libros");
    }
}

    @Override
protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // Leer parámetros del query string manualmente
    String query   = req.getQueryString(); // id=1&titulo=...&genero=...
    java.util.Map<String, String> params = new java.util.HashMap<>();
    if (query != null) {
        for (String par : query.split("&")) {
            String[] kv = par.split("=");
            params.put(kv[0], kv.length > 1 ? java.net.URLDecoder.decode(kv[1], "UTF-8") : "");
        }
    }
    ConsumirApiLibro.actualizar(
        params.get("id"),
        params.get("titulo"),
        params.get("genero"),
        params.get("anio"),
        params.get("autorId")
    );
    res.getWriter().write("ok");
}

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ConsumirApiLibro.eliminar(req.getParameter("id"));
        res.getWriter().write("ok");
    }
}