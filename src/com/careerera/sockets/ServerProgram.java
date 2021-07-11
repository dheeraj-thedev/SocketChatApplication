package com.careerera.sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9667);

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

		while (true) {
			try {
				Socket socket = serverSocket.accept();
				OutputStream outputStream = socket.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
				bufferedWriter.write("Hello All Nodes I am listening via LANs !!! \n");

				bufferedWriter.close();
				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
