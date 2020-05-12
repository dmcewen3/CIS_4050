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
import business.Tutor;
/**
 *
 * 
 */
public class database {
    
    public static Student getStudentFromRow(ResultSet rs) throws SQLException {
        
        int StudentID = rs.getInt(1);
        String FirstName = rs.getString(2);
        String LastName = rs.getString(3);
        String Major = rs.getString(4);
        String Year = rs.getString(5);
        
        Student student = new Student(StudentID, FirstName, LastName, Major, Year);
        
        return student;
        
    }
    
    public static List<Student> getAllStudents() throws DBException {
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
            ps.setString(4, student.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
       public static Tutor getTutorFromRow(ResultSet rs) throws SQLException {
        
        int TutorID = rs.getInt(1);
        String FirstName = rs.getString(2);
        String LastName = rs.getString(3);
        String Year = rs.getString(4);
        
        Tutor tutor = new Tutor(TutorID, FirstName, LastName, Year);
        
        return tutor;
        
    }
    
    public static List<Tutor> getAllTutors() throws DBException {
        String sql = "SELECT * FROM Tutor ORDER BY TutorID";
        List<Tutor> tutors = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Tutor t = getTutorFromRow(rs);
                tutors.add(t);
            }
            rs.close();
            return tutors;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
        
    public static Tutor getTutor(int tutorCode) throws DBException {
        String sql = "SELECT * FROM Tutor WHERE TutorID = ?";
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, tutorCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tutor t = getTutorFromRow(rs);
                rs.close();
                return t;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public static void addTutor(Tutor tutor) throws DBException {
        String sql
                = "INSERT INTO Tutor (FirstName, LastName, Year) "
                + "VALUES (?, ?, ?)";
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, tutor.getFirstName());
            ps.setString(2, tutor.getLastName());
            ps.setString(3, tutor.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
}
