<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>Agregar Libro</title></head><body>
<h2>Agregar Libro</h2>
<form action="libros" method="POST">
    Título:       <input type="text"   name="titulo"   required><br>
    Género:       <input type="text"   name="genero"   required><br>
    Año:          <input type="number" name="anio"     required><br>
    Cédula autor: <input type="text"   name="autorId"  required><br>
    <button type="submit">Guardar</button> <a href="libros">Volver</a>
</form>
</body></html>