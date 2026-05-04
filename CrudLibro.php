<?php
include_once("conexion.php");

class CrudLibro {

    public static function selectLibro() {
        $conexion = (new Conexion())->conectar();
        $titulo = $_GET['txtTitulo'] ?? '';
        $sql    = "SELECT l.*, CONCAT(a.nombre,' ',a.apellido) AS autor 
                   FROM libros l JOIN autores a ON l.autor_id = a.cedula WHERE 1=1";
        $params = [];
        if ($titulo !== '') { $sql .= " AND l.titulo LIKE :titulo"; $params[':titulo'] = '%'.$titulo.'%'; }
        $res = $conexion->prepare($sql);
        $res->execute($params);
        echo json_encode($res->fetchAll(PDO::FETCH_ASSOC));
    }

    public static function insertLibro() {
        $conexion = (new Conexion())->conectar();
        $t=$_POST['txtTitulo']; $g=$_POST['txtGenero'];
        $anio=$_POST['txtAnio']; $aid=$_POST['txtAutorId'];
        $conexion->prepare("INSERT INTO libros (titulo,genero,anio,autor_id) VALUES ('$t','$g','$anio','$aid')")->execute();
        echo json_encode("Libro insertado correctamente");
    }

    public static function deleteLibro() {
        $conexion = (new Conexion())->conectar();
        $id = $_GET['txtId'];
        $conexion->prepare("DELETE FROM libros WHERE id='$id'")->execute();
        echo json_encode("Libro eliminado correctamente");
    }

    public static function updateLibro() {
        $conexion = (new Conexion())->conectar();
        $id=$_GET['txtId']; $t=$_GET['txtTitulo'];
        $g=$_GET['txtGenero']; $anio=$_GET['txtAnio']; $aid=$_GET['txtAutorId'];
        $conexion->prepare("UPDATE libros SET titulo='$t', genero='$g', anio='$anio', autor_id='$aid' WHERE id='$id'")->execute();
        echo json_encode("Libro actualizado correctamente");
    }
}
?>