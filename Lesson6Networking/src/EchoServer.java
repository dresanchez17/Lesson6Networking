import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		// Create server socket
		int port = 8189;
		System.out.println("Server running on port: " +  port);
		try(ServerSocket s = new ServerSocket(port)){
			// wait for client
			System.out.println("Waiting for connection...");
			try(Socket incoming = s.accept()){
				System.out.println("Connected");
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				try (Scanner in = new Scanner(inStream, "UTF-8")){
					PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"),
							true); // autoFlush
					out.println("Hello! Enter BYE to exit.");
					
					//exit client input
					boolean done = false;
					while (!done && in.hasNextLine()) {
						String line = in.nextLine();
						out.print("Echo: " + line);
						if (line.trim().equals("BYE")) done = true;
					}
				}
			}
		}
	}
}
