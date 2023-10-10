import java.util.Scanner;
import java.util.Timer;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class QuizQuestion {
    String question;
    String[] options;
    int correctOption;

    public QuizQuestion(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}
public class Quiz
{
	 static int score = 0;
	    static int currentQuestionIndex = 0;

	    static QuizQuestion[] questions = 
	    	{
	    			new QuizQuestion("What is the capital of France?", 
	                new String[]
	                		{
	                				"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"}, 2),
	    			new QuizQuestion("Which one is the Smallest Ocean in the world?",
	    			new String[]
	    					{
	    							"A. Indian", "B. Pacific", "C. Atlantic", "D. Arctic"}, 3),
	    			new QuizQuestion("Which planet is known as the Red Planet?", 
	                new String[]
	                		{
	                				"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"}, 1),
	    			new QuizQuestion("In which Country White Elephant Is Found?", 
	    	                new String[]
	    	                		{
	    	                				"A. India", "B. Sri Lanka", "C. Thailand", "D. Malasyia"}, 2),
	    			new QuizQuestion("Total Number Of Oceans in the World Is?", 
	    	                new String[]
	    	                		{
	    	                				"A. 3", "B. 5", "C. 7", "D. 12"}, 1)
	    };
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		for(QuizQuestion question :questions)
		{
			displayQuestion(question);
			String userAnswer = sc.nextLine();
			checkAnswer(question, userAnswer);
			currentQuestionIndex++;
			wait(5);
			
		}
		displayResult();
	}
	static void displayQuestion(QuizQuestion question)
	{
		System.out.println(question.question);
		for(String option: question.options)
		{
			System.out.println(option);
		}
	}
	static void checkAnswer(QuizQuestion question, String userAnswer)
	{
		char userOption =userAnswer.charAt(0);
		int optionIndex = userOption-'A';
		if(userOption >= 0 && optionIndex < question.options.length && optionIndex == question.correctOption)
		{
			score++;
		}
	}
	static void displayResult()
	{
		System.out.println("Quiz ended!");
		System.out.println("Your Score is "+score +"/"+questions.length);
	}
	static void wait(int seconds)
	{
		try
		{
			TimeUnit.SECONDS.sleep(seconds);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
