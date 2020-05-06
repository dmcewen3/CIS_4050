/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import business.Student;
/**
 *
 * @author David
 */
public class database {
    
    public static Student getStudentFromRow(ResultSet rs) throws SQLException {
        
        int studentID = rs.getInt(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        String major = rs.getString(4);
        int year = rs.getInt(5);
        
        Student student = new Student(studentID, firstName, lastName, major, year);
        
        return student;
        
    }
    
    public static List<Student> getAll() throws DBException {
        String sql = "SELECT * FROM Student ORDER BY StudentID";
        List<Student> students = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = getStudentFromRow(rs);
                students.add(s);
            }
            rs.close();
            return students;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
        
    public static Student getStudent(int studentCode) throws DBException {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, studentCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = getStudentFromRow(rs);
                rs.close();
                return s;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public static void addStudent(Student student) throws DBException {
        String sql
                = "INSERT INTO Student (FirstName, LastName, Major, Year) "
                + "VALUES (?, ?, ?, ?)";
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getMajor());
            ps.setInt(4, student.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
