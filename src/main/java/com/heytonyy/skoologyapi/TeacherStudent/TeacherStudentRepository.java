package com.heytonyy.skoologyapi.TeacherStudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherStudentRepository extends JpaRepository<TeacherStudent, TeacherStudentId> {
}
