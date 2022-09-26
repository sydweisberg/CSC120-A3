import java.util.Scanner;
import java.util.Random;
/**
* The Conversation class and respective program begins a conversation
* between the user and a bot. It takes an input from the user and the
* bot outputs a response based off of what the user inputs. A transcript
* of the conversation is printed.
*
* @author  Sydney Weisberg
* @version 1.0
* @since   2022-09-26 
*/
class Conversation {
  static Scanner input = new Scanner(System.in); // Creates a global scanner that's used when asking for both rounds and the user's thoughts
  /**
  * The main method takes asks the user for a number and calls another method.
  */
  public static void main(String[] arguments) {
    // You will start the conversation here.
    System.out.print("Please enter the number of conversation rounds you'd like to have:");
    int numberOfRounds = input.nextInt(); // Number of conversation rounds the user requests
    input.nextLine();
    conversationCycle(numberOfRounds);
    

  }
  /**
  * The conversationCycle method takes a number given by the user and
  * sets up a conversation for that many rounds.
  */
  public static void conversationCycle(int rounds) {
    String userResponse = ""; // Contains the user's response and updates each round
    String updatedResponse = "";
    String[] transcript = new String[rounds*2 + 3]; // Creates an array that will take in the dialogue of the conversation at each position
    transcript[0] = "Hi there! What's on your mind?";
    int transcriptPosition = 1;
    System.out.println(transcript[0]); // First round question
    for(int i = 0; i < rounds; i++) {
      userResponse = input.nextLine();
      updatedResponse = botResponse(userResponse);
      System.out.println(updatedResponse);
      transcript[transcriptPosition] = userResponse;
      transcript[transcriptPosition + 1] = updatedResponse;
      transcriptPosition += 2;
    }
    input.close(); // Closes the scanner
    transcript[transcript.length - 1] = "Goodbye!";
    System.out.println(transcript[transcript.length - 1]); // Prints the transcript
    transcriber(transcript);
    
  }
  /**
  * The botResponse method takes the user's input
  * and develops a response that involves mirroring words and changing punctuation.
  */
  public static String botResponse(String userInput) {
    String userAlteration = "";
    String[] randomResponse = {"That's an interesting thought.", "I'm not sure about that.", "Hmm...", "Your thought intrigues me!", "Huh...", "Wow. I never thought about that before!", "Mhm."};
    String[] pronounGiven = {"I", "me", "am", "you", "my", "your", "are", "You"}; // Array of words to be mirrored
    String[] pronounReturned = {"you", "you", "are", "I", "your", "my", "am", "I"}; // Matching array of correct mirrored words
    String[] alterationSplit = userInput.split(" "); // Separates the user's thought into an array of words when there is a space between words in the string

    boolean changeMade = false; // Variable to detect whether or not a mirror wordhas been changed
    Random r = new Random();

    for(int i = 0; i < alterationSplit.length; i++) {
      for(int j = 0; j < pronounGiven.length; j++) {
        if(alterationSplit[i].equals(pronounGiven[j]) || alterationSplit[i].equals((pronounGiven[j] + "?")) || alterationSplit[i].equals((pronounGiven[j] + "."))) { 
          alterationSplit[i] = alterationSplit[i].replace(pronounGiven[j], pronounReturned[j]); //
          changeMade = true;
          break; // Ends the for loop since the word has already been mirrored
        }
      }
      userAlteration += alterationSplit[i] + " "; // Concatinates the words in the split array back into a single string
    }
    
    if(userAlteration.contains(".")) {
      userAlteration = userAlteration.replace(".", "?"); 
    }
    if(userAlteration.contains("!")) {
      userAlteration = userAlteration.replace("!", "?"); 
    }
    if(userAlteration.contains("How am I?")) {
      userAlteration = userAlteration.replace("How am I?", "I am good! Thanks for asking!");
    }

    if(changeMade == false) {
      userAlteration =  randomResponse[r.nextInt(randomResponse.length)]; // If no mirror word is detected, a random response is used
    }

    return(userAlteration);
  }
  /**
  * The transcriber method prints out a record of the
  * conversation
  */
  public static void transcriber(String[] script) {
    //System.out.println("\n");
    System.out.println("");
    System.out.println("TRANSCRIPTION");
    for(int i = 0; i < script.length - 2; i++) {
      System.out.println(script[i]); // Prints each part of the array line by line
    }
    System.out.println(script[script.length - 1]);
  } 
}
