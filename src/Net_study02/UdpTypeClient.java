package Net_study02;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本類型發送端
 * 1. 使用DatagramSocket指定端口創建接收端
 * 2. 將基本類型轉成位元組
 * 3. 封裝成DatagramPacket包裹，指定目的地
 * 4. 發送包裹send(DatagramPacket p)
 * 5. 釋放資源
 * @author YaoSheng
 *
 */
public class UdpTypeClient {

	public static void main(String[] args) throws Exception {
		System.out.println("發送方啟動中..");
		 // 1. 使用DatagramSocket指定端口創建接收端
		DatagramSocket client = new DatagramSocket(8888);
		 // 2. 準備數據封裝成位元組
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		dos.writeUTF("編碼辛酸淚");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();		
		byte[] datas = baos.toByteArray();		
		 // 3. 封裝成DatagramPacket包裹，指定目的地
		DatagramPacket pocket = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost", 6666));
		 // 4. 發送包裹send(DatagramPacket p)
		client.send(pocket);
		 // 5. 釋放資源
		client.close();
	}

}
