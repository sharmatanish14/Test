package design_pattern.statepattern;

public class DirectionService {

    TransportationMode transportationMode;

    public DirectionService(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void getETA() {
        transportationMode.calcETA();
    }

    public String getDirections() {
        return transportationMode.getDirection();
    }
}
