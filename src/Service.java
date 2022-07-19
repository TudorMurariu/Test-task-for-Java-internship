public class Service {
    private University uni;

    // creates a university with the given name
    public void create_uni(String name,String address)
    {
        this.uni = new University(name, address);
    }

    // checks if the university exists or not
    public boolean exists_uni()
    {
        return this.uni != null;
    }

    // returns the name of the university
    public String name_of_uni() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return uni.name;
    }

    // returns the adress of the university
    public String adress_of_uni() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return uni.address;
    }

    // returns the number of faculties in the university
    public int number_of_faculties() throws Exception
    {
        if(!exists_uni())
            throw new Exception("The university does not exist!");
        return uni.faculties.size();
    }
}
