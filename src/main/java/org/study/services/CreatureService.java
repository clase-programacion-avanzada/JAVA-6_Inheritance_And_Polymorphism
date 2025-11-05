package org.study.services;

import org.study.model.MokeponBattle;
import org.study.exceptions.BaseMokeponNotExistsException;
import org.study.model.BaseMokepon;
import java.util.HashMap;
import java.util.Map;


public class CreatureService {

    private Map<String, BaseMokepon> mokeponsByName = new HashMap<>();
    //private Map<String, FireMokepon> fireMokeponsByName = new HashMap<>();
    //private Map<String, ElectricMokepon> electricMokeponsByName = new HashMap<>();

    public CreatureService() {
        loadMokepons();
    }

    private void loadMokepons() {
        // Load Mokepons from CSV or any other source
        // For simplicity, we will hardcode some Mokepons here
        BaseMokepon charizard = new BaseMokepon("Chorizard",  150, 25);
        mokeponsByName.put(charizard.getName().toLowerCase(), charizard);
        BaseMokepon blastoise = new BaseMokepon("Blustoise", 160, 22);
        mokeponsByName.put(blastoise.getName().toLowerCase(), blastoise);
        BaseMokepon pidgeot = new BaseMokepon("Pidgeot", 130, 24);
        mokeponsByName.put(pidgeot.getName().toLowerCase(), pidgeot);
        BaseMokepon pokachu = new BaseMokepon("Pokachu", 125, 28);
        mokeponsByName.put(pokachu.getName().toLowerCase(), pokachu);
        BaseMokepon vaporeon = new BaseMokepon("Vaporeon", 180, 20);
        mokeponsByName.put(vaporeon.getName().toLowerCase(), vaporeon);

    }

    public MokeponBattle getMokeponByName(String name) {
        BaseMokepon mokepon = mokeponsByName.get(name.toLowerCase());
        
        if (mokepon == null) {
            throw new BaseMokeponNotExistsException(
                "Mokepon with name " + name + " does not exist."
            );
        }
        
        return new MokeponBattle(mokepon);
    }




}
