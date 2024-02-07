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

    public Ingrediente(String nombre, Double precio, String tipo, Float kcal, Float proteina, Float carbohidrato, Float grasa, Float gramo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.kcal = kcal;
        this.proteina = proteina;
        this.carbohidrato = carbohidrato;
        this.grasa = grasa;
        this.gramo = gramo;
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

    @Basic
    @Column(name = "kcal")
    private Float kcal;

    @Basic
    @Column(name = "proteina")
    private Float proteina;

    @Basic
    @Column(name = "carbohidrato")
    private Float carbohidrato;

    @Basic
    @Column(name = "grasa")
    private Float grasa;

    @Basic
    @Column(name = "gramo")
    private Float gramo;


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

    public Float getKcal() {
        return kcal;
    }

    public void setKcal(Float kcal) {
        this.kcal = kcal;
    }

    public Float getProteina() {
        return proteina;
    }

    public void setProteina(Float proteina) {
        this.proteina = proteina;
    }

    public Float getCarbohidrato() {
        return carbohidrato;
    }

    public void setCarbohidrato(Float carbohidrato) {
        this.carbohidrato = carbohidrato;
    }

    public Float getGrasa() {
        return grasa;
    }

    public void setGrasa(Float grasa) {
        this.grasa = grasa;
    }

    public Float getGramo() {
        return gramo;
    }

    public void setGramo(Float gramo) {
        this.gramo = gramo;
    }
}