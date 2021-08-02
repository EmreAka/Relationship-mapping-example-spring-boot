package kodlama.io.training.dataAccess.abstracts;

import kodlama.io.training.entities.concretes.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
}
