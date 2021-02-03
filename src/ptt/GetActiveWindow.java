package ptt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GetActiveWindow {

	public static void main(String[] args) {
		    new GetActiveWindow();
		  }
		  
		  public GetActiveWindow()
		  {
		    Runtime runtime = Runtime.getRuntime();
		    String applescriptCommand =  "global frontApp, frontAppName, windowTitle\n"
		    		+ "\n"
		    		+ "set windowTitle to \"\"\n"
		    		+ "tell application \"System Events\"\n"
		    		+ "	set frontApp to first application process whose frontmost is true\n"
		    		+ "	set frontAppName to name of frontApp\n"
		    		+ "	tell process frontAppName\n"
		    		+ "		tell (1st window whose value of attribute \"AXMain\" is true)\n"
		    		+ "			set windowTitle to value of attribute \"AXTitle\"\n"
		    		+ "		end tell\n"
		    		+ "	end tell\n"
		    		+ "end tell\n"
		    		+ "\n"
		    		+ "return {frontAppName, windowTitle}";

		    String[] args = { "osascript", "-e", applescriptCommand };

		    try
		    {
		    Process process = runtime.exec(args);
		    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    	String s = null;
		    	while ((s = stdInput.readLine()) != null) {
		    		System.out.println(s);
		    	}
		    }
		    catch (IOException e)
		    {
		      e.printStackTrace();
		    }
		  }
	}
	