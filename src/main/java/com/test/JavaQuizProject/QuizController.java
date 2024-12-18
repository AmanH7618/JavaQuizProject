package com.test.JavaQuizProject;

import com.test.JavaQuizProject.QuizSession.QuizSession;
import com.test.JavaQuizProject.QuizSession.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @Autowired
    private SessionRepo repo;

    @PostMapping("/start")
    public ResponseEntity<String> startQuiz(@RequestParam String userId) {
        Optional<QuizSession> activeSession = repo.findById(userId);
        if (activeSession.isPresent() && activeSession.get().isSession()) {
            return ResponseEntity.badRequest().body("A session is already active for this user.");
        }
        service.startSession(userId);
        return ResponseEntity.ok("Quiz session started successfully.");
    }

    @GetMapping("/question/{userId}")
    public ResponseEntity<Questions> getQuestion(@PathVariable String userId) {
        return ResponseEntity.ok(service.getQuestion(userId));
    }

    @PostMapping("/answer/{userId}")
    public ResponseEntity<String> submitAnswer(@PathVariable String userId,
                                               @RequestParam Long questionId,
                                               @RequestParam String answer) {
        return ResponseEntity.ok(service.submitAnswer(userId, questionId, answer));
    }

    @GetMapping("/result/{userId}")
    public ResponseEntity<QuizSession> getResult(@PathVariable String userId) {
        return ResponseEntity.ok(service.getResult(userId));
    }
}
