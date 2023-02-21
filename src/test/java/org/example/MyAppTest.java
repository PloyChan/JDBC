package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static java.sql.DriverManager.getConnection;


public class MyAppTest {
    @Test
    public void test() throws SQLException {

        StudentRepository sr = new StudentRepository();
        sr.getConnection();
        //List<Student> allStudent = sr.getAllStudent("id" ,"34");

//        for(Student s : allStudent) {
//            System.out.println(s);
//        }
        sr.disconnect();
    }
    @Test
    public void xx(){
        for(Object x: new Something()){
            System.out.println(x);
        }
    }

    @Test
    public void insertTest() throws SQLException {
        List<Student> students = new ArrayList<>();

        StudentRepository sr = new StudentRepository();

        Student s2 = new Student(33,"Shija");
        Student s = new Student(32,"xxx");
        Student s3 = new Student(34,"yyy");
        students.add(s);
        students.add(s2);
        students.add(s3);
        sr.insertStudent2(students);
    }


    @Test
    public void deleteTest()  throws SQLException{

        List<Student> studentsDelete = new ArrayList<>();
        List<Student> studentsInsert = new ArrayList<>();
        List<Student> studentsUpdate = new ArrayList<>();


        try(StudentRepository sr = new StudentRepository()){
            sr.getConnection();
    //predicate = "name = 'ploy' AND id = 30"
            List<Student> allStudent = sr.getAllStudent("name = 'ploy' AND id = 30");

            for(Student s : allStudent) {
                System.out.println(s);
            }

            Student s = new Student("id = 27");
            Student s1 = new Student("id = 26");
            studentsDelete.add(s);
            studentsDelete.add(s1);
            sr.deleteStudent(studentsDelete);

            Student s2 = new Student(54,"Shija");
            Student s4 = new Student(53,"xxx");
            studentsInsert.add(s4);
            studentsInsert.add(s2);
            sr.insertStudent2(studentsInsert);

            Student su = new Student("name = 'ploy'","id = 45");
            Student su2 = new Student("name = 'ploy'","name = 'Ron'");
            studentsUpdate.add(su);
            studentsUpdate.add(su2);
            sr.updateStudent(studentsUpdate);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
