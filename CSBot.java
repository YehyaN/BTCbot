public class CSBot extends BoscoBot //Anthony (D & R)
{
  @Override
  public String getResponse()
  {
    public boolean foundTech;

    else if(findKeyword(statement.toLowerCase(), "liturgy schedule") >= 0)
    {
      response = "This is our Liturgy Schedule:\n Liturgy Schedule: School begins at 8:00 a.m. \n First Bell 	7:50 a.m. \n FIRST BLOCK (A1/B1) 	8:00 - 9:10 a.m. \n Break 	9:10 - 9:20 a.m. \n SECOND BLOCK (A2/B2) 	9:20 - 10:25 a.m.\n LITURGY 	10:35 - 11:50 a.m.\n Lunch 	11:50 - 12:45 p.m. \n THIRD BLOCK (A3/B3) 	12:45 - 1:50 p.m. \n Break 	1:50 - 2:00 p.m. \n FOURTH BLOCK (A4/B4) 	2:00 - 3:05 p.m. This is our Liturgical schedule! To see others, type one of these keywords and press ENTER:\n 'Schedule', 'Late Start Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
    }
    else if(findKeyword(statement.toLowerCase(), "liturgy") >= 0)
    {
      response = "This is our Liturgy Schedule:\n Liturgy Schedule: School begins at 8:00 a.m. \n First Bell 	7:50 a.m. \n FIRST BLOCK (A1/B1) 	8:00 - 9:10 a.m. \n Break 	9:10 - 9:20 a.m. \n SECOND BLOCK (A2/B2) 	9:20 - 10:25 a.m.\n LITURGY 	10:35 - 11:50 a.m.\n Lunch 	11:50 - 12:45 p.m. \n THIRD BLOCK (A3/B3) 	12:45 - 1:50 p.m. \n Break 	1:50 - 2:00 p.m. \n FOURTH BLOCK (A4/B4) 	2:00 - 3:05 p.m. This is our Liturgical schedule! To see others, type one of these keywords and press ENTER:\n 'Schedule', 'Late Start Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
    }
    else if(findKeyword(statement.toLowerCase(), "late start") >= 0)
    {
      response = "This is our Late Start Schedule:\n Late Start Schedule: School begins at 8:50 a.m.\n First Bell 	8:40 a.m. \n FIRST BLOCK (A1/B1) 	8:50 – 10:05 a.m.\n Break 	10:05 – 10:15 a.m.	\n SECOND BLOCK (A2/B2) 	10:15 – 11:30 a.m.	\n Lunch 	11:30 – 12:25 p.m. \n THIRD BLOCK (A3/B3) 	12:25 – 1:40 p.m.	\n Break 	1:40 – 1:50 p.m.	\n FOURTH BLOCK (A4/B4) 	1:50 – 3:05 p.m. This is our Late Start schedule! To see others, type one of these keywords and press ENTER:\n 'Schedule', 'Liturgy Schedule', 'Morning Assembly Schedule', 'Afternoon Schedule', 'Standarized Test Prep Schedule'\n";
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
    else if(findKeyword(statement.toLowerCase(), "instagram") >= 0)
    {
      response = "Follow our Instagram account @wearebosotech";
    }
    else if(findKeyword(statement.toLowerCase(), "athletics") >= 0)
    {
      response = "Bosco Tech is a member of the California Interscholastic Federation (CIF) and the Catholic Athletic Association (CAA). The Tigers compete with other high schools in nine interscholastic sports: baseball, basketball, cross-country, football, golf, soccer, tennis, track & field, and volleyball.";
    }
  }
