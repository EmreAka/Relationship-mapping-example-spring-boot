package kodlama.io.training.api.controller;

import kodlama.io.training.dataAccess.abstracts.StudentDao;
import kodlama.io.training.entities.concretes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/getStudents")
    List<Student> getStudents() {
        return this.studentDao.findAll();
    }

    @PostMapping("createStudent")
    Student createStudent(@RequestBody Student student) {
        return this.studentDao.save(student);
    }
}
