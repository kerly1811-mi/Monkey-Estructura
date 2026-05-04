//package Controller;

import java.net.URI;
import java.net.http.*;
import static java.net.URLEncoder.encode;

public class ConsumirApiLibro {

    private static final String URL = "http://localhost/API/apiLibros.php";
    private static final HttpClient c = HttpClient.newHttpClient();

    private static String send(HttpRequest req) {
        try { return c.send(req, HttpResponse.BodyHandlers.ofString()).body(); }
        catch (Exception e) { return "[]"; }
    }

    public static String obtener(String titulo) {
        return send(HttpRequest.newBuilder()
            .uri(URI.create(URL + "?txtTitulo=" + encode(titulo)))
            .GET().build());
    }

    public static void insertar(String titulo, String genero, String anio, String autorId) {
        String body = "txtTitulo="+encode(titulo)+"&txtGenero="+encode(genero)
                    +"&txtAnio="+encode(anio)+"&txtAutorId="+encode(autorId);
        send(HttpRequest.newBuilder().uri(URI.create(URL))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(body)).build());
    }

    public static void eliminar(String id) {
        send(HttpRequest.newBuilder()
            .uri(URI.create(URL + "?txtId=" + encode(id)))
            .DELETE().build());
    }

    public static void actualizar(String id, String titulo, String genero, String anio, String autorId) {
        String p = "txtId="+encode(id)+"&txtTitulo="+encode(titulo)+"&txtGenero="+encode(genero)
                 +"&txtAnio="+encode(anio)+"&txtAutorId="+encode(autorId);
        send(HttpRequest.newBuilder().uri(URI.create(URL + "?" + p))
            .PUT(HttpRequest.BodyPublishers.noBody()).build());
    }
}