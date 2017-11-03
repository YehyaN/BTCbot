public class InternationalBot extends BoscoBot // Used for international statements
{
  public boolean foundInternational;
  private String statement;
  private boolean process, requirements, homestay, insurance, contact, international;
  private boolean what, who, when, how, why;
  private boolean foundQuestion;
  InternationalBot(String sentence)
  {
    statement = sentence;
    // Check to see if the statement involves technologies
    process = false; requirements = false; homestay = false; insurance = false; contact = false;
    international = false; what = false; who = false; when = false; how = false; why = false;
    if (willInternational() == 6){
      international = true;
    }

    switch(findInternational())
    {
      case 1: // process
        foundInternational = true;
        process = true;
        break;
      case 2:
        foundInternational = true;
        requirements = true;
        break;
      case 3:
        foundInternational = true;
        homestay = true;
        break;
      case 4:
        foundInternational = true;
        insurance = true;
        break;
      case 5:
        foundInternational = true;
        contact = true;
        break;
      case 6:
        foundInternational = true;
        break;
      default:
        foundInternational = false;
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
  private int willInternational(){
    String [] internationalKeys = {"international", "foreign exchange student", "foreign"};
    // Non-specific international
    for(int i = 0; i < internationalKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), internationalKeys[i], 0) >= 0)
      {
        return 6;
      }
    }
    // No international found
    return -1;
  }
  private int findInternational()
  {
    /*
    Returns 1 for process
    Returns 2 for requirements
    Returns 3 for homestay
    Returns 4 for insurance
    Returns 5 for contact
    Returns 6 for non specific International
    Returns -1 if no International keywords are found
    */

    String [] processKeys = {"process"};
    String [] requirementsKeys = {"requirements"};
    String [] homestayKeys = {"homestay", "home", "living"};
    String [] insuranceKeys = {"insurance", "medical", "eduabroad", "gateway"};
    String [] contactKeys = {"contact", "information"};
    String [] internationalKeys = {"international", "foreign exchange student", "foreign"};
    // process
    for(int i = 0; i < processKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), processKeys[i], 0) >= 0)
      {
        return 1; // 1 For process
      }
    }
    // requirements
    for(int i = 0; i < requirementsKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), requirementsKeys[i], 0) >= 0)
      {
        return 2; // 2 For requirements
      }
    }
    // homestay
    for(int i = 0; i < homestayKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), homestayKeys[i], 0) >= 0)
      {
        return 3; // 3 For homestay
      }
    }
    // insurance
    for(int i = 0; i < insuranceKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), insuranceKeys[i], 0) >= 0)
      {
        return 4; // 4 For insurance
      }
    }
    // contact
    for(int i = 0; i < contactKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), contactKeys[i], 0) >= 0)
      {
        return 5; // 5 For contact
      }
    }
    // Non-specific international
    for(int i = 0; i < internationalKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), internationalKeys[i], 0) >= 0)
      {
        return 6;
      }
    }
    // No international found
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
    if(international)
    {
      if(when)
      {
        response = "International students are encouraged to apply by May 1st.";
      }
      else if(how)
      {
        response = "You can apply to Bosco Tech as a international  in a few eassy steps.";
      }
      else if(process)
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
      else if(requirements)
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
      else if(homestay)
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
      else if(insurance)
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
      else if(contact)
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
        if(foundInternational)
        {
          response = "Bosco Tech's popular International Student program provides guidance as the student completes our rigorous\ncollege-preparatory academic program, while offering a nurturing environment. Participants find a welcoming\ncommunity that addresses national security clearance issues, creates opportunities for the individual student's growth, and provides counseling tailored to the student's academic goals and personal needs.";
        }
        else
        {
          response = "";
        }
      }
    }
    else{
      response = "";
    }
  return response;
  }
}
