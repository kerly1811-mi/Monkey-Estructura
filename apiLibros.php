<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json");
include_once("CrudLibro.php");

switch ($_SERVER["REQUEST_METHOD"]) {
    case "GET":    CrudLibro::selectLibro(); break;
    case "POST":   CrudLibro::insertLibro(); break;
    case "PUT":    CrudLibro::updateLibro(); break;
    case "DELETE": CrudLibro::deleteLibro(); break;
}
?>