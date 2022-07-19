import java.util.*;

public class University {
    
    public String name;
    public String address;
    public ArrayList<String> faculties;

    // empty construnctor
    public University()
    {
        faculties = new ArrayList<String>();
    }

    // construnctor
    public University(String name,String address)
    {
        this.name = name;
        this.address = address;
        faculties = new ArrayList<String>();
    }
}
