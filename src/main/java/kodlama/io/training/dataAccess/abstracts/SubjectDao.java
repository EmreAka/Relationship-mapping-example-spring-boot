package kodlama.io.training.dataAccess.abstracts;

import kodlama.io.training.entities.concretes.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Integer> {
}
