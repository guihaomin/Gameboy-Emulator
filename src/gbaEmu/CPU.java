package gbaEmu;

import java.util.HashMap;
import java.util.Map;
import gbaEmu.Util;
import gbaEmu.driver.Controller;
import gbaEmu.Log;
public class CPU {
	Util util;
	Controller controller;
	Register register;
	boolean globalInterrupt;
	boolean pendingInterruptEnabled; // this has to be initilized
	boolean halt;
	int fps;
	Memory memory;
	static int clock = 4194304;
	Timer timer;
	Opcodes opcodes;
	Map<Integer, Runnable> opMap;
	Map<Integer, Integer> opCycles;
	public CPU(Memory memory) {
		this.memory = memory;
		this.register = new Register();
		this.timer = new Timer();
	}
	public int executeNextOp() {
		short nextOp = this.register.pc;
		this.register.pc++;
		opMap.get(nextOp).run();
		return opCycles.get(nextOp);
	}
	public void run() throws InterruptedException {
		while (true) {
			update();
			if (controller.updateInput()) {
				requestInterrupt(4);
			}
			Thread.sleep(1000 / this.fps);
		}
	}
	public void update() {
		int cyclesThisUpdate = 0;
		while (cyclesThisUpdate < this.clock / this.fps) {
			int cycles = 4;
			if (!this.halt) {
				cycles = this.executeNextOp();
			}
			cyclesThisUpdate += cycles;
			this.updateTimer(cycles);
			cyclesThisUpdate += this.interrupt();
		}
	}
	public int interrupt() {
		if (this.pendingInterruptEnabled) {
			this.pendingInterruptEnabled = false;
			this.globalInterrupt = true;
			return 0;
		}
		if (!this.globalInterrupt && !this.halt) {
			return 0;
		}
		if (this.globalInterrupt || this.halt) {
			byte req = memory.readMemory(0xFF0F);
			byte enabled = memory.readMemory(0xFFFF);
			if (req > 0) {
				for(int i=0; i<5; i++) {
					if (Util.testBit(req, i)) {
						if(Util.testBit(enabled, i)) {
							this.doInterrupt(i);
							return 20;
						}
					}
				}
			}
		}
		return 0;
	}
	private void doInterrupt(int id) {
		if (!this.globalInterrupt && this.halt) {
			this.halt = false;
			return;
		}
		
		this.globalInterrupt = false;
		this.halt = false;
		byte req = memory.readMemory(0xFF0F);
		req = util.clearBit(req, id);
		memory.writeMemory(0xFF0F, req);
		memory.stackPush(register.pc);
		switch(id) {
		case 0:
			register.pc = 0x40;
			break;
		case 1:
			register.pc = 0x48;
			break;
		case 2:
			register.pc = 0x50;
			break;
		case 3:
			register.pc = 0x58;
			break;
		case 4:
			register.pc = 60;
			break;
		default:
			Log.fatalf("unknown interrupt: " + id);
		}
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
		opMap.put(0x09, () -> opcodes.OP09());
		opCycles.put(0x09, 8);
		opMap.put(0x19, () -> opcodes.OP19());
		opCycles.put(0x19, 8);
		opMap.put(0x29, () -> opcodes.OP29());
		opCycles.put(0x29, 8);
		opMap.put(0x39, () -> opcodes.OP39());
		opCycles.put(0x39, 8);
		opMap.put(0xE8, () -> opcodes.OPE8());
		opCycles.put(0xE8, 16);
		opMap.put(0x03, () -> opcodes.OP03());
		opCycles.put(0x03, 8);
		opMap.put(0x13, () -> opcodes.OP13());
		opCycles.put(0x13, 8);
		opMap.put(0x23, () -> opcodes.OP23());
		opCycles.put(0x23, 8);
		opMap.put(0x33, () -> opcodes.OP33());
		opCycles.put(0x33, 8);
		opMap.put(0x0B, () -> opcodes.OP0B());
		opCycles.put(0x0B, 8);
		opMap.put(0x1B, () -> opcodes.OP1B());
		opCycles.put(0x1B, 8);
		opMap.put(0x2B, () -> opcodes.OP2B());
		opCycles.put(0x2B, 8);
		opMap.put(0x3B, () -> opcodes.OP3B());
		opCycles.put(0x3B, 8);
//		opMap.put(0xCB, () -> opcodes.OPCB());
		opMap.put(0xCB37, () -> opcodes.OPCB37());
		opCycles.put(0xCB37, 12);
		opMap.put(0xCB30, () -> opcodes.OPCB30());
		opCycles.put(0xCB30, 12);
		opMap.put(0xCB31, () -> opcodes.OPCB31());
		opCycles.put(0xCB31, 12);
		opMap.put(0xCB32, () -> opcodes.OPCB32());
		opCycles.put(0xCB32, 12);
		opMap.put(0xCB33, () -> opcodes.OPCB33());
		opCycles.put(0xCB33, 12);
		opMap.put(0xCB34, () -> opcodes.OPCB34());
		opCycles.put(0xCB34, 12);
		opMap.put(0xCB35, () -> opcodes.OPCB35());
		opCycles.put(0xCB35, 12);
		opMap.put(0xCB36, () -> opcodes.OPCB36());
		opCycles.put(0xCB36, 20);
//		opMap.put(0x27, () -> opcodes.OP27());
		opCycles.put(0x27, 4);
		opMap.put(0x2F, () -> opcodes.OP2F());
		opCycles.put(0x2F, 4);
		opMap.put(0x3F, () -> opcodes.OP3F());
		opCycles.put(0x3F, 4);
		opMap.put(0x37, () -> opcodes.OP37());
		opCycles.put(0x37, 4);
		opMap.put(0x00, () -> opcodes.OP00());
		opCycles.put(0x00, 4);
		opMap.put(0x07, () -> opcodes.OP07());
		opCycles.put(0x07, 4);
		opMap.put(0x17, () -> opcodes.OP17());
		opCycles.put(0x17, 4);
		opMap.put(0x0F, () -> opcodes.OP0F());
		opCycles.put(0x0F, 4);
		opMap.put(0x1F, () -> opcodes.OP1F());
		opCycles.put(0x1F, 4);
		opMap.put(0xF3, () -> opcodes.OPF3());
		opCycles.put(0xF3, 4);
		opMap.put(0xFB, () -> opcodes.OPFB());
		opCycles.put(0xFB, 4);
		opMap.put(0xCB07, () -> opcodes.OPCB07());
		opCycles.put(0xCB07, 12);
		opMap.put(0xCB00, () -> opcodes.OPCB00());
		opCycles.put(0xCB00, 12);
		opMap.put(0xCB01, () -> opcodes.OPCB01());
		opCycles.put(0xCB01, 12);
		opMap.put(0xCB02, () -> opcodes.OPCB02());
		opCycles.put(0xCB02, 12);
		opMap.put(0xCB03, () -> opcodes.OPCB03());
		opCycles.put(0xCB03, 12);
		opMap.put(0xCB04, () -> opcodes.OPCB04());
		opCycles.put(0xCB04, 12);
		opMap.put(0xCB05, () -> opcodes.OPCB05());
		opCycles.put(0xCB05, 12);
		opMap.put(0xCB06, () -> opcodes.OPCB06());
		opCycles.put(0xCB06, 20);
		opMap.put(0xCB17, () -> opcodes.OPCB17());
		opCycles.put(0xCB17, 12);
		opMap.put(0xCB10, () -> opcodes.OPCB10());
		opCycles.put(0xCB10, 12);
		opMap.put(0xCB11, () -> opcodes.OPCB11());
		opCycles.put(0xCB11, 12);
		opMap.put(0xCB12, () -> opcodes.OPCB12());
		opCycles.put(0xCB12, 12);
		opMap.put(0xCB13, () -> opcodes.OPCB13());
		opCycles.put(0xCB13, 12);
		opMap.put(0xCB14, () -> opcodes.OPCB14());
		opCycles.put(0xCB14, 12);
		opMap.put(0xCB15, () -> opcodes.OPCB15());
		opCycles.put(0xCB15, 12);
		opMap.put(0xCB16, () -> opcodes.OPCB16());
		opCycles.put(0xCB16, 20);
		opMap.put(0xCB0F, () -> opcodes.OPCB0F());
		opCycles.put(0xCB0F, 12);
		opMap.put(0xCB08, () -> opcodes.OPCB08());
		opCycles.put(0xCB08, 12);
		opMap.put(0xCB09, () -> opcodes.OPCB09());
		opCycles.put(0xCB09, 12);
		opMap.put(0xCB0A, () -> opcodes.OPCB0A());
		opCycles.put(0xCB0A, 12);
		opMap.put(0xCB0B, () -> opcodes.OPCB0B());
		opCycles.put(0xCB0B, 12);
		opMap.put(0xCB0C, () -> opcodes.OPCB0C());
		opCycles.put(0xCB0C, 12);
		opMap.put(0xCB0D, () -> opcodes.OPCB0D());
		opCycles.put(0xCB0D, 12);
		opMap.put(0xCB0E, () -> opcodes.OPCB0E());
		opCycles.put(0xCB0E, 20);
		opMap.put(0xCB1F, () -> opcodes.OPCB1F());
		opCycles.put(0xCB1F, 12);
		opMap.put(0xCB18, () -> opcodes.OPCB18());
		opCycles.put(0xCB18, 12);
		opMap.put(0xCB19, () -> opcodes.OPCB19());
		opCycles.put(0xCB19, 12);
		opMap.put(0xCB1A, () -> opcodes.OPCB1A());
		opCycles.put(0xCB1A, 12);
		opMap.put(0xCB1B, () -> opcodes.OPCB1B());
		opCycles.put(0xCB1B, 12);
		opMap.put(0xCB1C, () -> opcodes.OPCB1C());
		opCycles.put(0xCB1C, 12);
		opMap.put(0xCB1D, () -> opcodes.OPCB1D());
		opCycles.put(0xCB1D, 12);
		opMap.put(0xCB1E, () -> opcodes.OPCB1E());
		opCycles.put(0xCB1E, 20);
		opMap.put(0xCB27, () -> opcodes.OPCB27());
		opCycles.put(0xCB27, 12);
		opMap.put(0xCB20, () -> opcodes.OPCB20());
		opCycles.put(0xCB20, 12);
		opMap.put(0xCB21, () -> opcodes.OPCB21());
		opCycles.put(0xCB21, 12);
		opMap.put(0xCB22, () -> opcodes.OPCB22());
		opCycles.put(0xCB22, 12);
		opMap.put(0xCB23, () -> opcodes.OPCB23());
		opCycles.put(0xCB23, 12);
		opMap.put(0xCB24, () -> opcodes.OPCB24());
		opCycles.put(0xCB24, 12);
		opMap.put(0xCB25, () -> opcodes.OPCB25());
		opCycles.put(0xCB25, 12);
		opMap.put(0xCB26, () -> opcodes.OPCB26());
		opCycles.put(0xCB26, 20);
		opMap.put(0xCB2F, () -> opcodes.OPCB2F());
		opCycles.put(0xCB2F, 12);
		opMap.put(0xCB28, () -> opcodes.OPCB28());
		opCycles.put(0xCB28, 12);
		opMap.put(0xCB29, () -> opcodes.OPCB29());
		opCycles.put(0xCB29, 12);
		opMap.put(0xCB2A, () -> opcodes.OPCB2A());
		opCycles.put(0xCB2A, 12);
		opMap.put(0xCB2B, () -> opcodes.OPCB2B());
		opCycles.put(0xCB2B, 12);
		opMap.put(0xCB2C, () -> opcodes.OPCB2C());
		opCycles.put(0xCB2C, 12);
		opMap.put(0xCB2D, () -> opcodes.OPCB2D());
		opCycles.put(0xCB2D, 12);
		opMap.put(0xCB2E, () -> opcodes.OPCB2E());
		opCycles.put(0xCB2E, 20);
		opMap.put(0xCB3F, () -> opcodes.OPCB3F());
		opCycles.put(0xCB3F, 12);
		opMap.put(0xCB38, () -> opcodes.OPCB38());
		opCycles.put(0xCB38, 12);
		opMap.put(0xCB39, () -> opcodes.OPCB39());
		opCycles.put(0xCB39, 12);
		opMap.put(0xCB3A, () -> opcodes.OPCB3A());
		opCycles.put(0xCB3A, 12);
		opMap.put(0xCB3B, () -> opcodes.OPCB3B());
		opCycles.put(0xCB3B, 12);
		opMap.put(0xCB3C, () -> opcodes.OPCB3C());
		opCycles.put(0xCB3C, 12);
		opMap.put(0xCB3D, () -> opcodes.OPCB3D());
		opCycles.put(0xCB3D, 12);
		opMap.put(0xCB3E, () -> opcodes.OPCB3E());
		opCycles.put(0xCB3E, 20);
		opMap.put(0xCB47, () -> opcodes.OPCB47());
		opCycles.put(0xCB47, 12);
		opMap.put(0xCB40, () -> opcodes.OPCB40());
		opCycles.put(0xCB40, 12);
		opMap.put(0xCB41, () -> opcodes.OPCB41());
		opCycles.put(0xCB41, 12);
		opMap.put(0xCB42, () -> opcodes.OPCB42());
		opCycles.put(0xCB42, 12);
		opMap.put(0xCB43, () -> opcodes.OPCB43());
		opCycles.put(0xCB43, 12);
		opMap.put(0xCB44, () -> opcodes.OPCB44());
		opCycles.put(0xCB44, 12);
		opMap.put(0xCB45, () -> opcodes.OPCB45());
		opCycles.put(0xCB45, 12);
		opMap.put(0xCB46, () -> opcodes.OPCB46());
		opCycles.put(0xCB46, 20);
		opMap.put(0xCB47, () -> opcodes.OPCB47());
		opCycles.put(0xCB47, 12);
		opMap.put(0xCB48, () -> opcodes.OPCB48());
		opCycles.put(0xCB48, 12);
		opMap.put(0xCB49, () -> opcodes.OPCB49());
		opCycles.put(0xCB49, 12);
		opMap.put(0xCB4A, () -> opcodes.OPCB4A());
		opCycles.put(0xCB4A, 12);
		opMap.put(0xCB4B, () -> opcodes.OPCB4B());
		opCycles.put(0xCB4B, 12);
		opMap.put(0xCB4C, () -> opcodes.OPCB4C());
		opCycles.put(0xCB4C, 12);
		opMap.put(0xCB4D, () -> opcodes.OPCB4D());
		opCycles.put(0xCB4D, 12);
		opMap.put(0xCB4E, () -> opcodes.OPCB4E());
		opCycles.put(0xCB4E, 20);
		opMap.put(0xCB4F, () -> opcodes.OPCB4F());
		opCycles.put(0xCB4F, 12);
		opMap.put(0xCB50, () -> opcodes.OPCB50());
		opCycles.put(0xCB50, 12);
		opMap.put(0xCB51, () -> opcodes.OPCB51());
		opCycles.put(0xCB51, 12);
		opMap.put(0xCB52, () -> opcodes.OPCB52());
		opCycles.put(0xCB52, 12);
		opMap.put(0xCB53, () -> opcodes.OPCB53());
		opCycles.put(0xCB53, 12);
		opMap.put(0xCB54, () -> opcodes.OPCB54());
		opCycles.put(0xCB54, 12);
		opMap.put(0xCB55, () -> opcodes.OPCB55());
		opCycles.put(0xCB55, 12);
		opMap.put(0xCB56, () -> opcodes.OPCB56());
		opCycles.put(0xCB56, 20);
		opMap.put(0xCB57, () -> opcodes.OPCB57());
		opCycles.put(0xCB57, 12);
		opMap.put(0xCB58, () -> opcodes.OPCB58());
		opCycles.put(0xCB58, 12);
		opMap.put(0xCB59, () -> opcodes.OPCB59());
		opCycles.put(0xCB59, 12);
		opMap.put(0xCB5A, () -> opcodes.OPCB5A());
		opCycles.put(0xCB5A, 12);
		opMap.put(0xCB5B, () -> opcodes.OPCB5B());
		opCycles.put(0xCB5B, 12);
		opMap.put(0xCB5C, () -> opcodes.OPCB5C());
		opCycles.put(0xCB5C, 12);
		opMap.put(0xCB5D, () -> opcodes.OPCB5D());
		opCycles.put(0xCB5D, 12);
		opMap.put(0xCB5E, () -> opcodes.OPCB5E());
		opCycles.put(0xCB5E, 20);
		opMap.put(0xCB5F, () -> opcodes.OPCB5F());
		opCycles.put(0xCB5F, 12);
		opMap.put(0xCB60, () -> opcodes.OPCB60());
		opCycles.put(0xCB60, 12);
		opMap.put(0xCB61, () -> opcodes.OPCB61());
		opCycles.put(0xCB61, 12);
		opMap.put(0xCB62, () -> opcodes.OPCB62());
		opCycles.put(0xCB62, 12);
		opMap.put(0xCB63, () -> opcodes.OPCB63());
		opCycles.put(0xCB63, 12);
		opMap.put(0xCB64, () -> opcodes.OPCB64());
		opCycles.put(0xCB64, 12);
		opMap.put(0xCB65, () -> opcodes.OPCB65());
		opCycles.put(0xCB65, 12);
		opMap.put(0xCB66, () -> opcodes.OPCB66());
		opCycles.put(0xCB66, 20);
		opMap.put(0xCB67, () -> opcodes.OPCB67());
		opCycles.put(0xCB67, 12);
		opMap.put(0xCB68, () -> opcodes.OPCB68());
		opCycles.put(0xCB68, 12);
		opMap.put(0xCB69, () -> opcodes.OPCB69());
		opCycles.put(0xCB69, 12);
		opMap.put(0xCB6A, () -> opcodes.OPCB6A());
		opCycles.put(0xCB6A, 12);
		opMap.put(0xCB6B, () -> opcodes.OPCB6B());
		opCycles.put(0xCB6B, 12);
		opMap.put(0xCB6C, () -> opcodes.OPCB6C());
		opCycles.put(0xCB6C, 12);
		opMap.put(0xCB6D, () -> opcodes.OPCB6D());
		opCycles.put(0xCB6D, 12);
		opMap.put(0xCB6E, () -> opcodes.OPCB6E());
		opCycles.put(0xCB6E, 20);
		opMap.put(0xCB6F, () -> opcodes.OPCB6F());
		opCycles.put(0xCB6F, 12);
		opMap.put(0xCB70, () -> opcodes.OPCB70());
		opCycles.put(0xCB70, 12);
		opMap.put(0xCB71, () -> opcodes.OPCB71());
		opCycles.put(0xCB71, 12);
		opMap.put(0xCB72, () -> opcodes.OPCB72());
		opCycles.put(0xCB72, 12);
		opMap.put(0xCB73, () -> opcodes.OPCB73());
		opCycles.put(0xCB73, 12);
		opMap.put(0xCB74, () -> opcodes.OPCB74());
		opCycles.put(0xCB74, 12);
		opMap.put(0xCB75, () -> opcodes.OPCB75());
		opCycles.put(0xCB75, 12);
		opMap.put(0xCB76, () -> opcodes.OPCB76());
		opCycles.put(0xCB76, 20);
		opMap.put(0xCB77, () -> opcodes.OPCB77());
		opCycles.put(0xCB77, 12);
		opMap.put(0xCB78, () -> opcodes.OPCB78());
		opCycles.put(0xCB78, 12);
		opMap.put(0xCB79, () -> opcodes.OPCB79());
		opCycles.put(0xCB79, 12);
		opMap.put(0xCB7A, () -> opcodes.OPCB7A());
		opCycles.put(0xCB7A, 12);
		opMap.put(0xCB7B, () -> opcodes.OPCB7B());
		opCycles.put(0xCB7B, 12);
		opMap.put(0xCB7C, () -> opcodes.OPCB7C());
		opCycles.put(0xCB7C, 12);
		opMap.put(0xCB7D, () -> opcodes.OPCB7D());
		opCycles.put(0xCB7D, 12);
		opMap.put(0xCB7E, () -> opcodes.OPCB7E());
		opCycles.put(0xCB7E, 20);
		opMap.put(0xCB7F, () -> opcodes.OPCB7F());
		opCycles.put(0xCB7F, 12);
		opMap.put(0xCB80, () -> opcodes.OPCB80());
		opCycles.put(0xCB80, 12);
		opMap.put(0xCB81, () -> opcodes.OPCB81());
		opCycles.put(0xCB81, 12);
		opMap.put(0xCB82, () -> opcodes.OPCB82());
		opCycles.put(0xCB82, 12);
		opMap.put(0xCB83, () -> opcodes.OPCB83());
		opCycles.put(0xCB83, 12);
		opMap.put(0xCB84, () -> opcodes.OPCB84());
		opCycles.put(0xCB84, 12);
		opMap.put(0xCB85, () -> opcodes.OPCB85());
		opCycles.put(0xCB85, 12);
		opMap.put(0xCB86, () -> opcodes.OPCB86());
		opCycles.put(0xCB86, 20);
		opMap.put(0xCB87, () -> opcodes.OPCB87());
		opCycles.put(0xCB87, 12);
		opMap.put(0xCB88, () -> opcodes.OPCB88());
		opCycles.put(0xCB88, 12);
		opMap.put(0xCB89, () -> opcodes.OPCB89());
		opCycles.put(0xCB89, 12);
		opMap.put(0xCB8A, () -> opcodes.OPCB8A());
		opCycles.put(0xCB8A, 12);
		opMap.put(0xCB8B, () -> opcodes.OPCB8B());
		opCycles.put(0xCB8B, 12);
		opMap.put(0xCB8C, () -> opcodes.OPCB8C());
		opCycles.put(0xCB8C, 12);
		opMap.put(0xCB8D, () -> opcodes.OPCB8D());
		opCycles.put(0xCB8D, 12);
		opMap.put(0xCB8E, () -> opcodes.OPCB8E());
		opCycles.put(0xCB8E, 20);
		opMap.put(0xCB8F, () -> opcodes.OPCB8F());
		opCycles.put(0xCB8F, 12);
		opMap.put(0xCB90, () -> opcodes.OPCB90());
		opCycles.put(0xCB90, 12);
		opMap.put(0xCB91, () -> opcodes.OPCB91());
		opCycles.put(0xCB91, 12);
		opMap.put(0xCB92, () -> opcodes.OPCB92());
		opCycles.put(0xCB92, 12);
		opMap.put(0xCB93, () -> opcodes.OPCB93());
		opCycles.put(0xCB93, 12);
		opMap.put(0xCB94, () -> opcodes.OPCB94());
		opCycles.put(0xCB94, 12);
		opMap.put(0xCB95, () -> opcodes.OPCB95());
		opCycles.put(0xCB95, 12);
		opMap.put(0xCB96, () -> opcodes.OPCB96());
		opCycles.put(0xCB96, 20);
		opMap.put(0xCB97, () -> opcodes.OPCB97());
		opCycles.put(0xCB97, 12);
		opMap.put(0xCB98, () -> opcodes.OPCB98());
		opCycles.put(0xCB98, 12);
		opMap.put(0xCB99, () -> opcodes.OPCB99());
		opCycles.put(0xCB99, 12);
		opMap.put(0xCB9A, () -> opcodes.OPCB9A());
		opCycles.put(0xCB9A, 12);
		opMap.put(0xCB9B, () -> opcodes.OPCB9B());
		opCycles.put(0xCB9B, 12);
		opMap.put(0xCB9C, () -> opcodes.OPCB9C());
		opCycles.put(0xCB9C, 12);
		opMap.put(0xCB9D, () -> opcodes.OPCB9D());
		opCycles.put(0xCB9D, 12);
		opMap.put(0xCB9E, () -> opcodes.OPCB9E());
		opCycles.put(0xCB9E, 20);
		opMap.put(0xCB9F, () -> opcodes.OPCB9F());
		opCycles.put(0xCB9F, 12);
		opMap.put(0xCBA0, () -> opcodes.OPCBA0());
		opCycles.put(0xCBA0, 12);
		opMap.put(0xCBA1, () -> opcodes.OPCBA1());
		opCycles.put(0xCBA1, 12);
		opMap.put(0xCBA2, () -> opcodes.OPCBA2());
		opCycles.put(0xCBA2, 12);
		opMap.put(0xCBA3, () -> opcodes.OPCBA3());
		opCycles.put(0xCBA3, 12);
		opMap.put(0xCBA4, () -> opcodes.OPCBA4());
		opCycles.put(0xCBA4, 12);
		opMap.put(0xCBA5, () -> opcodes.OPCBA5());
		opCycles.put(0xCBA5, 12);
		opMap.put(0xCBA6, () -> opcodes.OPCBA6());
		opCycles.put(0xCBA6, 20);
		opMap.put(0xCBA7, () -> opcodes.OPCBA7());
		opCycles.put(0xCBA7, 12);
		opMap.put(0xCBA8, () -> opcodes.OPCBA8());
		opCycles.put(0xCBA8, 12);
		opMap.put(0xCBA9, () -> opcodes.OPCBA9());
		opCycles.put(0xCBA9, 12);
		opMap.put(0xCBAA, () -> opcodes.OPCBAA());
		opCycles.put(0xCBAA, 12);
		opMap.put(0xCBAB, () -> opcodes.OPCBAB());
		opCycles.put(0xCBAB, 12);
		opMap.put(0xCBAC, () -> opcodes.OPCBAC());
		opCycles.put(0xCBAC, 12);
		opMap.put(0xCBAD, () -> opcodes.OPCBAD());
		opCycles.put(0xCBAD, 12);
		opMap.put(0xCBAE, () -> opcodes.OPCBAE());
		opCycles.put(0xCBAE, 20);
		opMap.put(0xCBAF, () -> opcodes.OPCBAF());
		opCycles.put(0xCBAF, 12);
		opMap.put(0xCBB0, () -> opcodes.OPCBB0());
		opCycles.put(0xCBB0, 12);
		opMap.put(0xCBB1, () -> opcodes.OPCBB1());
		opCycles.put(0xCBB1, 12);
		opMap.put(0xCBB2, () -> opcodes.OPCBB2());
		opCycles.put(0xCBB2, 12);
		opMap.put(0xCBB3, () -> opcodes.OPCBB3());
		opCycles.put(0xCBB3, 12);
		opMap.put(0xCBB4, () -> opcodes.OPCBB4());
		opCycles.put(0xCBB4, 12);
		opMap.put(0xCBB5, () -> opcodes.OPCBB5());
		opCycles.put(0xCBB5, 12);
		opMap.put(0xCBB6, () -> opcodes.OPCBB6());
		opCycles.put(0xCBB0, 20);
		opMap.put(0xCBB7, () -> opcodes.OPCBB7());
		opCycles.put(0xCBB7, 12);
		opMap.put(0xCBB8, () -> opcodes.OPCBB8());
		opCycles.put(0xCBB8, 12);
		opMap.put(0xCBB9, () -> opcodes.OPCBB9());
		opCycles.put(0xCBB9, 12);
		opMap.put(0xCBBA, () -> opcodes.OPCBBA());
		opCycles.put(0xCBBA, 12);
		opMap.put(0xCBBB, () -> opcodes.OPCBBB());
		opCycles.put(0xCBBB, 12);
		opMap.put(0xCBBC, () -> opcodes.OPCBBC());
		opCycles.put(0xCBBC, 12);
		opMap.put(0xCBBD, () -> opcodes.OPCBBD());
		opCycles.put(0xCBBD, 12);
		opMap.put(0xCBBE, () -> opcodes.OPCBBE());
		opCycles.put(0xCBBE, 20);
		opMap.put(0xCBBF, () -> opcodes.OPCBBF());
		opCycles.put(0xCBBF, 12);
		opMap.put(0xCBC0, () -> opcodes.OPCBC0());
		opCycles.put(0xCBC0, 12);
		opMap.put(0xCBC1, () -> opcodes.OPCBC1());
		opCycles.put(0xCBC1, 12);
		opMap.put(0xCBC2, () -> opcodes.OPCBC2());
		opCycles.put(0xCBC2, 12);
		opMap.put(0xCBC3, () -> opcodes.OPCBC3());
		opCycles.put(0xCBC3, 12);
		opMap.put(0xCBC4, () -> opcodes.OPCBC4());
		opCycles.put(0xCBC4, 12);
		opMap.put(0xCBC5, () -> opcodes.OPCBC5());
		opCycles.put(0xCBC5, 12);
		opMap.put(0xCBC6, () -> opcodes.OPCBC6());
		opCycles.put(0xCBC6, 20);
		opMap.put(0xCBC7, () -> opcodes.OPCBC7());
		opCycles.put(0xCBC7, 12);
		opMap.put(0xCBC8, () -> opcodes.OPCBC8());
		opCycles.put(0xCBC8, 12);
		opMap.put(0xCBC9, () -> opcodes.OPCBC9());
		opCycles.put(0xCBC9, 12);
		opMap.put(0xCBCA, () -> opcodes.OPCBCA());
		opCycles.put(0xCBCA, 12);
		opMap.put(0xCBCB, () -> opcodes.OPCBCB());
		opCycles.put(0xCBCB, 12);
		opMap.put(0xCBCC, () -> opcodes.OPCBCC());
		opCycles.put(0xCBCC, 12);
		opMap.put(0xCBCD, () -> opcodes.OPCBCD());
		opCycles.put(0xCBCD, 12);
		opMap.put(0xCBCE, () -> opcodes.OPCBCE());
		opCycles.put(0xCBCE, 20);
		opMap.put(0xCBCF, () -> opcodes.OPCBCF());
		opCycles.put(0xCBCF, 12);
		opMap.put(0xCBD0, () -> opcodes.OPCBD0());
		opCycles.put(0xCBD0, 12);
		opMap.put(0xCBD1, () -> opcodes.OPCBD1());
		opCycles.put(0xCBD1, 12);
		opMap.put(0xCBD2, () -> opcodes.OPCBD2());
		opCycles.put(0xCBD2, 12);
		opMap.put(0xCBD3, () -> opcodes.OPCBD3());
		opCycles.put(0xCBD3, 12);
		opMap.put(0xCBD4, () -> opcodes.OPCBD4());
		opCycles.put(0xCBD4, 12);
		opMap.put(0xCBD5, () -> opcodes.OPCBD5());
		opCycles.put(0xCBD5, 12);
		opMap.put(0xCBD6, () -> opcodes.OPCBD6());
		opCycles.put(0xCBD6, 20);
		opMap.put(0xCBD7, () -> opcodes.OPCBD7());
		opCycles.put(0xCBD7, 12);
		opMap.put(0xCBD8, () -> opcodes.OPCBD8());
		opCycles.put(0xCBD8, 12);
		opMap.put(0xCBD9, () -> opcodes.OPCBD9());
		opCycles.put(0xCBD9, 12);
		opMap.put(0xCBDA, () -> opcodes.OPCBDA());
		opCycles.put(0xCBDA, 12);
		opMap.put(0xCBDB, () -> opcodes.OPCBDB());
		opCycles.put(0xCBDB, 12);
		opMap.put(0xCBDC, () -> opcodes.OPCBDC());
		opCycles.put(0xCBDC, 12);
		opMap.put(0xCBDD, () -> opcodes.OPCBDD());
		opCycles.put(0xCBDD, 12);
		opMap.put(0xCBDE, () -> opcodes.OPCBDE());
		opCycles.put(0xCBDE, 20);
		opMap.put(0xCBDF, () -> opcodes.OPCBDF());
		opCycles.put(0xCBDF, 12);
		opMap.put(0xCBE0, () -> opcodes.OPCBE0());
		opCycles.put(0xCBE0, 12);
		opMap.put(0xCBE1, () -> opcodes.OPCBE1());
		opCycles.put(0xCBE1, 12);
		opMap.put(0xCBE2, () -> opcodes.OPCBE2());
		opCycles.put(0xCBE2, 12);
		opMap.put(0xCBE3, () -> opcodes.OPCBE3());
		opCycles.put(0xCBE3, 12);
		opMap.put(0xCBE4, () -> opcodes.OPCBE4());
		opCycles.put(0xCBE4, 12);
		opMap.put(0xCBE5, () -> opcodes.OPCBE5());
		opCycles.put(0xCBE5, 12);
		opMap.put(0xCBE6, () -> opcodes.OPCBE6());
		opCycles.put(0xCBE6, 20);
		opMap.put(0xCBE7, () -> opcodes.OPCBE7());
		opCycles.put(0xCBE7, 12);
		opMap.put(0xCBE8, () -> opcodes.OPCBE8());
		opCycles.put(0xCBE8, 12);
		opMap.put(0xCBE9, () -> opcodes.OPCBE9());
		opCycles.put(0xCBE9, 12);
		opMap.put(0xCBEA, () -> opcodes.OPCBEA());
		opCycles.put(0xCBEA, 12);
		opMap.put(0xCBEB, () -> opcodes.OPCBEB());
		opCycles.put(0xCBEB, 12);
		opMap.put(0xCBEC, () -> opcodes.OPCBEC());
		opCycles.put(0xCBEC, 12);
		opMap.put(0xCBED, () -> opcodes.OPCBED());
		opCycles.put(0xCBED, 12);
		opMap.put(0xCBEE, () -> opcodes.OPCBEE());
		opCycles.put(0xCBEE, 20);
		opMap.put(0xCBEF, () -> opcodes.OPCBEF());
		opCycles.put(0xCBEF, 12);
		opMap.put(0xCBF0, () -> opcodes.OPCBF0());
		opCycles.put(0xCBF0, 12);
		opMap.put(0xCBF1, () -> opcodes.OPCBF1());
		opCycles.put(0xCBF1, 12);
		opMap.put(0xCBF2, () -> opcodes.OPCBF2());
		opCycles.put(0xCBF2, 12);
		opMap.put(0xCBF3, () -> opcodes.OPCBF3());
		opCycles.put(0xCBF3, 12);
		opMap.put(0xCBF4, () -> opcodes.OPCBF4());
		opCycles.put(0xCBF4, 12);
		opMap.put(0xCBF5, () -> opcodes.OPCBF5());
		opCycles.put(0xCBF5, 12);
		opMap.put(0xCBF6, () -> opcodes.OPCBF6());
		opCycles.put(0xCBF6, 20);
		opMap.put(0xCBF7, () -> opcodes.OPCBF7());
		opCycles.put(0xCBF7, 12);
		opMap.put(0xCBF8, () -> opcodes.OPCBF8());
		opCycles.put(0xCBF8, 12);
		opMap.put(0xCBF9, () -> opcodes.OPCBF9());
		opCycles.put(0xCBF9, 12);
		opMap.put(0xCBFA, () -> opcodes.OPCBFA());
		opCycles.put(0xCBFA, 12);
		opMap.put(0xCBFB, () -> opcodes.OPCBFB());
		opCycles.put(0xCBFB, 12);
		opMap.put(0xCBFC, () -> opcodes.OPCBFC());
		opCycles.put(0xCBFC, 12);
		opMap.put(0xCBFD, () -> opcodes.OPCBFD());
		opCycles.put(0xCBFD, 12);
		opMap.put(0xCBFE, () -> opcodes.OPCBFE());
		opCycles.put(0xCBFE, 20);
		opMap.put(0xCBFF, () -> opcodes.OPCBFF());
		opCycles.put(0xCBFF, 12);
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
	public byte getCoreFreq() {
		return (byte) (this.memory.readMemory(0xFF07) & (byte) 0x3);
	}
	public int getCoreFreqCount() {
		switch (this.getCoreFreq()) {
		case 0:
			return 1024;
		case 1:
			return 16;
		case 2:
			return 64;
		case 3:
			return 256;
		default:
			return 1024;
		}
	}
	public boolean isClockEnabled() {
		if ((this.memory.readMemory(0xFF07) & 0x04) == 0x04) {
			return true;
		}
		return false;
	}
	public void updateDividerRegister(int cycles) {
		this.timer.dividerRegister += cycles;
		if (this.timer.dividerRegister >= 255) {
			this.timer.dividerRegister = 0;
			this.memory.memoryIncrement(0xFF04);
		}
	}
	public void requestInterrupt(int id) {
		byte req = this.memory.readMemory(0xFF0F);
		req = Util.setBit(req, id);
		this.memory.writeMemory(0xFF0F, req);
	}
	public void updateTimer(int cycles) {
		this.updateDividerRegister(cycles);
		if (this.isClockEnabled()) {
			this.timer.timerCounter += cycles;
			if (this.timer.timerCounter >= this.getCoreFreq()) {
				this.zeroTimerCounter();
			}
			if (this.memory.readMemory(0xFF05) == 255) {
				this.memory.writeMemory(0xFF05, this.memory.readMemory(0xFF06));
				this.requestInterrupt(2);
			} else {
				this.memory.writeMemory(0xFF05, (byte) (this.memory.readMemory(0xFF05) + 1));
			}
		}
	}
	public void zeroTimerCounter() {
		this.timer.timerCounter = 0;
	}
}
