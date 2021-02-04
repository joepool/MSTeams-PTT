package ptt;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener  {
	public void nativeKeyPressed(NativeKeyEvent e) {
		String keypressed =(NativeKeyEvent.getKeyText(e.getKeyCode()));
		if (keypressed == "Space") {
			System.out.println("space pressed");
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		String keyreleased =(NativeKeyEvent.getKeyText(e.getKeyCode()));
		if (keyreleased == "Space") {
			System.out.println("space released");
		}
	}
	public void nativeKeyTyped(NativeKeyEvent e) {}

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
		
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		logger.setUseParentHandlers(false);
	}
	
}