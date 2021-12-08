package VehicleRentalSystem.models;

public class Bike extends AbstractVehicle {

    Bike (int id, String registrationNumber, double rentPerHour) {
        super (id, registrationNumber);
        this.vehicleType = VehicleType.BIKE;
        this.rentPerHour = rentPerHour;
    }

    VehicleType getVehicleType () {
        return this.vehicleType;
    }

    double getRentPerHour() {
        return this.rentPerHour;
    }

    void setRentPerHour() {
        this.rentPerHour = rentPerHour;
    }
}
