package org.example.gtgapi.models.dao;

import org.example.gtgapi.models.entity.Menu;

public interface MenuDAO {
    void save(Menu menu);

    Menu findById(long id);

    Menu[] findAll();

    void update(Menu menu);

    void delete(long id);

    void deleteAll();
}
