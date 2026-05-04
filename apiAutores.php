<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json");
include_once("CrudAutor.php");

switch ($_SERVER["REQUEST_METHOD"]) {
    case "GET":    CrudAutor::selectAutor(); break;
    case "POST":   CrudAutor::insertAutor(); break;
    case "PUT":    CrudAutor::updateAutor(); break;
    case "DELETE": CrudAutor::deleteAutor(); break;
}
?>