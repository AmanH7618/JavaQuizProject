package com.test.JavaQuizProject;

import com.test.JavaQuizProject.QuizSession.QuizSession;
import com.test.JavaQuizProject.QuizSession.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuizRepo repo;

    @Autowired
    private SessionRepo sessionRepo;

    public void startSession(String userId) {
        if (sessionRepo.findById(userId).isPresent()) {
            throw new RuntimeException("A session is already active for this user.");
        }

        QuizSession session = new QuizSession();
        session.setSession(true);
        session.setId(userId);
        session.setCorrectAnswer(0);
        session.setIncorrectAnswer(0);
        session.setActiveQuestion(-1);
        sessionRepo.save(session);
    }

    public Questions getQuestion(String userId) {
        QuizSession session = sessionRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Session not found for user: " + userId));

        if (session.getActiveQuestion() != -1) {
            throw new RuntimeException("Submit the active question before requesting a new one.");
        }

        List<Questions> questions = repo.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }

        Questions question = questions.get(new Random().nextInt(questions.size()));
        session.setTotalQuestions(session.getTotalQuestions() + 1);
        session.setActiveQuestion(question.getId());
        sessionRepo.save(session);
        return question;
    }

    public String submitAnswer(String userId, Long questionId, String answer) {
        QuizSession session = sessionRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Session not found for user: " + userId));

        if (!session.isSession() || session.getActiveQuestion() == -1) {
            throw new RuntimeException("No active question. Start a new session or request a question.");
        }

        if (!Long.valueOf(session.getActiveQuestion()).equals(questionId)) {
            throw new RuntimeException("Error: Answer does not match the active question.");
        }

        Questions question = repo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found."));

        if (question.getAnswer().equalsIgnoreCase(answer)) {
            session.setCorrectAnswer(session.getCorrectAnswer() + 1);
        } else {
            session.setIncorrectAnswer(session.getIncorrectAnswer() + 1);
        }

        session.setActiveQuestion(-1); // Reset active question
        sessionRepo.save(session);

        return "Answer Submitted Successfully!";
    }

    public QuizSession getResult(String userId) {
        return sessionRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Session not found for user: " + userId));
    }
}
