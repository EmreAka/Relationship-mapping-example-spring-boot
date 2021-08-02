package kodlama.io.training.dataAccess.abstracts;

import kodlama.io.training.entities.concretes.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
}
