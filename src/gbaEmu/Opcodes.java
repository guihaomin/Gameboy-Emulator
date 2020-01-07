package gbaEmu;

public class Opcodes {
	CPU cpu;
	Memory memory;
	public int OP7F() {
		cpu.register.a = cpu.register.a;
		return 0;
	}
	public int OP78() {
		cpu.register.a = cpu.register.b;
		return 0;
	}
	public int OP79() {
		cpu.register.a = cpu.register.c;
		return 0;
	}
	public int OP7A() {
		cpu.register.a = cpu.register.d;
		return 0;
	}
	public int OP7B() {
		cpu.register.a = cpu.register.e;
		return 0;
	}
	public int OP7C() {
		cpu.register.a = cpu.register.h;
		return 0;
	}
	public int OP7D() {
		cpu.register.a = cpu.register.l;
		return 0;
	}
	public int OP7E() {
		cpu.register.a = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP40() {
		cpu.register.b = cpu.register.b;
		return 0;
	}
	public int OP41() {
		cpu.register.b = cpu.register.c;
		return 0;
	}
	public int OP42() {
		cpu.register.b = cpu.register.d;
		return 0;
	}
	public int OP43() {
		cpu.register.b = cpu.register.e;
		return 0;
	}
	public int OP44() {
		cpu.register.b = cpu.register.h;
		return 0;
	}
	public int OP45() {
		cpu.register.b = cpu.register.l;
		return 0;
	}
	public int OP46() {
		cpu.register.b = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP48() {
		cpu.register.c = cpu.register.b;
		return 0;
	}
	public int OP49() {
		cpu.register.c = cpu.register.c;
		return 0;
	}
	public int OP4A() {
		cpu.register.c = cpu.register.d;
		return 0;
	}
	public int OP4B() {
		cpu.register.c = cpu.register.e;
		return 0;
	}
	public int OP4C() {
		cpu.register.c = cpu.register.h;
		return 0;
	}
	public int OP4D() {
		cpu.register.c = cpu.register.l;
		return 0;
	}
	public int OP4E() {
		cpu.register.c = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP50() {
		cpu.register.d = cpu.register.b;
		return 0;
	}
	public int OP51() {
		cpu.register.d = cpu.register.c;
		return 0;
	}
	public int OP52() {
		cpu.register.d = cpu.register.d;
		return 0;
	}
	public int OP53() {
		cpu.register.d = cpu.register.e;
		return 0;
	}
	public int OP54() {
		cpu.register.d = cpu.register.h;
		return 0;
	}
	public int OP55() {
		cpu.register.d = cpu.register.l;
		return 0;
	}
	public int OP56() {
		cpu.register.d = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP58() {
		cpu.register.e = cpu.register.b;
		return 0;
	}
	public int OP59() {
		cpu.register.e = cpu.register.c;
		return 0;
	}
	public int OP5A() {
		cpu.register.e = cpu.register.d;
		return 0;
	}
	public int OP5B() {
		cpu.register.e = cpu.register.e;
		return 0;
	}
	public int OP5C() {
		cpu.register.e = cpu.register.h;
		return 0;
	}
	public int OP5D() {
		cpu.register.e = cpu.register.l;
		return 0;
	}
	public int OP5E() {
		cpu.register.e = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP60() {
		cpu.register.h = cpu.register.b;
		return 0;
	}
	public int OP61() {
		cpu.register.h = cpu.register.c;
		return 0;
	}
	public int OP62() {
		cpu.register.h = cpu.register.d;
		return 0;
	}
	public int OP63() {
		cpu.register.h = cpu.register.e;
		return 0;
	}
	public int OP64() {
		cpu.register.h = cpu.register.h;
		return 0;
	}
	public int OP65() {
		cpu.register.h = cpu.register.l;
		return 0;
	}
	public int OP66() {
		cpu.register.h = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP68() {
		cpu.register.l = cpu.register.b;
		return 0;
	}
	public int OP69() {
		cpu.register.l = cpu.register.c;
		return 0;
	}
	public int OP6A() {
		cpu.register.l = cpu.register.d;
		return 0;
	}
	public int OP6B() {
		cpu.register.l = cpu.register.e;
		return 0;
	}
	public int OP6C() {
		cpu.register.l = cpu.register.h;
		return 0;
	}
	public int OP6D() {
		cpu.register.l = cpu.register.l;
		return 0;
	}
	public int OP6E() {
		cpu.register.l = memory.readMemory(cpu.register.hl());
		return 0;
	}
	public int OP70() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.b);
		return 0;
	}
	public int OP71() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.c);
		return 0;
	}
	public int OP72() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.d);
		return 0;
	}
	public int OP73() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.e);
		return 0;
	}
	public int OP74() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.h);
		return 0;
	}
	public int OP75() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.l);
		return 0;
	}
	public int OP36() {
		memory.writeMemory(cpu.register.hl(), cpu.getValue8());
		return 0;
	}
	public int OP06() {
		cpu.register.b = cpu.getValue8();
		return 0;
	}
	public int OP0E() {
		cpu.register.c = cpu.getValue8();
		return 0;
	}
	public int OP16() {
		cpu.register.d = cpu.getValue8();
		return 0;
	}
	public int OP1E() {
		cpu.register.e = cpu.getValue8();
		return 0;
	}
	public int OP26() {
		cpu.register.h = cpu.getValue8();
		return 0;
	}
	public int OP2E() {
		cpu.register.l = cpu.getValue8();
		return 0;
	}
	public int OP0A() {
		cpu.register.a = memory.readMemory(cpu.register.bc());
		return 0;
	}
	public int OP1A() {
		cpu.register.a = memory.readMemory(cpu.register.de());
		return 0;
	}
	public int OPFA() {
		cpu.register.a = memory.readMemory(cpu.getValue16());
		return 0;
	}
	public int OP3E() {
		cpu.register.a = cpu.getValue8();
		return 0;
	}
	public int OP47() {
		cpu.register.b = cpu.register.a;
		return 0;
	}
	public int OP4F() {
		cpu.register.c = cpu.register.a;
		return 0;
	}
	public int OP57() {
		cpu.register.d = cpu.register.a;
		return 0;
	}
	public int OP5F() {
		cpu.register.e = cpu.register.a;
		return 0;
	}
	public int OP67() {
		cpu.register.h = cpu.register.a;
		return 0;
	}
	public int OP6F() {
		cpu.register.l = cpu.register.a;
		return 0;
	}
	public int OP02() {
		memory.writeMemory(cpu.register.bc(), (byte) cpu.register.a);
		return 0;
	}
	public int OP12() {
		memory.writeMemory(cpu.register.de(), (byte) cpu.register.a);
		return 0;
	}
	public int OP77() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.a);
		return 0;
	}
	public int OPEA() {
		memory.writeMemory(cpu.getValue16(), (byte) cpu.register.a);
		return 0;
	}
	public int OPF2() {
		cpu.register.a = memory.readMemory(0xFF00 + cpu.register.c);
		return 0;
	}
	public int OPE2() {
		memory.writeMemory(0xFF00 + cpu.register.c, (byte) cpu.register.a);
		return 0;
	}
	public int OP3A() {
		cpu.register.a = memory.readMemory(cpu.register.hl());
		cpu.decrementHL();
		return 0;
	}
	public int OP32() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.a);
		cpu.decrementHL();
		return 0;
	}
	public int OP2A() {
		cpu.register.a = memory.readMemory(cpu.register.hl());
		cpu.incrementHL();
		return 0;
	}
	public int OP22() {
		memory.writeMemory(cpu.register.hl(), (byte) cpu.register.a);
		cpu.incrementHL();
		return 0;
	}
	public int OPE0() {
		memory.writeMemory(0xFF00 + cpu.getValue8(), (byte) cpu.register.a);
		return 0;
	}
	public int OPF0() {
		cpu.register.a = memory.readMemory(0xFF00 + cpu.getValue8());
		return 0;
	}
	public int OP01() {
		int nn = cpu.getValue16();
		cpu.putBC(nn);
		return 0;
	}
	public int OP11() {
		int nn = cpu.getValue16();
		cpu.putDE(nn);
		return 0;
	}
	public int OP21() {
		int nn = cpu.getValue16();
		cpu.putHL(nn);
		return 0;
	}
	public int OP31() {
		int nn = cpu.getValue16();
		cpu.putSP(nn);
		return 0;
	}
	public int OPF9() {
		cpu.register.sp = cpu.register.hl();
		return 0;
	}
	public int OPF8() {
		int n = cpu.getValue8();
		int intermidiateValue = cpu.register.sp + n;
		cpu.register.zf = false;
		cpu.register.nf = false;
		if (n >= 0) {
			cpu.register.cf = ((cpu.register.sp & 255) + n) > 255;
			cpu.register.hf = ((cpu.register.sp & 16) + (n & 16)) > 16;
		} else {
			cpu.register.cf = ((cpu.register.sp & 255) + ((256 + n) & 255)) > 255;
			cpu.register.hf = ((cpu.register.sp & 16) + ((256 + n) & 16)) > 16;
		}
		cpu.putHL(0xFFFF & intermidiateValue);
		return 0;
	}
	public int OP08() {
		cpu.putSP(cpu.getValue16());
		return 0;
	}
	public int OPF5() {
		memory.stackPush(cpu.register.af());
		return 0;
	}
	public int OPC5() {
		memory.stackPush(cpu.register.bc());
		return 0;
	}
	public int OPD5() {
		memory.stackPush(cpu.register.de());
		return 0;
	}
	public int OPE5() {
		memory.stackPush(cpu.register.hl());
		return 0;
	}
	public int OPF1() {
		cpu.putAF(memory.stackPop());
		return 0;
	}
	public int OPC1() {
		cpu.putBC(memory.stackPop());
		return 0;
	}
	public int OPD1() {
		cpu.putDE(memory.stackPop());
		return 0;
	}
	public int OPE1() {
		cpu.putHL(memory.stackPop());
		return 0;
	}
	public int OP87() {
		int intermediateResult = cpu.register.a + cpu.register.a;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.a & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.a & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP80() {
		int intermediateResult = cpu.register.a + cpu.register.b;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.b & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.b & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP81() {
		int intermediateResult = cpu.register.a + cpu.register.c;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.c & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.c & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP82() {
		int intermediateResult = cpu.register.a + cpu.register.d;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.d & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.d & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP83() {
		int intermediateResult = cpu.register.a + cpu.register.e;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.e & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.e & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP84() {
		int intermediateResult = cpu.register.a + cpu.register.h;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.h & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.h & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP85() {
		int intermediateResult = cpu.register.a + cpu.register.l;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.l & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.l & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP86() {
		byte n = memory.readMemory(cpu.register.hl());
		int intermediateResult = cpu.register.a + n;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (n & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (n & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OPC6() {
		byte n = cpu.getValue8();
		int intermediateResult = cpu.register.a + n;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (n & 0xFF) > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (n & 0xF) > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8F() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.a + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.a & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.a & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP88() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.b + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.b & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.b & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP89() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.c + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.c & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.c & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8A() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.d + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.d & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.d & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8B() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.e + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.e & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.e & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8C() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.h + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.h & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.h & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8D() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		int intermediateResult = cpu.register.a + cpu.register.l + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (cpu.register.l & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (cpu.register.l & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP8E() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		byte n = memory.readMemory(cpu.register.hl());
		int intermediateResult = cpu.register.a + n + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (n & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (n & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OPCE() {
		int carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		byte n = cpu.getValue8();
		int intermediateResult = cpu.register.a + n + carryFlag;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.cf = (cpu.register.a & 0xFF) + (n & 0xFF) + carryFlag > 0xFF;
		cpu.register.hf = (cpu.register.a & 0xF) + (n & 0xF) + carryFlag > 0xF;
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
}
