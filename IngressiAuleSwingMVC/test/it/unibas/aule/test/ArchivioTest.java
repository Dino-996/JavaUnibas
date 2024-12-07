package it.unibas.aule.test;

import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.persistenza.DAOArchivio;
import it.unibas.aule.persistenza.DAOException;
import it.unibas.aule.persistenza.IDAOArchivio;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArchivioTest {

    IDAOArchivio daoArchivio = new DAOArchivio();
    Archivio archivio;

    @Before
    public void setUp() {
        try {
            this.archivio = daoArchivio.carica("");
        } catch (DAOException e) {
            Assert.fail("Errore durante il caricamento dell'archivio: " + e);
        }
    }

    @Test
    public void testAggiungiAule() {
        List<Aula> listaAule = archivio.getListaAule();
        Assert.assertEquals(2, listaAule.size());
    }

    @Test
    public void testListaPiano() {
        List<Aula> listaAule = archivio.getListaAule();
        Aula a1 = listaAule.get(0);
        Aula test = listaAule.get(1);
        Aula amd = listaAule.get(2);
        Assert.assertEquals(a1.getCodiceUnivoco(), archivio.getListaPiano(1).get(0).getCodiceUnivoco());
        Assert.assertEquals(test.getCodiceUnivoco(), archivio.getListaPiano(1).get(1).getCodiceUnivoco());
        Assert.assertEquals(amd.getCodiceUnivoco(), archivio.getListaPiano(0).get(0).getCodiceUnivoco());
    }
    
    @Test
    public void testVerificaArchivio() { 
        Assert.assertTrue(archivio.verificaArchivio());
        
    }
}
