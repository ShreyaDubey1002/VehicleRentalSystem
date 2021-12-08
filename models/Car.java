package VehicleRentalSystem.models;

public class Car extends AbstractVehicle {

    Car (int id, String registrationNumber, double rentPerHour) {
        super (id, registrationNumber);
        this.vehicleType = VehicleType.CAR;
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
