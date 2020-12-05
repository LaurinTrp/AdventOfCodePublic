package Globals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
	public static ArrayList<String> getFileContent(String path) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new java.io.FileReader(new File("E:\\Programmieren\\Java\\Wörkbensch\\AdventOfCode\\2020\\" + path)));
			ArrayList<String> strings = new ArrayList<>();
			String line = reader.readLine();
			while (line != null) {
				strings.add(line);
				line = reader.readLine();
			}
			return strings;
		} catch (IOException e) {
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
}
