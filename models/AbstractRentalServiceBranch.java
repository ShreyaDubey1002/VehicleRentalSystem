package VehicleRentalSystem.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AbstractRentalServiceBranch {
    HashMap<VehicleType, ArrayList<AbstractVehicle>> vehicleMapping;
    HashMap<VehicleType, Double> vehiclePriceMapping;
    int availableVehicleId;

    public HashMap<VehicleType, ArrayList<AbstractVehicle>> getVehicleMapping() {
        return vehicleMapping;
    }

    public void setVehicleMapping(HashMap<VehicleType, ArrayList<AbstractVehicle>> vehicleMapping) {
        this.vehicleMapping = vehicleMapping;
    }

    public HashMap<VehicleType, Double> getVehiclePriceMapping() {
        return vehiclePriceMapping;
    }

    public void setVehiclePriceMapping(HashMap<VehicleType, Double> vehiclePriceMapping) {
        this.vehiclePriceMapping = vehiclePriceMapping;
    }

    public int getAvailableVehicleId() {
        return availableVehicleId;
    }

    public void setAvailableVehicleId(int availableVehicleId) {
        this.availableVehicleId = availableVehicleId;
    }

    AbstractRentalServiceBranch(HashMap<VehicleType, Integer> vehicleCountMapping,
                                HashMap<VehicleType, Double> vehiclePriceMapping) {

        setVehiclePriceMapping(vehiclePriceMapping);
        setAvailableVehicleId(0);
        this.vehiclePriceMapping = vehiclePriceMapping;

        this.vehicleMapping = new HashMap<VehicleType, ArrayList<AbstractVehicle>>();
        for (Map.Entry<VehicleType, Integer> iter : vehicleCountMapping.entrySet()) {

            VehicleType curVehicleType = iter.getKey();
            Integer count = iter.getValue();

            for (int i=0; i<count; i++) {
                AbstractVehicle newVehicle = getVehicleObject(curVehicleType);
                if (!this.vehicleMapping.containsKey(curVehicleType)) {
                    this.vehicleMapping.put(curVehicleType, new ArrayList<AbstractVehicle>());
                }
                addVehicle(curVehicleType);
            }
        }
    }

    public void addVehicle (VehicleType vehicleType) {
        AbstractVehicle newVehicle = getVehicleObject(vehicleType);
        this.vehicleMapping.get(vehicleType).add(newVehicle);
    }

    AbstractVehicle getVehicleObject (VehicleType vehicleType) {

        this.availableVehicleId = this.availableVehicleId+1;
        AbstractVehicle newObject;

        switch(vehicleType) {
            case CAR : newObject = new Car(this.availableVehicleId, "",
                                           this.vehiclePriceMapping.get(vehicleType));
                       break;

            case BIKE : newObject = new Bike(this.availableVehicleId, "",
                                             this.vehiclePriceMapping.get(vehicleType));
                       break;

            default:
                throw new IllegalStateException("Unexpected value: " + vehicleType);
        }
        return newObject;
    }

}
