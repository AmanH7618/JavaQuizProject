package com.test.JavaQuizProject.QuizSession;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class QuizSession {
    @Id
    private String id;
    private int totalQuestions;
    private int correctAnswer;
    private int incorrectAnswer;
    private long activeQuestion;
    private boolean session;

    public QuizSession(String id, int totalQuestions, int correctAnswer, int incorrectAnswer, long activeQuestion, boolean session) {
        this.id = id;
        this.totalQuestions = totalQuestions;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.activeQuestion = activeQuestion;
        this.session = session;
    }

    public QuizSession() {

    }

    public String getId() {
        return id;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public long getActiveQuestion() {
        return activeQuestion;
    }

    public boolean isSession() {
        return session;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setIncorrectAnswer(int incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    public void setActiveQuestion(long activeQuestion) {
        this.activeQuestion = activeQuestion;
    }

    public void setSession(boolean session) {
        this.session = session;
    }
}
