package leetcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class S_000_renamefiles {

	public static void main(String[] args) throws IOException {
		File file = new File("./src/leetcode");
		for( File f : file.listFiles()){
			String name = f.getName();
//			if(name.matches("S\\d_.*")){
//				name = "S_00" + name.substring(1);
//				System.out.println(name);
//				f.renameTo(new File("./src/leetcode/" + name));
//			}
			if(name.matches("S_0[1-8]\\d_.*")){
//			if(name.matches("S_089_.*")){
//				System.out.println(name);
				List<String> lines = Files.readAllLines(f.toPath());
				for(int i = 10; i < lines.size(); i++){
					if(lines.get(i).matches(".*"+name.substring(6,name.length()-5)+".*")){
						String str = lines.remove(i).replaceFirst("S_", "S_0");
						System.out.println(str);
//						lines.remove(i);
//						lines.add(i, "public class "+name.substring(0, name.length()-5)+" {");
						lines.add(i,str);
						Files.write(f.toPath(), lines);
					}
					
				}
				
			}
		}
	}

}
