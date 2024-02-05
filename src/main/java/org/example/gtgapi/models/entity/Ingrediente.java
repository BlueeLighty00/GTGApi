package org.example.gtgapi.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Ingrediente", schema = "public", catalog = "")
public class Ingrediente {

    public Ingrediente() {
    }

    public Ingrediente(String nombre, Double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "precio")
    private Double precio;

    @Basic
    @Column(name = "tipo")
    private String tipo;

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @ManyToMany(mappedBy = "ingredientesAsociados", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Bowl> bowlsAsociados = new LinkedHashSet<>();

    public Set<Bowl> getBowlsAsociados() {
        return bowlsAsociados;
    }

    public void setBowlsAsociados(Set<Bowl> bowlsAsociados) {
        this.bowlsAsociados = bowlsAsociados;
    }
}
