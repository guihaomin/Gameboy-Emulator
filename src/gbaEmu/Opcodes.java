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
		cpu.register.sp = (short) cpu.register.hl();
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
	public int setSubFlags(int a, int n) {
		int intermediateResult = a - n;
		cpu.register.nf = true;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.cf = intermediateResult < 0;
		cpu.register.hf = (cpu.register.a & 0xF) < (cpu.register.a & 0xF);
		return 0;
	}
	public int OP97() {
		int intermediateResult = cpu.register.a - cpu.register.a;
		this.setSubFlags(cpu.register.a, cpu.register.a);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP90() {
		int intermediateResult = cpu.register.a - cpu.register.b;
		this.setSubFlags(cpu.register.a, cpu.register.b);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP91() {
		int intermediateResult = cpu.register.a - cpu.register.c;
		this.setSubFlags(cpu.register.a, cpu.register.c);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP92() {
		int intermediateResult = cpu.register.a - cpu.register.d;
		this.setSubFlags(cpu.register.a, cpu.register.d);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP93() {
		int intermediateResult = cpu.register.a - cpu.register.e;
		this.setSubFlags(cpu.register.a, cpu.register.e);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP94() {
		int intermediateResult = cpu.register.a - cpu.register.h;
		this.setSubFlags(cpu.register.a, cpu.register.h);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP95() {
		int intermediateResult = cpu.register.a - cpu.register.l;
		this.setSubFlags(cpu.register.a, cpu.register.l);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP96() {
		byte n = memory.readMemory(cpu.register.hl());
		int intermediateResult = cpu.register.a - n;
		this.setSubFlags(cpu.register.a, n);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OPD6() {
		byte n = cpu.getValue8();
		int intermediateResult = cpu.register.a - n;
		this.setSubFlags(cpu.register.a, n);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9F() {
		int intermediateResult = cpu.register.a - cpu.register.a - 1;
		this.setSubFlags(cpu.register.a, cpu.register.a + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP98() {
		int intermediateResult = cpu.register.a - cpu.register.b - 1;
		this.setSubFlags(cpu.register.a, cpu.register.b + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP99() {
		int intermediateResult = cpu.register.a - cpu.register.c - 1;
		this.setSubFlags(cpu.register.a, cpu.register.c + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9A() {
		int intermediateResult = cpu.register.a - cpu.register.d - 1;
		this.setSubFlags(cpu.register.a, cpu.register.d + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9B() {
		int intermediateResult = cpu.register.a - cpu.register.e - 1;
		this.setSubFlags(cpu.register.a, cpu.register.e + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9C() {
		int intermediateResult = cpu.register.a - cpu.register.h - 1;
		this.setSubFlags(cpu.register.a, cpu.register.h + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9D() {
		int intermediateResult = cpu.register.a - cpu.register.l - 1;
		this.setSubFlags(cpu.register.a, cpu.register.l + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OP9E() {
		byte n = memory.readMemory(cpu.register.hl());
		int intermediateResult = cpu.register.a - n - 1;
		this.setSubFlags(cpu.register.a, n + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	public int OPDE() {
		byte n = cpu.getValue8();
		int intermediateResult = cpu.register.a - n - 1;
		this.setSubFlags(cpu.register.a, n + 1);
		cpu.register.a = (byte) (intermediateResult & 0xFF);
		return 0;
	}
	private int setAndFlags(byte a, byte b) {
		int result = a & b;
		cpu.register.zf = result == 0;
		cpu.register.nf = false;
		cpu.register.hf = true;
		cpu.register.cf = false;
		return 0;
	}
	public int OPA7() {
		setAndFlags(cpu.register.a, cpu.register.a);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.a);
		return 0;
	}
	public int OPA0() {
		setAndFlags(cpu.register.a, cpu.register.b);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.b);
		return 0;
	}
	public int OPA1() {
		setAndFlags(cpu.register.a, cpu.register.c);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.c);
		return 0;
	}
	public int OPA2() {
		setAndFlags(cpu.register.a, cpu.register.d);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.d);
		return 0;
	}
	public int OPA3() {
		setAndFlags(cpu.register.a, cpu.register.e);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.e);
		return 0;
	}
	public int OPA4() {
		setAndFlags(cpu.register.a, cpu.register.h);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.h);
		return 0;
	}
	public int OPA5() {
		setAndFlags(cpu.register.a, cpu.register.l);
		cpu.register.a = (byte) (cpu.register.a & cpu.register.l);
		return 0;
	}
	public int OPA6() {
		byte n = memory.readMemory(cpu.register.hl());
		setAndFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a & n);
		return 0;
	}
	public int OPE6() {
		byte n = cpu.getValue8();
		setAndFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a & n);
		return 0;
	}
	private int setOrFlags(byte a, byte b) {
		int result = a | b;
		cpu.register.zf = result == 0;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.cf = false;
		return 0;
	}
	public int OPB7() {
		setOrFlags(cpu.register.a, cpu.register.a);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.a);
		return 0;
	}
	public int OPB0() {
		setOrFlags(cpu.register.a, cpu.register.b);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.b);
		return 0;
	}
	public int OPB1() {
		setOrFlags(cpu.register.a, cpu.register.c);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.c);
		return 0;
	}
	public int OPB2() {
		setOrFlags(cpu.register.a, cpu.register.d);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.d);
		return 0;
	}
	public int OPB3() {
		setOrFlags(cpu.register.a, cpu.register.e);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.e);
		return 0;
	}
	public int OPB4() {
		setOrFlags(cpu.register.a, cpu.register.h);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.h);
		return 0;
	}
	public int OPB5() {
		setOrFlags(cpu.register.a, cpu.register.l);
		cpu.register.a = (byte) (cpu.register.a | cpu.register.l);
		return 0;
	}
	public int OPB6() {
		byte n = memory.readMemory(cpu.register.hl());
		setOrFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a | n);
		return 0;
	}
	public int OPF6() {
		byte n = cpu.getValue8();
		setOrFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a | n);
		return 0;
	}
	private int setXorFlags(byte a, byte b) {
		int result = a ^ b;
		cpu.register.zf = result == 0;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.cf = false;
		return 0;
	}
	public int OPAF() {
		setXorFlags(cpu.register.a, cpu.register.a);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.a);
		return 0;
	}
	public int OPA8() {
		setXorFlags(cpu.register.a, cpu.register.b);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.b);
		return 0;
	}
	public int OPA9() {
		setXorFlags(cpu.register.a, cpu.register.c);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.c);
		return 0;
	}
	public int OPAA() {
		setXorFlags(cpu.register.a, cpu.register.d);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.d);
		return 0;
	}
	public int OPAB() {
		setXorFlags(cpu.register.a, cpu.register.e);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.e);
		return 0;
	}
	public int OPAC() {
		setXorFlags(cpu.register.a, cpu.register.h);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.h);
		return 0;
	}
	public int OPAD() {
		setXorFlags(cpu.register.a, cpu.register.l);
		cpu.register.a = (byte) (cpu.register.a ^ cpu.register.l);
		return 0;
	}
	public int OPAE() {
		byte n = memory.readMemory(cpu.register.hl());
		setXorFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a ^ n);
		return 0;
	}
	public int OPEE() {
		byte n = cpu.getValue8();
		setXorFlags(cpu.register.a, n);
		cpu.register.a = (byte) (cpu.register.a ^ n);
		return 0;
	}
	public int OPBF() {
		this.setSubFlags(cpu.register.a, cpu.register.a);
		return 0;
	}
	public int OPB8() {
		this.setSubFlags(cpu.register.a, cpu.register.b);
		return 0;
	}
	public int OPB9() {
		this.setSubFlags(cpu.register.a, cpu.register.c);
		return 0;
	}
	public int OPBA() {
		this.setSubFlags(cpu.register.a, cpu.register.d);
		return 0;
	}
	public int OPBB() {
		this.setSubFlags(cpu.register.a, cpu.register.e);
		return 0;
	}
	public int OPBC() {
		this.setSubFlags(cpu.register.a, cpu.register.h);
		return 0;
	}
	public int OPBD() {
		this.setSubFlags(cpu.register.a, cpu.register.l);
		return 0;
	}
	public int OPBE() {
		int n = memory.readMemory(cpu.register.hl());
		this.setSubFlags(cpu.register.a, n);
		return 0;
	}
	public int OPFE() {
		int n = cpu.getValue8();
		this.setSubFlags(cpu.register.a, n);
		return 0;
	}
	private int setIncFlags(int a) {
		int intermediateResult = a + 1;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.nf = false;
		cpu.register.hf = (a & 0xF) + (1 & 0xF) > 0xF;
		return 0;
	}
	public int OP3C() {
		setIncFlags(cpu.register.a);
		cpu.register.a = (byte) ((cpu.register.a + 1) & 0xFF);
		return 0;
	}
	public int OP04() {
		setIncFlags(cpu.register.b);
		cpu.register.b = (byte) ((cpu.register.b + 1) & 0xFF);
		return 0;
	}
	public int OP0C() {
		setIncFlags(cpu.register.c);
		cpu.register.c = (byte) ((cpu.register.c + 1) & 0xFF);
		return 0;
	}
	public int OP14() {
		setIncFlags(cpu.register.d);
		cpu.register.d = (byte) ((cpu.register.d + 1) & 0xFF);
		return 0;
	}
	public int OP1C() {
		setIncFlags(cpu.register.e);
		cpu.register.e = (byte) ((cpu.register.e + 1) & 0xFF);
		return 0;
	}
	public int OP24() {
		setIncFlags(cpu.register.h);
		cpu.register.h = (byte) ((cpu.register.h + 1) & 0xFF);
		return 0;
	}
	public int OP2C() {
		setIncFlags(cpu.register.d);
		cpu.register.d = (byte) ((cpu.register.d + 1) & 0xFF);
		return 0;
	}
	public int OP34() {
		int n = memory.readMemory(cpu.register.hl());
		setIncFlags(n);
		memory.writeMemory(cpu.register.hl(), (byte) ((n + 1) & 0xFF));
		return 0;
	}
	public int setDecFlags(int a) {
		int intermediateResult = a - 1;
		cpu.register.nf = true;
		cpu.register.zf = intermediateResult == 0;
		cpu.register.hf = (a & 0xF) < (1 & 0xF);
		return 0;
	}
	public int OP3D() {
		setDecFlags(cpu.register.a);
		cpu.register.a = (byte) ((cpu.register.a - 1) & 0xFF);
		return 0;
	}
	public int OP05() {
		setDecFlags(cpu.register.b);
		cpu.register.b = (byte) ((cpu.register.b - 1) & 0xFF);
		return 0;
	}
	public int OP0D() {
		setDecFlags(cpu.register.c);
		cpu.register.c = (byte) ((cpu.register.c - 1) & 0xFF);
		return 0;
	}
	public int OP15() {
		setDecFlags(cpu.register.d);
		cpu.register.d = (byte) ((cpu.register.d - 1) & 0xFF);
		return 0;
	}
	public int OP1D() {
		setDecFlags(cpu.register.e);
		cpu.register.e = (byte) ((cpu.register.e - 1) & 0xFF);
		return 0;
	}
	public int OP25() {
		setDecFlags(cpu.register.h);
		cpu.register.h = (byte) ((cpu.register.h - 1) & 0xFF);
		return 0;
	}
	public int OP2D() {
		setDecFlags(cpu.register.l);
		cpu.register.l = (byte) ((cpu.register.l - 1) & 0xFF);
		return 0;
	}
	public int OP35() {
		int n = memory.readMemory(cpu.register.hl());
		setDecFlags(n);
		memory.writeMemory(cpu.register.hl(), (byte) ((n - 1) & 0xFF));
		return 0;
	}
	private int setAdd16Flags(int a, int n) {
		cpu.register.nf = false;
		cpu.register.hf = (a & 0xFFF) + (n & 0xFFF) > 0xFFF;
		cpu.register.cf = (a & 0xFFFF) + (n & 0xFFFF) > 0xFFFF;
		return 0;
	}
	public int OP09() {
		setAdd16Flags(cpu.register.hl(), cpu.register.bc());
		int intermediateResult = cpu.register.hl() + cpu.register.bc();
		intermediateResult = (cpu.register.hl() + cpu.register.bc()) & 0xFFFF;
		cpu.putHL(intermediateResult);
		return 0;
	}
	public int OP19() {
		setAdd16Flags(cpu.register.hl(), cpu.register.de());
		int intermediateResult = cpu.register.hl() + cpu.register.de();
		intermediateResult = (cpu.register.hl() + cpu.register.de()) & 0xFFFF;
		cpu.putHL(intermediateResult);
		return 0;
	}
	public int OP29() {
		setAdd16Flags(cpu.register.hl(), cpu.register.hl());
		int intermediateResult = cpu.register.hl() + cpu.register.hl();
		intermediateResult = (cpu.register.hl() + cpu.register.hl()) & 0xFFFF;
		cpu.putHL(intermediateResult);
		return 0;
	}
	public int OP39() {
		setAdd16Flags(cpu.register.hl(), cpu.register.sp);
		int intermediateResult = cpu.register.hl() + cpu.register.sp;
		intermediateResult = (cpu.register.hl() + cpu.register.sp) & 0xFFFF;
		cpu.putHL(intermediateResult);
		return 0;
	}
	public int OPE8() {
		byte n = cpu.getValue8();
		setAdd16Flags(cpu.register.sp, n);
		int intermediateResult = cpu.register.hl() + cpu.register.sp;
		intermediateResult = (cpu.register.hl() + cpu.register.sp) & 0xFFFF;
		cpu.putSP(intermediateResult);
		return 0;
	}
	public int OP03() {
		cpu.putBC(cpu.register.bc() + 1);
		return 0;
	}
	public int OP13() {
		cpu.putDE(cpu.register.de() + 1);
		return 0;
	}
	public int OP23() {
		cpu.putHL(cpu.register.hl() + 1);
		return 0;
	}
	public int OP33() {
		cpu.putSP(cpu.register.sp + 1);
		return 0;
	}
	public int OP0B() {
		cpu.putBC(cpu.register.bc() - 1);
		return 0;
	}
	public int OP1B() {
		cpu.putDE(cpu.register.de() - 1);
		return 0;
	}
	public int OP2B() {
		cpu.putHL(cpu.register.hl() - 1);
		return 0;
	}
	public int OP3B() {
		cpu.putSP(cpu.register.sp - 1);
		return 0;
	}
	public int OPCB() {
		byte n = cpu.getValue8();
		if (cpu.opMap.containsKey(0xCB << 2 + n)) {
			Runnable op = cpu.opMap.get(0xCB << 2 + n);
			op.run();
		} else {
			return -1;
		}
		return cpu.opCycles.get(0xCB << 2 + n);
	}
	private byte swapByteAndSetFlags(byte a) {
		byte res = (byte) (((a & 0xF) << 4) | ((a & 0xF0) >> 4));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.hf = false;
		cpu.register.zf = res == 0;
		return res;
	}
	public int OPCB37() {
		cpu.register.a = swapByteAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB30() {
		cpu.register.b = swapByteAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB31() {
		cpu.register.c = swapByteAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB32() {
		cpu.register.d = swapByteAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB33() {
		cpu.register.e = swapByteAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB34() {
		cpu.register.h = swapByteAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB35() {
		cpu.register.l = swapByteAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB36() {
		byte n = memory.readMemory(cpu.register.hl());
		n = swapByteAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	public int OP2F() {
		cpu.register.a = (byte) (cpu.register.a ^ 0xFF);
		cpu.register.nf = true;
		cpu.register.hf = true;
		cpu.register.zf = false;
		cpu.register.cf = false;
		return 0;
	}
	public int OP3F() {
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.cf = !cpu.register.cf;
		return 0;
	}
	public int OP37() {
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.cf = true;
		return 0;
	}
	public int OP00() {
		return 0;
	}
	public int OP07() {
		cpu.register.cf = (cpu.register.a >> 7) == 1;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.a = (byte) (cpu.register.a << 1 | cpu.register.a >> 7);
		cpu.register.zf = cpu.register.a == 0;
		return 0;
	}
	public int OP17() {
		byte carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		cpu.register.cf = (cpu.register.a >> 7) == 1;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.a = (byte) (cpu.register.a << 1 | carryFlag);
		cpu.register.zf = cpu.register.a == 0;
		return 0;
	}
	public int OP0F() {
		cpu.register.cf = (cpu.register.a & 1) == 1;
		cpu.register.a = (byte) ((cpu.register.a >> 1) | ((cpu.register.a & 1) << 7));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = cpu.register.a == 0;
		return 0;
	}
	public int OP1F() {
		byte carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		cpu.register.cf = (cpu.register.a & 1) == 1;
		cpu.register.a = (byte) ((cpu.register.a >> 1) | (carryFlag << 7));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = cpu.register.a == 0;
		return 0;
	}
	private byte leftRotAndSetFlags(byte a) {
		cpu.register.cf = (a >> 7) == 1;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.a = (byte) (a << 1 | a >> 7);
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB07() {
		cpu.register.a = leftRotAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB00() {
		cpu.register.b = leftRotAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB01() {
		cpu.register.c = leftRotAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB02() {
		cpu.register.d = leftRotAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB03() {
		cpu.register.e = leftRotAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB04() {
		cpu.register.h = leftRotAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB05() {
		cpu.register.l = leftRotAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB06() {
		byte n = memory.readMemory(cpu.register.hl());
		n = leftRotAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte leftRotCarryAndSetFlags(byte a) {
		byte carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		cpu.register.cf = (a >> 7) == 1;
		cpu.register.nf = false;
		cpu.register.hf = false;
		a = (byte) (a << 1 | carryFlag);
		cpu.register.zf = a == 0;
		return 0;
	}
	public int OPCB17() {
		cpu.register.a = leftRotCarryAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB10() {
		cpu.register.b = leftRotCarryAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB11() {
		cpu.register.c = leftRotCarryAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB12() {
		cpu.register.d = leftRotCarryAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB13() {
		cpu.register.e = leftRotCarryAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB14() {
		cpu.register.h = leftRotCarryAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB15() {
		cpu.register.l = leftRotCarryAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB16() {
		byte n = memory.readMemory(cpu.register.hl());
		n = leftRotCarryAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte rightRotAndSetFlags(byte a) {
		cpu.register.cf = (a & 1) == 1;
		a = (byte) ((a >> 1) | ((a & 1) << 7));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB0F() {
		cpu.register.a = rightRotAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB08() {
		cpu.register.b = rightRotAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB09() {
		cpu.register.c = rightRotAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB0A() {
		cpu.register.d = rightRotAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB0B() {
		cpu.register.e = rightRotAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB0C() {
		cpu.register.h = rightRotAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB0D() {
		cpu.register.l = rightRotAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB0E() {
		byte n = memory.readMemory(cpu.register.hl());
		n = rightRotAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte rightRotCarryAndSetFlags(byte a) {
		byte carryFlag = 0;
		if (cpu.register.cf) {
			carryFlag = 1;
		}
		cpu.register.cf = (a & 1) == 1;
		a = (byte) ((a >> 1) | (carryFlag << 7));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB1F() {
		cpu.register.a = rightRotCarryAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB18() {
		cpu.register.b = rightRotCarryAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB19() {
		cpu.register.c = rightRotCarryAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB1A() {
		cpu.register.d = rightRotCarryAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB1B() {
		cpu.register.e = rightRotCarryAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB1C() {
		cpu.register.h = rightRotCarryAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB1D() {
		cpu.register.l = rightRotCarryAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB1E() {
		byte n = memory.readMemory(cpu.register.hl());
		n = rightRotCarryAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte leftShiftAndSetFlags(byte a) {
		cpu.register.cf = (a >> 7) == 1;
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.a = (byte) (a << 1);
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB27() {
		cpu.register.a = leftShiftAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB20() {
		cpu.register.b = leftShiftAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB21() {
		cpu.register.c = leftShiftAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB22() {
		cpu.register.d = leftShiftAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB23() {
		cpu.register.e = leftShiftAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB24() {
		cpu.register.h = leftShiftAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB25() {
		cpu.register.l = leftShiftAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB26() {
		byte n = memory.readMemory(cpu.register.hl());
		n = leftShiftAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte sraAndSetFlags(byte a) {
		cpu.register.cf = (a & 1) == 1;
		a = (byte) ((a >> 1) | (a & 0x80));
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB2F() {
		cpu.register.a = sraAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB28() {
		cpu.register.b = sraAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB29() {
		cpu.register.c = sraAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB2A() {
		cpu.register.d = sraAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB2B() {
		cpu.register.e = sraAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB2C() {
		cpu.register.h = sraAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB2D() {
		cpu.register.l = sraAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB2E() {
		byte n = memory.readMemory(cpu.register.hl());
		n = sraAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private byte srlAndSetFlags(byte a) {
		cpu.register.cf = (a & 1) == 1;
		a = (byte) ((a >> 1) & 0x7F);
		cpu.register.nf = false;
		cpu.register.hf = false;
		cpu.register.zf = a == 0;
		return a;
	}
	public int OPCB3F() {
		cpu.register.a = srlAndSetFlags(cpu.register.a);
		return 0;
	}
	public int OPCB38() {
		cpu.register.b = srlAndSetFlags(cpu.register.b);
		return 0;
	}
	public int OPCB39() {
		cpu.register.c = srlAndSetFlags(cpu.register.c);
		return 0;
	}
	public int OPCB3A() {
		cpu.register.d = srlAndSetFlags(cpu.register.d);
		return 0;
	}
	public int OPCB3B() {
		cpu.register.e = srlAndSetFlags(cpu.register.e);
		return 0;
	}
	public int OPCB3C() {
		cpu.register.h = srlAndSetFlags(cpu.register.h);
		return 0;
	}
	public int OPCB3D() {
		cpu.register.l = srlAndSetFlags(cpu.register.l);
		return 0;
	}
	public int OPCB3E() {
		byte n = memory.readMemory(cpu.register.hl());
		n = srlAndSetFlags(n);
		memory.writeMemory(cpu.register.hl(), n);
		return 0;
	}
	private void bitAndSetFlags(byte a, int pos) {
		cpu.register.zf = ((a >> pos) & 1) == 0;
		cpu.register.nf = false;
		cpu.register.hf = true;
	}
	public int OPCB47() {
		bitAndSetFlags(cpu.register.a, 0);
		return 0;
	}
	public int OPCB40() {
		bitAndSetFlags(cpu.register.b, 0);
		return 0;
	}
	public int OPCB41() {
		bitAndSetFlags(cpu.register.c, 0);
		return 0;
	}
	public int OPCB42() {
		bitAndSetFlags(cpu.register.d, 0);
		return 0;
	}
	public int OPCB43() {
		bitAndSetFlags(cpu.register.e, 0);
		return 0;
	}
	public int OPCB44() {
		bitAndSetFlags(cpu.register.h, 0);
		return 0;
	}
	public int OPCB45() {
		bitAndSetFlags(cpu.register.l, 0);
		return 0;
	}
	public int OPCB46() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 0);
		return 0;
	}
	public int OPCB48() {
		bitAndSetFlags(cpu.register.b, 1);
		return 0;
	}
	public int OPCB49() {
		bitAndSetFlags(cpu.register.c, 1);
		return 0;
	}
	public int OPCB4A() {
		bitAndSetFlags(cpu.register.d, 1);
		return 0;
	}
	public int OPCB4B() {
		bitAndSetFlags(cpu.register.e, 1);
		return 0;
	}
	public int OPCB4C() {
		bitAndSetFlags(cpu.register.h, 1);
		return 0;
	}
	public int OPCB4D() {
		bitAndSetFlags(cpu.register.l, 1);
		return 0;
	}
	public int OPCB4E() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 1);
		return 0;
	}
	public int OPCB4F() {
		bitAndSetFlags(cpu.register.a, 1);
		return 0;
	}
	public int OPCB50() {
		bitAndSetFlags(cpu.register.b, 2);
		return 0;
	}
	public int OPCB51() {
		bitAndSetFlags(cpu.register.c, 2);
		return 0;
	}
	public int OPCB52() {
		bitAndSetFlags(cpu.register.d, 2);
		return 0;
	}
	public int OPCB53() {
		bitAndSetFlags(cpu.register.e, 2);
		return 0;
	}
	public int OPCB54() {
		bitAndSetFlags(cpu.register.h, 2);
		return 0;
	}
	public int OPCB55() {
		bitAndSetFlags(cpu.register.l, 2);
		return 0;
	}
	public int OPCB56() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 2);
		return 0;
	}
	public int OPCB57() {
		bitAndSetFlags(cpu.register.a, 2);
		return 0;
	}
	public int OPCB58() {
		bitAndSetFlags(cpu.register.b, 3);
		return 0;
	}
	public int OPCB59() {
		bitAndSetFlags(cpu.register.c, 3);
		return 0;
	}
	public int OPCB5A() {
		bitAndSetFlags(cpu.register.d, 3);
		return 0;
	}
	public int OPCB5B() {
		bitAndSetFlags(cpu.register.e, 3);
		return 0;
	}
	public int OPCB5C() {
		bitAndSetFlags(cpu.register.h, 3);
		return 0;
	}
	public int OPCB5D() {
		bitAndSetFlags(cpu.register.l, 3);
		return 0;
	}
	public int OPCB5E() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 3);
		return 0;
	}
	public int OPCB5F() {
		bitAndSetFlags(cpu.register.a, 3);
		return 0;
	}
	public int OPCB60() {
		bitAndSetFlags(cpu.register.b, 4);
		return 0;
	}
	public int OPCB61() {
		bitAndSetFlags(cpu.register.c, 4);
		return 0;
	}
	public int OPCB62() {
		bitAndSetFlags(cpu.register.d, 4);
		return 0;
	}
	public int OPCB63() {
		bitAndSetFlags(cpu.register.e, 4);
		return 0;
	}
	public int OPCB64() {
		bitAndSetFlags(cpu.register.h, 4);
		return 0;
	}
	public int OPCB65() {
		bitAndSetFlags(cpu.register.l, 4);
		return 0;
	}
	public int OPCB66() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 4);
		return 0;
	}
	public int OPCB67() {
		bitAndSetFlags(cpu.register.a, 4);
		return 0;
	}
	public int OPCB68() {
		bitAndSetFlags(cpu.register.b, 5);
		return 0;
	}
	public int OPCB69() {
		bitAndSetFlags(cpu.register.c, 5);
		return 0;
	}
	public int OPCB6A() {
		bitAndSetFlags(cpu.register.d, 5);
		return 0;
	}
	public int OPCB6B() {
		bitAndSetFlags(cpu.register.e, 5);
		return 0;
	}
	public int OPCB6C() {
		bitAndSetFlags(cpu.register.h, 5);
		return 0;
	}
	public int OPCB6D() {
		bitAndSetFlags(cpu.register.l, 5);
		return 0;
	}
	public int OPCB6E() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 5);
		return 0;
	}
	public int OPCB6F() {
		bitAndSetFlags(cpu.register.a, 5);
		return 0;
	}
	public int OPCB70() {
		bitAndSetFlags(cpu.register.b, 6);
		return 0;
	}
	public int OPCB71() {
		bitAndSetFlags(cpu.register.c, 6);
		return 0;
	}
	public int OPCB72() {
		bitAndSetFlags(cpu.register.d, 6);
		return 0;
	}
	public int OPCB73() {
		bitAndSetFlags(cpu.register.e, 6);
		return 0;
	}
	public int OPCB74() {
		bitAndSetFlags(cpu.register.h, 6);
		return 0;
	}
	public int OPCB75() {
		bitAndSetFlags(cpu.register.l, 6);
		return 0;
	}
	public int OPCB76() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 6);
		return 0;
	}
	public int OPCB77() {
		bitAndSetFlags(cpu.register.a, 6);
		return 0;
	}
	public int OPCB78() {
		bitAndSetFlags(cpu.register.b, 7);
		return 0;
	}
	public int OPCB79() {
		bitAndSetFlags(cpu.register.c, 7);
		return 0;
	}
	public int OPCB7A() {
		bitAndSetFlags(cpu.register.d, 7);
		return 0;
	}
	public int OPCB7B() {
		bitAndSetFlags(cpu.register.e, 7);
		return 0;
	}
	public int OPCB7C() {
		bitAndSetFlags(cpu.register.h, 7);
		return 0;
	}
	public int OPCB7D() {
		bitAndSetFlags(cpu.register.l, 7);
		return 0;
	}
	public int OPCB7E() {
		byte n = memory.readMemory(cpu.register.hl());
		bitAndSetFlags(n, 7);
		return 0;
	}
	public int OPCB7F() {
		bitAndSetFlags(cpu.register.a, 7);
		return 0;
	}
	private byte resetBit(byte a, int pos) {
		byte mask = (byte) ((1 << pos) ^ 0xFF);
		return (byte) (a & mask);
	}
	private byte setBit(byte a, int pos) {
		byte mask = (byte) (1 << pos);
		return (byte) (a | mask);
	}
	public int OPCB87() {
		cpu.register.a = resetBit(cpu.register.a, 0);
		return 0;
	}
	public int OPCB80() {
		cpu.register.b = resetBit(cpu.register.b, 0);
		return 0;
	}
	public int OPCB81() {
		cpu.register.c = resetBit(cpu.register.c, 0);
		return 0;
	}
	public int OPCB82() {
		cpu.register.d = resetBit(cpu.register.d, 0);
		return 0;
	}
	public int OPCB83() {
		cpu.register.e = resetBit(cpu.register.e, 0);
		return 0;
	}
	public int OPCB84() {
		cpu.register.h = resetBit(cpu.register.h, 0);
		return 0;
	}
	public int OPCB85() {
		cpu.register.l = resetBit(cpu.register.l, 0);
		return 0;
	}
	public int OPCB86() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 0));
		return 0;
	}
	public int OPCB88() {
		cpu.register.b = resetBit(cpu.register.b, 1);
		return 0;
	}
	public int OPCB89() {
		cpu.register.c = resetBit(cpu.register.c, 1);
		return 0;
	}
	public int OPCB8A() {
		cpu.register.d = resetBit(cpu.register.d, 1);
		return 0;
	}
	public int OPCB8B() {
		cpu.register.e = resetBit(cpu.register.e, 1);
		return 0;
	}
	public int OPCB8C() {
		cpu.register.h = resetBit(cpu.register.h, 1);
		return 0;
	}
	public int OPCB8D() {
		cpu.register.l = resetBit(cpu.register.l, 1);
		return 0;
	}
	public int OPCB8E() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 1));
		return 0;
	}
	public int OPCB8F() {
		cpu.register.a = resetBit(cpu.register.a, 1);
		return 0;
	}
	public int OPCB90() {
		cpu.register.b = resetBit(cpu.register.b, 2);
		return 0;
	}
	public int OPCB91() {
		cpu.register.c = resetBit(cpu.register.c, 2);
		return 0;
	}
	public int OPCB92() {
		cpu.register.d = resetBit(cpu.register.d, 2);
		return 0;
	}
	public int OPCB93() {
		cpu.register.e = resetBit(cpu.register.e, 2);
		return 0;
	}
	public int OPCB94() {
		cpu.register.h = resetBit(cpu.register.h, 2);
		return 0;
	}
	public int OPCB95() {
		cpu.register.l = resetBit(cpu.register.l, 2);
		return 0;
	}
	public int OPCB96() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 2));
		return 0;
	}
	public int OPCB97() {
		cpu.register.a = resetBit(cpu.register.a, 2);
		return 0;
	}
	public int OPCB98() {
		cpu.register.b = resetBit(cpu.register.b, 3);
		return 0;
	}
	public int OPCB99() {
		cpu.register.c = resetBit(cpu.register.c, 3);
		return 0;
	}
	public int OPCB9A() {
		cpu.register.d = resetBit(cpu.register.d, 3);
		return 0;
	}
	public int OPCB9B() {
		cpu.register.e = resetBit(cpu.register.e, 3);
		return 0;
	}
	public int OPCB9C() {
		cpu.register.h = resetBit(cpu.register.h, 3);
		return 0;
	}
	public int OPCB9D() {
		cpu.register.l = resetBit(cpu.register.l, 3);
		return 0;
	}
	public int OPCB9E() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 3));
		return 0;
	}
	public int OPCB9F() {
		cpu.register.a = resetBit(cpu.register.a, 3);
		return 0;
	}
	public int OPCBA0() {
		cpu.register.b = resetBit(cpu.register.b, 4);
		return 0;
	}
	public int OPCBA1() {
		cpu.register.c = resetBit(cpu.register.c, 4);
		return 0;
	}
	public int OPCBA2() {
		cpu.register.d = resetBit(cpu.register.d, 4);
		return 0;
	}
	public int OPCBA3() {
		cpu.register.e = resetBit(cpu.register.e, 4);
		return 0;
	}
	public int OPCBA4() {
		cpu.register.h = resetBit(cpu.register.h, 4);
		return 0;
	}
	public int OPCBA5() {
		cpu.register.l = resetBit(cpu.register.l, 4);
		return 0;
	}
	public int OPCBA6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 4));
		return 0;
	}
	public int OPCBA7() {
		cpu.register.a = resetBit(cpu.register.a, 4);
		return 0;
	}
	public int OPCBA8() {
		cpu.register.b = resetBit(cpu.register.b, 5);
		return 0;
	}
	public int OPCBA9() {
		cpu.register.c = resetBit(cpu.register.c, 5);
		return 0;
	}
	public int OPCBAA() {
		cpu.register.d = resetBit(cpu.register.d, 5);
		return 0;
	}
	public int OPCBAB() {
		cpu.register.e = resetBit(cpu.register.e, 5);
		return 0;
	}
	public int OPCBAC() {
		cpu.register.h = resetBit(cpu.register.h, 5);
		return 0;
	}
	public int OPCBAD() {
		cpu.register.l = resetBit(cpu.register.l, 5);
		return 0;
	}
	public int OPCBAE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 5));
		return 0;
	}
	public int OPCBAF() {
		cpu.register.a = resetBit(cpu.register.a, 5);
		return 0;
	}
	public int OPCBB0() {
		cpu.register.b = resetBit(cpu.register.b, 6);
		return 0;
	}
	public int OPCBB1() {
		cpu.register.c = resetBit(cpu.register.c, 6);
		return 0;
	}
	public int OPCBB2() {
		cpu.register.d = resetBit(cpu.register.d, 6);
		return 0;
	}
	public int OPCBB3() {
		cpu.register.e = resetBit(cpu.register.e, 6);
		return 0;
	}
	public int OPCBB4() {
		cpu.register.h = resetBit(cpu.register.h, 6);
		return 0;
	}
	public int OPCBB5() {
		cpu.register.l = resetBit(cpu.register.l, 6);
		return 0;
	}
	public int OPCBB6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 6));
		return 0;
	}
	public int OPCBB7() {
		cpu.register.a = resetBit(cpu.register.a, 6);
		return 0;
	}
	public int OPCBB8() {
		cpu.register.b = resetBit(cpu.register.b, 7);
		return 0;
	}
	public int OPCBB9() {
		cpu.register.c = resetBit(cpu.register.c, 7);
		return 0;
	}
	public int OPCBBA() {
		cpu.register.d = resetBit(cpu.register.d, 7);
		return 0;
	}
	public int OPCBBB() {
		cpu.register.e = resetBit(cpu.register.e, 7);
		return 0;
	}
	public int OPCBBC() {
		cpu.register.h = resetBit(cpu.register.h, 7);
		return 0;
	}
	public int OPCBBD() {
		cpu.register.l = resetBit(cpu.register.l, 7);
		return 0;
	}
	public int OPCBBE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), resetBit(n, 7));
		return 0;
	}
	public int OPCBBF() {
		cpu.register.a = resetBit(cpu.register.a, 7);
		return 0;
	}
	public int OPCBC0() {
		cpu.register.b = setBit(cpu.register.b, 0);
		return 0;
	}
	public int OPCBC1() {
		cpu.register.c = setBit(cpu.register.c, 0);
		return 0;
	}
	public int OPCBC2() {
		cpu.register.d = setBit(cpu.register.d, 0);
		return 0;
	}
	public int OPCBC3() {
		cpu.register.e = setBit(cpu.register.e, 0);
		return 0;
	}
	public int OPCBC4() {
		cpu.register.h = setBit(cpu.register.h, 0);
		return 0;
	}
	public int OPCBC5() {
		cpu.register.l = setBit(cpu.register.l, 0);
		return 0;
	}
	public int OPCBC6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 0));
		return 0;
	}
	public int OPCBC7() {
		cpu.register.a = setBit(cpu.register.a, 0);
		return 0;
	}
	public int OPCBC8() {
		cpu.register.b = setBit(cpu.register.b, 1);
		return 0;
	}
	public int OPCBC9() {
		cpu.register.c = setBit(cpu.register.c, 1);
		return 0;
	}
	public int OPCBCA() {
		cpu.register.d = setBit(cpu.register.d, 1);
		return 0;
	}
	public int OPCBCB() {
		cpu.register.e = setBit(cpu.register.e, 1);
		return 0;
	}
	public int OPCBCC() {
		cpu.register.h = setBit(cpu.register.h, 1);
		return 0;
	}
	public int OPCBCD() {
		cpu.register.l = setBit(cpu.register.l, 1);
		return 0;
	}
	public int OPCBCE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 1));
		return 0;
	}
	public int OPCBCF() {
		cpu.register.a = setBit(cpu.register.l, 1);
		return 0;
	}
	public int OPCBD0() {
		cpu.register.b = setBit(cpu.register.b, 2);
		return 0;
	}
	public int OPCBD1() {
		cpu.register.c = setBit(cpu.register.c, 2);
		return 0;
	}
	public int OPCBD2() {
		cpu.register.d = setBit(cpu.register.d, 2);
		return 0;
	}
	public int OPCBD3() {
		cpu.register.e = setBit(cpu.register.e, 2);
		return 0;
	}
	public int OPCBD4() {
		cpu.register.h = setBit(cpu.register.h, 2);
		return 0;
	}
	public int OPCBD5() {
		cpu.register.l = setBit(cpu.register.l, 2);
		return 0;
	}
	public int OPCBD6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 2));
		return 0;
	}
	public int OPCBD7() {
		cpu.register.a = setBit(cpu.register.a, 2);
		return 0;
	}
	public int OPCBD8() {
		cpu.register.b = setBit(cpu.register.b, 3);
		return 0;
	}
	public int OPCBD9() {
		cpu.register.c = setBit(cpu.register.c, 3);
		return 0;
	}
	public int OPCBDA() {
		cpu.register.d = setBit(cpu.register.d, 3);
		return 0;
	}
	public int OPCBDB() {
		cpu.register.e = setBit(cpu.register.e, 3);
		return 0;
	}
	public int OPCBDC() {
		cpu.register.h = setBit(cpu.register.h, 3);
		return 0;
	}
	public int OPCBDD() {
		cpu.register.l = setBit(cpu.register.l, 3);
		return 0;
	}
	public int OPCBDE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 3));
		return 0;
	}
	public int OPCBDF() {
		cpu.register.a = setBit(cpu.register.a, 3);
		return 0;
	}
	public int OPCBE0() {
		cpu.register.b = setBit(cpu.register.b, 4);
		return 0;
	}
	public int OPCBE1() {
		cpu.register.c = setBit(cpu.register.c, 4);
		return 0;
	}
	public int OPCBE2() {
		cpu.register.d = setBit(cpu.register.d, 4);
		return 0;
	}
	public int OPCBE3() {
		cpu.register.e = setBit(cpu.register.e, 4);
		return 0;
	}
	public int OPCBE4() {
		cpu.register.h = setBit(cpu.register.h, 4);
		return 0;
	}
	public int OPCBE5() {
		cpu.register.l = setBit(cpu.register.l, 4);
		return 0;
	}
	public int OPCBE6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 4));
		return 0;
	}
	public int OPC3() {
		cpu.register.pc = cpu.getValue16();
		return 0;
	}
	public int OPCBE7() {
		cpu.register.a = setBit(cpu.register.a, 4);
		return 0;
	}
	public int OPCBE8() {
		cpu.register.b = setBit(cpu.register.b, 5);
		return 0;
	}
	public int OPCBE9() {
		cpu.register.c = setBit(cpu.register.c, 5);
		return 0;
	}
	public int OPCBEA() {
		cpu.register.d = setBit(cpu.register.d, 5);
		return 0;
	}
	public int OPCBEB() {
		cpu.register.e = setBit(cpu.register.e, 5);
		return 0;
	}
	public int OPCBEC() {
		cpu.register.h = setBit(cpu.register.h, 5);
		return 0;
	}
	public int OPCBED() {
		cpu.register.l = setBit(cpu.register.l, 5);
		return 0;
	}
	public int OPCBEE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 5));
		return 0;
	}
	public int OPCBEF() {
		cpu.register.a = setBit(cpu.register.a, 5);
		return 0;
	}
	public int OPCBF0() {
		cpu.register.b = setBit(cpu.register.b, 6);
		return 0;
	}
	public int OPCBF1() {
		cpu.register.c = setBit(cpu.register.c, 6);
		return 0;
	}
	public int OPCBF2() {
		cpu.register.d = setBit(cpu.register.d, 6);
		return 0;
	}
	public int OPCBF3() {
		cpu.register.e = setBit(cpu.register.e, 6);
		return 0;
	}
	public int OPCBF4() {
		cpu.register.h = setBit(cpu.register.h, 6);
		return 0;
	}
	public int OPCBF5() {
		cpu.register.l = setBit(cpu.register.l, 6);
		return 0;
	}
	public int OPCBF6() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 6));
		return 0;
	}
	public int OPCBF7() {
		cpu.register.a = setBit(cpu.register.a, 6);
		return 0;
	}
	public int OPCBF8() {
		cpu.register.b = setBit(cpu.register.b, 7);
		return 0;
	}
	public int OPCBF9() {
		cpu.register.c = setBit(cpu.register.c, 7);
		return 0;
	}
	public int OPCBFA() {
		cpu.register.d = setBit(cpu.register.d, 7);
		return 0;
	}
	public int OPCBFB() {
		cpu.register.e = setBit(cpu.register.e, 7);
		return 0;
	}
	public int OPCBFC() {
		cpu.register.h = setBit(cpu.register.h, 7);
		return 0;
	}
	public int OPCBFD() {
		cpu.register.l = setBit(cpu.register.l, 7);
		return 0;
	}
	public int OPCBFE() {
		byte n = memory.readMemory(cpu.register.hl());
		memory.writeMemory(cpu.register.hl(), setBit(n, 7));
		return 0;
	}
	public int OPCBFF() {
		cpu.register.a = setBit(cpu.register.a, 7);
		return 0;
	}
	public int OPC2() {
		if (!cpu.register.zf) {
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPCA() {
		if (cpu.register.zf) {
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPD2() {
		if (!cpu.register.cf) {
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPDA() {
		if (cpu.register.cf) {
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPE9() {
		cpu.register.pc = cpu.register.hl();
		return 0;
	}
	public int OP18() {
		cpu.register.pc += cpu.getValue8();
		return 0;
	}
	public int OP20() {
		if (!cpu.register.zf) {
			cpu.register.pc += cpu.getValue8();
		}
		return 0;
	}
	public int OP28() {
		if (cpu.register.zf) {
			cpu.register.pc += cpu.getValue8();
		}
		return 0;
	}
	public int OP30() {
		if (!cpu.register.cf) {
			cpu.register.pc += cpu.getValue8();
		}
		return 0;
	}
	public int OP38() {
		if (cpu.register.cf) {
			cpu.register.pc += cpu.getValue8();
		}
		return 0;
	}
	public int OPCD() {
		memory.stackPush((short) (cpu.register.pc));
		cpu.register.pc = cpu.getValue16();
		return 0;
	}
	public int OPC4() {
		if (!cpu.register.zf) {
			memory.stackPush((short) (cpu.register.pc));
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPCC() {
		if (cpu.register.zf) {
			memory.stackPush((short) (cpu.register.pc));
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPD4() {
		if (!cpu.register.cf) {
			memory.stackPush((short) (cpu.register.pc));
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPDC() {
		if (cpu.register.cf) {
			memory.stackPush((short) (cpu.register.pc));
			cpu.register.pc = cpu.getValue16();
		}
		return 0;
	}
	public int OPC9() {
		cpu.register.pc = memory.stackPop();
		return 0;
	}
	public int OPC0() {
		if (!cpu.register.zf) {
			cpu.register.pc = memory.stackPop();
		}
		return 0;
	}
	public int OPC8() {
		if (cpu.register.zf) {
			cpu.register.pc = memory.stackPop();
		}
		return 0;
	}
	public int OPD0() {
		if (!cpu.register.cf) {
			cpu.register.pc = memory.stackPop();
		}
		return 0;
	}
	public int OPD8() {
		if (cpu.register.cf) {
			cpu.register.pc = memory.stackPop();
		}
		return 0;
	}
	public int OPFB() {
		cpu.pendingInterruptEnabled = true;
		return 0;
	}
	public int OPF3() {
		cpu.pendingInterruptEnabled = false;
		return 0;
	}
}
