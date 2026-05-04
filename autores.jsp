<%@page import="com.google.gson.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Autores</title></head><body>
<h1>Autores</h1>
<form action="autores" method="GET">
    Cédula: <input type="text" name="txtCedula">
    Apellido: <input type="text" name="txtApellido">
    <button>Buscar</button> <a href="autores">Ver todos</a>
</form>
<a href="autores?accion=irAgregar">+ Agregar</a> | <a href="libros">Ver Libros</a>
<table border="1">
    <tr><th>Cédula</th><th>Nombre</th><th>Apellido</th><th>País</th><th>Acciones</th></tr>
    <% JsonArray autores = (JsonArray) request.getAttribute("autores");
       for (Object obj : autores) {
           JsonObject a = (JsonObject) obj;
           String cedula=a.get("cedula").getAsString(), nombre=a.get("nombre").getAsString(),
                  apellido=a.get("apellido").getAsString(), pais=a.get("pais").getAsString(); %>
    <tr>
        <td><%=cedula%></td><td><%=nombre%></td><td><%=apellido%></td><td><%=pais%></td>
        <td>
            <a href="autores?accion=editar&cedula=<%=cedula%>&nombre=<%=nombre%>&apellido=<%=apellido%>&pais=<%=pais%>">Editar</a>
            <button onclick="eliminar('<%=cedula%>')">Eliminar</button>
        </td>
    </tr>
    <% } %>
</table>
<script>
function eliminar(cedula) {
    if (confirm('¿Eliminar?'))
        fetch('autores?cedula=' + cedula, {method:'DELETE'}).then(()=>location.reload());
}
</script>
</body></html>