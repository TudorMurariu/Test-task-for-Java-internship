import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    private Service srv;
    public Console(Service srv)
    {
        this.srv = srv;
    }

    public void start()
    {   
        // functionalities :
        System.out.println("The functionalities are:");
        System.out.println("0 - exit the app");
        System.out.println("1 - Creation of the university");
        System.out.println("2 - Add a faculty");
        System.out.println("3 - Remove a faculty");
        System.out.println("4 - Add a group");
        System.out.println("5 - Remove a group");
        System.out.println("4 - Add a Students");
        System.out.println("5 - Remove a Students");
        System.out.println("6 - Displaying brief information about the university");
        System.out.println("7 - Display of complete information about the university (university data, faculty names, specialty names, group names, student information)");
        System.out.println("8 - Display of all specialties of a particular faculty. The name of the faculty is entered by the user");
        System.out.println("9 - Display of all groups of a particular faculty. The name of the faculty is entered by the user");
        System.out.println("10 - Display of all students of a particular group. The group name is entered by the user");
        System.out.println("11 - Show all the functionalities in the console");
        System.out.println("");
        System.out.println("");

        // we create an infinite loop to simulate an UI
        Scanner cin = new Scanner(System.in);
        while(true)
        {
            System.out.println("Give a command :");
            String input = cin.nextLine();

            switch(input)
            {
                // exits the program
                case "0":
                    cin.close();
                    return;
                
                case "1":
                    {
                        System.out.println("Name :");
                        String name = cin.nextLine();
                        System.out.println("Address :");
                        String address = cin.nextLine();
                        srv.create_uni(name, address);
                    }
                    break;

                case "2":
                    try{
                        System.out.println("Name :");
                        String name = cin.nextLine();
                        System.out.println("Enter the number of specialities :");
                        int nr = cin.nextInt();
                        cin.nextLine();
                        
                        ArrayList<String> specialities = new ArrayList<String>();
                        System.out.println("Name of specialities , one on each line :");
                        while(nr-- != 0)
                        {
                            System.out.println("Name :");
                            specialities.add(cin.nextLine());
                        }

                        srv.add_faculty(name, specialities);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case "3":
                    try{
                        System.out.println("Name :");
                        String name = cin.nextLine();
                        srv.remove_faculty(name);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case "4":
                    try{

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case "6":
                    try{
                        System.out.println();
                        System.out.println("University name: " + srv.name_of_uni());
                        System.out.println("University address: " + srv.adress_of_uni());
                        System.out.println("Number of faculties: " + srv.number_of_faculties());
                        System.out.println();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case "7":
                    try{
                        System.out.println();
                        System.out.println("University name: " + srv.name_of_uni());
                        System.out.println("University address: " + srv.adress_of_uni());
                        
                        System.out.println("The faculties:");
                        ArrayList<Faculty> faculties = srv.get_faculties();
                        for(Faculty f : faculties)
                        {
                            System.out.println("Faculty name: " + f.name);
                            System.out.println("Faculty specialties: ");
                            for(String name : f.name_of_specialties)
                                System.out.print(name + " ");
                            System.out.println();
                        }
                        System.out.println();

                        System.out.println();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                default:
                    System.out.println("There is no such command");
                    break;
            }
        }
    }   
}
