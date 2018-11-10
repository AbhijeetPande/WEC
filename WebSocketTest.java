package WEC;

import java.io.IOException;
import javax.websocket.*;


public class WebSocketTest {
	public static void main(String[] args) {
		
	}

	public void onMessage(String message, Session session) throws IOException,
			InterruptedException {
		
		session.getBasicRemote().sendText("Hello, " + message);
	}


	public void onOpen() {
		System.out.println("Client connected");
	}

	public void onClose() {
		System.out.println("Connection closed");
	}
}
