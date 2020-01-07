package gbaEmu;

public class Register {
	byte a,b,c,d,e,f,h,l; //int can cause problem because register is 8-bit.
	boolean zf, nf, hf, cf;
	int pc, sp;
	public int af() {
		return a << 8 | f;
	}
	public int hl() {
		return h << 8 | l;
	}
	public int bc() {
		return b << 8 | c;
	}
	public int de() {
		return d << 8 | e;
	}
}
