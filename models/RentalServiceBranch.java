package VehicleRentalSystem.models;

import java.util.HashMap;

public class RentalServiceBranch extends AbstractRentalServiceBranch {

    public RentalServiceBranch (HashMap<VehicleType, Integer> vehicleCountMapping,
                                HashMap<VehicleType, Double> vehiclePriceMapping) {
        super(vehicleCountMapping, vehiclePriceMapping);
    }
}
