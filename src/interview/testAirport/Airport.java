package interview.testAirport;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {

    private static List<Flight> flights;

    static {
        flights = new ArrayList<>();
        flights.add(new Flight("北京", 33.34));
        flights.add(new Flight("北京",44.44));
        flights.add(new Flight("北京",66.12));
        flights.add(new Flight("上海",11.12));
        flights.add(new Flight("广州",55.12));
    }

    public static void main(String[] args) {

//        System.out.println(cheapestDestination("北京"));
//        System.out.println(highestPrice("天津"));
        increase10p();
//        System.out.println(getDestinations());
//        System.out.println(getAvg("北京"));
//        System.out.println(sumPrice());
    }

    private static Flight cheapestDestination(String dest){
        Optional<Flight> min = flights.stream().filter(e -> dest.equals(e.getDestination())).min(Comparator.comparingDouble(Flight::getPrice));
        return min.orElse(new Flight("",0));
    }

    private static double highestPrice(String dest) {
        Optional<Flight> maxFlight = flights.stream().filter(e -> dest.equals(e.getDestination())).max(Comparator.comparingDouble(Flight::getPrice));
        return maxFlight.map(Flight::getPrice).orElse(0.0);
    }

    private static void increase10p(){
        flights.forEach(e->e.setPrice(e.getPrice()*1.1));
        flights.forEach(System.out::println);
    }
    public static Set<String> getDestinations() {
        return flights.stream().map(Flight::getDestination).collect(Collectors.toCollection(HashSet::new));
    }

    private static double getAvg(String dest){
        Double collect = flights.stream().filter(e -> dest.equals(e.getDestination())).map(Flight::getPrice)
                .collect(Collectors.averagingDouble(Double::doubleValue));
        return collect;
    }

    private static double sumPrice(){
        return flights.stream().map(Flight::getPrice).reduce(Double::sum).orElse(0D);
    }

}
