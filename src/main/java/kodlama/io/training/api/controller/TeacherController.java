package kodlama.io.training.api.controller;

import kodlama.io.training.dataAccess.abstracts.TeacherDao;
import kodlama.io.training.entities.concretes.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @GetMapping("/getTeachers")
    List<Teacher> getTeachers(){return this.teacherDao.findAll();}

    @PostMapping("creatTeacher")
    Teacher createTeacher(@RequestBody Teacher teacher) {return this.teacherDao.save(teacher);}
}
