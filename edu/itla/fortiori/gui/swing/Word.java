package edu.itla.fortiori.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Word extends JLabel implements Runnable {
	private int x;
	private int y;
	private boolean correct;
	private boolean destroyed;
	private int speed = 3;
	private WordManager word;
	private ImageIcon fire = new ImageIcon(GamePanel.getInstance().getConfig().getConfig("destroyImage"));
	{
		setFont(new Font("Arial",Font.BOLD,20) );
		setForeground(new Color(154,205,50));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(destroyed){
					return;
				}
				if(correct){
					setForeground(Color.RED);
					destroyed = true;
					word.setScore(word.getScore() + 10);
				}else{
					setForeground(Color.BLUE);
					word.setScore(word.getScore() - 5);
				}
			}
		});

	}

	public Word(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		setLocation(x, y);
	}

	public Word(String text, int x, int y) {
		super(text);
		this.x = x;
		this.y = y;
		setLocation(x, y);
	}
	public Word(String text, int x, int y, int speed, boolean correct) {
		super(text);
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.correct = correct;
		setLocation(x, y);
	}

	public Word() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		word =  WordManager.getInstance();
		
		while (y < 2000) { // Hardcoded 2000 as the MAX HEIGHT
			try {
				Thread.sleep(300 - (4 * speed));
				setLocation(x, y);
				y += speed;
				if(destroyed){
					destroy();
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.print("Word " + getText() + " has been disposed");
	}
	
	private void destroy(){
		//setText("");
		setIcon(fire);		
		setLocation(x,y);
	}

}
