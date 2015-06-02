package app;

import java.io.*;

public class Main {

	public static void main(String args[]) {
		try {
			if (args.length != 1) {
				System.out.println("error: this program has 1 parameter");
				return;
			}
			String outFilePath = "base64.txt";
			String filePath = args[0];
			FileInputStream f = new FileInputStream(filePath);
			BufferedReader dr = new BufferedReader(new InputStreamReader(f));
			String line = dr.readLine();
			String lineBase64; 
			StringBuffer sbBase64 = new StringBuffer();
			
			while (line != null) {
				if(line.trim().length()<1){
					continue;
				}
				System.out.println(line);
				lineBase64 = getBASE64(line);
				sbBase64.append(lineBase64 + "\n");
				line = dr.readLine();
			}
			writeToTextFile(outFilePath,sbBase64.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void writeToTextFile(String fileName, String str)
			throws IOException {
		// open for append
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
		out.write(str);
		out.close();
	}
	
	public static String getBASE64(String s) { 
		if (s == null) return ""; 
		return (new sun.misc.BASE64Encoder()).encode( s.getBytes() ); 
		} 


}
