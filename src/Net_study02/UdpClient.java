package Net_study02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 發送端
 * 1. 使用DatagramSocket指定端口創建接收端
 * 2. 準備數據封裝成位元組
 * 3. 封裝成DatagramPacket包裹，指定目的地
 * 4. 發送包裹send(DatagramPacket p)
 * 5. 釋放資源
 * @author YaoSheng
 *
 */
public class UdpClient {

	public static void main(String[] args) throws Exception {
		System.out.println("發送方啟動中..");
		 // 1. 使用DatagramSocket指定端口創建接收端
		DatagramSocket client = new DatagramSocket(8888);
		 // 2. 準備數據封裝成位元組
		String msg = "上海上學堂";
		byte[] datas = msg.getBytes();
		 // 3. 封裝成DatagramPacket包裹，指定目的地
		DatagramPacket pocket = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost", 6666));
		 // 4. 發送包裹send(DatagramPacket p)
		client.send(pocket);
		 // 5. 釋放資源
		client.close();
	}

}
