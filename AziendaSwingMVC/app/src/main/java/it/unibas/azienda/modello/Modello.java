package it.unibas.azienda.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private final Map<ECostanti, Object> beans = new HashMap<>();

    public Object getBeans(ECostanti chiave) {
        return this.beans.get(chiave);
    }

    public void putBeans(ECostanti chiave, Object valore) {
        this.beans.put(chiave, valore);
    }
}
