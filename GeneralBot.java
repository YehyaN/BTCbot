import java.util.Random;
public class GeneralBot extends BoscoBot // Used for general, non-bosco specific statements
{
  public boolean foundGeneral;
  private String statement;
  GeneralBot()
  {
    foundGeneral = false;
  }
  GeneralBot(String sentence)
  {
    statement = sentence;
    foundGeneral = false;
  }
  @Override
  public String getResponse()
  {
    return ""; // W.I.P. NOT READY YET.
  }
  public void newStatement(String sentence)
  {
    statement = sentence;

  }
  public String getGreeting()
  {
    return "Hello, my name is Saint John Bosco. Let's talk about Bosco Tech!";
  }
  public String getExitMessage()
  {
    return "Type in 'Bye' to exit.";
  }
  public String getRandomResponse () // Concrete -- Important, we'll get to this later
  {
   String [] randomResponses = {"Interesting, tell me more",
       "Hmmm.",
       "Do you really think so?",
       "You don't say.",
       "Do you really think so?",
       "I care for all the children!",
       };
   Random r = new Random ();
   return randomResponses [r.nextInt(randomResponses.length)];
  }

}
