package ptt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyPress {

	public static void main(String[] args){
			try {
				String s = null;
				String[] cmd = {
						"/bin/bash",
						"-c",
						"./script_python"
						};

						Process p = Runtime.getRuntime().exec(cmd);
				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((s = in.readLine()) != null) {
					System.out.println(s);
				}
				}
			catch(IOException ie) {
				ie.printStackTrace();
			}
	}

}
