package org.example;

import java.io.*;     // For input/output operations
import java.net.*;    // For networking classes like Socket

public class Client {
    public static void main(String[] args) {
        // Define the server's hostname (here it's "localhost", meaning the same machine)
        String hostname = "localhost";
        // Define the port number on which the server is listening
        int port = 6000;

        // Try to connect to the server and handle any exceptions
        try (Socket socket = new Socket(hostname, port)) {
            // Connection to the server is established at this point

            // Create output stream to send data to the server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Create input stream to receive data from the server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send a message to the server
            writer.println("Hello from client!");

            // Read the server's response
            String serverMessage = reader.readLine();
            System.out.println("Server: " + serverMessage);

            // The connection will automatically close at the end of this block
        } catch (UnknownHostException e) {
            // Handle case where the hostname is invalid or unknown
            System.out.println("Client error: Unknown host " + e.getMessage());
        } catch (IOException e) {
            // Handle any input/output errors (e.g., connection failure)
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
