//package vechiclerentalsystem;
import java.util.*;
abstract class vehicle{
    private String id;
    private boolean available;
    public vehicle(String id){
        this.id = id;
        this.available = true;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public abstract double getRentalCost(int days);
    public abstract double getMileage();
}
class car extends vehicle{
    public double dailyRate;
    public double Mileage;
    public car(String id, double dailyRate, double mileage) {
        super(id);
        this.dailyRate = dailyRate;
        this.Mileage = mileage;
    }
    public double getRentalCost(int days){
        return days*dailyRate;
    }
    public double getMileage(){
        return Mileage;
    }
}
class truck extends vehicle{
    public double dailyRate;
    public double Mileage;
    public truck(String id, double dailyRate, double mileage) {
        super(id);
        this.dailyRate = dailyRate;
        Mileage = mileage;
    }
    public double getRentalCost(int days){
        return days*dailyRate;
    }
    public double getMileage(){
        return Mileage;
    }
}
class motorCycle extends vehicle{
    public double dailyRate;
    public double Mileage;
    public motorCycle(String id, double dailyRate, double mileage) {
        super(id);
        this.dailyRate = dailyRate;
        Mileage = mileage;
    }
    public double getRentalCost(int days){
        return days*dailyRate;
    }
    public double getMileage(){
        return Mileage;
    }
}


class vechicleRentalSystem {
    private List<vehicle> inventroy;
    public  vechicleRentalSystem(){
        this.inventroy = new ArrayList<>();
    }
    public void addVehicle(vehicle Vehicle)
    {
        inventroy.add(Vehicle);
    }
    public void displayAvalability(){
        System.out.println("Availability Vehicle : ");
        for(vehicle u : inventroy)
        {
            if(u.isAvailable())
            {
                System.out.println("The vehicleId : "+u.getId());
                System.out.println("The vehicle Milege : "+u.getMileage());
            }
        }
    }
    public void gettingRental(String id,int days)
    {
        System.out.print("The Availability of "+id+" is : ");
        int count = 0;
        for(vehicle u : inventroy)
        {
            if(u.getId().equals(id) && u.isAvailable())
            {
                System.out.println(u.isAvailable());
                u.setAvailable(false);
                System.out.println("Vehicle "+id+" Rented for : "+days);
                System.out.println("The total cost is : "+u.getRentalCost(days));
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("The element is not Found");
        }
    }
    public void returnVehicle(String id)
    {
        for(vehicle u : inventroy)
        {
            if(u.getId().equals(id) && !u.isAvailable())
            {
                System.out.println("Vehicle "+id+" And the Vehicle is Returncd");
                u.setAvailable(true);
                return;
            }
        }
        System.out.println("The vehicle is Already Returned!!!");
    }
    public void searchMileage(double minMileage,double maxMileage)
    {
        System.out.println("The vehicles in your range are : ");
        for(vehicle u:inventroy)
        {
            if(u.getMileage()>=minMileage && u.getMileage()<=maxMileage)
            {
                System.out.println("The id :"+u.getId());
                System.out.println("The Mileage :"+u.getMileage());
            }
        }
    }
    public double totalEarning(int days,double total){
        
        for(vehicle u:inventroy)
        {
            if(!u.isAvailable())
            {
                total+=u.getRentalCost(days);
            }
        }
        System.out.println("The total Sales is : "+total);
        return total;
    }
}

public class Main{
    public static void main(String[] args){
            vechicleRentalSystem rental = new vechicleRentalSystem();
            vehicle car = new car("001", 20, 35);
            vehicle truck = new truck("002", 50, 10);
            vehicle motorcycle = new motorCycle("003", 10, 40);
            rental.addVehicle(car);
            rental.addVehicle(truck);
            rental.addVehicle(motorcycle);
            double total = 0;
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("==================VEHICLE RENTAL SYSTEM===============");
                System.out.println("1--> Display the Vehicle");
                System.out.println("2--> Get vehicle for Rent");
                System.out.println("3--> Return the vehicle");
                System.out.println("4--> Get vehicle by Mileage");
                System.out.println("5--> Total cost of rental ");
                System.out.println("6--> Quit");
                System.out.print("Enter the Choice : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        rental.displayAvalability();
                        break;
                    case 2:
                        System.out.print("Enter the vehicle Id to rent : ");
                        String id = sc.next();
                        System.out.print("Enter the Number of days : ");
                        int days = sc.nextInt();
                        rental.gettingRental(id, days);
                        break;
                    case 3:
                        System.out.print("Enter the vehicle Id to retrun : ");
                        String vehicleId = sc.next();
                        rental.returnVehicle(vehicleId);
                        break;
                    case 4 :
                        System.out.print("Enter the Minimum Mileage You Require : ");
                        double minmileage = sc.nextDouble();
                        System.out.print("Enter the Maximum Mileage You Require : ");
                        double maxmileage = sc.nextDouble();
                        rental.searchMileage(minmileage,maxmileage);
                        break;
                    case 5 :
                        total = rental.totalEarning(1,total);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Enter the valid choice:");
                }
            }
    }
}
