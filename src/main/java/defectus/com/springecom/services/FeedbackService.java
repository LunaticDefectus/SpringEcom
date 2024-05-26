package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Feedback;
import defectus.com.springecom.dao.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements FeedbackManager {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void deleteFeedbackById(Integer id) {
        feedbackRepository.deleteById(id);
    }
}
