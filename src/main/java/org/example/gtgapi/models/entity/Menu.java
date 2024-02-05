package org.example.gtgapi.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Menu", schema = "public", catalog = "")
public class Menu {

    public Menu(){
    }

    public Menu(String nombre, String descripcion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMenu = precio;
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
    @Column(name = "precio_menu")
    private Double precioMenu;

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

    public Double getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(Double precio) {
        this.precioMenu = precio;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable(name = "bowls_menus",
            joinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "bowl_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private Set<Bowl> bowlsAsociados = new HashSet<>();

    public Set<Bowl> getBowlsAsociados() {
        return bowlsAsociados;
    }

    public void setBowlsAsociados(Set<Bowl> bowlsAsociados) {
        this.bowlsAsociados = bowlsAsociados;
    }

    @ManyToMany(mappedBy = "menusAsociados", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Pedido> pedidosAsociados = new LinkedHashSet<>();

    public Set<Pedido> getPedidosAsociados() {
        return pedidosAsociados;
    }

    public void setPedidosAsociados(Set<Pedido> pedidosAsociados) {
        this.pedidosAsociados = pedidosAsociados;
    }
}
