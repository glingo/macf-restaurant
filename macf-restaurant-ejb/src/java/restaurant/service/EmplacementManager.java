package restaurant.service;

import java.util.List;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.Zone;

public class EmplacementManager {

    public Emplacement create(String numero, int nombrePlaces, String numeroZone) {
        throw new UnsupportedOperationException();
    }

    public List<Emplacement> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<Emplacement> getByZone(Zone zone) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToVacant(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToOccupied(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToCleaning(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }
}
