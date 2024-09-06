package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // Server will listen at port 5000
        int port = 6000;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listening at port: " + port);
            // Wait for a client to connect (this will block the code until a connection is made)
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input stream to receive data from the client
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Create output stream to send data to the client
            OutputStream output = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(output,true);

            // Read the client's message (this will also block the code until a message is received)
            String clientMessage = reader.readLine();
            System.out.println("Client: " + clientMessage);

            // Send a response message back to the client
            printWriter.println("Hello from server!");

            // Close the connection with the client after the communication is done
            socket.close();


        } catch(IOException e){
            System.out.println("Server error: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
