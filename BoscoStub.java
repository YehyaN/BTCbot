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

	public static void main(String[] args)
	{
		String statement = "";
		boolean isTalking = true;
		GeneralBot gBot = new GeneralBot();

		System.out.println(gBot.getGreeting());
		System.out.println(gBot.getExitMessage());
		String response = "";
		while(isTalking)
		{
			Scanner s = new Scanner(System.in);
			System.out.print("> ");
			statement = s.nextLine();
			gBot.newStatement(statement);
			if(statement.toLowerCase() != "bye")
			{
				if(gBot.foundGeneral)
				{
					response = gBot.getResponse();
				}
				else
				{
					response = respond(statement);
					if(response == "")
					{
						response = gBot.getRandomResponse();
					}
				}
				System.out.println(response);
			}
			else
			{
				isTalking = false;
				break;
			}
		}
	}
}
