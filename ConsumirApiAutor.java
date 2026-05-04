//package Controller;

import java.net.URI;
import java.net.http.*;
import static java.net.URLEncoder.encode;

public class ConsumirApiAutor {

    private static final String URL = "http://localhost/API/apiAutores.php";
    private static final HttpClient c = HttpClient.newHttpClient();

    private static String send(HttpRequest req) {
        try { return c.send(req, HttpResponse.BodyHandlers.ofString()).body(); }
        catch (Exception e) { return "[]"; }
    }

    public static String obtener(String cedula, String apellido) {
        return send(HttpRequest.newBuilder()
            .uri(URI.create(URL + "?txtCedula=" + encode(cedula) + "&txtApellido=" + encode(apellido)))
            .GET().build());
    }

    public static void insertar(String cedula, String nombre, String apellido, String pais) {
        String body = "txtCedula="+encode(cedula)+"&txtNombre="+encode(nombre)
                    +"&txtApellido="+encode(apellido)+"&txtPais="+encode(pais);
        send(HttpRequest.newBuilder().uri(URI.create(URL))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(body)).build());
    }

    public static void eliminar(String cedula) {
        send(HttpRequest.newBuilder()
            .uri(URI.create(URL + "?txtCedula=" + encode(cedula)))
            .DELETE().build());
    }

    public static void actualizar(String cedula, String nombre, String apellido, String pais) {
        String p = "txtCedula="+encode(cedula)+"&txtNombre="+encode(nombre)
                 +"&txtApellido="+encode(apellido)+"&txtPais="+encode(pais);
        send(HttpRequest.newBuilder().uri(URI.create(URL + "?" + p))
            .PUT(HttpRequest.BodyPublishers.noBody()).build());
    }
}