package it.unibas.aule.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Aula {

    private String codiceUnivoco;
    private String nomeAula;
    private int pianoAula;

    private final List<Accesso> listaAccessi = new ArrayList<>();

    public void addAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }
}
