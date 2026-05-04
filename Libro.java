//package Modelo;

public class Libro {
    private String id, titulo, genero, anio, autorId;

    public Libro(String id, String titulo, String genero, String anio, String autorId) {
        this.id = id; this.titulo = titulo; this.genero = genero;
        this.anio = anio; this.autorId = autorId;
    }
    public String getId()      { return id; }
    public String getTitulo()  { return titulo; }
    public String getGenero()  { return genero; }
    public String getAnio()    { return anio; }
    public String getAutorId() { return autorId; }
}