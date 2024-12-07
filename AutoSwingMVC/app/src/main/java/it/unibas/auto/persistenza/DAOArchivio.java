package it.unibas.auto.persistenza;

import it.unibas.auto.modello.Archivio;
import it.unibas.auto.modello.Auto;
import it.unibas.auto.modello.Compravendita;
import java.time.LocalDate;
import java.time.Month;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Auto BMW = new Auto("IFG098PLO", "BMW X7", 2003);
        BMW.addCompravendita(new Compravendita(LocalDate.of(2006, Month.SEPTEMBER, 1), 350000, 6000, "Carlo Spada"));
        BMW.addCompravendita(new Compravendita(LocalDate.of(2003, Month.JANUARY, 1), 0, 38500, "Mario Rossi"));
        BMW.addCompravendita(new Compravendita(LocalDate.of(2004, Month.MARCH, 4), 54000, 35000, "Rocco Verdi"));
        BMW.addCompravendita(new Compravendita(LocalDate.of(2005, Month.JUNE, 8), 120000, 25000, "Mimmo Gialli"));
        BMW.addCompravendita(new Compravendita(LocalDate.of(2018, Month.JULY, 12), 121000, 24200, "Mimmo Best"));
        BMW.addCompravendita(new Compravendita(LocalDate.of(2005, Month.JUNE, 10), 300000, 10000, "Ettore Allegretti"));

        Auto Audi = new Auto("PSL012SUD", "Audi A1 Sportback", 2005);
        Audi.addCompravendita(new Compravendita(LocalDate.of(2004, Month.FEBRUARY, 10), 0, 29000, "Lorenzo Violi"));
        Audi.addCompravendita(new Compravendita(LocalDate.of(2005, Month.MAY, 22), 129400, 20000, "Gianna Grigi"));

        Auto Panda = new Auto("DSC035JKL", "Fiat Panda", 2008);
        Panda.addCompravendita(new Compravendita(LocalDate.of(2008, Month.OCTOBER, 18), 0, 6000, "Gianni Bianchi"));

        archivio.addAuto(BMW);
        archivio.addAuto(Audi);
        archivio.addAuto(Panda);

        return archivio;
    }

}
