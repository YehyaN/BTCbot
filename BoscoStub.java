import java.util.Scanner;

/**
 * A simple class to run the BoscoBot class.
 * @author Yehya Nasser, James Villagrana, Shane Beshlian
 * @version October 2017
 */

public class BoscoStub
{
	public static String respond(String statement)
	{
		TBot techBot = new TBot(statement);
		if(techBot.foundTech)
		{
			return techBot.getResponse();
		}
		return "";
	}

	public static String respondA(String statement)
	{
		ABot techBotA = new ABot(statement);
		if(techBotA.foundClass)
		{
			return techBotA.getResponse();
		}
		return "";
	}

	public static void typeWriter(String statement)
  {
    for(int i = 0; i < statement.length(); i++)
    {
      char result;
      result = statement.charAt(i);
      System.out.printf("%c", result);
      try
      {
          Thread.sleep(10);//0.1s pause between characters
      }
      catch(InterruptedException ex)
      {
          Thread.currentThread().interrupt();
      }
    }
		System.out.print('\n');
  }

	public static void main(String[] args)
	{
		String statement = "";
		boolean isTalking = true;
		GeneralBot gBot = new GeneralBot();

		typeWriter(gBot.getGreeting());
		typeWriter(gBot.getExitMessage());
		String response = "";

		while(isTalking) // Conversation Loop
		{
			Scanner s = new Scanner(System.in);
			System.out.print("> ");
			statement = s.nextLine();
			gBot.newStatement(statement);
			if(!statement.toLowerCase().equals("bye"))
			{
				if(gBot.foundGeneral)
				{
					response = gBot.getResponse();
				}
				else
				{
					response = respond(statement);
					response = respondA(statement);
					if(response == "")
					{
						response = gBot.getRandomResponse();
					}
				}
				typeWriter(response);
			}
			else
			{
				isTalking = false;
				break;
			}
		}
	}
}
