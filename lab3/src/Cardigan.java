public class Cardigan extends Clothes{
private int sleeveLength;
private int percentageOFwool;

public Cardigan(String manufacturer,int cost,String style,int sleeveLength,int percentageOFwool){
    super(manufacturer,cost,style);
    this.sleeveLength = sleeveLength;
    this.percentageOFwool = percentageOFwool;
}

    public int getPercentageOFwool() {
        return percentageOFwool;
    }

    public int getSleeveLength() {
        return sleeveLength;
    }

    @Override
    public void info() {
        System.out.println("\nБренд: " + getManufacturer() + "\nЦена: " + getCost() + " б.р." + "\nСтиль: " + getStyle() + "\nДлина рукава: " + getSleeveLength() + "см" + "\nПроцент шерсти: " + getPercentageOFwool() + "%\n");
    }
}
