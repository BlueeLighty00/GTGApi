package org.example.gtgapi.models.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Bowl", schema = "public", catalog = "")
public class Bowl {

    public Bowl(){
    }

    public Bowl(Long id, String nombre, String descripcion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "precio")
    private Double precio;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable(name = "ingredientes_bowls",
            joinColumns = {
                    @JoinColumn(name = "bowl_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ingrediente_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private Set<Ingrediente> ingredientesAsociados = new HashSet<>();

    public Set<Ingrediente> getIngredientesAsociados() {
        return ingredientesAsociados;
    }

    public void setIngredientesAsociados(Set<Ingrediente> ingredientesAsociados) {
        this.ingredientesAsociados = ingredientesAsociados;
    }

    @ManyToMany(mappedBy = "bowlsAsociados", fetch = FetchType.EAGER)
    private Set<Menu> menusAsociados = new LinkedHashSet<>();

    public Set<Menu> getMenusAsociados() {
        return menusAsociados;
    }

    public void setMenusAsociados(Set<Menu> menusAsociados) {
        this.menusAsociados = menusAsociados;
    }
}
