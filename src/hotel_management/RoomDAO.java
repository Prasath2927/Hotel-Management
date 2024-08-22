package hotel_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void addRoom(Room room) throws SQLException {
        String query = "INSERT INTO rooms (hotel_id, room_number, room_type, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, room.getHotelId());
            pstmt.setString(2, room.getRoomNumber());
            pstmt.setString(3, room.getRoomType());
            pstmt.setDouble(4, room.getPrice());
            pstmt.executeUpdate();
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM rooms";
        try (Connection conn = Database_connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setHotelId(rs.getInt("hotel_id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setRoomType(rs.getString("room_type"));
                room.setPrice(rs.getDouble("price"));
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void updateRoom(Room room) throws SQLException {
        String query = "UPDATE rooms SET hotel_id = ?, room_number = ?, room_type = ?, price = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, room.getHotelId());
            pstmt.setString(2, room.getRoomNumber());
            pstmt.setString(3, room.getRoomType());
            pstmt.setDouble(4, room.getPrice());
            pstmt.setInt(5, room.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteRoom(int id) throws SQLException {
        String query = "DELETE FROM rooms WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
