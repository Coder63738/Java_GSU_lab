public abstract class Clothes implements Brand, Object{
private String manufacturer;
private int cost;
private String style;

public Clothes(){
}

public Clothes(String manufacturer,int cost,String style){
    this.manufacturer = manufacturer;
    this.cost = cost;
    this.style = style;
}

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCost() {
        return cost;
    }

    public String getStyle() {
        return style;
    }
}
