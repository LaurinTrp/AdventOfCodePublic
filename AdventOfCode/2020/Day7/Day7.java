package Day7;

import java.util.ArrayList;

import Globals.FileReader;

public class Day7 {
	public static void main(String[] args) {
		ArrayList<String> strings = FileReader.getFileContent("Day7\\Bags");
		System.out.println(strings);
	}
}
