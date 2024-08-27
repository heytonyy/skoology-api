package com.heytonyy.skoologyapi.Teacher;

import com.heytonyy.skoologyapi.DTO.TeacherDTO;
import com.heytonyy.skoologyapi.Student.Student;
import java.util.List;
import java.util.Set;

public interface ITeacherService {
    List<TeacherDTO> getAllTeachers();
    Teacher createTeacher(Teacher teacher);
    TeacherDTO getTeacherById(int id);
    boolean deleteTeacherById(int id);
    boolean updateTeacher(int id, Teacher updatedTeacher);
    Set<Student> getStudentsByTeacherId(int teacherId);
}