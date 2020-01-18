package gbaEmu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Rom rom = new Rom();
		rom.readRom("/home/haomin/Downloads/pr.gb");
		System.out.println(rom.getTitle());
		
	}
}
