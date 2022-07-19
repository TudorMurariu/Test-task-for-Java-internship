import java.util.ArrayList;

public class Service {
    private Repo repo;

    public Service(Repo repo)
    {
        this.repo = repo;
    }

    // creates a university with the given name
    public void create_uni(String name,String address)
    {
        repo.create_uni(name, address);
    }

    // checks if the university exists or not
    public boolean exists_uni()
    {
        return this.repo.get_uni() != null;
    }

    // returns the name of the university
    public String name_of_uni() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return repo.get_uni().name;
    }

    // returns the adress of the university
    public String adress_of_uni() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return repo.get_uni().address;
    }

    // returns the number of faculties in the university
    public int number_of_faculties() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return repo.get_uni().faculties.size();
    }

    // returns the faculties
    public ArrayList<Faculty> get_faculties()
    {
        return repo.get_faculties();
    }

    // adds a faculty
    public void add_faculty(String name, ArrayList<String> specs) throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");

        ArrayList<Faculty> v = repo.get_faculties();
        for(int i=0;i<v.size();i++)
        {
            // validate the name
            if(v.get(i).name.equals(name))
                throw new Exception("There is another faculty with this name!");

            // validate the specs
            for(String spec : v.get(i).name_of_specialties)
                for(String spec2 : specs)
                    if(spec.equals(spec2))
                        throw new Exception(spec + " is owned by another faculty!");
        }

        Faculty f = new Faculty();
        f.name = name;
        f.name_of_specialties = specs;
        repo.add_faculty(f);
    }

    // removes a faculty
    public void remove_faculty(String name) throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");

        int index = -1;
        ArrayList<Faculty> v = repo.get_faculties();
        for(int i=0;i<v.size();i++)
            if(v.get(i).name.equals(name))
            {
                index = i;
                break;
            }
        if(index == -1)
            throw new Exception("There is no such faculty!");

        repo.remove_faculty(index);
    }

    // returns the groups
    public ArrayList<Group> get_groups()
    {
        return repo.get_groups();
    }

    // returns the students
    public ArrayList<Student> get_students()
    {
        return repo.get_students();
    }

    // adds a group
    public void add_group(String name,String speciality,String faculty_name) throws Exception
    {
        ArrayList<Group> groups = repo.get_groups();
        for(Group g : groups)
            if(g.name.equals(name))
                throw new Exception("There is another group with this name!");

        ArrayList<Faculty> faculties = repo.get_faculties();
        for(Faculty f : faculties)
            if(f.name.equals(faculty_name))
            {
                for(String x : f.name_of_specialties)
                    if(x.equals(speciality))
                    {
                        Group g = new Group();
                        g.name = name;
                        g.speciality = speciality;
                        g.faculty_name = faculty_name;
                        repo.add_group(g);
                        return;
                    }
                throw new Exception("There is no such speciality in this faculty!");
            }
        throw new Exception("There is no faculty with this name");
    }

    // removes a group with the given name
    public void remove_group(String name) throws Exception
    {
        int index = -1;
        ArrayList<Group> groups = repo.get_groups();
        for(int i=0;i<groups.size();i++)
            if(groups.get(i).name.equals(name))
            {
                index = i;
                break;
            }
        
        if(index == -1)
            throw new Exception("There is no group with this name!");
        repo.remove_group(index);
    }
}
