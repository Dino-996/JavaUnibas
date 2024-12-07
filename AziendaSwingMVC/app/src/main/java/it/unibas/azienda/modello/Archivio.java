package it.unibas.azienda.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Archivio {

    private List<Azienda> listaAziende = new ArrayList<>();

    public void addAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }

    // --- Punto numero 1 ---
    
    public List<Azienda> cercaAziendaPerCitta(String nomeCitta) {
        List<Azienda> listaFiltrata = new ArrayList<>();
        for (Azienda azienda : this.listaAziende) {
            if (azienda.getSedeSociale().equalsIgnoreCase(nomeCitta)) {
                listaFiltrata.add(azienda);
            }
        }
        return listaFiltrata;
    }

    // --- Punto numero 3 ---
    
    private List<Dipendente> tuttiDipendenti() {
        List<Dipendente> listaDipendenti = new ArrayList<>();
        for (Azienda azienda : this.listaAziende) {
            listaDipendenti.addAll(azienda.getListaDipendenti());
        }
        return listaDipendenti;
    }

    private DettagliDipendenti getRegionePiuFrequente() {
        List<DettagliDipendenti> listaDettagliDipendenti = new OperatoreDettagliDipendente(tuttiDipendenti()).listaDettagliDipendenti();
        DettagliDipendenti dettagli = null;
        for (DettagliDipendenti dettagliDipendenti : listaDettagliDipendenti) {
            if (dettagli == null || dettagli.getNumeroDipendenti() < dettagliDipendenti.getNumeroDipendenti()) {
                dettagli = dettagliDipendenti;
            }
        }
        log.debug("Regione piu' frequente: {} - Numero di dipendenti: {}", dettagli.getRegione(), dettagli.getNumeroDipendenti());
        return dettagli;
    }

    private DettagliDipendenti getRegioneMenoFrequente() {
        List<DettagliDipendenti> listaDettagliDipendenti = new OperatoreDettagliDipendente(tuttiDipendenti()).listaDettagliDipendenti();
        DettagliDipendenti dettagli = null;
        for (DettagliDipendenti dettagliDipendenti : listaDettagliDipendenti) {
            if (dettagli == null || dettagli.getNumeroDipendenti() > dettagliDipendenti.getNumeroDipendenti()) {
                dettagli = dettagliDipendenti;
            }
        }
        log.debug("Regione meno frequente: {} - Numero di dipendenti: {}", dettagli.getRegione(), dettagli.getNumeroDipendenti());
        return dettagli;
    }

    public String verificaArchivio() {
        DettagliDipendenti regioneMenoFrequente = getRegioneMenoFrequente();
        DettagliDipendenti regionePiuFrequente = getRegionePiuFrequente();
        if (regionePiuFrequente.getNumeroDipendenti() > (regioneMenoFrequente.getNumeroDipendenti() * 3)) {
            return "La regione " + regionePiuFrequente.getRegione() + " e' la piu' frequente e ha più di tre volte il numero di dipendenti di " + regioneMenoFrequente.getRegione();
        }
        return "Nessuna regione ha piu' di tre volte il numero di dipendenti di un altra regione";
    }
}
