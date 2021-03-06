import java.util.Scanner;

/**
 * A simple class to run the BoscoBot class.
 * @author Yehya Nasser, James Villagrana, Shane Beshlian
 * @version October 2017
 */

public class BoscoStub
{


	public static String respondA(String statement)
	{
		ABot academicBot = new ABot(statement);
		InternationalBot iBot = new InternationalBot(statement);
		TBot techBot = new TBot(statement);
		FSBot fsBot = new FSBot(statement);
		DBot dBot = new DBot(statement);
		CSBot csBot = new CSBot(statement);
		AlumniBot alumniBot = new AlumniBot(statement);
		if(academicBot.foundClass)
		{
			return academicBot.getResponse();
		}
		else if(techBot.foundTech)
		{
			return techBot.getResponse();
		}
		else if (iBot.foundInternational){
			return iBot.getResponse();
		}
		else if(csBot.found)
		{
			return csBot.getResponse();
		}
		else if(dBot.foundDiscover){
			return dBot.getResponse();
		}
		else if(alumniBot.foundAlumni)
		{
			return alumniBot.getResponse();
		}
		else if(fsBot.foundFutureStudent)
		{
			return fsBot.getResponse();
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
