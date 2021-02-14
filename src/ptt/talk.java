package ptt;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class talk implements NativeKeyListener  {
	public static boolean space = false;
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
	    if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
	        space = true;
	        
	        }
	    }
	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	    if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
	        space = false;
	    }
	}

	public void nativeKeyTyped(NativeKeyEvent e) {}

	public static void main(String[] args) throws InterruptedException {
		String window = GetActiveWindow.GetActive(null);
		System.out.println(window);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new talk());
		
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		logger.setUseParentHandlers(false);
		//below 4 lines is only for testing
		while (true) {
			System.out.println(space);
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}
	
}