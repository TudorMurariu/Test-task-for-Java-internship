import java.util.ArrayList;

// repository
public class Repo {

    // class properties
    private ArrayList<Faculty> faculties;
    private ArrayList<Group> groups;
    private ArrayList<Student> students;
    private University uni;

    // constructor
    public Repo()
    {
        faculties = new ArrayList<Faculty>();
        groups = new ArrayList<Group>();
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

    // removes a faculty at a given index
    public void remove_faculty(int index) 
    {
        uni.faculties.remove(index);
        faculties.remove(index);
    }

     // returns the groups
     public ArrayList<Group> get_groups()
     {
         return groups;
     }

     // returns the students
     public ArrayList<Student> get_students()
     {
         return students;
     }

    // adds a group
    public void add_group(Group g)
    {
        groups.add(g);
    }

    // removes a group at a given index
    public void remove_group(int index)
    {
        groups.remove(index);
    }

    // adds a student
    public void add_student(Student s)
    {
        students.add(s);
    }

    // removes a student at a given index
    public void remove_student(int index)
    {
        students.remove(index);
    }
}
