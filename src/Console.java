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
                    String name = cin.nextLine();
                    srv.create_uni(name);
                    break;
                case "2":
                    
                    break;
                
                default:
                    System.out.println("There is no such command");
                    break;
            }
        }
    }   
}
