package server;

public class Main {
    private static final int PORT_NUMBER = 8080;
    private static final int MAX_WAITING_CONNECTIONS = 10;

    public static void main(String[] args) throws Exception{
        Server server = new Server(PORT_NUMBER, MAX_WAITING_CONNECTIONS);
        server.start();
        System.out.println("***********************");
        System.out.println("SERVER STARTED on PORT " + PORT_NUMBER);
        System.out.println("***********************");
    }
}
