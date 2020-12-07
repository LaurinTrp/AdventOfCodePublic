package Day7;

import java.util.ArrayList;
import java.util.HashSet;

import Globals.FileReader;

public class Day7 {
	static ArrayList<String> strings = FileReader.getFileContent("Day7//BagsExample"), bag = new ArrayList<>();
	static ArrayList<String[]> stringsArray = new ArrayList<>(), stringsArray2 = new ArrayList<>(), bagContained = new ArrayList<>();
	static ArrayList<Integer[]> ints = new ArrayList<>();
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) {
		String s = "";

		for (String string : strings) {
			s = string.replaceAll("(\\w*)([\\,.])", "").replaceAll("(\\d)", "").replaceAll("bags contain", "");
			stringsArray.add(s.split("(\\s{3})"));
			s = string.replaceAll("bags contain", "").replaceAll("bags", "").replaceAll("([\\,.])", " ").replaceAll("bag", "").strip();
			stringsArray2.add(s.split("(\\s{2,3})"));
		}
		check("shiny gold");
		System.out.println(set.size());
		Integer[] in;
		String[] st;
		for (String[] strings : stringsArray2) {
			bag.add(strings[0]);
			in = new Integer[strings.length-1];
			st = new String[strings.length-1];
			for (int i = 1; i < strings.length; i++) {
				try {
					in[i-1] = Integer.parseInt(strings[i].substring(0, 1));
					st[i-1] = strings[i].substring(2);
				} catch (Exception e) {
					in[i-1] = 0;
				}
			}
			bagContained.add(st);
			ints.add(in);
		}
		
	}
	
	private static void check(String search) {
		for (String[] strings2 : stringsArray) {
			for (int i = 1; i < strings2.length; i++) {
				if(strings2[i].contains(search)) {
					set.add(strings2[0]);
					check(strings2[0]);
				}
			}
		}
	}
}
