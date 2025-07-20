package org.example.datos;

import org.example.dominio.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.conexion.dbConnection.getConnection;

public class StudentDAO {
    public List<Student> listStudents(){
        List<Student> students = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM student ORDER BY id_student";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var student = new Student();
                student.setIdStudent(rs.getInt("id_student"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setPhone(rs.getString("phone"));
                student.setMail(rs.getString("mail"));
                students.add(student);
            }
        } catch(Exception e) {
            System.out.println("Ocurrio un error al seleccionar datos: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion" + e.getMessage());
            }
        }
        return students;
    }

    public boolean findStudentByID(Student student){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String query = "SELECT * FROM student WHERE id_student = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, student.getIdStudent());
            rs = ps.executeQuery();
            if(rs.next()){
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setPhone(rs.getString("phone"));
                student.setMail(rs.getString("mail"));
                return true;
            }
        }catch(Exception e){
            System.out.println("An error ocurred: " + e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrion un error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean insertStudent(Student student){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "INSERT INTO student(name, surname, phone, mail) " +
                " VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getPhone());
            ps.setString(4,student.getMail());
            ps.execute();
            return true;
        }
        catch (Exception e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
        finally{
            try{
                con.close();
            } catch(Exception e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
        return false;
    }
    public boolean modifyStudent(Student student){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "UPDATE student SET name=?, surname=?, phone=?, mail=? WHERE id_student=? ";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getPhone());
            ps.setString(4,student.getMail());
            ps.setInt(5,student.getIdStudent());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Failed to modify student");
        }
        finally {
            try{
                con.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }

    public boolean deleteStudent(Student student){
        PreparedStatement ps;
        Connection con = getConnection();
        String query = "DELETE FROM student WHERE id_student = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,student.getIdStudent());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to delete student");
        }
        finally {
            try{
                con.close();
            }
            catch (Exception e){
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
        return false;

    }
}
