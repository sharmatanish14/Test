package design_pattern.statepattern;

public class StatePatternExample {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(new Walking());

        directionService.getETA();
        System.out.println(directionService.getDirections());

        directionService.setTransportationMode(new Train());
        directionService.getETA();
        System.out.println(directionService.getDirections());


    }
}
