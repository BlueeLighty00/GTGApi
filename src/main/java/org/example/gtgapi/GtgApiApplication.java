package org.example.gtgapi;

import org.example.gtgapi.models.dao.BowlDAOImpl;
import org.example.gtgapi.models.dao.IngredienteDAOImpl;
import org.example.gtgapi.models.dao.MenuDAOImpl;
import org.example.gtgapi.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GtgApiApplication {

    @Autowired
    MenuDAOImpl menuService;
    @Autowired
    BowlDAOImpl bowlService;
    @Autowired
    IngredienteDAOImpl ingredienteService;

    public static void main(String[] args) {
        SpringApplication.run(GtgApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        Seeds seeds = new Seeds(ingredienteService, bowlService, menuService);
        return runner -> {
            seeds.generateSeeds();
        };
    }
}
