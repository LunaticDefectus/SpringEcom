package defectus.com.springecom.web;

import defectus.com.springecom.dao.entities.Feedback;
import defectus.com.springecom.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "Feedback";
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@ModelAttribute Feedback feedback, Model model) {
        feedbackService.saveFeedback(feedback);
        model.addAttribute("message", "Thank you for your feedback!");
        return "Feedback";
    }
    @GetMapping("/feedbackManagement")
    public String indexFeed(Model model) {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        model.addAttribute("listFeedbacks", feedbacks);
        return "FeedbackManagement";
    }
    @PostMapping("/delete")
    public String deleteFeedback(@RequestParam("id") Integer id) {
        feedbackService.deleteFeedbackById(id);
        return "redirect:/feedbackManagement";
    }
}
