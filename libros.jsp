<%@page import="com.google.gson.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Libros</title></head><body>
<h1>Libros</h1>
<form action="libros" method="GET">
    Título: <input type="text" name="txtTitulo">
    <button>Buscar</button> <a href="libros">Ver todos</a>
</form>
<a href="libros?accion=irAgregar">+ Agregar</a> | <a href="autores">Ver Autores</a>
<table border="1">
    <tr><th>ID</th><th>Título</th><th>Género</th><th>Año</th><th>Autor</th><th>Acciones</th></tr>
    <% JsonArray libros = (JsonArray) request.getAttribute("libros");
       for (Object obj : libros) {
           JsonObject l = (JsonObject) obj;
           String id=l.get("id").getAsString(), titulo=l.get("titulo").getAsString(),
                  genero=l.get("genero").getAsString(), anio=l.get("anio").getAsString(),
                  autor=l.get("autor").getAsString(), autorId=l.get("autor_id").getAsString(); %>
    <tr>
        <td><%=id%></td><td><%=titulo%></td><td><%=genero%></td><td><%=anio%></td><td><%=autor%></td>
        <td>
            <a href="libros?accion=editar&id=<%=id%>&titulo=<%=titulo%>&genero=<%=genero%>&anio=<%=anio%>&autorId=<%=autorId%>">Editar</a>
            <button onclick="eliminar('<%=id%>')">Eliminar</button>
        </td>
    </tr>
    <% } %>
</table>
<script>
function eliminar(id) {
    if (confirm('¿Eliminar?'))
        fetch('libros?id=' + id, {method:'DELETE'}).then(()=>location.reload());
}
</script>
</body></html>