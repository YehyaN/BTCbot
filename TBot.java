public class TBot extends BTCBot {
  public boolean foundTech;
  private String statement;
  private boolean csee, mat, mset, idea, ace;
  TBot(String sentence)
  {
    statement = sentence;
    // Check to see if the statement involves technologies
    csee = false, mat = false, mset = false, idea = false, ace = false;
    switch(findTechnology())
    {
      case 1: // csee
        foundTech = true;
        csee = true;
        break;
      case 2:
        foundTech = true;
        mat = true;
        break;
      case 3:
        foundTech = true;
        mset = true;
        break;
      case 4:
        foundTech = true;
        idea = true;
        break;
      case 5:
        foundTech = true;
        ace = true;
        break;
      default:
        foundTech = false;
        break;
    }
  }
  public int findTechnology()
  {
    /*
    Returns 1 for csee
    Returns 2 for mat
    Returns 3 for mset
    Returns 4 for idea
    Returns 5 for ace
    Returns -1 if no technology keywords are found
    */
    String [] cseeKeys = {"csee", "computer science", "electrical engineering", "programming", "coding", "cs", "ee"};
    String [] matKeys = {"mat", "media"};
    String [] msetKeys = {"mset", "materials", "metalurgy", "metal tech"};
    String [] ideaKeys = {"idea", "design", "integrated design", "engineering and art"};
    String [] aceKeys = {"ace", "arcitecture", "cunstruction", "civil engineering", "home depot"};

    // csee
    for(int i = 0; i < cseeKeys.length; i++)
    {
      if(findKeyword(toLowerCase(statement), cseeKeys[i], 0) >= 0)
      {
        return 1; // 1 For csee
      }
    }
    // mat
    for(int i = 0; i < matKeys.length; i++)
    {
      if(findKeyword(toLowerCase(statement), matKeys[i], 0) >= 0)
      {
        return 2; // 2 For mat
      }
    }
    // mset
    for(int i = 0; i < msetKeys.length; i++)
    {
      if(findKeyword(toLowerCase(statement), msetKeys[i], 0) >= 0)
      {
        return 3; // 3 For mset
      }
    }
    // idea
    for(int i = 0; i < ideaKeys.length; i++)
    {
      if(findKeyword(toLowerCase(statement), ideaKeys[i], 0) >= 0)
      {
        return 4; // 4 For idea
      }
    }
    // ace
    for(int i = 0; i < aceKeys.length; i++)
    {
      if(findKeyword(toLowerCase(statement), aceKeys[i], 0) >= 0)
      {
        return 5; // 5 For ace
      }
    }
    // No technologies found
    return -1;
  }


}
