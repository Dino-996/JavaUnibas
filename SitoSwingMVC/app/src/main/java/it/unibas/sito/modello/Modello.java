package it.unibas.sito.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<ECostanti, Object> beans = new HashMap<>();

    public Object getBean(ECostanti chiave) {
        return this.beans.get(chiave);
    }

    public void putBean(ECostanti chiave, Object valore) {
        this.beans.put(chiave, valore);
    }
}
