package com.example.cicdgithub;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
@Slf4j
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAll(){
        log.info("REQUEST ALL STUDENTS");
        return studentRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        log.info("REQUEST SAVE STUDENT");
        studentRepository.save(student);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        log.info("REQUEST DELETE STUDENT");
        studentRepository.deleteById(id);
    }
}

