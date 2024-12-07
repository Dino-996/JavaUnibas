package it.unibas.docenti.test;

import it.unibas.docenti.modello.Archivio;
import it.unibas.docenti.modello.Docente;
import it.unibas.docenti.persistenza.DAOArchivio;
import it.unibas.docenti.persistenza.DAOException;
import it.unibas.docenti.persistenza.IDAOArchivio;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArchivio extends Assertions {

    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private Archivio archivio;

    @BeforeEach
    public void setUp() {
        try {
            archivio = daoArchivio.carica("");
        } catch (DAOException e) {
            fail("Impossibile caricare l'archivio: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void testCercaDocente() {
        LocalDateTime dataOraDocenteOccupato = LocalDateTime.of(2024, 9, 1, 16, 40);
        LocalDateTime dataOraDocenteLibero = LocalDateTime.of(2024, 9, 1, 16, 50);
        Docente bianchi = archivio.getListaDocenti().get(0);
        assertEquals(1, archivio.cercaDocenti("Psicologia", dataOraDocenteOccupato).size());
        assertEquals(bianchi.getNome(), archivio.cercaDocenti("Psicologia", dataOraDocenteLibero).get(0).getNome());
        assertEquals(0, archivio.cercaDocenti("Scienza", dataOraDocenteLibero).size());
    }
    
    @Test
    public void testVerificaArchivio() {
        assertEquals("Il docente Elena Verdi ha ricevuto 4 prenotazioni da studenti diversi", archivio.verificaArchivio());
    }

}
