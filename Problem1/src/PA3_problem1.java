import java.util.Random;
import java.util.Scanner;
import java.security.SecureRandom;

public class PA3_problem1 {

    public static int difficulty () {
        int diff;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please select difficulty level: ");
        System.out.println("1: single-digit");
        System.out.println("2: double digit");
        System.out.println("3: triple digit");
        System.out.println("4: quadruple digit");

        diff = scnr.nextInt();

        if (diff >4 || diff <=0){
            while (diff >4 || diff <=0) {
                System.out.println("INVALID DIFFICULTY, PLEASE SELECT AGAIN");
                diff = scnr.nextInt();
            }//end while
        }//end if

        return diff;
    }//end difficulty method

    public static int problemtype () {
        int type;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please select problem type: ");
        System.out.println("1: addition problems only");
        System.out.println("2: multiplication problems only");
        System.out.println("3: subtraction problems only");
        System.out.println("4: division problems only (please round your answer to 2 decimal places)");
        System.out.println("5: random mixture");

        type = scnr.nextInt();

        if (type >5 || type <=0){
            while (type >5 || type <=0) {
                System.out.println("INVALID CHOICE, PLEASE SELECT AGAIN");
                type = scnr.nextInt();
            }//end while
        }//end if

        return type;
    }//end problemtype method

    public static double questions (int diff, int type){

        int num1, num2;
        double ans =0.0;
        Random rand = new SecureRandom();

        if (diff == 1) {

                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);

        }//end 1 if
        else if (diff == 2) {

                num1 = rand.nextInt(90) + 10;
                num2 = rand.nextInt(90) + 10;

        }//end 2 elif
        else if (diff == 3) {

                num1 = rand.nextInt(900) + 100;
                num2 = rand.nextInt(900) + 100;

        }//end 3 elif
        else {

                num1 = rand.nextInt(9000) + 1000;
                num2 = rand.nextInt(9000) + 1000;

        }//end 4 else
        if (type == 1){
            System.out.print("How much is " + num1 + " plus " + num2 + "?");
            ans = num1 + num2;
        }//end addition if statement
        else if (type == 2) {
            System.out.print("How much is " + num1 + " times " + num2 + "?");
            ans = num1 * num2;
        }//end multiplication elif
        else if (type == 3){
            System.out.print("How much is " + num1 + " minus " + num2 + "?");
            ans = num1 - num2;
        }//end subtraction elif
        else if (type== 4){
            if (num2 ==0){
                num2++;
            }
            System.out.print("How much is " + num1 + " divided by " + num2 + "?");
            ans = (double)num1 / num2;
            ans = Math.round(ans*100);
            ans /= 100;
        }//end division elif
        else {
            int randNum = rand.nextInt(4);
            switch (randNum){
                case 0: //addition
                    System.out.print("How much is " + num1 + " plus " + num2 + "?");
                    ans = num1 + num2;
                    break;
                case 1: //multiplication
                    System.out.print("How much is " + num1 + " times " + num2 + "?");
                    ans = num1 * num2;
                    break;
                case 2: //subtraction
                    System.out.print("How much is " + num1 + " minus " + num2 + "?");
                    ans = num1 - num2;
                    break;
                case 3: //division
                    if (num2 ==0){
                        num2++;
                    }
                    System.out.print("How much is " + num1 + " divided by " + num2 + "?");
                    ans = (double)num1 / num2;
                    ans = Math.round(ans*100);
                    ans /= 100;
                    break;
            }//end switch
        }//end mix else statement

        return ans;
    }//end questions method

    public static int response(int difficulty, int type){

        int numCorrect=0;
        double correctAnswer;
        Random rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        int respCorrect = rand.nextInt(4);
        int respWrong = rand.nextInt(4);

        correctAnswer = questions(difficulty, type);
        double answer = scnr.nextDouble();

        System.out.println("You answer: " + answer);

        if (answer == correctAnswer){
            numCorrect++;

            switch (respCorrect){

                case 0:
                    System.out.println("Very Good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
                default:
                    break;
            }//end respCorrect Switch case
        }//end if
        else {
            switch (respWrong){

                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
                default:
                    break;

            }//end respWrong Switch case
        }//end else
        return  numCorrect;
    }//end response method

    public static void main(String[] args){
        int correctAnswer, answer;
        int score=0;
        float finalScore;
        Scanner scnr = new Scanner(System.in);
        char cont= 'y';

        while(cont == 'y'){
            int diff = difficulty();
            int type = problemtype();
            for (int i = 0; i < 10; ++i) {

                score = score + response(diff, type);

            }//end for loop


            finalScore = (float) (score / 10.00);

            if (finalScore >= 0.75) {

                System.out.println("Score: " + (finalScore*100));
                System.out.println("Congratulations, you are ready to go to the next level!");

            }//end score if statement
            else {
                System.out.println("Score: " + (finalScore*100));
                System.out.println("Please ask your teacher for extra help.");

            }//end score else statement

            System.out.println("Reset for next student? [y/n]");
            cont = scnr.next().charAt(0);

        }//end contination while loop
    }//end main method

}//end class

