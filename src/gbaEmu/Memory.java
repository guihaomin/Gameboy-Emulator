package gbaEmu;

public class Memory {
	byte[] mainMemory;
	CPU cpu;
	public Memory() {
		mainMemory = new byte[0x10000];
	}
	public byte readMemory(int address) {
		return mainMemory[address];
	}
	public int writeMemory(int address, byte value) {
		mainMemory[address] = value;
		return 0;
	}
	// 16 bit stack push
	public int stackPush(short value) {
		cpu.register.sp--;
		writeMemory(cpu.register.sp, (byte) (value >> 8));
		cpu.register.sp--;
		writeMemory(cpu.register.sp, (byte) (value & 0xFF));
		return 0;
	}
	//16 bit stack pop
	public short stackPop() {
		cpu.register.sp++;
		int low = readMemory(cpu.register.sp);
		cpu.register.sp++;
		int high = readMemory(cpu.register.sp);
		return (short) (high << 8 | low);
	}
}
