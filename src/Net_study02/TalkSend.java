package Net_study02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 發送端:封裝
 * 
 * @author YaoSheng
 *
 */
public class TalkSend implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;

	public TalkSend(int port, String toIP, int toProt) {
		this.toIP = toIP;
		this.toPort = toProt;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String data;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				// 3. 封裝成DatagramPacket包裹，指定目的地
				DatagramPacket pocket = new DatagramPacket(datas, 0, datas.length,
						new InetSocketAddress(this.toIP, this.toPort));
				// 4. 發送包裹send(DatagramPacket p)
				client.send(pocket);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 5. 釋放資源
		client.close();
	}
}