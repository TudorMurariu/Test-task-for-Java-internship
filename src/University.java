import java.util.*;

// kind of an repository in our case
public class University {
    
    public String name;
    public String address;
    public ArrayList<Faculty> faculties;

    // empty construnctor
    public University()
    {
        faculties = new ArrayList<Faculty>();
    }

    // construnctor
    public University(String name,String address)
    {
        this.name = name;
        this.address = address;
        faculties = new ArrayList<Faculty>();
    }
}
