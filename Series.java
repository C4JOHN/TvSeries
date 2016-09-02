package tvSeries;
public class Series {
	private int generalNumberOfEpisodes;
    private int numberOfSeasons;
    private String nameOfSeries;
    protected Season[] season;
    public Series(){}
    public Series(int numSeason, String name,int numOfEpisodes){
    	generalNumberOfEpisodes=numOfEpisodes;
    	numberOfSeasons=numSeason;
    	nameOfSeries=name;
    	season=new Season[numberOfSeasons];
    	for(int i=0; i<numberOfSeasons; i++){//intializing the seasons
    		season[i]=new Season(generalNumberOfEpisodes,i);
    	}
    }
    public String getSeriesName(){
    	return nameOfSeries;
    }
    public int getNumOfSeason(){
    	return numberOfSeasons;
    }
    public int getNumberOfEpisodes(){
    	return generalNumberOfEpisodes;
    }
    public String[] getNameOfSeason(){
    	String season[]=new String[numberOfSeasons+1];
    	   for(int i=1;i<=numberOfSeasons;i++){
    		   season[i]=String.format(">>Season %d",i);
    	   }
    	   return season;
    }
}
