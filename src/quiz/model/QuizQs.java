package quiz.model;

import java.util.ArrayList;

public class QuizQs {
    public ArrayList<Question> Qs = new ArrayList<Question>();//ArrayList of Question object to store questions for the application

    public QuizQs(){
        //Question 1
        Question q = new Question(); //creates an instance of the object
        q.question = "Who formed the Theory of Relativity?"; //Adds 1st question
        q.options[1]="Alexander Friedmann"; //Adds option 1
        q.options[0]="Albert Einstein"; //Adds option 2
        q.options[2]="Isaac Newton"; //Adds option 3
        q.options[3]="Hermann Minkowski"; //Adds option 4
        Qs.add(q); //Adds question 1 with options to ArrayList Qs

        //Question 2
        q = new Question(); //creates second instance of the object
        q.question="What is the smallest prime number?"; //Adds 2nd question
        q.options[0]="2"; //Adds option 1
        q.options[2]="0"; //Adds option 2
        q.options[1]="-1"; //Adds option 3
        q.options[3]="1"; //Adds option 4
        Qs.add(q); //Adds question 2 with options to ArrayList Qs

        //Question 3
        q = new Question(); //creates third instance of the object
        q.question="What is the most abundant gas in Earth’s atmosphere?";
        q.options[2]="Oxygen"; //Adds option 1
        q.options[1]="Carbon Dioxide"; //Adds option 2
        q.options[0]="Nitrogen"; //Adds option 3
        q.options[3]="Argon"; //Adds option 4
        Qs.add(q); //Adds question 3 with options to ArrayList Qs

        //Question 4
        q = new Question(); //creates fourth instance of the object
        q.question="Which language is the most widely spoken in South America?";
        q.options[1]="English"; //Adds option 1
        q.options[0]="Spanish"; //Adds option 2
        q.options[2]="Portuguese"; //Adds option 3
        q.options[3]="Dutch"; //Adds option 4
        Qs.add(q); //Adds question 4 with options to ArrayList Qs

        //Question 5
        q = new Question(); //creates fifth instance of the object
        q.question="Which country has the largest land area?";
        q.options[0]="Russia"; //Adds option 1
        q.options[2]="China"; //Adds option 2
        q.options[1]="USA"; //Adds option 3
        q.options[3]="Canada"; //Adds option 4
        Qs.add(q); //Adds question 5 with options to ArrayList Qs

        //Question 6
        q = new Question(); //creates sixth instance of the object
        q.question="Which planet is known for its Great Red Spot?";
        q.options[2]="Mars"; //Adds option 1
        q.options[1]="Earth"; //Adds option 2
        q.options[3]="Venus"; //Adds option 3
        q.options[0]="Jupiter"; //Adds option 4
        Qs.add(q); //Adds question 6 with options to ArrayList Qs

        //Question 7
        q = new Question(); //creates seventh instance of the object
        q.question="Who is the youngest Nobel Prize winner?";
        q.options[3]="John Goodneough"; //Adds option 1
        q.options[0]="Malala Yousafzai"; //Adds option 2
        q.options[2]="Greta Thunberg"; //Adds option 3
        q.options[1]="Narges Mohammadi"; //Adds option 4
        Qs.add(q); //Adds question 7 with options to ArrayList Qs

        //Question 8
        q = new Question(); //creates eighth instance of the object
        q.question="What is the tallest breed of dog in the world?";
        q.options[1]="Irish Wolfhound"; //Adds option 1
        q.options[2]="Greyhound"; //Adds option 2
        q.options[0]="Anatolian Shepherd"; //Adds option 3
        q.options[3]="The Great Dane"; //Adds option 4
        Qs.add(q); //Adds question 8 with options to ArrayList Qs

        //Question 9
        q = new Question(); //creates ninth instance of the object
        q.question="Which year did India gain Independence?";
        q.options[0]="1947"; //Adds option 1
        q.options[3]="1978"; //Adds option 2
        q.options[1]="1956"; //Adds option 3
        q.options[2]="1981"; //Adds option 4
        Qs.add(q); //Adds question 9 with options to ArrayList Qs

        //Question 10
        q = new Question(); //creates tenth instance of the object
        q.question="What French King was guillotined?";
        q.options[1]="Hugh Capet"; //Adds option 1
        q.options[3]="Napoleon Bonaparte"; //Adds option 2
        q.options[0]="Louis XVI"; //Adds option 3
        q.options[2]="Philippe le Bel"; //Adds option 4
        Qs.add(q); //Adds question 10 with options to ArrayList Qs
    }
}