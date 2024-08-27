package com.heytonyy.skoologyapi.TeacherStudent;

import java.util.List;

public interface ITeacherStudentService {
    TeacherStudent createTeacherStudent(int teacherId, int studentId, int period);
    TeacherStudent getTeacherStudentById(int teacherId, int studentId);
    List<TeacherStudent> getTeacherStudentsByTeacherId(int teacherId);
    List<TeacherStudent> getTeacherStudentsByStudentId(int studentId);
    void deleteTeacherStudent(int teacherId, int studentId);
    TeacherStudent updateTeacherStudent(int teacherId, int studentId, int newPeriod);
}
