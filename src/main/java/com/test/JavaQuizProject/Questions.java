package com.test.JavaQuizProject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.*;


import java.util.List;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String question;
    @NotNull
    @Column(unique = true)
    private String optionA;
    @NotNull
    @Column(unique = true)
    private String optionB;
    @NotNull
    @Column(unique = true)
    private String optionC;
    @NotNull
    @Column(unique = true)
    private String optionD;
    @NotNull
    @Column(unique = true)
    private String answer;

    public Questions(long id, String question, String optionA, String optionB, String optionC, String optionD, String answer) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    public Questions() {
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
