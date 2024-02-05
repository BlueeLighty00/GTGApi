package org.example.gtgapi.models;

import jakarta.validation.constraints.NotEmpty;

public class RegistroUsuario {

    @NotEmpty(message = "The name cannot be empty")
    private String nombre;
    private String apellidos;
    @NotEmpty(message = "The email cannot be empty")
    private String correo;
    private Long telefono;
    @NotEmpty(message = "The address cannot be empty")
    private String direccion;
    @NotEmpty(message = "The username cannot be empty")
    private String username;
    @NotEmpty(message = "The password cannot be empty")
    private String contrasenya;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
