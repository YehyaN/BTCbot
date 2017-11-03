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
    String [] homestayKeys = {"homestay", "home", "living", "stay"};
    String [] insuranceKeys = {"insurance", "medical", "eduabroad", "gateway"};
    String [] contactKeys = {"contact", "information", "questions"};
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
        response = "You can apply to Bosco Tech as a international student in a few eassy steps.";
      }
      else if(process)
      {
        if(what)
        {
          response = "1) APPLICATION:  A $100.00 application fee is due when the application is submitted.\nApplicants are encouraged to apply by May 1 for the upcoming school year.  Fees are\nnon-refundable.\n2) PARENT'S E-MAIL AND CONTACT INFORMATION:  All applications must include the email\naddress and contact information of the parents or guardian of applicant.\n3) GRADES/TRANSCRIPT:  Must provide academic transcripts from the applicants current\nschool.  A minimum of 3.0 is required.  Transcripts must be translated into English.\n4) TEACHER/DIRECTOR RECOMMENDATION:  Please submit one or more\nrecommendation(s).\n5) CURRENT PASSPORT:  submit a copy of current passport.\n6) FINANCIAL MEANS OF SUPPORT:  Documentation verifying funds translated into U.S.\ncurrency is required by the Department of Homeland Security.";
        }
        else
        {
          response = "You can apply to Bosco Tech as a international student in a few eassy steps.";
        }
      }
      else if(requirements)
      {
        if(what)
        {
          response = "1)Student must be a male between the ages of 13 to 16.\n2) Minimum TOEFL score of at least 76.\n3) Academic performance with an average 3.0 g.p.a. (grade point average).*\n4) A proficiency in the English language.\n5) Good behavior as a student enrolled at Bosco Tech is expected to follow a set of standards\nthat reflect Catholic-Christian moral and spiritual values.\n6) Social maturity, flexibility, and willingness to full engage in the Bosco Tech community.";
        }
        else
        {
          response = "International students are required to take a few steps while applying.";
        }
      }
      else if(homestay)
      {
        if(who)
        {
          response = "You can contact the Location Director, Hiromi Shimamura for EduAbroad, at 858-605-0085 or\nyou can contact the Location Director, Julien Yang for Gateway, at 626-551-4491";
        }
        else
        {
          response = "Bosco Tech welcomes qualified students from all over the world to be part of our unique curriculum. A\nprospective international (or out-of-state) student can use EduAbroad or Gateway Education USA\nhelp facilitate the process of picking a host family. These organizations will guide you through the\nprocess of picking and ultimately finding a home for the student to stay in while studying at Bosco Tech.\nThe application and payment process goes through these companies. Bosco Tech does not provide\nhousing for any students.";
        }
      }
      else if(insurance)
      {
        if(who)
        {
          response = "More information is on the Insurance For Students website.";
        }
        else
        {
          response = "We require ALL students to have medical insurance in the chance there is any medical emergency so\nthat he will have an opportunity to receive the necessary treatment.";
        }
      }
      else if(contact)
      {
        response = "Please contact Olivia Kelly at 626-940-2011 or Okelly@boscotech.edu for anymore questions.";
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
