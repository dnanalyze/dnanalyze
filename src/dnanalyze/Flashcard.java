package dnanalyze;

import java.util.LinkedList;


public class Flashcard extends QuestionAnswer
{

  //Prompt for each question asked to the user
  String savePrompt= "Are you sure you would like to save?";
  String addTermPrompt = "Enter Term: ";
  String addDefPrompt ="Enter Definition: ";

  int numOfCards;
  String[] termsArray = new String[0];
  String[] definitionsArray= new String[0];

// Indexs for arrays
  int tailOfTerms= numOfCards;
  int tailofDefs = numOfCards;
  int numOfCurrentCardTerm = 0;
  int numOfCurrentCardDef = 0;


/**
Adds cards to an array based on the input from the user
**/
  public void addCard()
  {
    updateNumOfCards();
    System.out.println(addTermPrompt);
    termsArray[tailOfTerms] = input.next();
    System.out.println(addDefPrompt);
    definitionsArray[tailOfDefs] = input.next();
  }

/**
  Check to see if onw of the arrays are empty
**/
  public boolean isEmpty()
  {
    if( termsArray.length() == 0)
    {
      return true;
    }
    return false;
  }

/**
  updates the card number if a new flashcard is added and it updates the array by
  making a bigger array

**/
  public void updateNumOfCards()
  {
    if(isEmpty())
    {
      numOfCurrentCardDef = 1;
      numOfCurrentCardTerm =1;
      definitionsArray= new String[numOfCurrentCardDef];
      termsArray = new String[numOfCurrentCardTerm];

    }
    else
    {
        if( termsArray.length() >= numOfCurrentCardTerm)
        {
          numOfCurrentCardTerm++;
          numOfCurrentCardDef++;
          int index;
          String [] tempArray = newString(numOfCurrentCardTerm);

          for(index=0; index < termsArray.length(); index++)
          {
            tempArray[index]= termsArray[index];
          }

          termsArray= tempArray;

          for(index=0; index <  definitionsArray.length(); index++)
          {
            tempArray[index] = termsArray[index];
          }
          definitionsArray = tempArray;
        }
        else
        {
          numOfCurrentCardTerm++;
          numOfCurrentCardDef++;
        }
    }

  }

/**
    Deletes Card in array by shifting the termsArray and definitionsArray
**/
  public void deleteCard(int numOfCurrentCardTerm,int numOfCurrentCardDef)
  {

    if(!isEmpty())
    {
        int index;
          for ( index = numOfCurrentCardTerm; index < termsArray.length(); index++)
          {
            termsArray[index] = termsArray[ index + 1 ];
          }

          for ( index = numOfCurrentCardDef; index < definitionsArray.length(); index++)
          {
            definitionsArray [index] = definitionsArray[ index + 1 ];
          }

          numOfCurrentCardDef --;
          numOfCurrentCardTerm--;
    }

  }

/**
    moves index to the next value in each array
**/

  public void next()
  {
    numOfCurrentCardDef++;
    definitionsArray[numOfCurrentCardDef];

    numOfCurrentCardTerm++;
    termsArray[numOfCurrentCardTerm];
  }

/**
    moves index to the previous value in each array
**/
  public void previous()
  {
    numOfCurrentCardDef--;
    numOfCurrentCardTerm--;
    definitionsArray[numOfCurrentCardDef];
    termsArray[numOfCurrentCardTerm];
  }
}
