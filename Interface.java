/*
 * Wednesday 31/08/2106
 */
package tvSeries;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
public class Interface extends JFrame{
	    private Series selected;
        JList<String> listOfSeries;
        String array[];
        JPanel titlePanel;
        JPanel listPanel;
        JLabel label;
        SeriesDataBase database=new SeriesDataBase();
        public Interface(){
        	super("Tv Downloader");
        	
        	// Initializing panel for title
        	titlePanel=new JPanel();
        	FlowLayout titleLayout=new FlowLayout(FlowLayout.CENTER);
        	titlePanel.setLayout(titleLayout);
        	titlePanel.setBackground(Color.black);
        	add(titlePanel, BorderLayout.NORTH);
        	// initializing labels
        	label=new JLabel("TOP TV SERIES");
        	label.setForeground(Color.GREEN);
        	label.setFont(new Font("Serif", Font.ITALIC,60));
        	titlePanel.add(label);
        	
        	//initializing panels for JLsit and adding the Jlist for the list of series
        	listPanel=new JPanel();
        	FlowLayout layout=new FlowLayout(FlowLayout.CENTER);
        	layout.setHgap(20);
        	layout.setVgap(70);
        	
        	listPanel.setLayout(layout);
        	array=database.getSeriesNames();
        	DefaultListModel listModel= new DefaultListModel();
        	listModel.addElement(array);
        	listOfSeries=new JList<String>(array);
        	listOfSeries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Multiple selection is the defsult 
        	listOfSeries.setFixedCellHeight(30);
        	listOfSeries.setFixedCellWidth(300);
        	listOfSeries.setSelectionBackground(Color.GREEN);
        	listPanel.add(new JScrollPane(listOfSeries));
        	add(listPanel,BorderLayout.CENTER);
        	listOfSeries.addListSelectionListener(new ListSelectionListener(){
        		public void valueChanged(ListSelectionEvent event){
        			selected=database.series[listOfSeries.getSelectedIndex()];
        			int num=listOfSeries.getSelectedIndex();
        			remove(titlePanel);
        			remove(listPanel);
        			SeasonClass seasonDisplay=new SeasonClass(num);
        			add(seasonDisplay.displayPanel);
        			repaint();
        			revalidate();
        			}
        		
        	});
        	
        }
        private class SeasonClass{
        	JPanel displayPanel;
        	private JPanel labelPanel;
        	private JPanel displayListPanel;
        	JList<String> seasonList;
        	public SeasonClass(){}
        	public SeasonClass(int position){
        		// initializing database variable
        		//initializing display components
        		displayPanel=new JPanel(new BorderLayout());
        		
        		labelPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        		labelPanel.setBackground(Color.BLUE);
        		JLabel seasonLabel=new JLabel(database.series[position].getSeriesName());
        		seasonLabel.setFont(new Font("Serif",Font.ITALIC,60));
        		labelPanel.add(seasonLabel);
        		displayPanel.add(labelPanel,BorderLayout.NORTH);
        		
        		displayListPanel=new JPanel(new FlowLayout(FlowLayout.CENTER, 20,70));
        	    seasonList =new JList<String>(database.series[position].getNameOfSeason());
        	    seasonList.setSelectionBackground(Color.BLUE);
        	    seasonList.setFixedCellHeight(30);
            	seasonList.setFixedCellWidth(300);
        	    displayListPanel.add(new JScrollPane(seasonList));
        	    displayPanel.add(displayListPanel);
        	    seasonList.addListSelectionListener(new ListSelectionListener(){
        	    	public void valueChanged(ListSelectionEvent event){
        	    		int num=seasonList.getSelectedIndex();
        	    		EpisodeClass episode=new EpisodeClass(num);
        	    		remove(displayPanel);
        	    		//this.add(episode.forBoth);
        	    		repaint();
        	    		revalidate();
        	    	}
        	    	
        	    });
        	    	
       }
   }
 
	 private class EpisodeClass{
		 private JLabel seasonLabel;
		 private JList<String> episodeList;
		 private JPanel forLabel;
		 private JPanel forList;
		 private JPanel forBoth;
		 public EpisodeClass(int num){
		 forLabel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 seasonLabel=new JLabel("Season"+num);
		 seasonLabel.setBackground(Color.BLUE);
		 seasonLabel.setFont(new Font("Serif",Font.ITALIC,60));
		 forLabel.add(seasonLabel);
		 
		 forList=new JPanel(new FlowLayout(FlowLayout.CENTER,20,70));
         episodeList=new JList<String>(selected.season[num].getlistOfEpisodes());
         episodeList.setSelectionBackground(Color.BLUE);
         episodeList.setFixedCellHeight(30);
     	 episodeList.setFixedCellWidth(300);
         forList.add(new JScrollPane(episodeList));
         episodeList.addListSelectionListener(new ListSelectionListener(){
        	 public void valueChanged(ListSelectionEvent event){
        		  int answer= JOptionPane.showConfirmDialog(Interface.this, "Do you want to continue with the download",
        				   "Download",JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION);
        		     switch(answer){
        		     case JOptionPane.YES_OPTION:
        		    	 boolean download=true;
        		    	 while(download){
        		    	 JFileChooser chooser=new JFileChooser();
        		    	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        		    	 chooser.showSaveDialog(Interface.this);
        		    	 if(chooser.getSelectedFile().isDirectory()){
        		    	 File file=new File(chooser.getSelectedFile().getPath(),chooser.getSelectedFile().getName());
        		    	 JOptionPane.showMessageDialog(Interface.this, "Downloading movie into "+file.getPath(),
        		    			 "Download Info",JOptionPane.INFORMATION_MESSAGE);
        		    	 download=false;
        		    	 break;
        		    	 }else download=true;
        		    	 }
        	 } 
        		 
        	 }
         });
         
         forBoth=new JPanel(new BorderLayout());
         forBoth=(JPanel) getContentPane();
         forBoth.add(forLabel,BorderLayout.NORTH);
         forBoth.add(forList,BorderLayout.CENTER);
		 }
		 
	 }
	  
	  
  }