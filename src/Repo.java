import java.util.ArrayList;

public class Repo {

    // class properties
    private ArrayList<Faculty> faculties;
    private ArrayList<Group> grups;
    private ArrayList<Student> students;
    private University uni;

    // constructor
    public Repo()
    {
        faculties = new ArrayList<Faculty>();
        grups = new ArrayList<Group>();
        students = new ArrayList<Student>();
    }

    // creates a university with the given name
    public void create_uni(String name,String address)
    {
        this.uni = new University(name, address);
    }

    // returns the university
    public University get_uni()
    {
        return this.uni;
    }

    // returns the faculties
    public ArrayList<Faculty> get_faculties()
    {
        return faculties;
    }

    // adds a faculty
    public void add_faculty(Faculty f)
    {
        faculties.add(f);
        uni.faculties.add(f.name);
    }

    
}
