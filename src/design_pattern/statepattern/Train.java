package design_pattern.statepattern;

public class Train implements TransportationMode{
    @Override
    public int calcETA() {
        System.out.println("Calculating ETA for train");
        return 20;
    }

    @Override
    public String getDirection() {
        return "Directions for train";
    }
}
