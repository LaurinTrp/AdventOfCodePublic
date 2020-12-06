package Day6;

import java.util.ArrayList;

import Globals.FileReader;

public class Day6 {
	public static void main(String[] args) {
		
		ArrayList<String> strings = FileReader.getFileContent("Day6\\Answers"), answer = new ArrayList<>();
		String lines = "";
		
		for (int i = 0; i < strings.size(); i++) {
			lines = "";
			if (strings.get(i).equals("")) {
				for (int j = i - 1; j > 0; j--) {
					lines += strings.get(j) + " ";
					if (strings.get(j).equals("")) {
						break;
					}
				}
			}
			if (i == strings.size() - 1) {
				for (int j = i; j > 0; j--) {
					lines += strings.get(j) + " ";
					if (strings.get(j).equals("")) {
						break;
					}
				}
			}
			if (!lines.equals("")) {
				answer.add(lines);
			}
		}
		System.out.println(answer);
	}
}
