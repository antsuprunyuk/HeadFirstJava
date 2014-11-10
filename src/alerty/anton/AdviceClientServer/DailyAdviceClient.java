package alerty.anton.AdviceClientServer;
import java.net.*;
import java.io.*;

public class DailyAdviceClient {

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
	
	public void go() {
		try {
			Socket socket = new Socket("192.168.0.1", 4242);
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String advice = reader.readLine();
			System.out.println("You really need this: " + advice);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
