package it.unibas.codicefiscale.test;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import static org.junit.Assert.*;
import org.junit.Test;

public class CodiceFiscaleTest {

    @Test
    public void testCodiceFiscale1() {
        Persona persona = new Persona("Jon", "Snow", 1996, Costanti.MASCHIO, "Winterfall");
        assertEquals("JONSNO1996M", persona.getCodiceFiscale());
    }

    @Test
    public void testCodiceFiscale2() {
        Persona persona = new Persona("Maria", "Rossi", 2001, Costanti.FEMMINA, "Milano");
        assertEquals("MARROS2001F", persona.getCodiceFiscale());
    }

    @Test
    public void codiceFiscaleScorretto() {
        Persona persona = new Persona("Maria", "Ro", 2001, Costanti.FEMMINA, "Milano");
        try {
            persona.getCodiceFiscale();
            fail("Il codice fiscale non doveva poter essere calcolato");
        } catch (IllegalArgumentException e) {
            // ...
        }
    }
}
