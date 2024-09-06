package model;

public class Mascota {
    private String id;
    private String nombre;
    private String color;
    private int edad;
    private String tipo;


    public Mascota(String id, String nombre, String color, int edad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.tipo = tipo;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nColor: " + color +
                "\nEdad: " + edad +
                "\nTipo: " + tipo;
    }
}
