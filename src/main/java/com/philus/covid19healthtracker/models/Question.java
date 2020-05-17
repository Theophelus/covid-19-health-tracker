package com.philus.covid19healthtracker.models;

import java.util.List;

public class Question {

    private int id;
    private String question;
    private String img;

    private List<Answers> answers;

    public Question(int id, String question, String img, List<Answers> answers) {
        this.id = id;
        this.question = question;
        this.img = img;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", img='" + img + '\'' +
                ", answers=" + answers +
                '}';
    }
}

