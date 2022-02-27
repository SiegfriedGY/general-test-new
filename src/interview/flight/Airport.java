/*
 * Copyright (c) Numerical Method Inc.
 * http://www.numericalmethod.com/
 *
 * THIS SOFTWARE IS LICENSED, NOT SOLD.
 *
 * YOU MAY USE THIS SOFTWARE ONLY AS DESCRIBED IN THE LICENSE.
 * IF YOU ARE NOT AWARE OF AND/OR DO NOT AGREE TO THE TERMS OF THE LICENSE,
 * DO NOT USE THIS SOFTWARE.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITH NO WARRANTY WHATSOEVER,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION,
 * ANY WARRANTIES OF ACCURACY, ACCESSIBILITY, COMPLETENESS,
 * FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, NON-INFRINGEMENT,
 * TITLE AND USEFULNESS.
 *
 * IN NO EVENT AND UNDER NO LEGAL THEORY,
 * WHETHER IN ACTION, CONTRACT, NEGLIGENCE, TORT, OR OTHERWISE,
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIMS, DAMAGES OR OTHER LIABILITIES,
 * ARISING AS A RESULT OF USING OR OTHER DEALINGS IN THE SOFTWARE.
 */
package interview.flight;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

/**
 * Airport manages a collection of {@linkplain Flight}.
 *
 * @author haksunli
 */
public class Airport {

    private Collection<Flight> flights;

    public Airport(Collection<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Gets how many flights are there for a determined date.
     *
     * @param f
     * @return
     */
    public Long getNumFlightsDay(LocalDate f) {
//        throw new RuntimeException("please implement this method");
        Long num = 0L;
        for (Flight flight : flights) {
            if (f.isEqual(flight.getDate())) {
                num++;
            }
        }
        return num;
    }

    /**
     * Gets how many full flights there is.
     *
     * @return
     */
    public Long getNumFullFlights() {
//        throw new RuntimeException("please implement this method");
        Long num = 0L;
        for (Flight flight : flights) {
            if (flight.getNumSeats().equals(flight.getNumPassengers())){
                num ++;
            }
        }
        return num;
    }

    /**
     * Checks if all the flights of a date are full.
     *
     * @param f
     * @return
     */
    public Boolean allFull(LocalDate f) {
//        throw new RuntimeException("please implement this method");
        for (Flight flight : flights) {
            if (f.isEqual(flight.getDate()) && flight.getNumPassengers()<flight.getNumSeats()){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is any flight towards a specific destination and at a
     * specific date.
     *
     * @param f
     * @param d
     * @return
     */
    public Boolean existsFlightDestinationDate(LocalDate f, String d) {
//        throw new RuntimeException("please implement this method");
        for (Flight flight : flights) {
            if (f.isEqual(flight.getDate()) && d.equals(flight.getDestination())){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the cheaper flight to a certain destination.
     *
     * @param d
     * @return
     */
    public Flight getCheaperFlightDestination(String d) {
//        throw new RuntimeException("please implement this method");
        Optional<Flight> min = flights.stream().filter(e -> d.equals(e.getDestination())).min(Comparator.comparingDouble(Flight::getPrice));
        return min.orElse(null);
    }

    /**
     * Gets the highest occupation of all flight on a specific date.
     *
     * @param f
     * @return
     */
    public Double getHighestOccupation(LocalDate f) {
//        throw new RuntimeException("please implement this method");
        Optional<Flight> max = flights.stream().filter(e -> f.isEqual(e.getDate())).max(Comparator.comparingDouble(Flight::getOccupation));
        return max.map(Flight::getOccupation).orElse(0D);
    }

    /**
     * Gets the total duration of all flights on a specific date.
     *
     * @param f
     * @return
     */
    public Duration getDurationFlightsDate(LocalDate f) {
        // use Duration::sum
//        throw new RuntimeException("please implement this method");
//        Optional<Duration> reduce = flights.stream().filter(e -> f.isEqual(e.getDate())).map(Flight::getDuration).reduce(Duration::sum);
        return null;
    }

    /**
     * To increase the prices of all flights on a specific date by 10%.
     *
     * @param f
     */
    public void incrementPrices10pfromDate(LocalDate f) {
//        throw new RuntimeException("please implement this method");
        flights.stream().filter(e -> f.isEqual(e.getDate())).forEach(e->e.setPrice(e.getPrice()*1.1));
    }

    /**
     * Gets the set of all possible destinations from this airport.
     *
     * @return
     */
    public Set<String> getDestinations() {
//        throw new RuntimeException("please implement this method");
        return flights.stream().map(Flight::getDestination).collect(Collectors.toSet());
    }

    /**
     * Gets the average of the prices of the flights to a certain destination.
     *
     * @param d
     * @return
     */
    public Double getAveragePricesDestination(String d) {
//        throw new RuntimeException("please implement this method");
        return flights.stream().filter(e -> d.equals(e.getDestination())).map(Flight::getPrice)
                .collect(Collectors.averagingDouble(Double::doubleValue));
    }

    /**
     * Gets a map that organizes flights by date.
     *
     * @return
     */
    public SortedMap<Date, List<Flight>> getMapFlightsByDate() {
//        throw new RuntimeException("please implement this method");
        Map<LocalDate, List<Flight>> jodaDateMap = flights.stream().collect(Collectors.groupingBy(Flight::getDate));
        SortedMap<Date, List<Flight>> jvDateMap = new TreeMap<>();
        for (Map.Entry<LocalDate, List<Flight>> entry: jodaDateMap.entrySet()) {
            jvDateMap.put(entry.getKey().toDateTimeAtStartOfDay().toDate(), entry.getValue());
        }
        return jvDateMap;

    }
}
