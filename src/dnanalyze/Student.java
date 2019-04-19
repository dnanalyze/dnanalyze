package dnanalyze;

import java.util.ArrayList;

public class Student extends User
{
	
	ArrayList<restrictions> restrictions;
	
	public Student() {
		super();
		this.restrictions = new ArrayList<restrictions>();
	}

    @Override
    protected void getInfoFromDB()
    {
        // TODO Auto-generated method stub

    }
    
    /**
     * Adds a restriction to the student account
     * @param restriction
     */
    public void addRestiction(restrictions restriction) {
		this.restrictions.add(restriction);
	}
    
    public void removeRestriction(restrictions restriction) {
		this.restrictions.remove(restriction);
	}

}
