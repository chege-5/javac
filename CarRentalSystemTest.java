import org.junit.Test;
import static org.junit.Assert.*;

public class CarRentalSystemTest {

    // Test Customer Class
    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("John Doe", 30, "AB123456");
        
        assertEquals("Jimmy", customer.name);
        assertEquals(23, customer.age);
        assertEquals("13214", customer.lnNumber);
    }

    @Test
    public void testDisplayCustomerDetails() {
        Customer customer = new Customer("Jimmy", 23, "13214");
        customer.displayCustomerDetails();
    }

    // Test Car Class
    @Test
    public void testCarCreation() {
        Car car = new Car("WagonR", "Suzuki", 50);

        assertEquals("WagonR", car.model);
        assertEquals("Suzuki", car.brand);
        assertEquals(500, car.DailyPrice, 0.001);
    }

    @Test
    public void testDisplayCarDetails() {
        Car car = new Car("WagonR", "Suzuki", 50);
        car.displayDetails(); 
    }

    // Test Rental Class
    @Test
    public void testRentalCreation() {
        Customer customer = new Customer("Jimmy",23, "13214");
        Car car = new Car("WagonR", "Suzuki", 50);
        Rental rental = new Rental(customer, car, 3);

        assertEquals(customer, rental.customer);
        assertEquals(car, rental.car);
        assertEquals(3, rental.rentalDays);
        assertEquals(600, rental.totalCost, 0.001);
    }

    @Test
    public void testDisplayRentalDetails() {
        Customer customer = new Customer("Jimmy",23, "13214");
        Car car = new Car("WagonR", "Suzuki", 50);
        Rental rental = new Rental(customer, car, 3);
        rental.displayRentalDetails();
    }

    @Test
    public void testAddCar() {
        RentalAgency agency = new RentalAgency(2);
        Car car1 = new Car("Model S", "Tesla", 200);
        Car car2 = new Car("Mustang", "Ford", 150);

        agency.addCar(car1);
        agency.addCar(car2);

        assertEquals(2, agency.numberOfCars);
    }

    @Test
    public void testDisplayAvailableCars() {
        RentalAgency agency = new RentalAgency(2);
        Car car = new Car("Model S", "Tesla", 200);
        agency.addCar(car);
        agency.displayAvailableCars(); // This should output to console; manually check the console for correctness
    }

    @Test
    public void testRentCar() {
        RentalAgency agency = new RentalAgency(1);
        Car car = new Car("Model S", "Tesla", 200);
        agency.addCar(car);

        agency.rentCar(0);
        assertTrue(agency.isCarRented[0]); // Check that the car is marked as rented
    }

    @Test
    public void testReturnCar() {
        RentalAgency agency = new RentalAgency(1);
        Car car = new Car("Model S", "Tesla", 200);
        agency.addCar(car);

        agency.rentCar(0);
        agency.returnCar(0);
        assertFalse(agency.isCarRented[0]); // Check that the car is marked as returned
    }
}
