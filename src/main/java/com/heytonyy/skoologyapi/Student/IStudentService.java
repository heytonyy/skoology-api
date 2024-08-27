package com.heytonyy.skoologyapi.Student;

import com.heytonyy.skoologyapi.DTO.StudentDTO;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import java.util.List;
import java.util.Set;

public interface IStudentService {
    List<StudentDTO> getAllStudents();
    Student createStudent(Student student);
    StudentDTO getStudentById(int id);
    boolean deleteStudentById(int id);
    boolean updateStudent(int id, Student updatedStudent);
    Set<Teacher> getTeachersByStudentId(int studentId);
}