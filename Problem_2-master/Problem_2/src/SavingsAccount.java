public class SavingsAccount {

    private double savingsBalance;
    public static double annualInterestRate = 0.00;
    //interest rate must be set by Application class

    public SavingsAccount(double amount){

        this.savingsBalance = amount;

    }//end SavingsAccount method

    public void Balance(){
        System.out.printf("$%.2f", this.savingsBalance);
    }//end Balance method

    public void calculateMonthlyInterest (){

        double interest;
        interest = (this.savingsBalance * (annualInterestRate/100)) / 12;
        this.savingsBalance += interest;

        return;
    }//end calculateMonthlyInterest method

    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }//end modifyInterestRate method

    public static void main(String [] args){
    }//end main
}//end class
