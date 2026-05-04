<?php
include_once("conexion.php");

class CrudAutor {

    public static function selectAutor() {
        $conexion = (new Conexion())->conectar();
        $cedula   = $_GET['txtCedula']   ?? '';
        $apellido = $_GET['txtApellido'] ?? '';
        $sql    = "SELECT * FROM autores WHERE 1=1";
        $params = [];
        if ($cedula !== '')   { $sql .= " AND cedula LIKE :cedula";     $params[':cedula']   = '%'.$cedula.'%'; }
        if ($apellido !== '') { $sql .= " AND apellido LIKE :apellido"; $params[':apellido'] = '%'.$apellido.'%'; }
        $res = $conexion->prepare($sql);
        $res->execute($params);
        echo json_encode($res->fetchAll(PDO::FETCH_ASSOC));
    }

    public static function insertAutor() {
        $conexion = (new Conexion())->conectar();
        $c=$_POST['txtCedula']; $n=$_POST['txtNombre'];
        $a=$_POST['txtApellido']; $p=$_POST['txtPais'];
        $conexion->prepare("INSERT INTO autores VALUES ('$c','$n','$a','$p')")->execute();
        echo json_encode("Autor insertado correctamente");
    }

    public static function deleteAutor() {
        $conexion = (new Conexion())->conectar();
        $c = $_GET['txtCedula'];
        $conexion->prepare("DELETE FROM autores WHERE cedula='$c'")->execute();
        echo json_encode("Autor eliminado correctamente");
    }

    public static function updateAutor() {
        $conexion = (new Conexion())->conectar();
        $c=$_GET['txtCedula']; $n=$_GET['txtNombre'];
        $a=$_GET['txtApellido']; $p=$_GET['txtPais'];
        $conexion->prepare("UPDATE autores SET nombre='$n', apellido='$a', pais='$p' WHERE cedula='$c'")->execute();
        echo json_encode("Autor actualizado correctamente");
    }
}
?>