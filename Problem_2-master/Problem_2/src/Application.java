public class Application {
    /* THIS IS THE TEST PROGRAM THAT CALLS TO THE SavingsAccount CLASS */
    public static void main (String [] args){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        SavingsAccount.modifyInterestRate(4.0);
        System.out.println("Month \t\t Saver1 \t Saver2");

        for(int i=1; i<13; ++i){

            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + ": \t");
            saver1.Balance();
            System.out.print("\t");
            saver2.Balance();
            System.out.println();

        }//end for loop
        System.out.println("");

        System.out.println("When the Interest Rate is 5.0%:");
        //System.out.println();
        SavingsAccount.modifyInterestRate(5.0);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Month \t\t Saver1 \t Saver2");
        System.out.print("Month 13: \t");
        saver1.Balance();
        System.out.print("\t");
        saver2.Balance();
        System.out.println();

    }//end main
}//end class
