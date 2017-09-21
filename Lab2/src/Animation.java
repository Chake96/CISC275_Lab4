//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
//Carson Hake

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

    final int frameCount = 10;
    int picNum = 1;
    BufferedImage[] pics;
    static ArrayList<BufferedImage[]> orcs; //to hold multiple image sequences
    int xloc = imgWidth;
    int yloc = 0;
    int xIncr = 8;
    int yIncr = 2;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    
    public static JFrame frame;

    @Override
    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount; //0 : SE , 1 NW, 2 SW, 3 NE, 4 W, 5 E, 6 S, 7 N
    	
    	if(xloc <= 0 || xloc > frameWidth - imgWidth) { //meet wall -> flip direction
    		xIncr *= -1;
    	}
    	if(yloc < 0 || yloc > frameHeight - imgHeight){ //meet wall -> flip direction
    		yIncr *= -1;
    	}
    	
    	BufferedImage[] orc = null; 
    	
    	//image selection based on direction of acceleration
    	if(yIncr > 0){
    		//north
    		if(xIncr == 0) orc = orcs.get(7); //north
    		else if(xIncr > 0) orc = orcs.get(0); //north east
    		else orc = orcs.get(2); //north west
    	}else{
    		//south
    		if(xIncr == 0 && yIncr == 0) orc = orcs.get(5); //non-moving - East
    		else if(xIncr > 0) orc = orcs.get(3); //south-east
    		else if(xIncr < 0) orc = orcs.get(1); //south-west
    		else if(xIncr == 0) orc = orcs.get(6); //south
    		else{
    			if(yIncr == 0 && xIncr > 0) orc = orcs.get(4);
    			else orc = orcs.get(5);
    		}
    	}
    	
    	
    	g.drawImage(orc[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
    	//Be sure that animation picture direction matches what is happening on screen.
    	
    }
    
    
 

    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	orcs = new ArrayList<BufferedImage[]>(); //initiate orcs
    	
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new Animation());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	
    	
    	
    	for(int num_orcs = 7; num_orcs > -1; num_orcs--){
    		pics = new BufferedImage[10];

    		BufferedImage img = createImage(1,num_orcs, num_orcs);
	    	
    		for(int i = 0; i < frameCount; i++){
	    			pics[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);	
	    	}
    		orcs.add(pics);
    	}
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    	
    }  
    
    //Read image from file and return
    public BufferedImage createImage(int action, int direct1, int direct2){
    	BufferedImage bufferedImage;
    	try {
    		String[] directions = {"north", "south","east","west"};
    		String[] actions = {"fire", "forward","idle", "jump"};
    		String image_loc;
    		
    		if(direct1 < 4) image_loc = "images/orc/orc_"+ actions[action] + "_"+ directions[direct1].toString() +".png";
    		else if(direct1 > 4 && direct2%4 == 3){
    			image_loc = "images/orc/orc_"+ actions[action] + "_"+ directions[direct1%2].toString() + directions[2].toString() +".png";
    		}else{
    			image_loc = (direct2%4==2) ? "images/orc/orc_"+ actions[action] + "_"+ directions[direct1%2].toString() + directions[3].toString() +".png":  "images/orc/orc_"+ actions[action] + "_"+ directions[direct1%2].toString() + directions[direct1%2+2].toString() + ".png" ;
    		}
    		
    		System.out.println(image_loc);
    		
    		bufferedImage = ImageIO.read(new File(image_loc));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
    
}
