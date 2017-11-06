public class FSBot extends BoscoBot // Used for technology statements
{
  public boolean foundFutureStudent;
  private String statement;
  private boolean admissionsprocess, shadow, fsp, summer;
  private boolean what, who, when, how, why;
  private boolean foundQuestion;
  FSBot(String sentence)
  {
    statement = sentence;
    // Check to see if the statement involves technologies
    admissionsprocess = false; shadow = false; fsp = false; summer = false;
    what = false; who = false; when = false; how = false; why = false;
    switch(findTopic())
    {
      case 1: // csee
        foundFutureStudent = true;
        admissionsprocess = true;
        break;
      case 2:
        foundFutureStudent = true;
        shadow = true;
        break;
      case 3:
        foundFutureStudent = true;
        fsp = true;
        break;
      case 4:
        foundFutureStudent = true;
        summer = true;
        break;
      case 5:
        foundFutureStudent = true;
        break;
      default:
        foundFutureStudent = false;
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
  private int findTopic()
  {
    /*
    Returns 1 for admissionsprocess
    Returns 2 for FAQS
    Returns 3 for Shadow program
    Returns 4 for Transfer Students
    Returns 5 for Summer Programs
    Returns 6 for FSP
    Returns -1 if no technology keywords are found
    */
    String [] admissionsKeys = {"apply", "freshman", "deadline", "process", "8th grade", "grade 8"};
    String [] shadowKeys = {"shadow", "visit", "see our school", "tiger shadow program"};
    String [] fspKeys = {"freshman summer", "requirments", "fsp"};
    String [] summerKeys = {"summer school"};
    String [] futureKeys = {"Future", "Futrue Students"};
    // admissionsprocess
    for(int i = 0; i < admissionsKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), admissionsKeys[i], 0) >= 0)
      {
        return 1; // 1 For admissions
      }
    }
    // mat
    for(int i = 0; i < shadowKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), shadowKeys[i], 0) >= 0)
      {
        return 2; // 2 For shadow
      }
    }
    // mset
    for(int i = 0; i < fspKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), fspKeys[i], 0) >= 0)
      {
        return 3; // fsp
      }
    }
    // idea
    for(int i = 0; i < summerKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), summerKeys[i], 0) >= 0)
      {
        return 4; // 4 For summer programs
      }
    }
    // ace
    for(int i = 0; i < futureKeys.length; i++)
    {
      if(findKeyword(statement.toLowerCase(), futureKeys[i], 0) >= 0)
      {
        return 5; // 5 For general
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
      response = "Early Admission deadline: December 8, 2017\nRegular Admission deadline: February 10, 2018";
    }
    else if(how)
    {
      response = "You can apply at https://boscotech.edu/.";
    }
    else if(admissionsprocess)
    {
      if(what)
      {
        response = "If you are currently an 8th grade student seeking admission to the Bosco Tech Class of 2022 students have the opportunity to apply under two deadlines:\nEarly Admission deadline: December 8, 2017\nRegular Admission deadline: February 10, 2018\nStudents can still apply after these deadlines, but they will be reviewed on a rolling basis.\n\nAll materials stated below must be submitted to complete to be considered for admission.\n1. Complete Admission Application with a non-refundable application fee of $75.\n2. Provide your mathematics, language arts or literature teacher, and principal with the appropriate recommendation form and ask that he/she complete and submit on your behalf.\n3. Complete a portfolio and submit on the date of your interview.\nIf you are applying under the Early Admissions deadline, the possible dates to choose from are: December 13-16, 2017. \nIf you are applying under the Regular Admissions deadline, the possible dates to choose from are: February 15, 16, 21, 22, 2018.";
      }
      else if(who)
      {
        response = "The admissions process for the clss of 2022 is open to current 8th graders.";
      }
      else if(why)
      {
        response = "Bosco Tech is the only all-male Catholic high school in the state that uniquely combines college-preparatory curriculum with a comprehensive program of project-based applied sciences and engineering.\nAt Bosco Tech you will be able to:\nLearn the theories of engineering while putting them in real-life situations through various hands-on projects.\nDevelop strengths through various clubs, leadership opportunities, civic engagement, and athletics.\nEngage with leaders in various STEM fields through the many internships our alumni provide.";
      }
      else
      {
        response = "Ask an ambassador or admissions officer for more information to apply.\nVisit our website: Boscotech.edu to find out more information about the school.\nSee you soon";
      }
    }
    else if(fsp)
    {
      if(what)
      {
        response = "Incoming freshman take classes during the summer and spend a week at each technology.";
      }
      else if(who)
      {
        response = "The FSP is mandatory for all incoming freshman.";
      }
      else if(why)
      {
        response = "FSP is to help teachers and students asess where they are and can help with the load of the curriculum by starting in the summer.\nFSP lets students acclimate to the rigorous and demanding curriculum they will experience here at the Tech.";
      }
      else
      {
        response = "Visit our website Boscotech.edu to find out more about the Freshman Summer Program.";
      }
    }
    else if(shadow)
    {
      if(what)
      {
        response = "The Tiger Shadow Program is an oppertuinty for prospective students to \"shadow\" a Bosco Tech Ambassador for a day and gain a real-life campus experience.\nStudent's will enjoy a regular day of school, attending classes and eating lunch with his host, while meeting the school's faculty, staff, and students.\nIn addition, he will learn about the school's academic programs, extra-curricular activities, and the admissions process. ";
      }
      else if(who)
      {
        response = "The shadow program is for prospective boys in seventh and eighth grade, as well as prospective transfer students.";
      }
      else if(why)
      {
        response = "A student should schedule a shadow day if he is interested in the school or would like to find out more about Boscotech.";
      }
      else
      {
        response = "Go on to Boscotech.edu to find out more info and schedule your shadow day at Bosco.";
      }
    }
    else if(summer)
    {
      if(what)
      {
        response = "Summer programs are classes during the summer.";
      }
      else if(who)
      {
        response = "Summer programs are offered to 7th and 8th graders.";
      }
      else if(why)
      {
        response = "Summer and Sports programs are offered for students to get ahead during the summer.";
      }
      else
      {
        response = "Visit Boscotech.edu to find out more about the summer programs offered";
      }
    }
    else
    {

        response = "";

    }
    return response;
  }
}
