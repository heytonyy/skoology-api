package com.heytonyy.skoologyapi.Student;

import com.heytonyy.skoologyapi.DTO.StudentDTO;
import com.heytonyy.skoologyapi.Mapper.EntityDTOMapper;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import com.heytonyy.skoologyapi.TeacherStudent.TeacherStudent;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public boolean deleteStudentById(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    studentRepository.save(student);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Set<Teacher> getTeachersByStudentId(int studentId) {
        return studentRepository.findById(studentId)
                .map(student -> student.getTeacherStudents().stream()
                        .map(TeacherStudent::getTeacher)
                        .collect(Collectors.toSet()))
                .orElse(Set.of());
    }


    public StudentDTO getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return EntityDTOMapper.toStudentDTO(student);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(EntityDTOMapper::toStudentDTO)
                .collect(Collectors.toList());
    }
}