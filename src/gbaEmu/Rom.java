package gbaEmu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Rom {
	byte[] content;
	public byte[] readRom(String filename) {
		try (InputStream inputStream = new FileInputStream(filename);) {
			content = inputStream.readAllBytes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	public String getTitle() {
		String titleString;
		if (content.length == 0 ) {
			return "NULL";
		} else {
			byte[] title = Arrays.copyOfRange(content, 0x134, 0x143);
			titleString = new String(title, Charset.defaultCharset());
		}
		return titleString;
	}
}
