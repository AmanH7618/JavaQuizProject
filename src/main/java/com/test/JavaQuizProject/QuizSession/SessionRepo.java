package com.test.JavaQuizProject.QuizSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<QuizSession, String> {

}
