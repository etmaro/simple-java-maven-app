package com.mycompany.app;


class MyHandler implements HttpHandler {
   public void handle(HttpExchange t) throws IOException {
       InputStream is = t.getRequestBody();
       read(is); // .. read the request body
       String response = "Hello World!";
       t.sendResponseHeaders(200, response.length());
       OutputStream os = t.getResponseBody();
       os.write(response.getBytes()); os.close();
   }
}


public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000));
        server.createContext("/applications/myapp", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private final String getMessage() {
        return message;
    }

}
