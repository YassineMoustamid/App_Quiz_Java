package com.example.quiz;

public class QuestionNumero1 {
    public String quetion,option1,option2,option3;
    private int CorrectAnsNo;

    public QuestionNumero1(String quetion, String option1, String option2, String option3, int correctAnsNo) {
        this.quetion = quetion;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        CorrectAnsNo = correctAnsNo;
    }

    public String getQuetion() {
        return quetion;
    }

    public void setQuetion(String quetion) {
        this.quetion = quetion;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getCorrectAnsNo() {
        return CorrectAnsNo;
    }

    public void setCorrectAnsNo(int correctAnsNo) {
        CorrectAnsNo = correctAnsNo;
    }
}
