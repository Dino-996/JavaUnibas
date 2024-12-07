package it.unibas.ricettario;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.persistenza.DAOArchivio;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import org.junit.*;

public class ArchivioTest {

    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private Archivio archivio;

    @Before
    public void setUp() {
        try {
            this.archivio = daoArchivio.carica("");
        } catch (DAOException e) {
            Assert.fail("Impossibile caricare l'archivio: " + e.getMessage());
        }
    }

    @Test
    public void testFiltroCategoria() {
        Assert.assertEquals(0, archivio.getPietanzePerCategoria(Costanti.ANTIPASTO).size());
        Assert.assertEquals(1, archivio.getPietanzePerCategoria(Costanti.PRIMO).size());
        Assert.assertEquals(1, archivio.getPietanzePerCategoria(Costanti.SECONDO).size());
        Assert.assertEquals(1, archivio.getPietanzePerCategoria(Costanti.DESSERT).size());
    }

    @Test
    public void textPietanzaSimileCategoria() {
        Pietanza pizzaMargherita = archivio.getListaPietanze().get(0);
        Pietanza carbonara = archivio.getListaPietanze().get(1);
        Pietanza pastaFrolla = archivio.getListaPietanze().get(2);

        Assert.assertEquals(carbonara.getNome(), archivio.pietanzaCaloricamenteSimile(pizzaMargherita).getNome());
        Assert.assertEquals(pastaFrolla.getNome(), archivio.pietanzaCaloricamenteSimile(carbonara).getNome());
        Assert.assertEquals(carbonara.getNome(), archivio.pietanzaCaloricamenteSimile(pastaFrolla).getNome());
    }
}
