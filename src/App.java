public class App {
    public static void main(String[] args) 
    {
        Service srv = new Service();
        Console console = new Console(srv);
        console.start();
    }
}
