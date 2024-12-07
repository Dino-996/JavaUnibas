package it.unibas.sito.test;

import it.unibas.sito.modello.Archivio;
import it.unibas.sito.modello.SitoWeb;
import it.unibas.sito.persistenza.DAOArchivio;
import it.unibas.sito.persistenza.DAOException;
import it.unibas.sito.persistenza.IDAOArchivio;
import java.time.LocalDate;
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
    public void testCercaSitiWeb() {
        LocalDate oggi = LocalDate.now();  
        Assertions.assertEquals(1, archivio.cercaSitiWeb(oggi).size());
    }
    
    @Test
    public void testVerificaArchivio() {
        Assertions.assertEquals("Biblioteca Unibas", archivio.verificaArchivio().getNome());
    }
}
