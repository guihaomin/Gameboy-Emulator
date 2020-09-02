package gbaEmu;

public final class Log {
	public static void fatalf(String message) {
		System.out.println("Fatal error occur: "+ message);
		System.exit(-1);
	}
}
