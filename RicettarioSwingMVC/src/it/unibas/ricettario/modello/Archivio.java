package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Archivio {

    public static final Logger consol = LoggerFactory.getLogger(Archivio.class);

    private final List<Pietanza> listaPietanze = new ArrayList<>();

    public void addPietanza(Pietanza pietanza) {
        this.listaPietanze.add(pietanza);
    }

    public List<Pietanza> getPietanzePerCategoria(String categoria) {
        List<Pietanza> listaFiltrata = new ArrayList<>();
        for (Pietanza pietanza : this.listaPietanze) {
            if (pietanza.getCategoria().equalsIgnoreCase(categoria)) {
                listaFiltrata.add(pietanza);
            }
        }
                consol.debug("Pietanze per categoria: {}", listaFiltrata.size());
        return listaFiltrata;
    }

    public Pietanza pietanzaCaloricamenteSimile(Pietanza pietanzaScelta) {
        Pietanza pietanzaTrovata = null;
        for (Pietanza pietanza : this.listaPietanze) {
            if (!pietanza.getNome().equals(pietanzaScelta.getNome())) {
                if (pietanzaTrovata == null || Math.abs(pietanza.getKcalTotali() - pietanzaScelta.getKcalTotali()) < Math.abs(pietanzaTrovata.getKcalTotali() - pietanza.getKcalTotali())) {
                    pietanzaTrovata = pietanza;
                }
            }
        }
        consol.debug("Pietanza trovata: {}", pietanzaTrovata.getNome());
        return pietanzaTrovata;
    }

}
