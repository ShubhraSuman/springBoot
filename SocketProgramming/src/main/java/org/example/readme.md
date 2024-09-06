### Client
Here’s the client code with comments added and a simplified explanation to make it easy to understand:

### Explanation with Comments:

1. **Connecting to the server**:
   ```java
   Socket socket = new Socket(hostname, port);
   ```
    - The client creates a `Socket` to connect to the server at `localhost` (which means it's running on the same machine) on port `5000`.
    - Think of this as dialing a phone number to call the server. When the client connects, the server accepts the connection.

2. **Sending a message to the server**:
   ```java
   OutputStream output = socket.getOutputStream();
   PrintWriter writer = new PrintWriter(output, true);
   writer.println("Hello from client!");
   ```
    - The client sets up an `OutputStream` to send data to the server.
    - The `PrintWriter` is used to send text messages (like the `println()` method to print to the console).
    - The client sends the message `"Hello from client!"` to the server.

3. **Receiving a message from the server**:
   ```java
   InputStream input = socket.getInputStream();
   BufferedReader reader = new BufferedReader(new InputStreamReader(input));
   String serverMessage = reader.readLine();
   System.out.println("Server: " + serverMessage);
   ```
    - The client sets up an `InputStream` to receive data from the server.
    - The `BufferedReader` is used to read the server’s response as a line of text.
    - The message from the server is printed using `System.out.println()`.

4. **Handling errors**:
   ```java
   catch (UnknownHostException e) { ... }
   catch (IOException e) { ... }
   ```
    - If something goes wrong, like the server is unreachable or the host is unknown, the client catches and handles these errors. It prints an error message for debugging.

5. **Connection closes**:
    - The `Socket` is automatically closed when the program exits the `try` block (because it's in a "try-with-resources" block), so there's no need to manually close the connection.

### Simple Analogy:
- **Socket connection**: Imagine the client is making a phone call to the server. It dials the server's number (hostname and port).
- **Send message**: The client says, "Hello from client!" (using `PrintWriter` to send the message).
- **Receive message**: The server responds, and the client listens (using `BufferedReader` to read the response).
- **Close connection**: When the conversation is over, the client hangs up the phone.

This simple back-and-forth is how the client communicates with the server.

### server
Let’s break down the **server code** step by step in a simple way:

### 1. `ServerSocket` creation:
```java
ServerSocket serverSocket = new ServerSocket(port);
```
- **What this does**: Think of the server as a person waiting for a phone call. `ServerSocket` is like the phone that the server uses to receive calls (connections). We set it up to listen on a specific "line" (the port number). In this case, the port is `5000`.

### 2. `Accept client connection`:
```java
Socket socket = serverSocket.accept();
```
- **What this does**: This is like picking up the phone when someone calls. The server is waiting for a client (caller) to connect. When the client connects, the server accepts the connection and creates a `Socket`. This `Socket` allows both the server and client to communicate.

### 3. `Streams for communication`:
```java
InputStream input = socket.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
OutputStream output = socket.getOutputStream();
PrintWriter writer = new PrintWriter(output, true);
```
- **What this does**: Once the connection is established, the server needs to send and receive messages. Here, the `InputStream` is like the microphone for receiving what the client says, and the `OutputStream` is like the speaker for sending messages to the client.

### 4. `Read message from the client`:
```java
String clientMessage = reader.readLine();
System.out.println("Client: " + clientMessage);
```
- **What this does**: The server listens to the client's message by reading a line of text using `reader.readLine()`. It then prints the message out, like writing down what the client said.

### 5. `Send response to the client`:
```java
writer.println("Hello from server!");
```
- **What this does**: Now, the server sends a response back to the client using the `PrintWriter`. This is like talking back to the client over the phone.

### 6. `Close the connection`:
```java
socket.close();
```
- **What this does**: After the conversation is done, the server hangs up the phone by closing the `Socket`. This ends the connection between the client and server.

### Summary:
- The server waits for a connection on port `5000`.
- Once a client connects, they can exchange messages.
- The server sends a reply and closes the connection when finished.

It’s like a basic conversation between two people using a phone: one person listens, the other speaks, they exchange messages, and then they hang up.