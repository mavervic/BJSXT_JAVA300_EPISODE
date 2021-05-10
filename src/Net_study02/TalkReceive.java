package Net_study02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端:封裝
 * 
 * @author YaoSheng
 *
 */
public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String from;

	public TalkReceive(String from, int port) {
		this.from = from;
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			byte[] container = new byte[1024 * 60];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);

			try {
				// 3. 阻塞式接收包裹receive(DatagramPacket p)
				server.receive(packet);
				// 4. 分析數據
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String data = new String(datas, 0, len);
				System.out.println(from + ": " + data);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		// 5. 釋放資源
		server.close();
	}
}