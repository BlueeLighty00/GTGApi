package org.example.gtgapi.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pedido", schema = "public", catalog = "")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "fecha_pedido")
    private String fechaPedido;

    @Basic
    @Column(name = "precio_total")
    private Double precioTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable(name = "menus_pedido",
            joinColumns = {
                    @JoinColumn(name = "pedido_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private Set<Menu> menusAsociados = new HashSet<>();

    public Set<Menu> getMenusAsociados() {
        return menusAsociados;
    }

    public void setMenusAsociados(Set<Menu> menusAsociados) {
        this.menusAsociados = menusAsociados;
    }

    public Pedido(Long id, String fechaPedido, Double precioTotal) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
    }

    public Pedido() {

    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
