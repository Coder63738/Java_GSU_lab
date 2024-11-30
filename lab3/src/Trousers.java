public class Trousers extends Clothes{
    private int bellowing;

    public Trousers(String manufacturer,int cost,String style,int bellowing){
        super(manufacturer,cost,style);
        this.bellowing = bellowing;
    }

    public int getBellowing() {
        return bellowing;
    }

    @Override
    public void info() {
        System.out.println("Бренд: " + getManufacturer() + "\nЦена: " + getCost() + " б.р." + "\nСтиль: " + getStyle() + "\nРасклёшенность: " + getBellowing() + "см\n");
    }
}
