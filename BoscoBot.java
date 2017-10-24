/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 *    Uses advanced search for keywords
 * </li></ul>
 *
 * @author Yehya Nasser
 * @version October 2017
 */

public class BoscoBot
{
	/**
	 * Get a default greeting
	 *
	 * @return a greeting
	 */

	public String getGreeting()
	{
		return "Hello, my name is Saint John Bosco. Let's talk about Bosco Tech. First, what is your name?";
	}
	public String getExitMessage()
	{
		return "Type in 'Bye' to exit.";
	}
	public String getName(String name)
	{
		System.out.println("Nice to meet you, " + name);
		return " ";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */

	public String getResponse(String statement)
	{
		String response = "";
		if (findKeyword(statement, "Hello") >= 0)
		{
			response = "Hello my friend!";
		}
		else if(findKeyword(statement, "no") >= 0)
		{
			response = "Why are you so negative?";
		}
		else if (findKeyword(statement, "president") >= 0
						&& findKeyword(statement, "school") >= 0)
		{
			response = "The President of Bosco Tech is Xavier Jimenez.";
		}
		else if (findKeyword(statement, "home") >= 0
				|| findKeyword(statement, "school") >= 0
				|| findKeyword(statement, "church") >= 0
				|| findKeyword(statement, "playground") >= 0)
			{
				response = "Oratory.";
			}
		else if (findKeyword(statement, "who are you") >= 0)
		{
			response = "I am Saint John Bosco.";
		}
		else if(findKeyword(statement, "Who made you") >= 0)
		{
			response = "I was made by God, but this bot was made by the Senior AP CS Class of 2018!";
		}
		else if(findKeyword(statement, "tech hall") >= 0)
		{
			response = "Tech hall has an extensive history.";
		}
		else if(findKeyword(statement, "the techs") >= 0)
		{
			response = "The 5 Techs are: CSEE, MAT, MSET, IDEA, and ACE!";
		}
		else if(findKeyword(statement, "ace") >= 0)
		{
			response = "ACE stands for 'Architecture and Construction Engineering'. This tech is great if you are into learning about how homes are made and how to keep them GREEN with green technology!";
		}
		else if(findKeyword(statement, "idea") >= 0)
		{
			response = "IDEA stands for 'Integrated Design Engineering and Art'. This tech is great if you want to focus on design of all sorts! Such as: Character design, Home design, and so much more!";
		}
		else if(findKeyword(statement, "mset") >= 0)
		{
			response = "MSET stands for 'Material Science Engineering Technology'. This tech is great if you would like to learn how thing are made, down to the atom! You also learn how to test and discover why things break!";
		}
		else if (findKeyword(statement, "csee") >= 0)
		{
			response = "CSEE stands for 'Computer Science and Electrical Engineering'. This tech is great if you love computers and video games! There are a variety of courses, mostly focused on programming and circuit theory!";
		}
		else if(findKeyword(statement, "mat") >= 0)
		{
			response = "MAT stands for 'Media Arts and Technology'. If you love being artistic in the media field, this tech is perfet for you. You'll learn how to frame pictures, edit videos, and use these techiques for marketing!";
		}
		else if(findKeyword(statement, "fart") >= 0)
		{
			response = "Farts are nice.";
		}
		else if(findKeyword(statement, "") >= 0)
		{
			response = "Speak up! I can't hear a word you are saying!";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	public String typeWriter(String statement)
	{
		int i;
    for(i = 0; i < statement.length(); i++)
		{
      char result;
      result = statement.charAt(i);
	    System.out.printf("%c", result);
	    try
			{
	        Thread.sleep(50);//0.5s pause between characters
	    }
			catch(InterruptedException ex)
			{
	        Thread.currentThread().interrupt();
    	}
		}
		return " ";
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */

	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 *
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "CSEE is a nice tech!";
		}
		else if (whichResponse == 5)
		{
			response = "ACE is fun for architecture!";
		}
		else if (whichResponse == 6)
		{
			response = "MSET is well known for Mr. Curiel's hillarious roasts!";
		}
		else if (whichResponse == 7)
		{
			response = "I care for all the children!";
		}
		else if (whichResponse == 8)
		{
			response = "MAT is where the a e s t h e t i c s are at!";
		}
		else if (whichResponse == 9)
		{
			response = "IDEA's robotics team sure is cool!";
		}
		return response;
	}
}
