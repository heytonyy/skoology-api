package com.heytonyy.skoologyapi.Teacher;

import com.heytonyy.skoologyapi.DTO.TeacherDTO;
import com.heytonyy.skoologyapi.Student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable int id) {
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);
        return teacherDTO != null ? ResponseEntity.ok(teacherDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable int id) {
        boolean deleted = teacherService.deleteTeacherById(id);
        return deleted
                ? ResponseEntity.ok("Teacher deleted successfully")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTeacher(@PathVariable int id, @RequestBody Teacher updatedTeacher) {
        boolean updated = teacherService.updateTeacher(id, updatedTeacher);
        return updated
                ? ResponseEntity.ok("Teacher updated successfully")
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<Set<Student>> getStudentsByTeacherId(@PathVariable int id) {
        Set<Student> students = teacherService.getStudentsByTeacherId(id);
        return ResponseEntity.ok(students);
    }
}