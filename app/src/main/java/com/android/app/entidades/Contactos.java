package com.android.app.entidades;

public class Contactos {

    private int id;
    private String Email;
    private String Nombre;
    private String Apellido;
    private String Dni;
    private String Domicilio;
    private String Telefono;

    private String Patente;
    private String Modelo;
    private String Marca;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }



    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }



    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }



    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }



    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }



    public String getModelo() { return Modelo;}

    public void setModelo(String modelo) {Modelo = modelo;}



    public String getMarca() {return Marca;}

    public void setMarca(String marca) {Marca = marca;}


}
