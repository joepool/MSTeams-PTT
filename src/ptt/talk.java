package ptt;
//import ptt.KeyPress;
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
		while (true) {
			if (space == true) {
				TimeUnit.MILLISECONDS.sleep(300);
				if (space == true) {
					TimeUnit.MILLISECONDS.sleep(50);
					String window = GetActiveWindow.GetActive(null);
					boolean window_check=(window.contains("eclipse"));
					if (window_check == true) {
						KeyPress.main(null);
					}
					if (space == false) {
						System.out.println("Released");
					}
					//need to stop the forever loop once space == true, then resume it when its =! true again
				}
			}
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}
	
}