package org.example.gtgapi.models;

import jakarta.validation.constraints.NotEmpty;

public class LoginUsuario {

    @NotEmpty(message = "The username cannot be empty")
    private String username;
    @NotEmpty(message = "The password cannot be empty")
    private String contrasenya;

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
