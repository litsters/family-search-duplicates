package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static final String HTTP_ROOT = "dist/angular-template/";
    public static String getHttpRoot(){return HTTP_ROOT;}

    private static final String DEFAULT_CONTEXT = "/";
    private static final String GENERATE_CONTEXT = "/generate";

    private HttpServer server;

    public Server(int portNumber, int maxWaitingConnections) throws IOException {
        server = HttpServer.create(new InetSocketAddress(portNumber), maxWaitingConnections);
        server.setExecutor(null);
        server.createContext(GENERATE_CONTEXT, new GenerateHandler());
        server.createContext(DEFAULT_CONTEXT, new DefaultHandler());
    }

    public void start(){
        server.start();
    }
}
