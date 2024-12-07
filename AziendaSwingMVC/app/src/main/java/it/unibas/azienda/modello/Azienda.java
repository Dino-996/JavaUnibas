package it.unibas.azienda.modello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Azienda implements Comparable<Azienda> {

    private String partitaIVA;
    private String denominazione;
    private String sedeSociale;

    private final List<Dipendente> listaDipendenti = new ArrayList<>();

    public void addDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

    public boolean verificaDuplicati(String nome, String cognome, LocalDateTime data) {
        for (Dipendente dipendente : this.listaDipendenti) {
            if (dipendente.getNome().equalsIgnoreCase(nome) && dipendente.getCognome().equalsIgnoreCase(cognome)) {
                if (dipendente.getDataAssunzione().isEqual(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificaCodiceFiscaleDuplicato(String codiceFiscale) {
        for (Dipendente dipendente : this.listaDipendenti) {
            if (dipendente.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

    public List<Dipendente> getDipendentiDuplicati(String codiceFiscale) {
        List<Dipendente> listaFiltrata = new ArrayList<>();
        for (Dipendente dipendente : this.listaDipendenti) {
            if (dipendente.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                listaFiltrata.add(dipendente);
            }
        }
        return listaFiltrata;
    }

    public void aggiornaDipendente(LocalDateTime data, String codiceFiscale, String nome, String cognome, String regione) {
        for (Dipendente dipendente : this.getDipendentiDuplicati(codiceFiscale)) {
            if (data.isAfter(dipendente.getDataAssunzione())) {
                dipendente.setCodiceFiscale(codiceFiscale);
                dipendente.setNome(nome);
                dipendente.setCognome(cognome);
                dipendente.setRegioneResidenza(regione);
                dipendente.setDataAssunzione(data);
            }
        }
    }

    @Override
    public int compareTo(Azienda o) {
        return this.getDenominazione().compareTo(o.getDenominazione());
    }
}
