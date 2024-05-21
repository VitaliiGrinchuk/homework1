package org.example;
import java.sql.*;


public class Main {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "1100229933";
    public static void main(String[] args) {
    }
    //добавление студента в базу данных
    public void addStudent(String name, String email) {
        String query = "INSERT INTO Students (name, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Чтение информации о студентах из базы данных
    public void listStudents() {
        String query = "SELECT * FROM Students";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Обновление информации о студенте из базы данных
    public void updateStudent(int student_id, String name, String email) {
        String query = "UPDATE Students SET name = ?, email = ? WHERE student_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, student_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Удаление студента из базы данных
    public void deleteStudent(int student_id) {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}