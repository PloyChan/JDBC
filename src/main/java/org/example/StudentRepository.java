package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class StudentRepository implements AutoCloseable {
    private Connection connection;

    Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.132:5432/student","student","computer");
        }
        return connection;
    }

    void disconnect() throws SQLException {
        if(connection != null){
            connection.close();            System.out.println("successfully");
        }

    }
    List<Student> getAllStudent(String predicate) throws SQLException {
        List<Student> students = new ArrayList<>();

        try(final Statement statement = connection.createStatement();){
            final ResultSet resultSet = statement.executeQuery("select id,name from student where "+predicate);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Student st = new Student(id, name);
                students.add(st);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    void updateStudent(List<Student> students) throws SQLException {
        for(Student student : students){
            try(final Statement statement = connection.createStatement();){
                statement.executeUpdate("UPDATE student " +
                        "set " + student.getPredicateSet()+
                        " where "+student.getPredicate());

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void insertStudent2(List<Student> students) throws SQLException
    {
        for(Student student : students){
            try(final Statement statement = connection.createStatement();)
            {
                statement.executeUpdate("INSERT INTO student (name,id) values('"
                        +student.getName()+"', "
                        +student.getId()+")");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void deleteStudent(List<Student> students) throws SQLException {
        for (Student student : students){
            try(final Statement statement = connection.createStatement();){

                statement.executeUpdate("delete from student where "
                        +student.getPredicate());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void close() throws Exception {
        disconnect();
        System.out.println("close!");
    }
}
