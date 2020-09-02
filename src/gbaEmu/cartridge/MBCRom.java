package gbaEmu.cartridge;

public class MBCRom implements MBC {

	private byte[] rom;
	public byte currentRomBank;
	private byte[] ramBank = new byte[0x8000];
	public byte currentRamBank;
	public boolean enableRam;
	
	@Override
	public byte readRom(int address) {
		return rom[address];
	}

	@Override
	public byte readRomBank(int address) {
		return rom[address];
	}

	@Override
	public byte readRamBank(int address) {
		// ram bank not supported in rom only cartridge
		return 0;
	}

	@Override
	public void writeRamBank(int address, byte data) {
		
	}

	@Override
	public void handleBanking(int address, byte data) {
		
	}

	@Override
	public void saveRam(String fileName) {
		
	}

}
