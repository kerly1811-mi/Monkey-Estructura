<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Editar Autor</title></head><body>
<h2>Editar Autor</h2>
<form action="autores" method="POST">
    <input type="hidden" name="_method"   value="PUT">
    <input type="hidden" name="cedula"    value="<%=request.getParameter("cedula")%>">
    Nombre:   <input type="text" name="nombre"   value="<%=request.getParameter("nombre")%>"   required><br>
    Apellido: <input type="text" name="apellido" value="<%=request.getParameter("apellido")%>" required><br>
    País:     <input type="text" name="pais"     value="<%=request.getParameter("pais")%>"     required><br>
    <button type="submit">Actualizar</button> <a href="autores">Volver</a>
</form>
</body></html>