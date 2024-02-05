package org.example.gtgapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Rol", schema = "public", catalog = "")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Rol(String name) {
        this.name = name;
    }

    public Rol() {
    }

    @ManyToMany(mappedBy = "rolesAsociados", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuariosAsociados = new LinkedHashSet<>();

    public Set<Usuario> getUsuariosAsociados() {
        return usuariosAsociados;
    }

    public void setUsuariosAsociados(Set<Usuario> usuariosAsociados) {
        this.usuariosAsociados = usuariosAsociados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {

        return name;
    }
}
