package Day9;

import java.util.ArrayList;

import Globals.FileReader;

public class Day9 {
	static final int length = 25;
	static ArrayList<String> strings = FileReader.getFileContent("Day9\\Numbers");
	static ArrayList<Integer> ints = new ArrayList<>(), ints2 = new ArrayList<>();
	static int current = length, currentValue = 0, part1Final = 0, counter = 0;
	static int[] counters = {2, 3, 4};
	static boolean found;
	public static void main(String[] args) {
		for (int i = 0; i < strings.size(); i++) {
			method();
			current++;
		}
		for (int i = 0; i < counters.length; i++) {
			for (int k = 0; k < strings.size(); k++) {
				counter = 0;
				for (int j = 0; j < counters[i]; j++) {
					try {
						counter += Integer.parseInt(strings.get(k + j));
					} catch (Exception e) {
					}
				}
				System.out.println(counter + "\t" + counters[i]);
				if(counter == 127) {
					System.err.println(counter);
				}
			}
		}
		
	}
	
	private static void method() {
		try {
			currentValue = Integer.parseInt(strings.get(current));
			search(current);
			ints2.clear();
			for (Integer integer : ints) {
				for (Integer integer2 : ints) {
					if(integer + integer2 == currentValue && integer != integer2 && ints2.size() == 0) {
						ints2.add(integer);
					}
				}
			}
			if(ints2.size() == 0) {
				System.err.println(currentValue);
				part1Final = currentValue;
			}
		} catch (Exception e) {
		}
		
	}
	
	private static void search(int currentLine) {
		ints.clear();
		for (int i = length; i > 0; i--) {
			ints.add(Integer.parseInt(strings.get(currentLine - i)));
		}
	}
	
}
