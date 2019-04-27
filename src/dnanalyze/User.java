package dnanalyze;

import java.util.ArrayList;

public abstract class User
{
   public static void main(String args[])
   {
      DnaGui DNAGui = new DnaGui();
      DNAGui.setVisible(true);
   }

   String name;

    int UID;

    public User()
    {
        this.name = "";
        UID = -1;
    }

    protected abstract void getInfoFromDB();
    
    /**
     * Has the user take the test
     * @param test
     */
    public void takeTest(ArrayList<TestQuestion> test) {
		//TODO need the method to call
	}
    
    /**
     * Creates a flash card for the user
     */
    public void createFlashCards() {
		//TODO need the method to call
	}
    
    /**
     * Views a user's flash card
     * @param flashcard
     */
    public void viewFlashCard(Flashcard flashcard) {
		//TODO need the method to call
    }


    
}
