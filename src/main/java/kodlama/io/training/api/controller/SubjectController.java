package kodlama.io.training.api.controller;

import kodlama.io.training.dataAccess.abstracts.StudentDao;
import kodlama.io.training.dataAccess.abstracts.SubjectDao;
import kodlama.io.training.dataAccess.abstracts.TeacherDao;
import kodlama.io.training.entities.concretes.Student;
import kodlama.io.training.entities.concretes.Subject;
import kodlama.io.training.entities.concretes.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    @GetMapping
    List<Subject> getSubjects() {return this.subjectDao.findAll();}

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {return this.subjectDao.save(subject);}

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable int subjectId,
            @PathVariable int studentId
    ) {
        Subject subject = subjectDao.findById(subjectId).get();
        Student student = studentDao.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectDao.save(subject);
    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable int subjectId,
            @PathVariable int teacherId
    ) {
        Subject subject = subjectDao.findById(subjectId).get();
        Teacher teacher = teacherDao.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectDao.save(subject);
    }
}
