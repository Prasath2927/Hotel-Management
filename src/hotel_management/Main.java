package hotel_management;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static HotelDAO hotelDAO = new HotelDAO();
    private static RoomDAO roomDAO = new RoomDAO();
    private static CustomerDAO customerDAO = new CustomerDAO();
    private static BookingDAO bookingDAO = new BookingDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Manage Hotels");
            System.out.println("2. Manage Rooms");
            System.out.println("3. Manage Customers");
            System.out.println("4. Manage Bookings");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choice) {
                case 1:
                    manageHotels();
                    break;
                case 2:
                    manageRooms();
                    break;
                case 3:
                    manageCustomers();
                    break;
                case 4:
                    manageBookings();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void manageHotels() {
        while (true) {
            System.out.println("Manage Hotels");
            System.out.println("1. Add Hotel");
            System.out.println("2. View Hotels");
            System.out.println("3. Update Hotel");
            System.out.println("4. Delete Hotel");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter hotel name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter location: ");
                        String location = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        Hotel hotel = new Hotel();
                        hotel.setName(name);
                        hotel.setLocation(location);
                        hotel.setDescription(description);
                        hotelDAO.addHotel(hotel);
                        System.out.println("Hotel added successfully.");
                        break;
                    case 2:
                        List<Hotel> hotels = hotelDAO.getAllHotels();
                        System.out.println("Hotels:");
                        for (Hotel h : hotels) {
                            System.out.println("ID: " + h.getId() + ", Name: " + h.getName() + ", Location: " + h.getLocation() + ", Description: " + h.getDescription());
                        }
                        break;
                    case 3:
                        System.out.print("Enter hotel ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new hotel name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new location: ");
                        String newLocation = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        Hotel updateHotel = new Hotel();
                        updateHotel.setId(updateId);
                        updateHotel.setName(newName);
                        updateHotel.setLocation(newLocation);
                        updateHotel.setDescription(newDescription);
                        hotelDAO.updateHotel(updateHotel);
                        System.out.println("Hotel updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter hotel ID to delete: ");
                        int deleteId = scanner.nextInt();
                        hotelDAO.deleteHotel(deleteId);
                        System.out.println("Hotel deleted successfully.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void manageRooms() {
        while (true) {
            System.out.println("Manage Rooms");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Update Room");
            System.out.println("4. Delete Room");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter hotel ID: ");
                        int hotelId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter room number: ");
                        String roomNumber = scanner.nextLine();
                        System.out.print("Enter room type: ");
                        String roomType = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); 
                        Room room = new Room();
                        room.setHotelId(hotelId);
                        room.setRoomNumber(roomNumber);
                        room.setRoomType(roomType);
                        room.setPrice(price);
                        roomDAO.addRoom(room);
                        System.out.println("Room added successfully.");
                        break;
                    case 2:
                        List<Room> rooms = roomDAO.getAllRooms();
                        System.out.println("Rooms:");
                        for (Room r : rooms) {
                            System.out.println("ID: " + r.getId() + ", Hotel ID: " + r.getHotelId() + ", Room Number: " + r.getRoomNumber() + ", Room Type: " + r.getRoomType() + ", Price: " + r.getPrice());
                        }
                        break;
                    case 3:
                        System.out.print("Enter room ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new hotel ID: ");
                        int newHotelId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new room number: ");
                        String newRoomNumber = scanner.nextLine();
                        System.out.print("Enter new room type: ");
                        String newRoomType = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();  
                        Room updateRoom = new Room();
                        updateRoom.setId(updateId);
                        updateRoom.setHotelId(newHotelId);
                        updateRoom.setRoomNumber(newRoomNumber);
                        updateRoom.setRoomType(newRoomType);
                        updateRoom.setPrice(newPrice);
                        roomDAO.updateRoom(updateRoom);
                        System.out.println("Room updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter room ID to delete: ");
                        int deleteId = scanner.nextInt();
                        roomDAO.deleteRoom(deleteId);
                        System.out.println("Room deleted successfully.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void manageCustomers() {
        while (true) {
            System.out.println("Manage Customers");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter customer phone number: ");
                        String phoneNumber = scanner.nextLine();
                        Customer customer = new Customer();
                        customer.setName(name);
                        customer.setEmail(email);
                        customer.setPhoneNumber(phoneNumber);
                        customerDAO.addCustomer(customer);
                        System.out.println("Customer added successfully.");
                        break;
                    case 2:
                        List<Customer> customers = customerDAO.getAllCustomers();
                        System.out.println("Customers:");
                        for (Customer c : customers) {
                            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Email: " + c.getEmail() + ", Phone Number: " + c.getPhoneNumber());
                        }
                        break;
                    case 3:
                        System.out.print("Enter customer ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new customer name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new customer email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new customer phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        Customer updateCustomer = new Customer();
                        updateCustomer.setId(updateId);
                        updateCustomer.setName(newName);
                        updateCustomer.setEmail(newEmail);
                        updateCustomer.setPhoneNumber(newPhoneNumber);
                        customerDAO.updateCustomer(updateCustomer);
                        System.out.println("Customer updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter customer ID to delete: ");
                        int deleteId = scanner.nextInt();
                        customerDAO.deleteCustomer(deleteId);
                        System.out.println("Customer deleted successfully.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void manageBookings() {
        while (true) {
            System.out.println("Manage Bookings");
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter room ID: ");
                        int roomId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter customer ID: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter check-in date (YYYY-MM-DD): ");
                        String checkInDate = scanner.nextLine();
                        System.out.print("Enter check-out date (YYYY-MM-DD): ");
                        String checkOutDate = scanner.nextLine();
                        System.out.print("Enter status (Booked, Checked-in, Checked-out, Cancelled): ");
                        String status = scanner.nextLine();
                        Booking booking = new Booking();
                        booking.setRoomId(roomId);
                        booking.setCustomerId(customerId);
                        booking.setCheckInDate(Date.valueOf(checkInDate));
                        booking.setCheckOutDate(Date.valueOf(checkOutDate));
                        booking.setStatus(status);
                        bookingDAO.addBooking(booking);
                        System.out.println("Booking added successfully.");
                        break;
                    case 2:
                        List<Booking> bookings = bookingDAO.getAllBookings();
                        System.out.println("Bookings:");
                        for (Booking b : bookings) {
                            System.out.println("ID: " + b.getId() + ", Room ID: " + b.getRoomId() + ", Customer ID: " + b.getCustomerId() + ", Check-In Date: " + b.getCheckInDate() + ", Check-Out Date: " + b.getCheckOutDate() + ", Status: " + b.getStatus());
                        }
                        break;
                    case 3:
                        System.out.print("Enter booking ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new room ID: ");
                        int newRoomId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter new customer ID: ");
                        int newCustomerId = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new check-in date (YYYY-MM-DD): ");
                        String newCheckInDate = scanner.nextLine();
                        System.out.print("Enter new check-out date (YYYY-MM-DD): ");
                        String newCheckOutDate = scanner.nextLine();
                        System.out.print("Enter new status (Booked, Checked-in, Checked-out, Cancelled): ");
                        String newStatus = scanner.nextLine();
                        Booking updateBooking = new Booking();
                        updateBooking.setId(updateId);
                        updateBooking.setRoomId(newRoomId);
                        updateBooking.setCustomerId(newCustomerId);
                        updateBooking.setCheckInDate(Date.valueOf(newCheckInDate));
                        updateBooking.setCheckOutDate(Date.valueOf(newCheckOutDate));
                        updateBooking.setStatus(newStatus);
                        bookingDAO.updateBooking(updateBooking);
                        System.out.println("Booking updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter booking ID to cancel: ");
                        int cancelId = scanner.nextInt();
                        bookingDAO.cancelBooking(cancelId);
                        System.out.println("Booking cancelled successfully.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}