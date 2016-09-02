package tvSeries;
public class Season {
  private String name;
  private int numOfEpisodes;
  public Season(){
	  
  }
  public Season(int numEpisodes,int seasonName){
	  name=String.format("Season %d", seasonName);
	  numOfEpisodes=numEpisodes;
  }
  public String[] getlistOfEpisodes(){
	   String[] list=new String[numOfEpisodes+1];
	   for(int i=1; i<=numOfEpisodes; i++){
		   list[i]=String.format("Episode %d", i);
	   }
	   return list;
}
  public String getName(){
	  return name;
  }
  public int getNumOfEpisodes(){
	  return numOfEpisodes;
  }
}
