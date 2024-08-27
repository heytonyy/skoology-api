package com.heytonyy.skoologyapi.Teacher;

import com.heytonyy.skoologyapi.DTO.TeacherDTO;
import com.heytonyy.skoologyapi.Mapper.EntityDTOMapper;
import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.TeacherStudent.TeacherStudent;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public boolean deleteTeacherById(int id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTeacher(int id, Teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(updatedTeacher.getName());
                    teacher.setEmail(updatedTeacher.getEmail());
                    teacherRepository.save(teacher);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Set<Student> getStudentsByTeacherId(int teacherId) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> teacher.getTeacherStudents().stream()
                        .map(TeacherStudent::getStudent)
                        .collect(Collectors.toSet()))
                .orElse(Set.of());
    }

    public TeacherDTO getTeacherById(int id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return EntityDTOMapper.toTeacherDTO(teacher);
    }

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(EntityDTOMapper::toTeacherDTO)
                .collect(Collectors.toList());
    }
}