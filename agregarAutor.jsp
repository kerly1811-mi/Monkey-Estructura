<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Agregar Autor</title></head><body>
<h2>Agregar Autor</h2>
<form action="autores" method="POST">
    Cédula:   <input type="text" name="cedula"   required><br>
    Nombre:   <input type="text" name="nombre"   required><br>
    Apellido: <input type="text" name="apellido" required><br>
    País:     <input type="text" name="pais"     required><br>
    <button type="submit">Guardar</button> <a href="autores">Volver</a>
</form>
</body></html>