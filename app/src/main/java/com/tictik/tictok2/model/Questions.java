package com.tictik.tictok2.model;

/**
 * Created by Mac on 25/05/17.
 */

public class Questions {


    public String question[] = {"Which is the first planet",
            "Which one of these was Akshay kumar's movie"
    };
    public String answers[][] = {{"Mercury","Venus","Jupiter","Mars"},
            {"Don","Sarabjit","Joker","Ek Villain"}

    };
    public String correctAns[] = {"Mercury",
            "Joker"
    };

    public String getQuestion(int i){

String mquestion = question[i];
        return mquestion;

    }

    public String getChoice1(int i){

        String manswers = answers[i][0];
        return manswers;

    }
    public String getChoice2(int i){

        String manswers = answers[i][1];
        return manswers;

    }
    public String getChoice3(int i){

        String manswers = answers[i][2];
        return manswers;

    }
    public String getChoice4(int i){

        String manswers = answers[i][3];
        return manswers;

    }
    public String getCorrectAns(int i){

        String correct = correctAns[i];
        return correct;

    }
}
