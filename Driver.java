package VehicleRentalSystem.test;

import VehicleRentalSystem.models.VehicleType;
import VehicleRentalSystem.services.Booking;

import java.util.*;

class compareNum implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        return b.getValue()-a.getValue();
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        ArrayList<Integer> I = new ArrayList<Integer>();
        int n = 4;
        while (n>0) {
            I.add(sc.nextInt());
            n--;
        }

        Integer[] arr2 = {2, 3, 1};
        //Arrays.sort(arr2, Collections.reverseOrder());
        //Arrays.sort(arr2);
        Arrays.sort(arr2, new compareNum());
        for (int i=0;i<arr2.length;i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
        */

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("a", 3);
        hm.put("b", 1);
        hm.put("c", 2);
        hm.put("d", 4);

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, new compareNum());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.print(entry.getKey() + " " + entry.getValue());
        }
        /*
        String line;
        while (true) {
            line = sc.nextLine();
            String[] arr = line.split(" ");
            for (int i=0;i<arr.length;i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

         */
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cars : ");
        int cars = sc.nextInt();
        System.out.println("Enter number of bikes : ");
        int bikes = sc.nextInt();

        HashMap< VehicleType, Integer> vehicleCountMapping = new HashMap< VehicleType, Integer>();
        HashMap<VehicleType, Double> vehiclePriceMapping = new HashMap<VehicleType, Double>();

        vehicleCountMapping.put(VehicleType.CAR, cars);
        vehicleCountMapping.put(VehicleType.BIKE, bikes);

        vehiclePriceMapping.put(VehicleType.CAR, 100.0);
        vehiclePriceMapping.put(VehicleType.BIKE, 200.0);

        Booking bookingObject = new Booking(vehicleCountMapping, vehiclePriceMapping);
        String flag = "Y";

        while (flag.equalsIgnoreCase("Y")) {
            VehicleType vehicleType = null;
            System.out.println("Enter vehicle type (B/C)");
            String c = sc.next();
            if (c.equalsIgnoreCase("C"))
                vehicleType = VehicleType.CAR;
            else if (c.equalsIgnoreCase("B"))
                vehicleType = VehicleType.BIKE;
            
            int startHour;
            System.out.println("Enter start hour (0-24)");
            startHour = sc.nextInt();

            int numberOfHours;
            System.out.println("Enter number of hours");
            numberOfHours = sc.nextInt();
            
            bookingObject.bookVehicle(vehicleType, startHour, numberOfHours);

            System.out.println("Want to continue booking ? (Y/N)");
            flag = sc.next();
        }
    }
}
