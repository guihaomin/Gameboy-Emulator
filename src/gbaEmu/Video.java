package gbaEmu;

public class Video {
	Memory memory;
	int[][][] screen = new int[160][144][3];
	boolean[] scanlineBGWhite = new boolean[160];
	public void drawScanLine() {
		byte control = memory.readMemory(0xFF40);
		if (Util.testBit(control, 0)) {
			renderTiles();
		}
		
		if (Util.testBit(control, 1)) {
			renderSprites();
		}
	}
	public void renderSprites() {
		boolean use8x16 = false;
		byte lcdControl = memory.readMemory(0xFF40);
		if (Util.testBit(lcdControl, 2)) {
			use8x16 = true;
		}
		for (int sprite = 0; sprite < 40; sprite++) {
			int index = sprite * 4;
			int yPos = memory.readMemory(0xFE00 + index) - 16;
			int xPos = memory.readMemory(0xFE00 + index + 1) - 8;
			int tileLocation = memory.readMemory(0xFE00 + index + 2);
			byte attributes = memory.readMemory(0xFE00 + index + 3);
			
			boolean yFlip = Util.testBit(attributes, 6);
			boolean xFlip = Util.testBit(attributes, 5);
			boolean priority = Util.testBit(attributes, 7);
			int scanLine = memory.readMemory(0xFF44);
			int ySize = 8;
			if (use8x16) {
				ySize = 16;
			}
			if (scanLine >= yPos && scanLine < yPos + ySize) {
				int line = scanLine - yPos;
				if (yFlip) {
					line -= ySize;
					line *= -1;
				}
				line *= 2;
				int dataAddress = tileLocation * 16 + line;
				byte data1 = memory.readMemory(0x8000 + dataAddress);
				byte data2 = memory.readMemory(0x8000 + dataAddress + 1);
				for (int tilePixel = 7; tilePixel >=0; tilePixel--) {
					int colorBit = tilePixel;
					
					if (xFlip) {
						colorBit -= 7;
						colorBit *= -1;
					}
					byte colorNum = (byte) (Util.getVal(data2, colorBit) << 1);
					colorNum |= Util.getVal(data1, colorBit);
					if (colorNum == 0) {
						continue;
					}
					int colorAddress = 0xFF48;
					if (Util.testBit(attributes, 4)) {
						colorAddress = 0xFF49;
					}
					int color = this.getColor(colorNum, colorAddress);
					int red = 0;
					int green = 0;
					int blue = 0;
					switch (color) {
						case 0:
							red = 255;
							green = 255;
							blue = 255;
						case 1:
							red = 0xCC;
							green = 0xCC;
							blue = 0xCC;
						case 2:
							red = 0x77;
							green = 0x77;
							blue = 0x77;
						default:
							red = 0;
							green = 0;
							blue = 0;
					}
					int xPix = 0 - tilePixel;
					xPix *= -1;
					int pixel = xPos + xPix;
					if (scanLine < 0 || scanLine > 143 || pixel < 0 || pixel > 159) {
						continue;
					}
					if (this.scanlineBGWhite[pixel] || priority) {
						this.screen[pixel][scanLine][0] = red;
						this.screen[pixel][scanLine][1] = green;
						this.screen[pixel][scanLine][2] = blue;
					}
				}
			}
			
		}
	}
	public void renderTiles() {
		boolean unSigned = true;
		int tileData = 0;
		int backgroundMemory = 0;
		byte lcdControl = memory.readMemory(0xFF40);
		byte scrollY = memory.readMemory(0xFF42);
		byte scrollX = memory.readMemory(0xFF43);
		
		byte windowY = memory.readMemory(0xFF4A);
		byte windowX = (byte) (memory.readMemory(0xFF4B) - 7);
		boolean usingWindow = false;
		if (Util.testBit(lcdControl, 5)) {
			if (windowY <= memory.readMemory(0xFF44)) {
				usingWindow = true;
			}
		}
		if (Util.testBit(lcdControl, 4)) {
			tileData = 0x8000;
		} else {
			tileData = 0x8800;
			unSigned = false;
		}
		
		if (!usingWindow) {
			if (Util.testBit(lcdControl, 3)) {
				backgroundMemory = 0x9C00;
			} else {
				backgroundMemory = 0x9800;
			}
		} else {
			if (Util.testBit(lcdControl, 6)) {
				backgroundMemory = 0x9C00;
			} else {
				backgroundMemory = 0x9800;
			}
		}
		
		byte yPos = 0;
		if (!usingWindow) {
			yPos = (byte) (scrollY + memory.readMemory(0xFF44));
		} else {
			yPos = (byte) (memory.readMemory(0xFF44) - windowY);
		}
		int tileRow = (yPos / 8) * 32;
		for (byte pixel = 0; pixel < 160; pixel++) {
			byte xPos = (byte) (pixel + scrollX);
			if (usingWindow) {
				if (pixel >= windowX) {
					xPos = (byte) (pixel - windowX);
				}
			}
			int tileCol = xPos / 8;
			int tileNum;
			int tileAddress = backgroundMemory + tileRow + tileCol;
			if (unSigned) {
				tileNum = memory.readMemory(tileAddress);
			} else {
				tileNum = (int)(byte)memory.readMemory(tileAddress);
			}
			int tileLocation = tileData;
			if (unSigned) {
				tileLocation += tileData * 16;
			} else {
				tileLocation = tileLocation + (tileNum + 128) * 16;
			}
			int line = yPos % 8;
			line *= 2;
			byte data1 = memory.readMemory(tileLocation + line);
			byte data2 = memory.readMemory(tileLocation + line + 1);
			int colorBit = xPos % 8;
			colorBit -= 7;
			colorBit *= -1;
			
			byte colorNum = Util.getVal(data2, colorBit);
			colorNum <<= 1;
			colorNum |= Util.getVal(data1, colorBit);
			int color = getColor(colorNum, 0xFF47);
			int red = 0;
			int green = 0;
			int blue = 0;
			switch (color) {
				case 0:
					red = 255;
					green = 255;
					blue = 255;
				case 1:
					red = 0xCC;
					green = 0xCC;
					blue = 0xCC;
				case 2:
					red = 0x77;
					green = 0x77;
					blue = 0x77;
				default:
					red = 0;
					green = 0;
					blue = 0;
			}
			int yIndex = memory.readMemory(0xFF44);
			if (yIndex < 0 || yIndex > 143 || pixel < 0 || pixel > 159) {
				continue;
			}
			if (color == 0) {
				this.scanlineBGWhite[pixel] = true;
			} else {
				this.scanlineBGWhite[pixel] = false;
			}
			this.screen[pixel][yIndex][0] = red;
			this.screen[pixel][yIndex][1] = green;
			this.screen[pixel][yIndex][2] = blue;
		}
	}
	public int getColor(byte colorNum, int address) {
		int res = 0;
		byte palette = memory.readMemory(address);
		int high;
		int low;
		switch (colorNum) {
			case 0:
				high = 1;
				low = 0;
			case 1:
				high = 3;
				low = 2;
			case 2:
				high = 5;
				low = 4;
			case 3:
				high = 7;
				low = 6;
			default:
				high = 1;
				low = 0;
		}
		byte color = 0;
		color = (byte) (Util.getVal(palette, high) << 1);
		color |= Util.getVal(palette, low);

		switch (color) {
			case 0:
				res = 0;
			case 1:
				res = 1;
			case 2:
				res = 2;
			case 3:
				res = 3;
			default:
				res = 0;
		}
		return res;
	}
}
