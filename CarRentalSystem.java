import java.util.Scanner;

class Customer {
String name;
int age;
String lnNumber;

public Customer(String name, int age, String lnNumber) {
this.name = name;
this.age = age;
this.lnNumber = lnNumber;
}

public void displayCustomerDetails() {
    System.out.println("Customer Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("License Number: " + lnNumber);
}
}

class Car {
String brand;
String model;
double DailyPrice;

public Car(String model, String brand, double DailyPrice) {
this.model = model;
this.brand = brand;
this.DailyPrice = DailyPrice;
}

public void displayDetails() {
System.out.println("Car Model: " + model);
System.out.println("Brand: " + brand);
System.out.println("Price per day: $" + DailyPrice);
}
}

class Rental {
    Customer customer;
    Car car;
    int rentalDays;
    double totalCost;

public Rental(Customer customer, Car car, int rentalDays) {
 this.customer = customer;
this.car = car;
this.rentalDays = rentalDays;
this.totalCost = car.DailyPrice * rentalDays;
}

public void displayRentalDetails() {
 System.out.println("Customer Name: " + customer.name);
 System.out.println("Car Model: " + car.model);
 System.out.println("Rental Days: " + rentalDays);
 System.out.println("Total Cost: $" + totalCost);
 }
}

class RentalAgency {
Car[] cars;
 boolean[] isCarRented;
int numberOfCars;

public RentalAgency(int size) {
cars = new Car[size];
isCarRented = new boolean[size];
numberOfCars = 0;
}

public void addCar(Car car) {
if (numberOfCars < cars.length) {
cars[numberOfCars] = car;
isCarRented[numberOfCars] = false; 
 numberOfCars++;
} else {
    System.out.println("No space to add more cars.");
}
}

public void displayAvailableCars() {
if (numberOfCars == 0) {
    System.out.println("No cars available.");
} else {
for (int i = 0; i < numberOfCars; i++) {
if (!isCarRented[i]) { // available cars
 System.out.println("Car " + (i + 1) + ":");
cars[i].displayDetails();
 System.out.println();
}
}
}
}

public void rentCar(int carIndex) {
if (!isCarRented[carIndex]) {
isCarRented[carIndex] = true;
System.out.println("Car " + (carIndex + 1) + " has been rented.");
} else {
System.out.println("Sorry, that car is already rented.");
}
 }

public void returnCar(int carIndex) {
if (isCarRented[carIndex]) {
isCarRented[carIndex] = false;
 System.out.println("Car " + (carIndex + 1) + " has been returned.");
}
 else {
     System.out.println("Car was not rented.");
}
}
}

public class CarRentalSystem {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

// Create RentalAgency
RentalAgency agency = new RentalAgency(3); 

// Add some cars
Car car1 = new Car("WagonR", "Suzuki", 50);
Car car2 = new Car("Ranger", "Ford", 150);
Car car3 = new Car("3201", "BMW", 100);
agency.addCar(car1);
agency.addCar(car2);
agency.addCar(car3);

 System.out.println("Available cars in the rental agency:");
agency.displayAvailableCars();

System.out.println("Enter customer details:");
System.out.print("Name: ");
String name = scanner.nextLine();
System.out.print("Age: ");
int age = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("License Number: ");
String licenseNumber = scanner.nextLine();

Customer customer = new Customer(name, age, licenseNumber);
 System.out.println("Customer Details:");
customer.displayCustomerDetails();

// Car rental
System.out.println("Choose a car by number (1-3): ");
int carChoice = scanner.nextInt();
if (carChoice >= 1 && carChoice <= 3) {
 agency.rentCar(carChoice - 1); // Rent the car if available
 System.out.print("For how many days would you like to rent this car? ");
 int rentalDays = scanner.nextInt();
 Rental rental = new Rental(customer, agency.cars[carChoice - 1], rentalDays);
System.out.println("Rental Details:");
rental.displayRentalDetails();
} else {
     System.out.println("Sorry, that car is not available.");
}

// Car return
 System.out.println("Would you like to return a car? (yes/no)");
scanner.nextLine(); // Consume newline
String returnResponse = scanner.nextLine();
if (returnResponse.equalsIgnoreCase("yes")) {
System.out.println("Which car would you like to return? (1-3): ");
 int returnCarChoice = scanner.nextInt();
agency.returnCar(returnCarChoice - 1);
}

scanner.close();
}
}
