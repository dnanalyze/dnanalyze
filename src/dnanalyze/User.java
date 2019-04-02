package dnanalyze;

public abstract class User
{
    String name;

    int UID;

    public User()
    {
        this.name = "";
        UID = -1;
    }

    protected abstract void getInfoFromDB();
}
