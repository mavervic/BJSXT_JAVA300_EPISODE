package IO_study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConvertTest02 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new URL("https://www.google.com.tw/").openStream(), "UTF-8"));
			{
				String msg;
				while ((msg = reader.readLine()) != null) {
					System.out.println(msg);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
