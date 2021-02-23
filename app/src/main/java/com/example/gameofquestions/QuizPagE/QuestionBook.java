package com.example.gameofquestions.QuizPagE;

public class QuestionBook {

    public static String Questions [] = {
            "What is the throne called?",
            "What is the name given to the sword Arya recieves from Jon Snow?",
            "What is the nickname of Jaime Lannister",
            "Which house sat on the iron throne before King Baratheon",
            "What does Jon see after Death",
            "Who rescues Bran and Meera after the death of Hodor",
            "What does Arya do when she find out Lyanna Stark is dead?",
            "How many ships does Daario tell Daenerys they have after they took Mereen?",
            "Blah Blah Blah",
            "This is a question"



    };

    private String Answers [] [] = {

            {"Iron Throne","Steel Throne","Sword Throne"},
            {"Stick","Needle","Sting"},
            {"The Kingslayer","Azor Ahai","The Hound"},
            {"Lannister","Stark","Targaryen"},
            {"Nothing","Ned Stark","Winter"},
            {"Three eyed raven","Benjen Stark","Jon Snow"},
            {"Faints","Laughs","Screams"},
            {"128","300","93"},
            {"128","300","93"},
            {"128","300","93"}








    };

    private String CorrectAnswers[] = {
            "Iron Throne" ,
            "Needle",
            "The Kingslayer",
            "Targaryen",
            "Nothing",
            "Benjen Stark",
            "Laughs",
            "93",
            "128",
            "300"


    };

    public String getQuestion(int a){

        String question = Questions[a];
        return question;
    }


    public String getAnswer1(int a) {
        String choice0 = Answers[a][0];
        return choice0;
    }
    public String getAnswer2(int a) {
        String answer1 = Answers[a][1];
        return answer1;
    }
    public String getAnswer3(int a) {
        String answer2 = Answers[a][2];
        return answer2;

    }

    public String getCorrectAnswer(int a) {

        String answer = CorrectAnswers[a];
        return answer;
    }


}
