package it.unibas.agenzia.persistenza;

import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Archivio;
import it.unibas.agenzia.modello.Costanti;
import it.unibas.agenzia.modello.PacchettoVacanza;
import java.time.LocalDate;

/**
 *
 * @author David
 */
public class DAOArchivio implements IDAOArchivio {

    /**
     *
     * @param file
     * @return
     * @throws DAOException
     */
    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Agenzia agenzia1 = new Agenzia(123, "Viaggiare in Allegria", "Roma"); // Il primo in ordine decrescente
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Egitto", 1400.0, LocalDate.of(2023, 7, 1), 5, Costanti.CROCIERA));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Spagna", 1100.0, LocalDate.of(2024, 6, 1), 6, Costanti.VILLAGGIO));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Parigi", 950.0, LocalDate.of(2024, 2, 14), 4, Costanti.CITTA));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Malta", 800.0, LocalDate.of(2024, 5, 15), 3, Costanti.CROCIERA));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Grecia", 1200.0, LocalDate.of(2023, 9, 10), 7, Costanti.VILLAGGIO));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Amsterdam", 3000.0, LocalDate.of(2024, 6, 5), 7, Costanti.CITTA));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Maldive", 2800.0, LocalDate.of(2024, 2, 28), 5, Costanti.CROCIERA));
        agenzia1.addPacchettoVacanza(new PacchettoVacanza("Mosca", 800.0, LocalDate.of(2024, 2, 17), 7, Costanti.VILLAGGIO));


        Agenzia agenzia2 = new Agenzia(456, "Travel & Fun", "Milano");
        agenzia2.addPacchettoVacanza(new PacchettoVacanza("Caraibi", 3500.0, LocalDate.of(2024, 12, 20), 10, Costanti.CROCIERA));

        Agenzia agenzia3 = new Agenzia(789, "Mondo Vacanze", "Napoli"); // Il primo in ordine crescente
        agenzia3.addPacchettoVacanza(new PacchettoVacanza("Norvegia", 2000.0, LocalDate.of(2023, 8, 5), 8, Costanti.CROCIERA));
        agenzia3.addPacchettoVacanza(new PacchettoVacanza("New York", 2500.0, LocalDate.of(2024, 10, 15), 7, Costanti.CITTA));

        archivio.addAgenzia(agenzia1);
        archivio.addAgenzia(agenzia2);
        archivio.addAgenzia(agenzia3);

        return archivio;
    }
}
