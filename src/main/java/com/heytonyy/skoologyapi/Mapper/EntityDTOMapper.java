package com.heytonyy.skoologyapi.Mapper;

import com.heytonyy.skoologyapi.Teacher.Teacher;
import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.TeacherStudent.TeacherStudent;
import com.heytonyy.skoologyapi.DTO.*;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDTOMapper {

    public static TeacherDTO toTeacherDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getTeacherId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        dto.setStudents(teacher.getTeacherStudents().stream()
                .map(ts -> toStudentSummaryDTO(ts.getStudent()))
                .collect(Collectors.toList()));
        return dto;
    }

    public static StudentDTO toStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getStudentId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setTeachers(student.getTeacherStudents().stream()
                .map(ts -> toTeacherSummaryDTO(ts.getTeacher()))
                .collect(Collectors.toList()));
        return dto;
    }

    public static TeacherSummaryDTO toTeacherSummaryDTO(Teacher teacher) {
        TeacherSummaryDTO dto = new TeacherSummaryDTO();
        dto.setId(teacher.getTeacherId());
        dto.setName(teacher.getName());
        return dto;
    }

    public static StudentSummaryDTO toStudentSummaryDTO(Student student) {
        StudentSummaryDTO dto = new StudentSummaryDTO();
        dto.setId(student.getStudentId());
        dto.setName(student.getName());
        return dto;
    }

    public static TeacherStudent toTeacherStudent(TeacherStudentDTO dto) {
        TeacherStudent teacherStudent = new TeacherStudent();
        // You'll need to set the id, teacher, and student here
        // This might involve looking up the Teacher and Student entities
        teacherStudent.setPeriod(dto.getPeriod());
        return teacherStudent;
    }
}