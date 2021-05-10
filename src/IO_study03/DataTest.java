package IO_study03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * DataInputStream DataOutputStream
 * 
 * @author YaoSheng
 *
 */
public class DataTest {

	public static void main(String[] args) throws IOException {
		// 寫出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));

		// 操作數據類型
		dos.writeUTF("UTF-8");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();

		byte[] datas = baos.toByteArray();
		System.out.println(datas.length);
		// 讀取
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		// 與寫入順序一致
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println();
	}

}
