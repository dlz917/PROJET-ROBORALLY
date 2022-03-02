import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverSocket {
	
	private static final int port = 3333;
	private ServerSocket serverSocket = null;
	private Socket socketEnd1;
	private InputStream  input = null;
	private OutputStream output = null;
	public socketServer() {
		try {
			System.out.println("server started...");
		serverSocket = new ServerSocket (port);
		}catch(Exception exp) {}
	}
	
public void accepterConnexion() {
	try {
	System.out.println("attente de demande...");
	socketEnd1=serverSocket.accept();
	System.out.println("Connexion établie...");
	input = socketEnd1.getInputStream();
	output = socketEnd1.getOutputStream();
	}catch(Exception exp) {}
}

public void sendInfosTest() {
	try {
		ObjectOutputStream os = new ObjectOutputStream(output);
		ArrayList<String> listeTest = new ArrayList<String> ();
		listeTest.add("a");
		listeTest.add("b");
		objetTest test = new objetTest("Anna",19,listeTest);
		System.out.println(test.getNom());
		os.writeObject(test);
		os.flush();
		os.close();
		
	}catch(Exception exp) {System.out.println(exp);}
}

public static void main(String[]args) {
	try {
	InetAddress adresse = InetAddress.getLocalHost();
	System.out.println(adresse.getHostAddress());
	
	socketServer server = new socketServer();
	server.accepterConnexion();
	server.sendInfosTest();
	}catch(Exception exp) {}
}
//timeout : pour faire attendre le serveur (attente de connexion par ex)

}
