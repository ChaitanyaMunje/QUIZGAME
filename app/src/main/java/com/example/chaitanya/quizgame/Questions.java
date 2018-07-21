package com.example.chaitanya.quizgame;

public class Questions {
    public String mQuestions[]={

            "2 is greater than three ?",
            "4 is greater than three ?",
            "8 is greater than three ?",
            "1 is greater than three ?",
            "9 is greater than three ?",
            "9 is smaller than three ?",
            "6 is smaller than three ?",
            "2 is smaller than three ?"




    };
    // Arrange answers
    //here i have arranged answers
    public String mAnswers[]={
            "false",
            "true",
            "true",
            "false",
            "true",
            "false",
            "false",
            "true"


    };
    public String getQuestions(int number){
        return mQuestions[number];
    }
    public String getAnswer(int number)
    {
        return mAnswers[number];
    }
}
