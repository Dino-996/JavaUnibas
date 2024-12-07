package it.unibas.concorsi.test;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.persistenza.DAOArchivio;
import it.unibas.concorsi.persistenza.DAOException;
import it.unibas.concorsi.persistenza.IDAOArchivio;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConcorsiTest {

    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private Archivio archivio;

    @Before
    public void setUp() {
        try {
            archivio = daoArchivio.carica("");
        } catch (DAOException e) {
            Assert.fail("Impossibile caricare l'archivio: " + e.getMessage());
        }
    }

    @Test
    public void testArchivio() {
        Assert.assertEquals(4, archivio.getListaConcorsi().size());
    }

    @Test
    public void testConcorsiFiltrati() {
        Assert.assertEquals("BS03", archivio.getConcorsiFiltrati("Basilicata", Costanti.ORDINAMENTO_POSTI_DECRESCENTE).get(0).getCodice());
        Assert.assertEquals("BS03", archivio.getConcorsiFiltrati("Basilicata", Costanti.ORDINAMENTO_DATA_CRESCENTE).get(0).getCodice());
    }

    @Test
    public void testCodiceFiscaleDuplicato() {
        Concorso concorso1 = archivio.getListaConcorsi().get(0);
        Concorso concorso2 = archivio.getListaConcorsi().get(1);
        Concorso concorso4 = archivio.getListaConcorsi().get(3);

        Assert.assertTrue(concorso1.isCodiceFiscaleDuplicato("FGH342NJR"));
        Assert.assertTrue(concorso1.isCodiceFiscaleDuplicato("XLM679VBG"));
        Assert.assertTrue(concorso2.isCodiceFiscaleDuplicato("JSL196SSO"));
        Assert.assertFalse(concorso4.isCodiceFiscaleDuplicato("ABC123DEF"));
    }

    @Test
    public void concorsoDuplicatoAltraRegione() {
        Concorso concorso1 = archivio.getListaConcorsi().get(0);
        Concorso concorso2 = archivio.getListaConcorsi().get(1);
        Concorso concorso3 = archivio.getListaConcorsi().get(2);
        Concorso concorso4 = archivio.getListaConcorsi().get(3);
        Concorso concorso5 = archivio.getListaConcorsi().get(4);

        Assert.assertTrue(archivio.verificaDomanda("ABC123DEF", concorso5));
        Assert.assertFalse(archivio.verificaDomanda("WBG789PLJ", concorso5));
        Assert.assertFalse(archivio.verificaDomanda("ABC123DEF", concorso2));
        Assert.assertFalse(archivio.verificaDomanda("JSL196SSO", concorso1));

    }
}
