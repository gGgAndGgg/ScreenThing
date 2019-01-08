import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class W {
	
	private static JFrame previous;
 private static void placeImage(Robot r) {
	
  ImageIcon img = new ImageIcon((r.createScreenCapture(new Rectangle(0,0,(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight())).getScaledInstance((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-20, Image.SCALE_DEFAULT)));
  JFrame f = new JFrame();
  f.setLocation(10, 10);
  f.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setUndecorated(true);
  JPanel pnl = new JPanel();
  JLabel l = new JLabel(img);
  pnl.add(l);
  f.add(pnl);
  f.setVisible(true);
  if(previous!=null){
		 previous.dispose(); 
	 }
  previous = f;
 }
 public static void main(String[] args) {
  Robot r = null;
  
  try {
   r = new Robot();
  } catch (AWTException e) {
   e.printStackTrace();
  }
  for(int i=0;i<500;i++) {
	  try {
		  placeImage(r);
	  }catch(OutOfMemoryError e){
	  break;
  }
  }
  
 }
}
