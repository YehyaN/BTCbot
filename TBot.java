public class TBot extends BoscoBot // Used for technology statements
{
  public boolean foundTech;
  private String statement;
  private boolean csee, mat, mset, idea, ace;
  private boolean what, who, when, how, why;
  private boolean foundQuestion;
  TBot(String sentence)
  {
    statement = sentence;
    // Check to see if the statement involves technologies
    csee = false; mat = false; mset = false; idea = false; ace = false;
    what = false; who = false; when = false; how = false; why = false;
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
      case 6:
        foundTech = true;
        break;
      default:
        foundTech = false;
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
        when = true;
        foundQuestion = true;
        break;
      case 4:
        how = true;
        foundQuestion = true;
        break;
      case 5:
        why = true;
        foundQuestion = true;
        break;
      default:
        foundQuestion = false;
        break;
    }
  }
  private int findTechnology()
  {
    /*
    Returns 1 for csee
    Returns 2 for mat
    Returns 3 for mset
    Returns 4 for idea
    Returns 5 for ace
    Returns 6 for non specific tech
    Returns -1 if no technology keywords are found
    */
    String [] cseeKeys = {"csee", "computer science", "electrical engineering", "programming", "coding", "cs", "ee"};
    String [] matKeys = {"mat", "media"};
    String [] msetKeys = {"mset", "materials", "metalurgy", "metal tech"};
    String [] ideaKeys = {"idea", "design", "integrated design", "engineering and art"};
    String [] aceKeys = {"ace", "architecture", "cunstruction", "civil engineering", "home depot"};
    String [] techs = {"tech", "techs", "technology", "technologies", "majors"};
    // csee
    for(int i = 0; i < cseeKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), cseeKeys[i], 0) >= 0)
      {
        return 1; // 1 For csee
      }
    }
    // mat
    for(int i = 0; i < matKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), matKeys[i], 0) >= 0)
      {
        return 2; // 2 For mat
      }
    }
    // mset
    for(int i = 0; i < msetKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), msetKeys[i], 0) >= 0)
      {
        return 3; // 3 For mset
      }
    }
    // idea
    for(int i = 0; i < ideaKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), ideaKeys[i], 0) >= 0)
      {
        return 4; // 4 For idea
      }
    }
    // ace
    for(int i = 0; i < aceKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), aceKeys[i], 0) >= 0)
      {
        return 5; // 5 For ace
      }
    }
    // Non-specific tech
    for(int i = 0; i < techs.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), techs[i], 0) >= 0)
      {
        return 6;
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
    Returns 3 for when
    Returns 4 for how
    Returns 5 for why
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
    else if(findKeyword(statement.toLowerCase(), "when", 0) >= 0) // when
    {
      return 3; // 3 For when
    }
    else if(findKeyword(statement.toLowerCase(), "how", 0) >= 0) // how
    {
      return 4; // 4 For how
    }
    else if(findKeyword(statement.toLowerCase(), "why", 0) >= 0) // why
    {
      return 5; // 5 For why
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
    if(when)
    {
      response = "Freshmen choose their technology majors in January.";
    }
    else if(how)
    {
      response = "During the summer, incomming freshmen spend a week in each technology. After that, they narrow their selection down to 3 technologies that they spend 6 weeks in each during the first semester. Then, in January, they make their final technology selection.";
    }
    else if(csee)
    {
      if(what)
      {
        response = "CSEE stands for Computer Science and Electrical Engineering. In CSEE, we learn how to program in C++, Java, and Python and basic electronics principals.";
      }
      else if(who)
      {
        response = "The teachers in CSEE are Edward Sepulveda and Al Lopez.";
      }
      else if(why)
      {
        response = "A student should choose CSEE if they are interested in computers, electrical engineering, or like math and logic";
      }
      else
      {
        response = "CSEE is where all of the smart kids go!";
      }
    }
    else if(mat)
    {
      if(what)
      {
        response = "MAT stands for Media Arts Technology. In MAT they learn marketing, app design, web design, and Photoshop.";
      }
      else if(who)
      {
        response = "The teachers in MAT are Brendan Chua and Casey Hernandez.";
      }
      else if(why)
      {
        response = "A student should choose MAT if they are interested in business, marketing, and art.";
      }
      else
      {
        response = "MAT is where the a e s t h e t i c s are!";
      }
    }
    else if(mset)
    {
      if(what)
      {
        response = "MSET stands for Materials Science Engineering Technology. In MSET they learn about materials and how they work.";
      }
      else if(who)
      {
        response = "The teachers in MSET are Jim Curiel and Gaurav Nagalia.";
      }
      else if(why)
      {
        response = "A student should choose MSET if they are interested in chemistry, forensics, or medicine.";
      }
      else
      {
        response = "MSET is well known for Mr. Curiel's hillarious roasts!";
      }
    }
    else if(idea)
    {
      if(what)
      {
        response = "IDEA stands for Integrated Design Engineering and Art. In IDEA, they learn design and prototyping aswell as some architecture and robotics.";
      }
      else if(who)
      {
        response = "The teachers in IDEA are Luis Garza and Rory Mulcahey.";
      }
      else if(why)
      {
        response = "A student should choose IDEA if they are interested in design, mechanical engineering, or want to be an inventor.";
      }
      else
      {
        response = "IDEA's robotics team sure is cool!";
      }
    }
    else if(ace)
    {
      if(what)
      {
        response = "ACE stands for Architecture and Cunstruction Engineering. In ACE, they learn about architecture, civil engineering, and green energy.";
      }
      else if(who)
      {
        response = "The teachers in ACE are Clifford Reid and Diego Lopez.";
      }
      else if(why)
      {
        response = "A student should choose ACE if they are interested in buildings, architecture, or aspire to work at home depot.";
      }
      else
      {
        response = "ACE is fun for architecture!";
      }
    }
    else
    {
      if(foundTech)
      {
        response = "The five technologies are CSEE, MAT, MSET, IDEA, and ACE.";
      }
      else
      {
        response = "";
      }
    }
    return response;
  }
}
