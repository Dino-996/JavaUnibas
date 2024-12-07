package it.unibas.azienda.test;

import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.persistenza.DAOArchivio;
import it.unibas.azienda.persistenza.DAOException;
import it.unibas.azienda.persistenza.IDAOArchivio;
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
    public void testVerificaArchivio() {
        Assertions.assertEquals("La regione Sicilia e' la piu' frequente e ha più di tre volte il numero di dipendenti di Veneto", archivio.verificaArchivio());
    }
}
