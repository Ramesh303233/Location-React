package udemy.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataRead1 {

	public static void main(String[] args) throws IOException {
		try {
		FileReader fr = new FileReader("D:\\Hibernate Books\\jsondata12");
		
		BufferedReader br = new BufferedReader(fr);

		int i;
		while ((i = br.read()) != -1) {
			System.out.print((char) i);
		}
		
		
		br.close();
		fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
