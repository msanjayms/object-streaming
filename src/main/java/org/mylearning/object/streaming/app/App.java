package org.mylearning.object.streaming.app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.mylearning.data.Person;

public class App {

	public static void main(String[] args) {
		Socket sock = null;
		try {
			InetAddress host = InetAddress.getLocalHost();
			sock = new Socket(host.getHostAddress(), 9990);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (ConnectException cE) {
			System.out.println(cE.getMessage());
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Person person = new Person("Sanjay", "Sathyanarayana", 1234567890L);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(person);
			oos.flush();

			byte[] byteArray = bos.toByteArray();
			System.out.println(byteArray.length);
			OutputStream os = sock.getOutputStream();
			os.write(byteArray);
			
			 /*bjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			 Object readObject = ois.readObject();
			 
			 System.out.println(readObject);*/
			 
//			 ois.close();
			 os.close();
			 oos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
