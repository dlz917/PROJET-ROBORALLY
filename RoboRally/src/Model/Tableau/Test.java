package Model.Tableau;

import java.awt.EventQueue;

import View.MainWindow;

public class Test {

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