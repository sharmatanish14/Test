package design_pattern.statepattern;

public class Cycling implements TransportationMode{

    @Override
    public int calcETA() {
        System.out.println("Calculating ETA for cycling");
        return 60;
    }

    @Override
    public String getDirection() {
        return "Directions for cycling";
    }
}
