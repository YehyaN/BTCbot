public class AlumniBot extends BoscoBot // Used for technology statements
{

  private String statement;

  public boolean foundAlumni;

  private boolean alumni;

  private boolean foundQuestion;
  private boolean what;
  private boolean who;
  private boolean how;

  AlumniBot(String sentence)
  {
    statement = sentence;

    switch(findAlumni())
    {
      case 1: // csee
        foundAlumni = true;
        alumni = true;
        break;
      default:
        foundAlumni = false;
        break;
    }
    switch(findQuestion())
    {
      case 1:
        what = true;
        foundQuestion = true;
        break;
      case 2:
        who = true;
        foundQuestion = true;
        break;
      case 3:
        how = true;
        foundQuestion = true;
        break;
      default:
        foundQuestion = false;
        break;
    }
  }
  private int findAlumni()
  {
    /*
    Returns 1 for alumni
    Returns -1 if no alumni keywords are found
    */
    String [] alumniKeys = {"alumni", "alumni association", "alumnist", "alumn", "alum"};
    // csee
    for(int i = 0; i < alumniKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), alumniKeys[i], 0) >= 0)
      {
        return 1; // 1 For alumni
      }
    }
    // No technologies found
    return -1;
  }
  private int findQuestion()
  {
    /*
    Returns 1 for what
    Returns 2 for who
    Returns 3 for how
    Returns -1 for none of the above
    */
    if(findKeyword(statement.toLowerCase(), "what", 0) >= 0) // what
    {
      return 1; // 1 For what
    }
    else if(findKeyword(statement.toLowerCase(), "who", 0) >= 0) // who
    {
      return 2; // 2 For who
    }
    else if(findKeyword(statement.toLowerCase(), "how", 0) >= 0) // how
    {
      return 3; // 3 For how
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
    if(alumni)
    {
      if(how)
      {
        response = "You can join the Alumni Association by emailing martinhairston@hotmail.com";
      }
      else if(who)
      {
        response = "The Board President of the Alumni Association is Martin Hairston";
      }
      else if(what)
      {
        response = "The Alumni Association is involved with Bosco Tech by doantions, visiting campus, and attending class reunions.";
      }
      else
      {
        response = "The mission of the Alumni Association is to organize alumni into a cohesive unit for the benefit of the school and all its members including alumni, students, faculty, staff and friends.";
      }
    }
    return response;
  }
}
