package org.example.gtgapi.models.dao;


import org.example.gtgapi.models.entity.Rol;


public interface RolDAO {
    void save(Rol rol);

    Rol findById(long id);

    Rol[] findAll();

    void update(Rol rol);

    void delete(long id);

    void deleteAll();
}
