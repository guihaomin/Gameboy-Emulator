package gbaEmu;

import java.util.HashMap;
import java.util.Map;

public class CPU {
	Register register;
	Memory memory;
	Map<Integer, Runnable> opMap = new HashMap<>();
	Map<Integer, Integer> opCycles = new HashMap<>();
	public CPU(Memory memory) {
		this.memory = memory;
	}
	public byte getValue8() {
		byte ans = memory.readMemory(register.pc);
		register.pc++;
		return ans;
	}
	public int getValue16() {
		int value1 = memory.readMemory(register.pc);
		int value2 = memory.readMemory(register.pc + 1);
		register.pc += 2;
		return value1 << 8 + value2;
	}
	public int decrementHL() {
		int hl = register.hl();
		hl--;
		register.h = (byte) (hl >> 8);
		register.l = (byte) (hl & 255);
		return 0;
	}
	public int incrementHL() {
		int hl = register.hl();
		hl++;
		register.h = (byte) (hl >> 8);
		register.l = (byte) (hl & 255);
		return 0;
	}
	public int putBC(int value) {
		register.b = (byte) (value >> 8);
		register.c = (byte) (value & 255);
		return 0;
	}
	public int putDE(int value) {
		register.d = (byte) (value >> 8);
		register.e = (byte) (value & 255);
		return 0;
	}
	public int putHL(int value) {
		register.h = (byte) (value >> 8);
		register.l = (byte) (value & 255);
		return 0;
	}
	public int putSP(int value) {
		register.sp = (short) value;
		return 0;
	}
	public int putAF(int value) {
		register.a = (byte) (value >> 8);
		register.f = (byte) (value & 255);
		return 0;
	}
}
