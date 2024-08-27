package com.heytonyy.skoologyapi.TeacherStudent;
import com.heytonyy.skoologyapi.DTO.TeacherStudentDTO;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/teacher-student")
public class TeacherStudentController {
    private final TeacherStudentService teacherStudentService;

    public TeacherStudentController(TeacherStudentService teacherStudentService) {
        this.teacherStudentService = teacherStudentService;
    }

    @PostMapping
    public ResponseEntity<TeacherStudent> createTeacherStudent(@RequestBody TeacherStudentDTO dto) {
        TeacherStudent created = teacherStudentService.createTeacherStudent(dto.getTeacherId(), dto.getStudentId(), dto.getPeriod());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{teacherId}/{studentId}")
    public ResponseEntity<TeacherStudent> getTeacherStudent(@PathVariable int teacherId,
                                                            @PathVariable int studentId) {
        TeacherStudent teacherStudent = teacherStudentService.getTeacherStudentById(teacherId, studentId);
        return new ResponseEntity<>(teacherStudent, HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<TeacherStudent>> getTeacherStudentsByTeacher(@PathVariable int teacherId) {
        List<TeacherStudent> teacherStudents = teacherStudentService.getTeacherStudentsByTeacherId(teacherId);
        return new ResponseEntity<>(teacherStudents, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TeacherStudent>> getTeacherStudentsByStudent(@PathVariable int studentId) {
        List<TeacherStudent> teacherStudents = teacherStudentService.getTeacherStudentsByStudentId(studentId);
        return new ResponseEntity<>(teacherStudents, HttpStatus.OK);
    }

    @PutMapping("/{teacherId}/{studentId}")
    public ResponseEntity<TeacherStudent> updateTeacherStudent(@PathVariable int teacherId,
                                                               @PathVariable int studentId,
                                                               @RequestParam int newPeriod) {
        TeacherStudent updated = teacherStudentService.updateTeacherStudent(teacherId, studentId, newPeriod);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}/{studentId}")
    public ResponseEntity<Void> deleteTeacherStudent(@PathVariable int teacherId,
                                                     @PathVariable int studentId) {
        teacherStudentService.deleteTeacherStudent(teacherId, studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
