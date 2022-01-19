import java.util.Scanner;
import java.util.InputMismatchException;

//DoubleDice class - houses game logic
class DoubleDice{
    Scanner scnr = new Scanner(System.in);
    //initialize bank amount to 100.00
    Double total = 100.00;
    //declare bet variable to record users desired bet amount
    Double bet = -1.00;
  //created a method to reduce redundancy
  //takes in parameter of total to display the user's current bank amount
  public static void askUserForInput(Double total){
    System.out.print("You have $");
    //implementing printf to get correct formatting
    System.out.printf("%.2f", total);
    System.out.println();
    System.out.println("How much would you like to bet (Enter 0 to quit)?");
  }

  public void validateInput(){
      try {
        bet = scnr.nextDouble();
        if(bet < 0){
          System.out.println("Please input a positive numeric value only");
        }
      } catch (InputMismatchException e) {
          System.out.println("Please input a positive numeric value only");
      }
  }

  //main method - initiates a new game
  public void main(){
    //solicit bet amount from user using askUserForInput method
    askUserForInput(total);
    //grab user's bet amount using the scanner, checking for InputMismatchException violations, and displaying a message if necessary
    do {
        validateInput();
        scnr.nextLine(); // clears the buffer
    } while (bet < 0.00 );
    //while the the user a.) provides a bet that isn't 0 b.) still has money and c.) does not bet more than they have, execute the game
    while(bet != 0 && total > 0 && bet <= total){
        if(total <= 0.0){
          break;
        }
      //create two new die using Die class
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
        bet = -1.00;
      }
        //line break and ask the user again for input
        System.out.println();
        if(total <= 0.0){
          break;
        }
        askUserForInput(total);
        bet = -1.00;
        do {
          validateInput();
          scnr.nextLine();
        } while(bet == -1.00);
        //get new bet amount, prompting the loop to repeat if looping conditions are met
    }
    //if user inputs a 0 to quit, display good-bye message
    if(bet == 0){
      System.out.println("See you around, winner!");
    } 
    //if user has lost all their money, display proper good-bye message
    if(total <= 0){
        System.out.println("You are out of money!");
        System.out.println("Better luck next time!");
    } else{
        while(bet > total){
          System.out.println("You can't bet more than you have! Try again.");
          System.out.println();
          askUserForInput(total);
          validateInput();
        }
    }
  }
}