package it.unibas.libri.test;

import it.unibas.libri.modello.Archivio;
import it.unibas.libri.modello.Utente;
import it.unibas.libri.persistenza.DAOArchivio;
import it.unibas.libri.persistenza.DAOException;
import it.unibas.libri.persistenza.IDAOArchivio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArchivio {

    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private Archivio archivio;

    @BeforeEach
    public void setUp() {
        try {
            archivio = daoArchivio.carica("");
        } catch (DAOException ex) {
            Assertions.fail("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
        }
    }

    @Test
    public void cercaUtentiInArchivio() {
        Utente harryPotter = archivio.getListaUtente().get(0);
        Utente harryPotterCopia = archivio.getListaUtente().get(1);
        Utente hermioneGranger = archivio.getListaUtente().get(2);
        Utente ronWeasley = archivio.getListaUtente().get(3);

        Assertions.assertEquals(4, archivio.cercaUtenti("", "").size());
        Assertions.assertEquals(0, archivio.cercaUtenti("Mirco", "").size());
        Assertions.assertEquals(0, archivio.cercaUtenti("", "Rossi").size());
        Assertions.assertEquals(harryPotterCopia.getNomeUtenteUnivoco(), archivio.cercaUtenti("Harry", "").get(0).getNomeUtenteUnivoco());
        Assertions.assertEquals(harryPotter.getNomeUtenteUnivoco(), archivio.cercaUtenti("Harry", "").get(1).getNomeUtenteUnivoco());
        Assertions.assertEquals(hermioneGranger.getNomeUtenteUnivoco(), archivio.cercaUtenti("", "Granger").get(0).getNomeUtenteUnivoco());
        Assertions.assertEquals(ronWeasley.getNomeUtenteUnivoco(), archivio.cercaUtenti("Ron", "Weasley").get(0).getNomeUtenteUnivoco());
    }

    @Test
    public void verificaArchivio() {
        Assertions.assertEquals(true, archivio.isAutoriTuttiDiversi());
    }
}
