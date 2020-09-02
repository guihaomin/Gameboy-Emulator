package gbaEmu.driver;

import java.util.HashMap;
import java.util.Map;

import gbaEmu.Util;

public class Controller {
	private static long nanoToMilliConvertionRate = 1000000;
	Util util;
	public byte inputStatus;
	KeyMap[] keyMap = new KeyMap[8];
	private Map<String, Integer> keyStringMap = new HashMap<>();
	public void initStatus(byte status) {
		this.inputStatus = status;
		keyStringMap.put("Right", 0);
		keyStringMap.put("Left", 1);
		keyStringMap.put("Up", 2);
		keyStringMap.put("Down", 3);
		keyStringMap.put("A", 4);
		keyStringMap.put("B", 5);
		keyStringMap.put("Select", 6);
		keyStringMap.put("Start", 7);
	}

	public boolean updateInput() {
		boolean requestInterrupt = false;
		byte inputStatusCopy;
		inputStatusCopy = inputStatus;
		long currentTime = System.nanoTime() / nanoToMilliConvertionRate;
		for (int i = 0; i < keyMap.length; i++) {
			if (currentTime - keyMap[i].lastPressed <= 200) {
				util.clearBit(inputStatusCopy, i);
				if (currentTime - keyMap[i].lastChecked <= 100) {
					requestInterrupt = true;
				}
				keyMap[i].lastChecked = currentTime;
			} else {
				util.setBit(inputStatusCopy, i);
			}
		}
		this.inputStatus = inputStatusCopy;
		return requestInterrupt;
	}

	public void newInput(String data) {
		int keyId = keyStringMap.get(data);
		long currentTime = System.nanoTime() / nanoToMilliConvertionRate;
		keyMap[keyId].lastPressed = currentTime;
	}
}
