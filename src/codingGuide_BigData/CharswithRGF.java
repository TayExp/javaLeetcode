package codingGuide_BigData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharswithRGF {

	public static void main(String[] args) throws IOException {
		int r, N = 5000;
		String filePath = "./RGF.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath),true));
		for(int i = 0; i < N; i++){
			r = (int) (Math.random()*3);
			char c = (r==0?'R':(r==1?'G':'F'));
			System.out.println(c);
			writer.write(c);
		}
		writer.close();
	}

}
