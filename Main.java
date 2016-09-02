package tvSeries;

import javax.swing.JFrame;

public class Main {
      public static void main(String args[]){
    	  Interface panel=new Interface();
    	  panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  panel.setSize(600,600);
    	  panel.setLocationRelativeTo(null);
    	  panel.setVisible(true);
      }
}
