package com.heytonyy.skoologyapi.Gradebook;

import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import com.heytonyy.skoologyapi.Teacher.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gradebook")
public class GradebookController {
    GradebookService gradebookService;

    public GradebookController(GradebookService gradebookService) {
        this.gradebookService = gradebookService;
    }

    @GetMapping
    public ResponseEntity<List<Gradebook>> findAll() {
        return ResponseEntity.ok(gradebookService.getAllGradebooks());
    }

    @PostMapping
    public ResponseEntity<Gradebook> createGradebook(@RequestParam int teacherId){
        Gradebook gradebook = gradebookService.createGradebook(teacherId);
        if (gradebook != null) {
            return new ResponseEntity<>(gradebook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gradebook> getGradebookById(@PathVariable int id) {
        Gradebook gradebook = gradebookService.getGradebookById(id);
        if (gradebook != null) {
            return new ResponseEntity<>(gradebook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGradebookById(@PathVariable int id) {
        boolean hasBeenDeleted = gradebookService.deleteGradebookById(id);
        if (hasBeenDeleted) {
            return new ResponseEntity<String>("Gradebook deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Gradebook not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGradebook(@PathVariable int id, @RequestBody Gradebook updatedGradebook) {
        boolean hasBeenUpdated = gradebookService.updateGradebook(id, updatedGradebook);
        if (hasBeenUpdated) {
            return new ResponseEntity<String>("Gradebook updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Gradebook not found", HttpStatus.NOT_FOUND);
    }

}
