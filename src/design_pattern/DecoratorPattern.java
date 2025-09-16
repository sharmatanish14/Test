package design_pattern;

interface Coffee{
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public int getCost() {
        return 100;
    }
}

abstract class CoffeeDecorator implements Coffee{
    Coffee deoratedCoffee;

    public CoffeeDecorator(Coffee deoratedCoffee){
        this.deoratedCoffee = deoratedCoffee;
    }

    @Override
    public String getDescription() {
        return deoratedCoffee.getDescription();
    }

    @Override
    public int getCost() {
        return deoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " added milk";
    }

    @Override
    public int getCost() {
        return super.getCost()+50;
    }
}

class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() +" added sugar";
    }

    @Override
    public int getCost() {
        return super.getCost() +10;
    }
}





public class DecoratorPattern {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();

        System.out.println(coffee.getDescription() +" @@@@ "+ coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() +" @@@@ "+ coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() +" @@@@ "+ coffee.getCost());
    }
}
