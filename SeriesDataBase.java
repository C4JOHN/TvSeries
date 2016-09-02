package tvSeries;

public class SeriesDataBase {
	public Series[] series=new Series[12];
	public SeriesDataBase(){
		series[0]=new Series(5,"Arrow",12);
		series[1]=new Series(5,"Mentalist",32);
		series[2]=new Series(5,"Grimm",21);
		series[3]=new Series(6,"Game Of Thrones",21);
		series[4]=new Series(6,"White Collar",12);
		series[5]=new Series(10,"Naruto",100);
		series[6]=new Series(8,"Prison Break",12);
		series[7]=new Series(9,"Big Bang Theory",12);
		series[8]=new Series(12,"Merlin",23);
		series[9]=new Series(9,"Kyle XY",21);
		series[10]=new Series(10,"Flash",12);
		series[11]=new Series(20,"My Only Daughter",12);
	}
     public Series[] getSeries(){
    	 return series;
     }
     public String[] getSeriesNames(){
    	 String[] names=new String[series.length];
    	 for(int i=0; i<series.length;i++){
    		  names[i]=(">>"+series[i].getSeriesName());
    	 }
    	 return names;
     }
}
