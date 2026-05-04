<?php
class Conexion{
    public function conectar(){
        $server="localhost";
        $username="root";
        $database="autores";
        $password="";

        try{
            $conexion= new PDO("mysql:host=$server;dbname=$database", $username, $password);
        }catch(Exception $e){
            die("Error de conexion".$e->getMessage());
        }
        return $conexion;


    }
}

?>