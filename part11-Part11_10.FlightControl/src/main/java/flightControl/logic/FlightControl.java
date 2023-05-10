package flightControl.logic;

import flightControl.domain.Airplane;
import flightControl.domain.Flight;
import flightControl.domain.Place;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tom
 */
public class FlightControl {
    
    private Map<String, Airplane> airplanes;
    private Map<String, Place> places;
    private Map<String, Flight> flights;
    
    
    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public Map<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public Map<String, Flight> getFlights() {
        return flights;
    }
    
    
    public void addAirplane(String id, int capacity) {
        Airplane airplane = new Airplane(id, capacity);
        this.airplanes.put(id, airplane);
        
    }
    
    public void addFlight(Airplane airplane, String departureID, String arriveID) {
        
        Place departure = new Place(departureID);
        Place arrive = new Place(arriveID);
        
        this.places.putIfAbsent(departureID, departure);
        this.places.putIfAbsent(arriveID, arrive);
        
        Flight flight = new Flight(airplane, departure, arrive);
        
        this.flights.putIfAbsent(flight.toString(), flight);

    }
    
    public boolean isAirplane(String id) {
        
        return this.airplanes.keySet().contains(id);
        
    }
    
    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }
    
    public void printAirplanes() {
        this.airplanes.values()
                .stream()
                .forEach(airplane -> System.out.println(airplane.toString()));
    }
    
    public void printFlights() {
        this.flights.values()
                .stream()
                .forEach(flight -> System.out.println(flight.toString()));
    }
}
