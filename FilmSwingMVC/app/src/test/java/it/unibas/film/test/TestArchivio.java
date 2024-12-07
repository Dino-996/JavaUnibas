package it.unibas.film.test;

import it.unibas.film.modello.Archivio;
import it.unibas.film.modello.Film;
import it.unibas.film.persistenza.DAOArchivio;
import it.unibas.film.persistenza.DAOException;
import it.unibas.film.persistenza.IDAOArchivio;
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
    public void testDimensioneListaArchivioFilm() {
        Assertions.assertEquals(2, archivio.getListaFilm().size());
    }
    
    @Test
    public void testDettagliAttore() {
        Film film1 = archivio.getListaFilm().get(0);
        Assertions.assertEquals("USA", film1.listaDettagliAttore().get(0).getNazionalita());
    }
    
    @Test
    public void testverificaAttoriDuplicati() {
        Assertions.assertFalse(archivio.isDuplicato());
    }
}
