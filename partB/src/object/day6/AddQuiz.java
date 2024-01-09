package object.day6;


import java.util.Scanner;

 
public class AddQuiz {
    private static final int NUM_QUESTIONS = 10;  //문제 수
    private AdditionQuestion[] questions;  //AdditionQuestion 객체를 저장하는데 사용됨
    private int[] userAnswer;
    
    public AddQuiz() {
        this.questions = new AdditionQuestion[NUM_QUESTIONS]; 
        createQuiz();
    }
    
    //퀴즈에 사용될 랜덤 문제를 quertions[]배열에 저장
    private void createQuiz() { 
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            questions[i] = new AdditionQuestion();  //문제객체 
        }
    }
    
    //사용자게에게 문제를 제시하고 답 입력받기
    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        userAnswer = new int[NUM_QUESTIONS];
        
        System.out.println("덧셈 " + NUM_QUESTIONS + "문제 퀴즈를 진행합니다");
        
        //입력받은 값을  userAnswers배열에 저장
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.print(questions[i].getQuestionString(i + 1) + "\n답을 입력하세요 >> ");
            userAnswer[i] = scanner.nextInt();
        }
        
        System.out.println("::::::채점을 진행하고 있습니다::::::");
        System.out.println(String.format("%s\t \t %s\t %s\t %s", "문제","제출한 답","정답","채점"));
        
        int correctAnswerCount = 0;
        
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            int correctAnswer = questions[i].getCorrectAnswer();
            char result = (userAnswer[i] == correctAnswer) ? 'o' : 'x';
            System.out.println( questions[i].getQuestionString(i + 1) + "    " +
                    userAnswer[i] + "              " + correctAnswer + "          " + result);
            if(userAnswer[i] == correctAnswer){
                correctAnswerCount++;
            }
        }
        System.out.println(":::맞은 개수는 총 "+correctAnswerCount+"개 입니다");
    }


    public static void main(String[] args) {
        AddQuiz quiz = new AddQuiz();
        quiz.runQuiz();
    }
}