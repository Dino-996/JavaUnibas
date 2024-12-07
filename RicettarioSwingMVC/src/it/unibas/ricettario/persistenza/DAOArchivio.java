package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Ingrediente;
import it.unibas.ricettario.modello.Pietanza;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String carica) throws DAOException {
        Archivio archivio = new Archivio();

        Ingrediente pomodoro = new Ingrediente("Pomodoro", 150, false, 18);
        Ingrediente mozzarella = new Ingrediente("Mozzarella", 100, false, 280);
        Ingrediente basilico = new Ingrediente("Basilico", 5, false, 23);
        
        Ingrediente pasta = new Ingrediente("Pasta", 200, false, 350);
        Ingrediente pancetta = new Ingrediente("Pancetta", 50, true, 541);
        Ingrediente uovo = new Ingrediente("Uovo", 60, false, 155);
        
        Ingrediente farina = new Ingrediente("Farina", 100, false, 364);
        Ingrediente zucchero = new Ingrediente("Zucchero", 50, false, 387);
        Ingrediente burro = new Ingrediente("Burro", 30, false, 717);

        Pietanza pizzaMargherita = new Pietanza("Pizza Margherita", 5, "Secondo");
        pizzaMargherita.addIngrediente(pomodoro);
        pizzaMargherita.addIngrediente(mozzarella);
        pizzaMargherita.addIngrediente(basilico);
        
        Pietanza carbonara = new Pietanza("Carbonara", 6, "Primo");
        carbonara.addIngrediente(pasta);
        carbonara.addIngrediente(uovo);
        carbonara.addIngrediente(pancetta);
        
        Pietanza pastaFrolla = new Pietanza("Pasta frolla", 10, "Dessert");
        pastaFrolla.addIngrediente(farina);
        pastaFrolla.addIngrediente(zucchero);
        pastaFrolla.addIngrediente(burro);
        
        archivio.addPietanza(pizzaMargherita);
        archivio.addPietanza(carbonara);
        archivio.addPietanza(pastaFrolla);
        
        return archivio;
    }
}
