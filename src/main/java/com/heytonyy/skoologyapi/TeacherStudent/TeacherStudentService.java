package com.heytonyy.skoologyapi.TeacherStudent;

import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.Student.StudentRepository;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import com.heytonyy.skoologyapi.Teacher.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherStudentService implements ITeacherStudentService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final TeacherStudentRepository teacherStudentRepository;

    public TeacherStudentService(TeacherRepository teacherRepository, StudentRepository studentRepository, TeacherStudentRepository teacherStudentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.teacherStudentRepository = teacherStudentRepository;
    }

    @Override
    public TeacherStudent createTeacherStudent(int teacherId, int studentId, int period) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("Teacher not found with ID: " + teacherId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + studentId));

        TeacherStudentId teacherStudentId = new TeacherStudentId(teacherId, studentId);
        TeacherStudent teacherStudent = new TeacherStudent(teacherStudentId, teacher, student, period);

        return teacherStudentRepository.save(teacherStudent);
    }

    @Override
    public TeacherStudent getTeacherStudentById(int teacherId, int studentId) {
        TeacherStudentId id = new TeacherStudentId(teacherId, studentId);
        return teacherStudentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TeacherStudent not found for Teacher ID: " + teacherId + " and Student ID: " + studentId));
    }

    @Override
    public List<TeacherStudent> getTeacherStudentsByTeacherId(int teacherId) {
        return teacherStudentRepository.findAll().stream()
                .filter(ts -> ts.getTeacher().getTeacherId() == teacherId)
                .toList();
    }

    @Override
    public List<TeacherStudent> getTeacherStudentsByStudentId(int studentId) {
        return teacherStudentRepository.findAll().stream()
                .filter(ts -> ts.getStudent().getStudentId() == studentId)
                .toList();
    }

    @Override
    public void deleteTeacherStudent(int teacherId, int studentId) {
        TeacherStudentId id = new TeacherStudentId(teacherId, studentId);
        teacherStudentRepository.deleteById(id);
    }

    @Override
    public TeacherStudent updateTeacherStudent(int teacherId, int studentId, int newPeriod) {
        TeacherStudent teacherStudent = getTeacherStudentById(teacherId, studentId);
        teacherStudent.setPeriod(newPeriod);
        return teacherStudentRepository.save(teacherStudent);
    }


}
