public class ABot extends BoscoBot
{

  private String statement;

  public boolean foundClass;

  private boolean freshman;
  private boolean sophomore;
  private boolean junior;
  private boolean senior;
  private boolean course;

  private boolean foundQuestion;
  private boolean what;

  ABot(String sentence)
  {
    statement = sentence;

    switch(findClass())
    {
      case 1:
        foundClass = true;
        freshman = true;
        break;
      case 2:
        foundClass = true;
        sophomore = true;
        break;
      case 3:
        foundClass = true;
        junior = true;
        break;
      case 4:
        foundClass = true;
        senior = true;
        break;
      case 5:
        foundClass = true;
        course = true;
        break;
      default:
        foundClass = false;
        break;
    }
    switch(findQuestion())
    {
      case 1:
        what = true;
        foundQuestion = true;
        break;
      default:
        foundQuestion = false;
        break;
    }
  }

  private int findClass()
  {
    String [] freshmenKeys = {"freshmen", "freshman", "first years", "first year", "9th grade", "ninth grade", "9th graders", "ninth graders"};
    String [] sophomoreKeys = {"sophomore", "sophomores", "second years", "second year", "10th grade", "tenth grade", "10th graders", "tenth graders"};
    String [] juniorKeys = {"junior", "juniors", "third years", "third year", "11th grade", "eleventh grade", "11th graders", "eleventh graders"};
    String [] seniorKeys = {"senior", "seniors", "fourth years", "fourth year", "12th grade", "twelve grade", "12th graders", "twelve graders"};
    String [] classKeys = {"class", "classes", "course", "courses"};

    //freshmen
    for(int i = 0; i < freshmenKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), freshmenKeys[i], 0) >= 0)
      {
        return 1; // 1 For freshmen
      }
    }

    //sophomores
    for(int i = 0; i < sophomoreKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), sophomoreKeys[i], 0) >= 0)
      {
        return 2; // 2 For sophomores
      }
    }

    //juniors
    for(int i = 0; i < juniorKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), juniorKeys[i], 0) >= 0)
      {
        return 3; // 3 For juniors
      }
    }

    //seniors
    for(int i = 0; i < seniorKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), seniorKeys[i], 0) >= 0)
      {
        return 4; // 4 For seniors
      }
    }

    //classes
    for(int i = 0; i < classKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), classKeys[i], 0) >= 0)
      {
        return 5; // 5 For classes
      }
    }

    //no class found
    return -1;
  }

  private int findQuestion()
  {
    if(findKeyword(statement.toLowerCase(), "what", 0) >= 0) // what
    {
      return 1; // 1 For what
    }
    else
    {
      return -1;
    }
  }

  @Override
  public String getResponse()
  {
    String response = "";

    if(freshman)
    {
      if(what)
      {
        response = "The classes freshman take are:\nMath: Algebra 1,2 or Geometry or Algebra 3,4 (determined by placement testing and previous courses)\nEnglish: English I - Composition and Literature (honors section available)\nTheology: Revelation of Jesus Christ in Scripture and Who is Jesus Christ? (one semester each)\nHealth and Physical Education: Healthy Living\nScience: Biology (honors section available)\nSocial Studies: World History (honors section available)\nTechnology Courses: Tech rotation classes and Introductory courses in tech major (one semester each)";
      }
    }
    else if(sophomore)
    {
      if(what)
      {
          response = "The classes sophomores take are:\nMath: Geometry or Algebra 3,4 or Pre-calculus\nEnglish: English II - Composition and Literature (honors section available)\nTheology: Mission of Jesus Christ and Christ's Mission Continues in the Church (one semester each)\nScience: Physical Science for Engineering or Honors Chemistry\nForeign Language: Spanish I or Bilingual Spanish I or Japanese I\nFine Arts: Art Appreciation or Introduction to Music\nTechnology: Depending on each Technology Major";
      }
    }
    else if(junior)
    {
      if(what)
      {
          response = "The classes juniors take are:\nMath: Algebra 3,4 or Pre-calculus or Calculus or AP Calculus AB\nEnglish: English III - Composition and American Literature (honors section available)\nTheology: Christ's Mission in the Church and Sacraments as Privileged Encounters (one semester each)\nScience: General Chemistry or AP Chemistry or Physics\nSocial Studies: U.S. History or AP U.S. History\nForeign Language: Spanish II or Bilingual Spanish II or AP Spanish Language and Culture or Japanese II\nTechnology: Depending on each Technology Major";
      }
    }
    else if(senior)
    {
      if(what)
      {
        response = "The classes seniors take are:\nMath: Pre-calculus or Calculus or AP Calculus AB or AP Calculus BC or Statistics or AP Statistics\nEnglish: English IV - Composition and British Literature or AP English Literature\nTheology: Sacraments as Privileged Encounters and Responding to the Call of Christ (one semester each)\nScience: Physics or AP Physics C or Anatomy and Physiology\nSocial Stcience: U.S. Government or AP U.S. Government and Economics or AP Macroeconomics (one semester each)\nSenior Elective: Spanish III or AP Spanish Literature or AP Human Geography or Creative Writing or Speech and Forensics\nTechnology: Depending on each Technology Major";
      }
    }
    else
    {
      if(foundClass)
      {
        response = "The Instructional Areas at Bosco Tech are: English\nFine Arts\nForeign Language\nMath\nHealth/Physical Education\nScience\nSocial Sciences\nTheology";
      }
      else
      {
        response = "";
      }
    }
    return response;
  }
}
