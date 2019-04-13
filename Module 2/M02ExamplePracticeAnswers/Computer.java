
public class Computer {
	
	private static final int MEGABYTES_IN_GIGABYTE = 1024;
	private static final int MEGABYTES_IN_TERABYTE = MEGABYTES_IN_GIGABYTE * 1024;
		
	private String brand, name;
	private long memoryInMB; // note: you could also represent memory with a String that includes the memory measure: e.g., "1TB" or "126GB"

	public Computer(String initialBrand, String initialName, long initialMemoryInMB) {
		brand = initialBrand;
		name = initialName;
		memoryInMB = initialMemoryInMB;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String newBrand) {
		brand = newBrand;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	public long getMemoryInMB() {
		return memoryInMB;
	}
	public void setMemoryInMB(long newMemoryInMB) {
		if(newMemoryInMB >= 0) {
			memoryInMB = newMemoryInMB;
		} else {
			System.out.println("Invalid memory value.");
		}
	}
	public String toString() {
		return brand + " " + name + " (" + memoryString() + ")";
	}
	
	private String memoryString() {
		String memoryString = "";
		if(numberOfTB()>0) {
			memoryString += numberOfTB() + "TB";
		}
		if(numberOfGBAfterTB()>0) {
			memoryString += " " + numberOfGBAfterTB() + "GB";
		}
		if(numberOfMBLeftOver()>0) {
			memoryString += " " + numberOfMBLeftOver() + "MB";
		}
		return memoryString;
	}
	
	private long numberOfMBLeftOver() {
		return memoryInMB % MEGABYTES_IN_GIGABYTE;
	}
	private long numberOfGBAfterTB() {
		return ( (memoryInMB) % MEGABYTES_IN_TERABYTE)/ MEGABYTES_IN_GIGABYTE;
	}
	private long numberOfTB() {
		return memoryInMB / MEGABYTES_IN_TERABYTE;
	}
	
	public boolean canStoreFile(long fileSizeInMB) {
		return memoryInMB >= fileSizeInMB;
	}
	
	
}
