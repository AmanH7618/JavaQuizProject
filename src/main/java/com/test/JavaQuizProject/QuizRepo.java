package com.test.JavaQuizProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Questions, Long> {
}
