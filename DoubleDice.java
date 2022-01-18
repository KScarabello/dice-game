import java.util.Scanner;
import java.util.InputMismatchException;

//DoubleDice class - houses game logic
class DoubleDice{
  //created a method to reduce redundancy
  //takes in parameter of total to display the user's current bank amount
  public static void askUserForInput(Double total){
    System.out.print("You have $");
    //implementing printf to get correct formatting
    System.out.printf("%.2f", total);
    System.out.println();
    System.out.println("How much would you like to bet (Enter 0 to quit)?");
  }

  public static void runGame(Double total, Double bet, Scanner scnr){
 //while the the user a.) provides a bet that isn't 0 b.) still has money and c.) does not bet more than they have, execute the game
    System.out.println("total" + total);
    System.out.println("bet" + bet);
    System.out.println("scanner" + scnr);
    while(bet != 0 && total <= 0 && bet > total){
      //create two new die using Die class
      System.out.println("hello");
      Die dieRoll1 = new Die();
      Die dieRoll2 = new Die();
      //roll both die, saving a string value to variables result1 and result2
      String result1 = dieRoll1.roll();
      String result2 = dieRoll2.roll();
      //print results for user
      System.out.println("You rolled a " + result1 + " and " + result2);
      //begin handling logic to determine a win or a loss
      //if the result string values match - show win message
      if(result1.equals(result2)){
        System.out.print("You win $");
        //implement formatting to correctly display dollar amount
        System.out.printf("%.2f", bet);
        System.out.println();
        //update total to add winnings to the pot
        total = total + bet;
      } else {
        //if values do not match, display loss message
        System.out.print("You lose $");
        System.out.printf("%.2f", bet);
        System.out.println();
        //update total to deduct lost bet money
        total = total - bet;
      }
      // if(bet == 0){
      //   System.out.println("See you around, winner!");
      //   break;
      // } else if(total <= 0){
      //   System.out.println("You are out of money!");
      //   System.out.println("Better luck next time!");
      //   break;
      // } else {
        //line break and ask the user again for input
        System.out.println();
        askUserForInput(total);
        //get new bet amount, prompting the loop to repeat if looping conditions are met
        bet = scnr.nextDouble();
        System.out.println("bet" + bet);
        // if(bet > total){
        //   System.out.println("You tried to bet more than you have! Try again.");
        //   break;
        // }
      // }
    }
  }
  //main method - initiates a new game
  public void main(){
    Scanner scnr = new Scanner(System.in);
    //initialize bank amount to 100.00
    Double total = 100.00;
    //declare bet variable to record users desired bet amount
    Double bet = -1.00;
    //solicit bet amount from user using askUserForInput method
    askUserForInput(total);
    //grab user's bet amount using the scanner
    do {
      try {
          bet = scnr.nextDouble();
      } catch (InputMismatchException e) {
          System.out.println("Please input a positive numeric value only");
      }
      scnr.nextLine(); // clears the buffer
    } while (bet < 0.00);
    //while the the user a.) provides a bet that isn't 0 b.) still has money and c.) does not bet more than they have, execute the game
    runGame(total, bet, scnr);
    do{
      System.out.println("You can't bet more than you have! Try again");
      bet = scnr.nextDouble();
      runGame(total, bet, scnr);
    } while(bet > total);

    //if user inputs a 0 to quit, display good-bye message
    if(bet == 0){
      System.out.println("See you around, winner!");
    } 
    //if user has lost all their money, display proper good-bye message
    if(total <= 0){
        System.out.println("You are out of money!");
        System.out.println("Better luck next time!");
    }
  }
}