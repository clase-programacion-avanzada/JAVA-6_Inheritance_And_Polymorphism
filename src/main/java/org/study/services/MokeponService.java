package org.study.services;

import java.util.ArrayList;
import java.util.List;
import org.study.model.ElectricMokepon;
import org.study.model.FireMokepon;
import org.study.model.MokeponBattle;
import org.study.exceptions.BaseMokeponNotExistsException;
import org.study.model.BaseMokepon;
import java.util.HashMap;
import java.util.Map;


public class MokeponService {

    private Map<String, BaseMokepon> mokeponsByName = new HashMap<>();
    //private Map<String, FireMokepon> fireMokeponsByName = new HashMap<>();
    //private Map<String, ElectricMokepon> electricMokeponsByName = new HashMap<>();

    public MokeponService() {
        loadMokepons();
    }

    private void loadMokepons() {
        // Load Mokepons from CSV or any other source
        // For simplicity, we will hardcode some Mokepons here
        BaseMokepon charizard =
            new FireMokepon("Chorizard",  150, 25, 0.3f, 5);
        mokeponsByName.put(charizard.getName().toLowerCase(), charizard);
        BaseMokepon pokachu =
            new ElectricMokepon("Pokachu", 125, 28, 1);
        mokeponsByName.put(pokachu.getName().toLowerCase(), pokachu);

    }

    public List<BaseMokepon> getFireMokepons() {

        List<BaseMokepon> mokepons = new ArrayList<>();

        for (BaseMokepon mokepon : mokeponsByName.values()) {
            if (mokepon instanceof FireMokepon) {
                mokepons.add(mokepon);
            }
        }

        return mokepons;

    }

    public List<BaseMokepon> getMokeponsByType(String type) {
        List<BaseMokepon> mokepons = new ArrayList<>();

        for (BaseMokepon mokepon : mokeponsByName.values()) {
            if (mokepon.getClass().getSimpleName().equalsIgnoreCase(type)) {
                mokepons.add(mokepon);
            }
        }

        return mokepons;
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
