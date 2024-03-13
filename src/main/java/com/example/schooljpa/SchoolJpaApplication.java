package com.example.schooljpa;

import com.example.schooljpa.school.School;
import com.example.schooljpa.school.SchoolRepository;
import com.example.schooljpa.student.Student;
import com.example.schooljpa.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class SchoolJpaApplication implements CommandLineRunner {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SchoolJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> students = new ArrayList<>();
        Student student0 = Student.builder()
                .firstName("John")
                .lastName("Galt")
                .email("johngalt@gmail.com")
                .age(22)
                .build();
        Student student1 = Student.builder()
                .firstName("Michael")
                .lastName("Brown")
                .email("michaelbrown@yahoo.com")
                .age(21)
                .build();
        Student student2 = Student.builder()
                .firstName("Emma")
                .lastName("Johnson")
                .email("emmajohnson@hotmail.com")
                .age(23)
                .build();
        Student student3 = Student.builder()
                .firstName("John")
                .lastName("Miller")
                .email("johnmiller@gmail.com")
                .age(25)
                .build();
        students.add(student0);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        studentRepository.saveAll(students);

        List<School> schools  = new ArrayList<>();
        School school0 = School.builder()
                .name("NIS")
                .studentsAmount(532)
                .build();

        School school1 = School.builder()
                .name("Sunrise Academy")
                .studentsAmount(789)
                .build();

        School school2 = School.builder()
                .name("Golden Hills High")
                .studentsAmount(621)
                .build();

        School school3 = School.builder()
                .name("Greenwood College")
                .studentsAmount(453)
                .build();
        schools.add(school0);
        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
        schoolRepository.saveAll(schools);

        School sunriseAcademy = schoolRepository.findSchoolByName("NIS");
        System.out.println("The name of the found school: " + sunriseAcademy.getName());

        int studentsAmount = schoolRepository.getStudentsAmountById(sunriseAcademy.getId());
        System.out.println("The number of students: " + studentsAmount);

        Student john = studentRepository.findStudentsByFirstName("Emma");
        System.out.println("Student's firstname: " + john.getFirstName());
    }
}
