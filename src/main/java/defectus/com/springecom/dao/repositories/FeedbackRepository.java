package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
