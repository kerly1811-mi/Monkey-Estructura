package Modelo;

public class Autor {
    private String id, nombre, pais;

    public Autor(String id, String nombre, String pais) {
        this.id = id; this.nombre = nombre; this.pais = pais;
    }
    public String getId()     { return id; }
    public String getNombre() { return nombre; }
    public String getPais()   { return pais; }
}