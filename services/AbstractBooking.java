package VehicleRentalSystem.services;

import VehicleRentalSystem.models.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AbstractBooking {
        RentalServiceBranch rentalServiceBranch;
        boolean isDynamicPricing;

        public RentalServiceBranch getRentalServiceBranch() {
            return rentalServiceBranch;
        }

        public void setRentalServiceBranch(RentalServiceBranch rentalServiceBranch) {
            this.rentalServiceBranch = rentalServiceBranch;
        }

        public boolean isDynamicPricing() {
            return isDynamicPricing;
        }

        public void setDynamicPricing(boolean dynamicPricing) {
            isDynamicPricing = dynamicPricing;
        }

        public AbstractBooking (HashMap<VehicleType, Integer> vehicleCountMapping,
                        HashMap<VehicleType, Double> vehiclePriceMapping) {
            this.rentalServiceBranch = new RentalServiceBranch(vehicleCountMapping, vehiclePriceMapping);
            setDynamicPricing(isDynamicPricing);
        }

        public void bookVehicle (VehicleType vehicleType, int startHour, int numberOfHours) {
            if (vehicleType == null)
                return;
            if (startHour+numberOfHours > 24) {
                System.out.println("Time slot should be between 0-24!");
                return;
            }
            ArrayList<AbstractVehicle> mapping = rentalServiceBranch.getVehicleMapping().get(vehicleType);
            boolean found = false;

            for (AbstractVehicle cur : mapping) {
                if(cur.isSlotAvailable(startHour, startHour+numberOfHours-1)) {
                    cur.setSlotAvailable(startHour, startHour+numberOfHours-1, true);
                    found = true;
                    System.out.println("Total price : " + getPrice(vehicleType)*numberOfHours);
                    break;
                }
            }
            if (found == false) {
                System.out.println("No vehicle available for time slot!");
            }
        }

        public double getPrice(VehicleType vehicleType) {
            if (!isDynamicPricing)
                return rentalServiceBranch.getVehiclePriceMapping().get(vehicleType);
            else {
                return rentalServiceBranch.getVehiclePriceMapping().get(vehicleType);
            }
        }
    }
