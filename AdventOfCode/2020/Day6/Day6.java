package Day6;

import java.util.ArrayList;
import java.util.HashSet;

import Globals.FileReader;

public class Day6 {
	public static void main(String[] args) {

		ArrayList<String> strings = FileReader.getFileContent("Day6\\AnswersExample"), answer = new ArrayList<>();
		ArrayList<String[]> stringArrays = new ArrayList<>();
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
				stringArrays.add(lines.split(" "));
				answer.add(lines.replaceAll(" ", ""));
			}
		}
		HashSet<String> set = new HashSet<>();
		Object[] setArray = null;
		String line = "";
		for (int j = 0; j < answer.size(); j++) {
			set.clear();
			line = "";
			for (int i = 0; i < answer.get(j).length(); i++) {
				set.add(Character.toString(answer.get(j).charAt(i)));
				setArray = set.toArray();
			}
			for (int i = 0; i < setArray.length; i++) {
				line += setArray[i];
			}
			answer.set(j, line);
		}
		int counter = 0;
		for (String string : answer) {
			counter += string.length();
		}
		System.out.println(counter);

		counter = 0;

		for (String[] string : stringArrays) {
			if(string.length > 1) {
				for (int i = 0; i < string.length; i++) {
					System.out.println(string[i]);
				}
			}
//			System.out.println(line);
		}
	}
}
