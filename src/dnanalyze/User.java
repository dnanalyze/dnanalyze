package dnanalyze;

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
}
