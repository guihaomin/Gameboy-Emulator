package gbaEmu;

import java.util.HashMap;
import java.util.Map;

public class CPU {
	Register register;
	boolean globalInterrupt;
	Memory memory;
	Opcodes opcodes;
	Map<Integer, Runnable> opMap;
	Map<Integer, Integer> opCycles;
	public CPU(Memory memory) {
		this.memory = memory;
		this.register = new Register();
	}
	public int initOpcodes() {
		opcodes = new Opcodes();
		opMap = new HashMap<>();
		opCycles = new HashMap<>();
		opMap.put(0x7F, () -> opcodes.OP7F());
		opCycles.put(0x7F, 4);
		for (int i = 0x78; i <= 0x7D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x78, () -> opcodes.OP78());
		opMap.put(0x79, () -> opcodes.OP79());
		opMap.put(0x7A, () -> opcodes.OP7A());
		opMap.put(0x7B, () -> opcodes.OP7B());
		opMap.put(0x7C, () -> opcodes.OP7C());
		opMap.put(0x7D, () -> opcodes.OP7D());
		opMap.put(0x7E, () -> opcodes.OP7E());
		opCycles.put(0x7E, 8);
		for (int i = 0x40; i <= 0x45; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x40, () -> opcodes.OP40());
		opMap.put(0x41, () -> opcodes.OP41());
		opMap.put(0x42, () -> opcodes.OP42());
		opMap.put(0x43, () -> opcodes.OP43());
		opMap.put(0x44, () -> opcodes.OP44());
		opMap.put(0x45, () -> opcodes.OP45());
		opMap.put(0x46, () -> opcodes.OP46());
		opCycles.put(0x46, 8);
		for (int i = 0x48; i <= 0x4D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x48, () -> opcodes.OP48());
		opMap.put(0x49, () -> opcodes.OP49());
		opMap.put(0x4A, () -> opcodes.OP4A());
		opMap.put(0x4B, () -> opcodes.OP4B());
		opMap.put(0x4C, () -> opcodes.OP4C());
		opMap.put(0x4D, () -> opcodes.OP4D());
		opMap.put(0x4E, () -> opcodes.OP4E());
		opCycles.put(0x4E, 8);
		for (int i = 0x50; i <= 0x55; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x50, () -> opcodes.OP50());
		opMap.put(0x51, () -> opcodes.OP51());
		opMap.put(0x52, () -> opcodes.OP52());
		opMap.put(0x53, () -> opcodes.OP53());
		opMap.put(0x54, () -> opcodes.OP54());
		opMap.put(0x55, () -> opcodes.OP55());
		opMap.put(0x56, () -> opcodes.OP56());
		opCycles.put(0x56, 8);
		for (int i = 0x58; i <= 0x5D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x58, () -> opcodes.OP58());
		opMap.put(0x59, () -> opcodes.OP59());
		opMap.put(0x5A, () -> opcodes.OP5A());
		opMap.put(0x5B, () -> opcodes.OP5B());
		opMap.put(0x5C, () -> opcodes.OP5C());
		opMap.put(0x5D, () -> opcodes.OP5D());
		opMap.put(0x5E, () -> opcodes.OP5E());
		opCycles.put(0x5E, 8);
		for (int i = 0x60; i <= 0x65; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x60, () -> opcodes.OP60());
		opMap.put(0x61, () -> opcodes.OP61());
		opMap.put(0x62, () -> opcodes.OP62());
		opMap.put(0x63, () -> opcodes.OP63());
		opMap.put(0x64, () -> opcodes.OP64());
		opMap.put(0x65, () -> opcodes.OP65());
		opMap.put(0x66, () -> opcodes.OP66());
		opCycles.put(0x66, 8);
		for (int i = 0x68; i <= 0x6D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x68, () -> opcodes.OP68());
		opMap.put(0x69, () -> opcodes.OP69());
		opMap.put(0x6A, () -> opcodes.OP6A());
		opMap.put(0x6B, () -> opcodes.OP6B());
		opMap.put(0x6C, () -> opcodes.OP6C());
		opMap.put(0x6D, () -> opcodes.OP6D());
		opMap.put(0x6E, () -> opcodes.OP6E());
		opCycles.put(0x6E, 8);
		for (int i = 0x70; i <= 0x75; i++) {
			opCycles.put(i, 8);
		}
		opMap.put(0x70, () -> opcodes.OP70());
		opMap.put(0x71, () -> opcodes.OP71());
		opMap.put(0x72, () -> opcodes.OP72());
		opMap.put(0x73, () -> opcodes.OP73());
		opMap.put(0x74, () -> opcodes.OP74());
		opMap.put(0x75, () -> opcodes.OP75());
		opCycles.put(0x36, 12);
		opMap.put(0x36, () -> opcodes.OP36());
		opMap.put(0x0A, () -> opcodes.OP0A());
		opCycles.put(0x0A, 8);
		opMap.put(0x1A, () -> opcodes.OP1A());
		opCycles.put(0x1A, 8);
		opMap.put(0x7E, () -> opcodes.OP7E());
		opCycles.put(0x7E, 8);
		opMap.put(0xFA, () -> opcodes.OPFA());
		opCycles.put(0xFA, 16);
		opMap.put(0x3E, () -> opcodes.OP3E());
		opCycles.put(0x3E, 8);
		opMap.put(0x47, () -> opcodes.OP47());
		opCycles.put(0x47, 4);
		opMap.put(0x4F, () -> opcodes.OP4F());
		opCycles.put(0x4F, 4);
		opMap.put(0x57, () -> opcodes.OP57());
		opCycles.put(0x57, 4);
		opMap.put(0x5F, () -> opcodes.OP5F());
		opCycles.put(0x5F, 4);
		opMap.put(0x67, () -> opcodes.OP67());
		opCycles.put(0x67, 4);
		opMap.put(0x6F, () -> opcodes.OP6F());
		opCycles.put(0x6F, 4);
		opMap.put(0x02, () -> opcodes.OP02());
		opCycles.put(0x02, 8);
		opMap.put(0x12, () -> opcodes.OP12());
		opCycles.put(0x12, 8);
		opMap.put(0x77, () -> opcodes.OP77());
		opCycles.put(0x77, 8);
		opMap.put(0xEA, () -> opcodes.OPEA());
		opCycles.put(0xEA, 16);
		opMap.put(0xF2, () -> opcodes.OPF2());
		opCycles.put(0xF2, 8);
		opMap.put(0xE2, () -> opcodes.OPE2());
		opCycles.put(0xE2, 8);
		opMap.put(0x3A, () -> opcodes.OP3A());
		opCycles.put(0x3A, 8);
		opMap.put(0x32, () -> opcodes.OP32());
		opCycles.put(0x32, 8);
		opMap.put(0x2A, () -> opcodes.OP2A());
		opCycles.put(0x2A, 8);
		opMap.put(0x22, () -> opcodes.OP22());
		opCycles.put(0x22, 8);
		opMap.put(0xE0, () -> opcodes.OPE0());
		opCycles.put(0xE0, 12);
		opMap.put(0xF0, () -> opcodes.OPF0());
		opCycles.put(0xF0, 12);
		opMap.put(0x01, () -> opcodes.OP01());
		opCycles.put(0x01, 12);
		opMap.put(0x11, () -> opcodes.OP11());
		opCycles.put(0x11, 12);
		opMap.put(0x21, () -> opcodes.OP21());
		opCycles.put(0x21, 12);
		opMap.put(0x31, () -> opcodes.OP31());
		opCycles.put(0x31, 12);
		opMap.put(0xF9, () -> opcodes.OPF9());
		opCycles.put(0xF9, 8);
		opMap.put(0xF8, () -> opcodes.OPF8());
		opCycles.put(0xF8, 12);
		opMap.put(0x08, () -> opcodes.OP08());
		opCycles.put(0x08, 20);
		opMap.put(0xF5, () -> opcodes.OPF5());
		opCycles.put(0xF5, 16);
		opMap.put(0xC5, () -> opcodes.OPC5());
		opCycles.put(0xC5, 16);
		opMap.put(0xD5, () -> opcodes.OPD5());
		opCycles.put(0xD5, 16);
		opMap.put(0xE5, () -> opcodes.OPE5());
		opCycles.put(0xE5, 16);
		opMap.put(0xF1, () -> opcodes.OPF1());
		opCycles.put(0xF1, 12);
		opMap.put(0xC1, () -> opcodes.OPC1());
		opCycles.put(0xC1, 12);
		opMap.put(0xD1, () -> opcodes.OPD1());
		opCycles.put(0xD1, 12);
		opMap.put(0xE1, () -> opcodes.OPE1());
		opCycles.put(0xE1, 12);
		opMap.put(0x87, () -> opcodes.OP87());
		opCycles.put(0x87, 4);
		for (int i = 0x80; i <= 0x85; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x80, () -> opcodes.OP80());
		opMap.put(0x81, () -> opcodes.OP81());
		opMap.put(0x82, () -> opcodes.OP82());
		opMap.put(0x83, () -> opcodes.OP83());
		opMap.put(0x84, () -> opcodes.OP84());
		opMap.put(0x85, () -> opcodes.OP85());
		opMap.put(0x86, () -> opcodes.OP86());
		opCycles.put(0x86, 8);
		opMap.put(0xC6, () -> opcodes.OPC6());
		opCycles.put(0xC6, 8);
		opMap.put(0x8F, () -> opcodes.OP8F());
		opCycles.put(0x8F, 4);
		for (int i = 0x88; i <= 0x8D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x88, () -> opcodes.OP88());
		opMap.put(0x89, () -> opcodes.OP89());
		opMap.put(0x8A, () -> opcodes.OP8A());
		opMap.put(0x8B, () -> opcodes.OP8B());
		opMap.put(0x8C, () -> opcodes.OP8C());
		opMap.put(0x8D, () -> opcodes.OP8D());
		opMap.put(0x8E, () -> opcodes.OP8E());
		opCycles.put(0x8E, 8);
		opMap.put(0xCE, () -> opcodes.OPCE());
		opCycles.put(0xCE, 8);
		opMap.put(0x97, () -> opcodes.OP97());
		opCycles.put(0x97, 4);
		for (int i = 0x90; i <= 0x95; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x90, () -> opcodes.OP90());
		opMap.put(0x91, () -> opcodes.OP91());
		opMap.put(0x92, () -> opcodes.OP92());
		opMap.put(0x93, () -> opcodes.OP93());
		opMap.put(0x94, () -> opcodes.OP94());
		opMap.put(0x95, () -> opcodes.OP95());
		opMap.put(0x96, () -> opcodes.OP96());
		opCycles.put(0x96, 8);
		opMap.put(0xD6, () -> opcodes.OPD6());
		opCycles.put(0xD6, 8);
		opMap.put(0x9F, () -> opcodes.OP9F());
		opCycles.put(0x9F, 4);
		for (int i = 0x98; i <= 0x9D; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0x98, () -> opcodes.OP98());
		opMap.put(0x99, () -> opcodes.OP99());
		opMap.put(0x9A, () -> opcodes.OP9A());
		opMap.put(0x9B, () -> opcodes.OP9B());
		opMap.put(0x9C, () -> opcodes.OP9C());
		opMap.put(0x9D, () -> opcodes.OP9D());
		opMap.put(0x9E, () -> opcodes.OP9E());
		opCycles.put(0x9E, 8);
		opMap.put(0xDE, () -> opcodes.OPDE());
		opCycles.put(0xDE, 8);
		opMap.put(0xA7, () -> opcodes.OPA7());
		opCycles.put(0xA7, 4);
		for (int i = 0xA0; i <= 0xA5; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0xA0, () -> opcodes.OPA0());
		opMap.put(0xA1, () -> opcodes.OPA1());
		opMap.put(0xA2, () -> opcodes.OPA2());
		opMap.put(0xA3, () -> opcodes.OPA3());
		opMap.put(0xA4, () -> opcodes.OPA4());
		opMap.put(0xA5, () -> opcodes.OPA5());
		opMap.put(0xA6, () -> opcodes.OPA6());
		opCycles.put(0xA6, 8);
		opMap.put(0xE6, () -> opcodes.OPE6());
		opCycles.put(0xE6, 8);
		opMap.put(0xB7, () -> opcodes.OPB7());
		opCycles.put(0xB7, 4);
		for (int i = 0xB0; i <= 0xB5; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0xB0, () -> opcodes.OPB0());
		opMap.put(0xB1, () -> opcodes.OPB1());
		opMap.put(0xB2, () -> opcodes.OPB2());
		opMap.put(0xB3, () -> opcodes.OPB3());
		opMap.put(0xB4, () -> opcodes.OPB4());
		opMap.put(0xB5, () -> opcodes.OPB5());
		opMap.put(0xB6, () -> opcodes.OPB6());
		opCycles.put(0xB6, 8);
		opMap.put(0xF6, () -> opcodes.OPF6());
		opCycles.put(0xF6, 8);
		opMap.put(0xAF, () -> opcodes.OPAF());
		opCycles.put(0xAF, 4);
		for (int i = 0xA8; i <= 0xAD; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0xA8, () -> opcodes.OPA8());
		opMap.put(0xA9, () -> opcodes.OPA9());
		opMap.put(0xAA, () -> opcodes.OPAA());
		opMap.put(0xAB, () -> opcodes.OPAB());
		opMap.put(0xAC, () -> opcodes.OPAC());
		opMap.put(0xAD, () -> opcodes.OPAD());
		opMap.put(0xAE, () -> opcodes.OPAE());
		opCycles.put(0xAE, 8);
		opMap.put(0xEE, () -> opcodes.OPEE());
		opCycles.put(0xEE, 8);
		opMap.put(0xBF, () -> opcodes.OPBF());
		opCycles.put(0xBF, 4);
		for (int i = 0xB8; i <= 0xBD; i++) {
			opCycles.put(i, 4);
		}
		opMap.put(0xB8, () -> opcodes.OPB8());
		opMap.put(0xB9, () -> opcodes.OPB9());
		opMap.put(0xBA, () -> opcodes.OPBA());
		opMap.put(0xBB, () -> opcodes.OPBB());
		opMap.put(0xBC, () -> opcodes.OPBC());
		opMap.put(0xBD, () -> opcodes.OPBD());
		opMap.put(0xBE, () -> opcodes.OPBE());
		opCycles.put(0xBE, 8);
		opMap.put(0xFE, () -> opcodes.OPFE());
		opCycles.put(0xFE, 8);
		opMap.put(0x3C, () -> opcodes.OP3C());
		opCycles.put(0x3C, 4);
		opMap.put(0x04, () -> opcodes.OP04());
		opCycles.put(0x04, 4);
		opMap.put(0x0C, () -> opcodes.OP0C());
		opCycles.put(0x0C, 4);
		opMap.put(0x14, () -> opcodes.OP14());
		opCycles.put(0x14, 4);
		opMap.put(0x1C, () -> opcodes.OP1C());
		opCycles.put(0x1C, 4);
		opMap.put(0x24, () -> opcodes.OP24());
		opCycles.put(0x24, 4);
		opMap.put(0x2C, () -> opcodes.OP2C());
		opCycles.put(0x2C, 4);
		opMap.put(0x34, () -> opcodes.OP34());
		opCycles.put(0x34, 12);
		opMap.put(0x3D, () -> opcodes.OP3D());
		opCycles.put(0x3D, 4);
		opMap.put(0x05, () -> opcodes.OP05());
		opCycles.put(0x05, 4);
		opMap.put(0x0D, () -> opcodes.OP0D());
		opCycles.put(0x0D, 4);
		opMap.put(0x15, () -> opcodes.OP15());
		opCycles.put(0x15, 4);
		opMap.put(0x1D, () -> opcodes.OP1D());
		opCycles.put(0x1D, 4);
		opMap.put(0x25, () -> opcodes.OP25());
		opCycles.put(0x25, 4);
		opMap.put(0x2D, () -> opcodes.OP2D());
		opCycles.put(0x2D, 4);
		opMap.put(0x35, () -> opcodes.OP35());
		opCycles.put(0x35, 12);
		return 0;
	}
	public int initCPU() {
		register.zf = true;
		register.nf = false;
		register.cf = true;
		register.hf = true;
		globalInterrupt = false;
		register.a = 0x01;
		register.b = 0x00;
		register.c = 0x13;
		register.d = 0x00;
		register.e = (byte) 0xD8;
		register.f = (byte) 0xB0;
		putHL(0x014D);
		register.pc = 0x0100;
		putSP(0xFFFE);
		return 0;
	}
	public byte getValue8() {
		byte ans = memory.readMemory(register.pc);
		register.pc++;
		return ans;
	}
	public short getValue16() {
		int value1 = memory.readMemory(register.pc);
		int value2 = memory.readMemory(register.pc + 1);
		register.pc += 2;
		return (short) (value1 << 8 + value2);
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
