package it.unibas.agenzia.test;

import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Archivio;
import it.unibas.agenzia.modello.Costanti;
import it.unibas.agenzia.persistenza.DAOArchivio;
import it.unibas.agenzia.persistenza.DAOException;
import it.unibas.agenzia.persistenza.IDAOArchivio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivioTest {

    IDAOArchivio daoArchivio = new DAOArchivio();
    Archivio archivio;

    @BeforeEach
    public void setUp() {
        try {
            archivio = daoArchivio.carica("");
        } catch (DAOException ex) {
            Assertions.fail("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
        }
    }

    @Test
    public void cercaAgenzia() {
        Assertions.assertEquals("Viaggiare in Allegria", archivio.cercaAgenzie(Costanti.NOME_DECRESCENTE).get(0).getNome());
        Assertions.assertEquals("Mondo Vacanze", archivio.cercaAgenzie(Costanti.NOME_CRESCENTE).get(0).getNome());
    }

    @Test
    public void nuovoPacchetto() {
        Agenzia agenzia1 = archivio.getListaAgenzie().get(0);
        Assertions.assertEquals(3, agenzia1.listaDettagliPacchettoVacanza().size());
        Assertions.assertEquals("domenica 10 settembre 2023", agenzia1.listaDettagliPacchettoVacanza().get(0).getDataPartenza());
    }
    
    @Test
    public void verificaArchivio() {
        Agenzia agenzia1 = archivio.getListaAgenzie().get(0);
        Assertions.assertTrue(agenzia1.isPacchettoSovrapposto());
    }
}
