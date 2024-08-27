package com.heytonyy.skoologyapi.Gradebook;

import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import com.heytonyy.skoologyapi.Teacher.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradebookService implements IGradebookService{
    GradebookRepository gradebookRepository;
    TeacherRepository teacherRepository;

    public GradebookService(GradebookRepository gradebookRepository, TeacherRepository teacherRepository) {
        this.gradebookRepository = gradebookRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Gradebook> getAllGradebooks() {
        return gradebookRepository.findAll();
    }

    @Override
    public Gradebook createGradebook(int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher != null) {
            Gradebook gradebook = new Gradebook();
            gradebook.setTeacher(teacher);
            return gradebookRepository.save(gradebook);
        }
        return null;
    }

    @Override
    public Gradebook getGradebookById(int id) {
        return gradebookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteGradebookById(int id) {
        if (gradebookRepository.existsById(id)) {
            gradebookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateGradebook(int id, Gradebook updatedGradebook) {
        Optional<Gradebook> optionalGradebook = gradebookRepository.findById(id);
        if (optionalGradebook.isPresent()) {
            Gradebook gradebook = optionalGradebook.get();
            gradebook.setTeacher(updatedGradebook.getTeacher());
            gradebookRepository.save(gradebook);
            return true;
        }
        return false;
    }
}
