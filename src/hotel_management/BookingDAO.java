package hotel_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO bookings (room_id, customer_id, check_in_date, check_out_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, booking.getRoomId());
            pstmt.setInt(2, booking.getCustomerId());
            pstmt.setDate(3, booking.getCheckInDate());
            pstmt.setDate(4, booking.getCheckOutDate());
            pstmt.setString(5, booking.getStatus());
            pstmt.executeUpdate();
        }
    }

    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        try (Connection conn = Database_connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setRoomId(rs.getInt("room_id"));
                booking.setCustomerId(rs.getInt("customer_id"));
                booking.setCheckInDate(rs.getDate("check_in_date"));
                booking.setCheckOutDate(rs.getDate("check_out_date"));
                booking.setStatus(rs.getString("status"));
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public void updateBooking(Booking booking) throws SQLException {
        String query = "UPDATE bookings SET room_id = ?, customer_id = ?, check_in_date = ?, check_out_date = ?, status = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, booking.getRoomId());
            pstmt.setInt(2, booking.getCustomerId());
            pstmt.setDate(3, booking.getCheckInDate());
            pstmt.setDate(4, booking.getCheckOutDate());
            pstmt.setString(5, booking.getStatus());
            pstmt.setInt(6, booking.getId());
            pstmt.executeUpdate();
        }
    }

    public void cancelBooking(int id) throws SQLException {
        String query = "UPDATE bookings SET status = 'Cancelled' WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
