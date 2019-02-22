package org.mylearning.object.streaming.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.mylearning.data.Person;

public class ListeningApp {

	public static void main(String[] args) {
		try {
			ServerSocket serverSock = new ServerSocket(9990);
			InetAddress host = InetAddress.getLocalHost();
			Socket accept = serverSock.accept();
			byte[] b = new byte[255];

			int read = accept.getInputStream().read(b);
			System.out.println(read);
			while (read != -1) {
				read = accept.getInputStream().read(b);
				System.out.println(read);
			}

			/*
			 * ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
			 * oos.writeObject("I read my first MSG"); Thread.sleep(5000);
			 */

			Person person = deSerialize(b);
			System.out.println(person);

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ConnectException cE) {
			System.out.println(cE.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Person deSerialize(byte[] b) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(b);
		ObjectInputStream ois;
		ois = new ObjectInputStream(bis);
		Person person = (Person) ois.readObject();
		return person;
	}
}
