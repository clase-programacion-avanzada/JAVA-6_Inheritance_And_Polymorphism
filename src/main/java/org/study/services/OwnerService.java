package org.study.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.study.exceptions.NotFoundException;
import org.study.model.owners.Owner;
import org.study.exceptions.UserNameAlreadyTakenException;

public class OwnerService {

   private final List<Owner> owners;

    public OwnerService() {
        this.owners = new ArrayList<>();
    }


    public List<Owner> getOwners() {
        return new ArrayList<>(owners);
    }

    public void loadOwners(List<Owner> owners) {
        clearDatabase();
        this.owners.addAll(owners);

    }

    private void clearDatabase() {
       owners.clear();
    }
}
