import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
    System.out.print("Please enter the number of conversation rounds you'd like to have:");
    Scanner input = new Scanner(System.in);
    int numberOfRounds = input.nextInt(); // Number of conversation rounds the user requests
    input.close();
    conversationCycle(numberOfRounds);

  }
  
  public static void conversationCycle(int rounds) {
    Scanner newInput = new Scanner(System.in);
    System.out.println("Successfully calls conversationCycle method for " + rounds + " rounds."); // Checks to see if main successfully calls this method (REMOVE LATER)
    String userResponse = ""; // Contains the user's response and updates each round
    for(int i = 0; i < rounds; i++) {
      if(i == 0) {
        System.out.println("Hi there!  What's on your mind?"); // First round question
      }
      else {
        botResponse(userResponse); // Round responses
      }
      userResponse = newInput.next(); 
    }
    botResponse(userResponse); // Final response
    newInput.close();
  }

  public static void botResponse(String userInput) {
    System.out.println("slay");
  }
}

/* Pseudo Code
 * 
 * 
 * 
 * 
 */
