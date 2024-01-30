package org.example.gtgapi.models.dao;

import org.example.gtgapi.models.entity.Usuario;

public interface UsuarioDAO {
    void save(Usuario usuario);

    Usuario findById(long id);

    Usuario[] findAll();

    void update(Usuario usuario);

    void delete(long id);

    void deleteAll();
}
