import java.io.FileWriter;
import java.util.ArrayList;

public class Service {
    private Repo repo;

    public Service(Repo repo)
    {
        this.repo = repo;
        test_exists_uni();
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

    // adds a student
    public void add_student(String name,String last_name,String phone_number,String group_name) throws Exception
    {
        // validate the phone number 
        // we do not know from witch country it is so we can not put any other restrictions
        String nums = "0123456789+-";
        for(int i=0;i<phone_number.length();i++)
            if(nums.indexOf(phone_number.charAt(i)) == -1)
                throw new Exception("Incorect phone number!!!");

        // two students can have the same names

        // we serch for a group with the given group_name
        ArrayList<Group> groups = repo.get_groups();
        for(Group g : groups)
            if(g.name.equals(group_name))
            {
                Student s = new Student(name, last_name, phone_number, group_name);
                repo.add_student(s);
                return;
            }
        throw new Exception("There is no group with this name!!!");
    }

    // removes a student
    public void remove_student(String name,String last_name) throws Exception
    {
        ArrayList<Student> students = repo.get_students();
        int index = -1;
        for(int i=0;i<students.size();i++)
            if(name.equals(students.get(i).name) && last_name.equals(students.get(i).last_name) )
            {
                index = i;
                break;
            }
        if(index == -1)
            throw new Exception("There is no student with this name!!!");
        
        repo.remove_student(index);
    }

    // returns all the specialities of a given faculty
    public String get_speccialities(String faculty_name) throws Exception
    {
        ArrayList<Faculty> faculties = repo.get_faculties();
        for(Faculty f : faculties)
            if(f.name.equals(faculty_name))
            {
                String specs = new String();
                for(String spec : f.name_of_specialties)
                {
                    specs += spec + " ";
                }
                return specs;
            }
        
        throw new Exception("There is no faculty with this name!!!");
    }

    // returns all the groups of a given faculty
    public String get_groups(String faculty_name) throws Exception
    {
        ArrayList<Faculty> faculties = repo.get_faculties();
        for(Faculty f : faculties)
            if(f.name.equals(faculty_name))
            {
                ArrayList<Group> all_groups = repo.get_groups();
                String groups = new String();
                for(Group g : all_groups)
                    if(g.faculty_name.equals(faculty_name))
                        groups += g.name + " ";
                return groups;
            }
        
        throw new Exception("There is no faculty with this name!!!");
    }

    // returns all the students of a given group
    public String get_students(String group_name) throws Exception
    {
        ArrayList<Group> groups = repo.get_groups();
        for(Group g : groups)
            if(g.name.equals(group_name))
            {
                ArrayList<Student> all_studs = repo.get_students();
                String students = new String();
                for(Student s : all_studs)
                    if(s.group_name.equals(group_name))
                        students += s.name + " ";
                return students;
            }
        
        throw new Exception("There is no group with this name!!!");
    }

    // exports the data to a file
    public void Export(String file_name) throws Exception
    {
        if(!file_name.endsWith(".txt"))
            throw new Exception("The file must end in .txt!!!");

        // we create a file writer
        FileWriter file = new FileWriter(file_name);

        file.write("University name: " + name_of_uni() + "\n");
        file.write("University address: " + adress_of_uni() + "\n\n");

        // first we print the faculties
        file.write("The faculties:\n");
        ArrayList<Faculty> faculties = repo.get_faculties();
        for(Faculty f : faculties)
        {
            file.write("Faculty name: " + f.name + "\n");
            file.write("Faculty specialties: \n");
            for(String name : f.name_of_specialties)
                file.write(name + " ");
            file.write("\n");
        }
        file.write("\n");

        // we print the group
        file.write("The groups:\n");
        ArrayList<Group> groups = repo.get_groups();
        for(Group g : groups)
        {
            file.write("Name : " + g.name + "\n");
            file.write("Speciality : " + g.speciality + "\n");
            file.write("From the faculty : " + g.faculty_name + "\n");
            file.write("\n");
        }
        file.write("\n");

        // we print the students
        file.write("The Students:\n");
        ArrayList<Student> students = repo.get_students();
        for(Student s : students)
        {
            file.write("Name: " + s.name + "\n");
            file.write("Last name: " + s.last_name + "\n");
            file.write("Phone number: " + s.phone_number + "\n");
            file.write("Group name: " + s.group_name + "\n");
            file.write("\n");
        }
        file.write("\n");

        // we close the file writer
        file.close();
    }

    // tests: 

    private void test_exists_uni()
    {
        assert(exists_uni() == false);
    }
}