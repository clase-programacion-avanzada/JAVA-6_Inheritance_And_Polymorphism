package org.study.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.study.model.Vaccine;

public class VaccineService {

    private final List<Vaccine> vaccines;

    public VaccineService() {
        this.vaccines = new ArrayList<>();
    }

    public void loadVaccines(List<Vaccine> vaccines) {
        this.vaccines.addAll(vaccines);
    }

    public Map<String, Vaccine> getVaccinesById() {
        Map <String, Vaccine> vaccinesById = new HashMap<>();
        for (Vaccine vaccine : vaccines) {
            vaccinesById.put(vaccine.getId().toString(), vaccine);
        }
        return vaccinesById;
    }

    public List<Vaccine> getVaccines() {
        return new ArrayList<>(vaccines);
    }
}
