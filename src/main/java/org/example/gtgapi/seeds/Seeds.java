package org.example.gtgapi.seeds;

import org.example.gtgapi.models.dao.BowlDAOImpl;
import org.example.gtgapi.models.dao.IngredienteDAOImpl;
import org.example.gtgapi.models.dao.MenuDAOImpl;
import org.example.gtgapi.models.entity.Bowl;
import org.example.gtgapi.models.entity.Ingrediente;
import org.example.gtgapi.models.entity.Menu;

public class Seeds {
    private IngredienteDAOImpl ingredienteService;
    private BowlDAOImpl bowlService;
    private MenuDAOImpl menuService;

    public Seeds(IngredienteDAOImpl ingredienteService, BowlDAOImpl bowlService, MenuDAOImpl menuService) {
        this.ingredienteService = ingredienteService;
        this.bowlService = bowlService;
        this.menuService = menuService;
    }

    public void generateSeeds() {
        seedIngredientes();
        seedBowls();
        seedMenus();
    }

    private void seedIngredientes() {
        if (ingredienteService.findAll().length == 0) {
            Ingrediente tomate = new Ingrediente("Tomate", 5.0, "Vegetal");
            Ingrediente pollo = new Ingrediente("Pollo", 10.0, "Proteína");
            Ingrediente lechuga = new Ingrediente("Lechuga", 3.0, "Vegetal");
            Ingrediente arroz = new Ingrediente("Arroz", 4.0, "Carbohidrato");
            Ingrediente salmon = new Ingrediente("Salmón", 15.0, "Proteína");
            Ingrediente pepino = new Ingrediente("Pepino", 2.0, "Vegetal");
            Ingrediente frijoles = new Ingrediente("Frijoles", 7.0, "Proteína");
            Ingrediente aguacate = new Ingrediente("Aguacate", 8.0, "Grasa");
            Ingrediente queso = new Ingrediente("Queso", 6.0, "Proteína");
            Ingrediente maiz = new Ingrediente("Maíz", 3.0, "Carbohidrato");

            ingredienteService.save(tomate);
            ingredienteService.save(pollo);
            ingredienteService.save(lechuga);
            ingredienteService.save(arroz);
            ingredienteService.save(salmon);
            ingredienteService.save(pepino);
            ingredienteService.save(frijoles);
            ingredienteService.save(aguacate);
            ingredienteService.save(queso);
            ingredienteService.save(maiz);
        }
    }

    private void seedBowls() {
        if (bowlService.findAll().length == 0) {
            Ingrediente[] ingredientes = ingredienteService.findAll();

            Bowl ensaladaPollo = new Bowl("Ensalada de Pollo", "Deliciosa ensalada con pollo", 12.0);
            ensaladaPollo.getIngredientesAsociados().add(ingredientes[0]);
            ensaladaPollo.getIngredientesAsociados().add(ingredientes[1]);
            bowlService.save(ensaladaPollo);

            Bowl arrozSalmon = new Bowl("Arroz con Salmón", "Arroz con salmón al estilo asiático", 15.0);
            arrozSalmon.getIngredientesAsociados().add(ingredientes[2]);
            arrozSalmon.getIngredientesAsociados().add(ingredientes[3]);
            bowlService.save(arrozSalmon);

            Bowl ensaladaVegana = new Bowl("Ensalada Vegana", "Ensalada fresca y nutritiva", 10.0);
            ensaladaVegana.getIngredientesAsociados().add(ingredientes[4]);
            ensaladaVegana.getIngredientesAsociados().add(ingredientes[5]);
            bowlService.save(ensaladaVegana);
        }
    }

    private void seedMenus() {
        if (menuService.findAll().length == 0) {
            Bowl[] bowls = bowlService.findAll();

            Menu menuSaludable = new Menu("Menú Saludable", "Menú equilibrado para una alimentación saludable", 20.0);
            menuSaludable.getBowlsAsociados().add(bowls[0]);
            menuService.save(menuSaludable);

            Menu menuGourmet = new Menu("Menú Gourmet", "Exquisitas combinaciones gourmet", 25.0);
            menuGourmet.getBowlsAsociados().add(bowls[1]);
            menuGourmet.getBowlsAsociados().add(bowls[2]);
            menuService.save(menuGourmet);

        }
    }


}
