package com.heytonyy.skoologyapi.Student;

import com.heytonyy.skoologyapi.DTO.StudentDTO;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO != null ? ResponseEntity.ok(studentDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        boolean deleted = studentService.deleteStudentById(id);
        return deleted
                ? ResponseEntity.ok("Student deleted successfully")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        boolean updated = studentService.updateStudent(id, updatedStudent);
        return updated
                ? ResponseEntity.ok("Student updated successfully")
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<Set<Teacher>> getTeachersByStudentId(@PathVariable int id) {
        Set<Teacher> teachers = studentService.getTeachersByStudentId(id);
        return ResponseEntity.ok(teachers);
    }
}