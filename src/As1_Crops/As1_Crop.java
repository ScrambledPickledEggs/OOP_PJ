package As1_Crops;

public class As1_Crop {
    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;


    public As1_Crop(String n, double y, String u, double p){
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;
    }//constructor #1


    public String toString(){
        return name + " " + yield + " " + units + " " + price + " " + acres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }

    public String getName() {
        return name;
    }

    public void printMe(){
        System.out.println("Crop name: " + name +", How many " + units + ": " + yield + ", dollars per " + units + ": " + price + ", acres allocated to crop: " + acres);
    }

    public double harvest(int given){
        double temp = (price * yield * units * acres);
        return temp;
    }

}
