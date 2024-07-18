package strategies.spotassigningstrategies;

import models.Pair;
import models.SpotType;

public interface SpotAssignmentStrategy {

    Pair assignSpot(SpotType spotType, Long parkingLotId);
}
