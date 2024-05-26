package defectus.com.springecom.services;
import defectus.com.springecom.dao.entities.Feedback;

import java.util.List;

public interface FeedbackManager {

    public Feedback saveFeedback(Feedback feedback);
    public List<Feedback> getAllFeedback() ;
   public void deleteFeedbackById(Integer id);

    }


