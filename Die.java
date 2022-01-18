import java.util.Random;

class Die {
  //method to roll the dice
  public String roll(){
    //initiate a new random object to use for random number generation
    Random random = new Random();
    //generate a random number between 0 and 5, save to rollResult variable
    int rollResult = random.nextInt(5);
    //return the rollResult passed through the toString method
    return toString(rollResult);
  }

  //toString method - which converts the random number created in roll() to a user-readable string, using a switch statement
  public String toString(int result){
    switch(result){
      case 0:
        return "one";
      case 1:
        return "two";
      case 2:
        return "three";
      case 3:
        return "four";
      case 4:
        return "five";
      case 5:
        return "six";
      //default method added for good best practices, but unlikely to ever display
      default:
        return "error - invalid integer passed";
    }
  }

}