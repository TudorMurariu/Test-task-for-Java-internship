public class App {
    public static void main(String[] args) 
    {
        Repo repo = new Repo();
        Service srv = new Service(repo);
        Console console = new Console(srv);
        console.start();
    }
}
