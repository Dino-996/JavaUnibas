package it.unibas.ricettario.modello;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Ingrediente {

    private String nome;
    private int quantita; // espressa in grammi
    private boolean allergene;
    private int Kcal100grammi; //Kcal per 100 grammi
    
    public int getKcalInValoreAssoluto() {
        return this.quantita * this.Kcal100grammi / 100;
    }

}
