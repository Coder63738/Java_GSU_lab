public class Jacket extends Clothes{
    private String seasonality;
    private String hood;

    public Jacket(String manufacturer,int cost,String style,String seasonality,String hood){
        super(manufacturer,cost,style);
        this.seasonality = seasonality;
        this.hood = hood;
    }

    public String getSeasonality() {
        return seasonality;
    }

    public String getHood() {
        return hood;
    }

    public void info(){
    System.out.println("\nБренд: " + getManufacturer() + "\nЦена: " + getCost() + " б.р." + "\nСтиль: " + getStyle() + "\nСезонность: " + getSeasonality() + "\nКапюшон: " + getHood() + "\n");
    }
}
