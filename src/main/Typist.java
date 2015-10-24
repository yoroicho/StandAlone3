package main;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

	public class Typist {

		private static Robot robot;
		public final static int delayValue = 50; //50;
		
		public Typist(){
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
	    public static void mouseClick(int x, int y){
	    	try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        robot.mouseMove(x, y);
	        robot.mousePress(InputEvent.BUTTON1_MASK);
	        robot.delay(100);
	        robot.mouseRelease(InputEvent.BUTTON1_MASK);
	        robot.delay(100);
	    }
		
	    public static void setTextToClip(String str){
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        StringSelection selection = new StringSelection(str);
	        clipboard.setContents(selection, null);
	      }
	      
	    public static void pasteTextFromClip(){
			robot.delay(delayValue);
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        // CTRL+Z is now pressed (receiving application should see a "key down" event.)
			robot.delay(delayValue);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        // CTRL+Z is now released (receiving application should now see a "key up" event - as well as a "key pressed" event).
	        
	    }
	    
	    public static void boxSkip(int value){
	    	robot.delay(delayValue);
	    	for (int i=0;i<value;i++){
	    		robot.keyPress(KeyEvent.VK_TAB);
	    		robot.delay(delayValue);
	    	}
	    }
	    
	    public static void cursorMove(int value){
	    	robot.delay(delayValue);
	    	switch (value){
	    	case 2 :
	    		System.out.println("2");
	    		robot.keyPress(KeyEvent.VK_DOWN);
	    		break;
	    	case 4 :
	    		System.out.println("4");
	    	
	    	}
	    	
	    		
	    	
	    }
	    
	    public static void saveFile(){
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_S);
	    	
	    	robot.keyRelease(KeyEvent.VK_S);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	
	    }
	    
	    public static void sendKey(String text){
	        for(int i=0; i<text.length(); i++){
	            char c = text.charAt(i);
	            int keycode;
	            
	            switch(c){			
	    		case '0':	
	    			keycode = KeyEvent.VK_0;
	    			break;
	    		case '1':	
	    			keycode = KeyEvent.VK_1;
	    			break;
	    		case '2':	
	    			keycode = KeyEvent.VK_2;
	    			break;
	    		case '3':	
	    			keycode = KeyEvent.VK_3;
	    			break;
	    		case '4':	
	    			keycode = KeyEvent.VK_4;
	    			break;
	    		case '5':	
	    			keycode = KeyEvent.VK_5;
	    			break;
	    		case '6':	
	    			keycode = KeyEvent.VK_6;
	    			break;
	    		case '7':	
	    			keycode = KeyEvent.VK_7;
	    			break;
	    		case '8':	
	    			keycode = KeyEvent.VK_8;
	    			break;
	    		case '9':	
	    			keycode = KeyEvent.VK_9;
	    			break;
	    		default:	
	    			throw new IllegalArgumentException("unsupported : " + c);
	    		}	
	            robot.keyPress(keycode);
	            robot.delay(100);
	        }
	    }
	    
	}


