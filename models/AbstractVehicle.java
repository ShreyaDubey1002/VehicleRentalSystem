package VehicleRentalSystem.models;

import java.lang.*;
import java.util.HashMap;

public abstract class AbstractVehicle {
    int vehicleId = 0;
    String registrationNumber;
    VehicleType vehicleType;
    double rentPerHour;
    HashMap<Integer, Boolean> availableMapping;

    AbstractVehicle(int vehicleId, String registrationNumber) {
        this.vehicleId = vehicleId;
        this.registrationNumber = registrationNumber;
        this.availableMapping = new HashMap<Integer, Boolean>();
        for (int i=0;i<24;i++) {
            availableMapping.put(i, false);
        }
    }

    public boolean isSlotAvailable (int startHour, int endHour) {
        for (int i=startHour; i<=endHour;i++) {
            if (availableMapping.get(i) == true) {
                return false;
            }
        }
        return true;
    }

    public void setSlotAvailable (int startHour, int endHour, boolean value) {
        for (int i=startHour; i<=endHour;i++) {
            availableMapping.put(i, value);
        }
    }

    public int getVehicleId () {
        return this.vehicleId;
    }

    public void setVehicleId (int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
