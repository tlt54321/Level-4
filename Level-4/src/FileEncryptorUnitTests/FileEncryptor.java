package FileEncryptorUnitTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileEncryptor {
	public static File openSecretFile(){
			File file = new File("/Users/league/Desktop/Level-4/Level-4/src/FileEncryptorUnitTests/file");
			return file;
	}
	public boolean isFile(){
		return true;
	}
	public static String readOneLine(File file){
		String x = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			x = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}
	public static String readFileContents(File file) throws Exception{
		String x = "";
		String content = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((x = br.readLine()) != null){
			content += x;
		}
		return content;
	}
}
