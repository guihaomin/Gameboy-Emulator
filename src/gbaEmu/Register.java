package gbaEmu;

public class Register {
	byte a,b,c,d,e,f,h,l; //int can cause problem because register is 8-bit.
	boolean zf, nf, hf, cf;
	short pc, sp;
	public short af() {
		return (short) (a << 8 | f);
	}
	public short hl() {
		return (short) (h << 8 | l);
	}
	public short bc() {
		return (short) (b << 8 | c);
	}
	public short de() {
		return (short) (d << 8 | e);
	}
}
