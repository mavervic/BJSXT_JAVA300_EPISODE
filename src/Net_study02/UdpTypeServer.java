package Net_study02;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本類型接收端 1. 使用DatagramSocket指定端口創建接收端 2. 準備容器封裝成DatagramPacket包裹 3.
 * 阻塞式接收包裹receive(DatagramPacket p) 4. 分析數據 將位元組還原成對應的類型 byte[] getData()
 * getLength() 5. 釋放資源
 * 
 * @author YaoSheng
 *
 */
public class UdpTypeServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收方等待接收...");
		// 1. 使用DatagramSocket指定端口創建接收端
		DatagramSocket server = new DatagramSocket(6666);
		// 2. 準備容器封裝成DatagramPacket包裹
		byte[] container = new byte[1024 * 60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 3. 阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);
		// 4. 分析數據 將位元組還原成對應的類型
		// byte[] getData()
		// getLength()		
		byte[] datas = packet.getData();
		int len = packet.getLength();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();		
		System.out.println(flag);
		// 5. 釋放資源
		server.close();
	}

}
