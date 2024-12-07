package it.unibas.fitness.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {
    
    private Map<ECostanti, Object> beans = new HashMap<>();
    
    public void putBean(ECostanti chiave, Object valore) {
        this.beans.put(chiave, valore);
    }
    
    public Object getBean(ECostanti chiave) {
        return this.beans.get(chiave);
    }
}
