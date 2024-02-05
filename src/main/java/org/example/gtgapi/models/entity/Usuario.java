package org.example.gtgapi.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Usuario", schema = "public", catalog = "")
public class Usuario {

    public Usuario() {

    }

    public Usuario(Long id, String nombre, String apellidos, String correo, Long telefono, String contrasenya, String direccion, String username) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.username = username;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "apellidos")
    private String apellidos;

    @Basic
    @Column(name = "correo", unique = true)
    private String correo;

    @Basic
    @Column(name = "telefono")
    private Long telefono;

    @Basic
    @Column(name = "contrasenya")
    @JsonIgnore
    private String contrasenya;

    @Basic
    @Column(name = "direccion")
    private String direccion;

    @Basic
    @Column(name = "username", unique = true)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable(name = "usuarios_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "rol_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private Set<Rol> rolesAsociados = new HashSet<>();

    public Set<Rol> getRolesAsociados() {
        return rolesAsociados;
    }

    public void setRolesAsociados(Set<Rol> rolesAsociados) {
        this.rolesAsociados = rolesAsociados;
    }
}
