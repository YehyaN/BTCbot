import java.util.Random;
 //author Yehya Nasser, James Villagrana
 //version October 2017

public class BoscoBot
{

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

	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "Hello") >= 0)
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
		else if(findKeyword(statement.toLowerCase(), "bell schedules") >= 0)
		{
			response = "These are our normal schedules:\n Daily Schedule: School begins at 8:00 a.m.\n First Bell 	7:50 a.m.\n FIRST BLOCK (A1/B1) 	8:00 - 9:30 a.m.\n Break 	9:30 - 9:40 a.m.\n SECOND BLOCK (A2/B2) 	9:40 - 11:05 a.m.\n Lunch 	11:05 - 12:05 p.m.\n THIRD BLOCK (A3/B3) 	12:05 - 1:30 p.m.\n Break 	1:30 - 1:40 p.m.\n FOURTH BLOCK (A4/B4) 	1:40 - 3:05 p.m.\n This is our normal schedule! To see others, type one of these keywords and press ENTER:\n 'Liturgy Schedule', 'Late Start Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
		}
		else if(findKeyword(statement.toLowerCase(), "schedule") >= 0)
		{
			response = "These are our normal schedules:\n Daily Schedule: School begins at 8:00 a.m.\n First Bell 	7:50 a.m.\n FIRST BLOCK (A1/B1) 	8:00 - 9:30 a.m.\n Break 	9:30 - 9:40 a.m.\n SECOND BLOCK (A2/B2) 	9:40 - 11:05 a.m.\n Lunch 	11:05 - 12:05 p.m.\n THIRD BLOCK (A3/B3) 	12:05 - 1:30 p.m.\n Break 	1:30 - 1:40 p.m.\n FOURTH BLOCK (A4/B4) 	1:40 - 3:05 p.m.\n This is our normal schedule! To see others, type one of these keywords and press ENTER:\n 'Liturgy Schedule', 'Late Start Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
		}
		else if(findKeyword(statement.toLowerCase(), "bell") >= 0)
		{
			response = "These are our normal schedules:\n Daily Schedule: School begins at 8:00 a.m.\n First Bell 	7:50 a.m.\n FIRST BLOCK (A1/B1) 	8:00 - 9:30 a.m.\n Break 	9:30 - 9:40 a.m.\n SECOND BLOCK (A2/B2) 	9:40 - 11:05 a.m.\n Lunch 	11:05 - 12:05 p.m.\n THIRD BLOCK (A3/B3) 	12:05 - 1:30 p.m.\n Break 	1:30 - 1:40 p.m.\n FOURTH BLOCK (A4/B4) 	1:40 - 3:05 p.m.\n This is our normal schedule! To see others, type one of these keywords and press ENTER:\n 'Liturgy Schedule', 'Late Start Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
		}
		else if(findKeyword(statement.toLowerCase(), "twitter") >= 0)
		{
			response = "Follow our Twitter account @WeAreBoscoTech";
		}
		else if(findKeyword(statement, "instagram") >= 0)
		{
			response = "Follow our Instagram account @wearebosotech";
		}
		else if(findKeyword(statement, "athletics") >= 0)
		{
			response = "Bosco Tech is a member of the California Interscholastic Federation (CIF) and the Catholic Athletic Association (CAA). The Tigers compete with other high schools in nine interscholastic sports: baseball, basketball, cross-country, football, golf, soccer, tennis, track & field, and volleyball.";
		}
		else if(findKeyword(statement, "discover") >= 0
			||findKeyword(statement, "discover the tech") >= 0)
		{
			response = "Bosco Tech is an all-male Catholic high school that combines rigorous college-preparatory and innovative technological education. The science, engineering, technology and math (STEM) curriculum allows students to exceed university admission requirements while completing extensive integrated coursework in one of several applied science and engineering programs.";
		}
		else if (findKeyword(statement, "mission") >= 0
				|| findKeyword(statement, "mission statement") >=0)
		{
			response = "Guided by the Salesian educational system of St. John Bosco, Don Bosco Technical Institute is a Catholic high school that offers a rigorous college preparatory curriculum—uniquely integrating academics and technology—to qualified young men of all religious, ethnic and socioeconomic backgrounds. As a Christian faith community, the school prepares and equips students to be life-long learners who are dedicated men of faith and integrity, committed to leading successful lives of distinguished service and social justice.";
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
	        Thread.sleep(25);//0.5s pause between characters
	    }
			catch(InterruptedException ex)
			{
	        Thread.currentThread().interrupt();
    	}
		}
		return " ";
	}

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

	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

	 private String getRandomResponse ()
 	{
 		Random r = new Random ();
 		return randomResponses [r.nextInt(randomResponses.length)];
 	}

 	private String [] randomResponses = {"Interesting, tell me more",
 			"Hmmm.",
 			"Do you really think so?",
 			"You don't say.",
			"Do you really think so?",
			"CSEE is a nice tech!",
			"ACE is fun for architecture!",
			"MSET is well known for Mr. Curiel's hillarious roasts!",
			"I care for all the children!",
			"MAT is where the a e s t h e t i c s are at!",
			"IDEA's robotics team sure is cool!"
 	};
}
