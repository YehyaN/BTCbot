import java.util.Scanner;

/**
 * A simple class to run the BoscoBot class.
 * @author Yehya Nasser
 * @version October 2017
 */

public class BoscoStub
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */

	public static void main(String[] args)
	{
		BoscoBot john = new BoscoBot();

		System.out.println (john.typeWriter(john.getGreeting()));
		System.out.println (john.typeWriter(john.getExitMessage()));
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println("cool");
			System.out.println (john.typeWriter(john.getResponse(statement)));
			statement = in.nextLine();
		}
	}
}
