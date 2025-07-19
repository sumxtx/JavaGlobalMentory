package org.example.datos;

import org.example.dominio.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.example.conexion.dbConnection.getConnection;

public class StudentDAO {
    public List<Student> listar(){
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

    public static void main(String[] args) {
        var studentDao = new StudentDAO();
        System.out.println("Listado de Estudiantes: ");
        List<Student> students = studentDao.listar();
        students.forEach(System.out::println);

        var student1 = new Student(1);
        var encontrado = studentDao.findStudentByID(student1);
        if(encontrado)
            System.out.println("Estudiante encontrado: " + student1);
        else
            System.out.println("No se encontro el Estudiante" + student1.getIdStudent());


    }
}
