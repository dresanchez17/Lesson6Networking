import java.io.*;
import java.net.*;

/**
 * This program demonstrates the InetAddress class. Supply a host name as command-line argument,
 * or run without command-line arguments to see the address of the local host.
 * @author asanchez
 *
 */
public class InetAddressTest {
	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			String host = args[0];
			//gets an array of addresses
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses) {
				System.out.println(a);
			}
		}
		else {
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
