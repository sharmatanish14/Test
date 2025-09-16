package design_pattern.statepattern;

public class Walking implements TransportationMode{

    @Override
    public int calcETA() {
        System.out.println("Calculating ETA (Walking)");
        return 100;
    }

    @Override
    public String getDirection() {
        return "Directions for walking";
    }
}
