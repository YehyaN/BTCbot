public class DBot extends BoscoBot // Used for discover statements
{
  public boolean foundDiscover;
  private String statement;
  DBot(String sentence)
  {
    statement = sentence;
    foundDiscover = false;
    getResponse();
  }
  @Override
  public String getResponse()
  {
    String response = "";
    if (findKeyword(statement, "president") >= 0
            && findKeyword(statement, "school") >= 0)
    {
      response = "The President of Bosco Tech is Xavier Jimenez.";
      foundDiscover = true;
    }
    else if (findKeyword(statement, "home") >= 0
        || findKeyword(statement, "school") >= 0
        || findKeyword(statement, "church") >= 0
        || findKeyword(statement, "playground") >= 0)
      {
        response = "Oratory.";
        foundDiscover = true;
      }
    else if (findKeyword(statement, "who are you") >= 0)
    {
      response = "I am Saint John Bosco.";
      foundDiscover = true;
    }
    else if(findKeyword(statement, "Who made you") >= 0)
    {
      response = "I was made by God, but this bot was made by the Senior AP CS Class of 2018!";
      foundDiscover = true;
    }
    else if(findKeyword(statement, "tech hall") >= 0)
    {
      response = "Tech hall has an extensive history.";
      foundDiscover = true;
    }
    return response;
  }
}
