package gbaEmu.cartridge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface MBC {
	public byte readRom(int address);
	public byte readRomBank(int address);
	public byte readRamBank(int address);
	public void writeRamBank(int address, byte data);
	public void handleBanking(int address, byte data);
	public void saveRam(String fileName);
	
	default byte[] readRomFile(String romPath) throws IOException {
		return readDataFile(romPath, false);
	}

	default byte[] readDataFile(String path, boolean ram) throws IOException {
		byte[] fileContent = Files.readAllBytes(Paths.get(path));
		return fileContent;
	}
}
