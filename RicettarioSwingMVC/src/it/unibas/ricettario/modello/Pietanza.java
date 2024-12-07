package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Pietanza {

    private String nome;
    private int costro;
    private String categoria; // Antipasto, primo, secondo, dessert

    private final List<Ingrediente> listaIngredienti = new ArrayList<>();

    public void addIngrediente(Ingrediente ingrediente) {
        this.listaIngredienti.add(ingrediente);
    }

    public int getKcalTotali() {
        int somma = 0;
        for (Ingrediente ingrediente : this.listaIngredienti) {
            somma = ingrediente.getKcalInValoreAssoluto();
        }
        return somma;
    }

    public boolean contieneAllergeni() {
        for (Ingrediente i : this.listaIngredienti) {
            if (i.isAllergene()) {
                return true;
            }
        }
        return false;
    }
}
