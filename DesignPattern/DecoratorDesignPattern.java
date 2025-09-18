Decorator design pattern

interface Beverages{
    String getDescription();
    double cost();
}
class Espresso implements Beverages{
    public String getDescription(){
        return "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}
class HouseBlend implements Beverages{
    public String getDescription(){
        return "House Blend Coffee";
    }
    public double cost(){
        return 0.89;
    }
}
clas Capaccino implements Beverages{
    public String getDescription(){
        return "Cappuccino";
    }
    public double cost(){
        return 2.99;
    }
}
public abstract class Addons implements Beverages{
    protected Beverages beverage;
    public Addons(Beverages beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription();
    }
    public double cost(){
        return beverage.cost();
    }
}
class Chocolate extends Addons{
    public Chocolate(Beverages beverage){
        super(beverage);
    }
    public String getDescription(){
        return beverage.getDescription() + ", Chocolate";
    }
    public double cost(){
        return beverage.cost() + 0.20;
    }
}
class Whip extends Addons{
    public Whip(Beverages beverage){
        super(beverage);
    }
    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }
    public double cost(){
        return beverage.cost() + 0.30;
    }
}
class Client{
    public static void main(String args[]){
        Beverages beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        //Expected Output: Espresso $1.99
        Beverages beverage2 = new HouseBlend();
        beverage2 = new Chocolate(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
        //Expected Output: House Blend Coffee, Chocolate, Whip $1.39

        Beverages beverage3 = new Capaccino();
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
        //Expected Output: Cappuccino, Whip $3.29
    }
}