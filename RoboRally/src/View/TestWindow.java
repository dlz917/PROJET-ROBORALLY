package View;

import java.awt.EventQueue;

public class TestWindow {

	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					MainWindow window=new MainWindow();
					window.getFrame().setVisible(true);
					}
				catch(Exception e){
					e.printStackTrace();
					}
				}
			});
		}
	}