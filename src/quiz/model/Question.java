package quiz.model;


public class Question {
    public String question; //stores the question
    public String [] options = new String[4]; //stores the 4 options for each question

    public boolean evaluateResponse(String response){
        if(response.equals(options[0])) //if the option is first in the options Array then return true
            return true;
        else //else return false
            return false;
    }
}
