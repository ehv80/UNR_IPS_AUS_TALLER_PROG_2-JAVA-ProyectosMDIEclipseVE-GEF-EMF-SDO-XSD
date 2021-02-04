package mdi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ThreadServidor extends Thread {
	Socket socket = null;
	ServerSocket servidor;
	JComboBox mensajesRecibidos;
	
	ThreadServidor(ServerSocket s, JComboBox j){
		servidor = s;
		mensajesRecibidos = j;
	}
	
	public void run () {
		while(true) {
			try {
				socket = servidor.accept();
				BufferedReader lectura;
				lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				mensajesRecibidos.addItem(lectura.readLine());
			} catch (IOException e) {
				return;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"El puerto debe ser un número");
			}
			
			
		}
	}
}
