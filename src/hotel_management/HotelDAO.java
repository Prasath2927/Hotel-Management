package hotel_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public void addHotel(Hotel hotel) throws SQLException {
        String query = "INSERT INTO hotels (name, location, description) VALUES (?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, hotel.getName());
            pstmt.setString(2, hotel.getLocation());
            pstmt.setString(3, hotel.getDescription());
            pstmt.executeUpdate();
        }
    }

    public List<Hotel> getAllHotels() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM hotels";
        try (Connection conn = Database_connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setLocation(rs.getString("location"));
                hotel.setDescription(rs.getString("description"));
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    public void updateHotel(Hotel hotel) throws SQLException {
        String query = "UPDATE hotels SET name = ?, location = ?, description = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, hotel.getName());
            pstmt.setString(2, hotel.getLocation());
            pstmt.setString(3, hotel.getDescription());
            pstmt.setInt(4, hotel.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteHotel(int id) throws SQLException {
        String query = "DELETE FROM hotels WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
