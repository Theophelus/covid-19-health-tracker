package com.philus.covid19healthtracker.models;

public class Answers {

    private String yesOrNo;
    private int score;

    public Answers(String yesOrNo, int score) {
        this.yesOrNo = yesOrNo;
        this.score = score;
    }

    public String getYesOrNo() {
        return yesOrNo;
    }

    public void setYesOrNo(String yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "yesOrNo='" + yesOrNo + '\'' +
                ", score=" + score +
                '}';
    }
}
