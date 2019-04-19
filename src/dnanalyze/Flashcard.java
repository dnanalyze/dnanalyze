package dnanalyze;

import java.util.LinkedList;


public class Flashcard extends QuestionAnswer
{
  String savePrompt= "Are you sure you would like to save?";
  String addTermPrompt = "Enter Term: ";
  String addDefPrompt ="Enter Definition: ";

  int numOfCards= 15;
  String [] termsArray = new String(numOfCards);
  String [] definitionsArray = new String(numOfCards);

  int tailOfTerms= numOfCards;
  int tailofDefs = numOfCards;
  int numOfCurrentCard= 0;



  public void addCard()
  {
    System.out.println(addTermPrompt);
    termsArray[tailOfTerms] = input.next();
    System.out.println(addDefPrompt);
    definitionsArray[tailOfDefs] = input.next();
  }

  public void deleteCard(int numOfCurrentCard)
  {
    int index;

    for ( index = numOfCurrentCard; index < termsArray.length(); index++)
    {
      termsArray[index] = termsArray[index+1];
    }

    for ( index = numOfCurrentCard; index < definitionsArray.length(); index++)
    {
      definitionsArray [index] = definitionsArray[index+1];
    }

  }




}
