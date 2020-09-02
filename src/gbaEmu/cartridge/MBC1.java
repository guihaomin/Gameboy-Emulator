package gbaEmu.cartridge;

public class MBC1 implements MBC {
	private byte[] rom;
	public byte currentRomBank;
	private byte[] ramBank;
	public byte currentRamBank;
	public boolean enableRam;
	boolean is168Mode;
	@Override
	public byte readRom(int address) {
		return rom[address];
	}
	@Override
	public byte readRomBank(int address) {
		int newAddress = address - 0x4000;
		return rom[newAddress + currentRomBank * 0x4000];
	}
	@Override
	public byte readRamBank(int address) {
		int newAddress = address - 0xA000;
		return ramBank[newAddress + currentRamBank * 0x2000];
	}
	@Override
	public void writeRamBank(int address, byte data) {
		if (enableRam) {
			int newAddress = address - 0xA000;
			ramBank[newAddress + currentRamBank * 0x2000] = data;
		}
	}
	@Override
	public void handleBanking(int address, byte data) {
		if (address < 0x2000) {
			doRamEnable(address, data);
		} else if (address >= 0x2000 && address < 0x4000) {
			doChangeLowRomBank(data);
		} else if (address >= 0x4000 && address < 0x6000) {
			if (is168Mode) {
				doChangeHighRomBank(data);
			} else {
				doChangeRamBank(data);
			}
		} else if (address >= 0x6000 && address < 0x8000) {
			doChangeRomRamMode(data);
		}
		
	}
	private void doChangeRomRamMode(byte data) {
		byte newData = (byte) (data & 0x1);
		if (newData == 0) {
			is168Mode = true;
		} else {
			is168Mode = false;
		}
		if (is168Mode) {
			currentRamBank = 0;
		}
	}
	@Override
	public void saveRam(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	private void doRamEnable(int address, byte value) {
		byte testData = (byte) (value & 0xF);
		if (testData == 0xA) {
			enableRam = true;
		} else {
			enableRam = false;
		}
	}

	private void doChangeLowRomBank(byte value) {
		byte lower5 = (byte) (value & 31);
		currentRomBank &= 224;
		currentRomBank |= lower5;
		if (currentRomBank == 0) {
			currentRomBank++;
		}
	}

	private void doChangeHighRomBank(byte value) {
		currentRomBank &= 31;
		value &= 0b11 << 5;
		currentRomBank |= value;
		if (currentRomBank == 0) {
			currentRomBank++;
		}
	}
	
	private void doChangeRamBank(byte value) {
		currentRamBank = (byte) (value & 0x3);
	}
	
}
