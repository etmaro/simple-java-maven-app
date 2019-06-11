package com.mycompany.app;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 */
public class App {

    private final String message = "Hello World!";

    public App() {
    }

    public static void main(String[] args) {
        System.out.println(new App().getMessage());

        HttpServer server = null;

        {
            try {
                server = HttpServer.create(new InetSocketAddress(8000), 8000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.createContext("/applications/myapp", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private final String getMessage() {
        return message;
    }
}
