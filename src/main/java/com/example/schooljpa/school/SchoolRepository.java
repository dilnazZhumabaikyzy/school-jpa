package com.example.schooljpa.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolByName(String name);

    @Query("SELECT s.studentsAmount from School s where s.id = :id")
    int getStudentsAmountById(Long id);
}
