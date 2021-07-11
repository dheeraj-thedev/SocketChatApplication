package com.careerera.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientProgram {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9667);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println(bufferedReader.readLine());
			bufferedReader.close();
			socket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
