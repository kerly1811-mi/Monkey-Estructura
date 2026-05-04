<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Editar Libro</title></head><body>
<h2>Editar Libro</h2>
<form action="libros" method="POST">
    <input type="hidden" name="_method"  value="PUT">
    <input type="hidden" name="id"       value="<%=request.getParameter("id")%>">
    Título:       <input type="text"   name="titulo"  value="<%=request.getParameter("titulo")%>"  required><br>
    Género:       <input type="text"   name="genero"  value="<%=request.getParameter("genero")%>"  required><br>
    Año:          <input type="number" name="anio"    value="<%=request.getParameter("anio")%>"    required><br>
    Cédula autor: <input type="text"   name="autorId" value="<%=request.getParameter("autorId")%>" required><br>
    <button type="submit">Actualizar</button> <a href="libros">Volver</a>
</form>
</body></html>