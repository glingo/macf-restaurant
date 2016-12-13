package restaurant.service;

import java.util.logging.Logger;
import restaurant.model.salle.Zone;
import restaurant.model.salle.Emplacement;

public class ZoneManager {
    //exemple LOG. Log plus clean que SysOut pour vérifier le code.
    private static final Logger LOG = Logger.getLogger(ZoneManager.class.getName());

	public Zone create(String numero) {
            
            LOG.info("je passe par create");
            
            
            
		throw new UnsupportedOperationException();
	}

	public Zone update(Zone zone) {
		throw new UnsupportedOperationException();
	}

	public Zone addEmplacement(Zone zone, Emplacement emplacement) {
		throw new UnsupportedOperationException();
	}

	public Zone removeEmplacement(Zone zone, Emplacement emplacement) {
		throw new UnsupportedOperationException();
	}

	public void delete(Zone zone) {
		throw new UnsupportedOperationException();
	}
}