package openu.java.unit2.maman13;
/**
 * This class represent an Airports departors and arrivals flights data.
 * @author Edith Kamkhaji
 * @version v.0.0.5
 */

import java.util.Arrays;
import java.util.Set;

public class Airport {
    // instance variables
    private int _noOfFlights;
    private String _city;
    private Flight[] _flightsSchedule;

    private final int MAX_FLIGHTS = 200;

    // constractors

    /**
     *  Initialize an airport object
     * @param city - name of the city in which the airport is located
     */
    public Airport(String city) {
        _city = city;
        _flightsSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    /**
     * a default constractor
     */
    public Airport() {
        _city = "Tel-Aviv";
        _flightsSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    // getters

    /**
     * Return the number of flights
     * @return number of flights in the airport board in array
     */
    public int getNoOfFlights() {
        return _noOfFlights;
    }

    /**
     * Return the number of flights
     * @return ame of the city in which the airport is located
     */
    public String getCity() {
        return _city;
    }

    /**
     * Return an actual flights array
     * @return actual flights arry
     */
    public Flight[] getFlight() {
        Flight[] actFlightArray = new Flight[_noOfFlights];
        for (int i = 0; i < _noOfFlights; i++) {
            actFlightArray[i] = new Flight(_flightsSchedule[1]); //we use new in order to avoid aliasing
        }
        return actFlightArray;
    }

    /**
     * this function will add a flight to the flightSchedule
     * @param f - flight data
     * @return false - if flight wasn't added, true - if flight was added
     */
    public boolean addFlight(Flight f) {
        if (_noOfFlights == MAX_FLIGHTS) //first we will check if there is a place
        {
            return false;
        }
        _flightsSchedule[_noOfFlights] = new Flight(f); //copy in order to avoid aliasing
        _noOfFlights++;
        return true;
    }

    /**
     * remove flight from board
     * @param f flight data
     * @return true - deletion was done, false - deletion wasn't done
     */
    public boolean removeFlight(Flight f) {
        for (int i = 0; i < _noOfFlights; i++) {
            //move last at palce of removed flight
            if (_flightsSchedule[i].equals(f)) {
                _flightsSchedule[i] = _flightsSchedule[_noOfFlights - 1];
                _flightsSchedule[_noOfFlights - 1] = null;
                _noOfFlights--;
                return true;
            } // end if statment - f in _flightsSchedule - return true
        } // end for loop
        return false; // f not in _flightsSchedule
    }

    // @param place - String
    // @return first flight from place if there is no flight from place @return null

    /**
     *
     * @param place
     * @return first flight from place if there is no flight from place return null
     */
    public Time1 firstFlightFromOrigin(String place) {
        // check if there are flights
        if (_noOfFlights == 0) {
            return null; // no flights
        }
        int i = 0;
        Flight first = _flightsSchedule[i];
        for (i++; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place)) {
                if (_flightsSchedule[i].getDeparture().before(first.getDeparture())) {
                    first = _flightsSchedule[i];
                }
            }
        }
        if (first == null) {
            return null;
        }
        return first.getDeparture();
    }

    /**
     * chec how many full flights there are in this day
     * @return the number of full flight in current day
     */
    public int howManyFullFlights(){
        int flightCounter = 0;
        for(int i = 0; i < _noOfFlights; i++){
            if(_flightsSchedule[i] != null && _flightsSchedule[i].getIsFull()){
                flightCounter++;
            }
        }
        return flightCounter;
    }
    //@param place String -
    //@return int - a sum of flight that depart and arrive from and to this place (see number 8 in the maman)
    public int howManyFlightsBetween(String place){
        int flightBetweenCount = 0;
        for(int i = 0; i <_noOfFlights; i++){
            if(_flightsSchedule[i].getDestination().equals(place) || _flightsSchedule[i].getOrigin().equals(place)){
                flightBetweenCount++;
            }
        }
        return flightBetweenCount;
    }
    //9
    // @return _city String the most popolar city
    public String mostPopularDestination() {
        String mostPopolarDest = "";
        int countPopular = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            String currentDest = _flightsSchedule[i].getDestination();
            int currentDestCount = 1;
            for (int j = 0; j < _noOfFlights; j++) {
                if (_flightsSchedule[j].getDestination().equals(currentDest)) {
                    currentDestCount++;
                }
            }// end of internal for
            if (currentDestCount > countPopular) {
                countPopular = currentDestCount;
                mostPopolarDest = currentDest;
            }
        }// end of external for
        return mostPopolarDest;
    }

    //10
    // @return Fligh which its' price is the higher (the first one)
    // @return null if no flights
    public Flight mostExpensiveTicket() {
        if (_noOfFlights == 0) {
            return null; //no flights in schedule
        }
        Flight expensiveTicket = _flightsSchedule[0];
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getPrice() > expensiveTicket.getPrice()) {
                expensiveTicket = _flightsSchedule[i];
            }
        }
        return expensiveTicket;
    }

    //11
    // return flight (longest flight)
    // return null if no flights
    public Flight longestFlight() {
        if (_noOfFlights == 0) {
            return null; //no flights in schedule
        }
        Flight longest = _flightsSchedule[0];
        for (int i = 1; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getFlightDuration() < longest.getFlightDuration()) {
                longest = _flightsSchedule[i];
            } //end of if statment
        } //end of for loop
        return longest;
    }

    //12
    // @return String of all flights in the flights array, each flight in new line
    // flights output should have a title
    //if there it no flights in the flights list @return null


    public String toString() {
        return "Airport flights: " +
                "number of flights are " + _noOfFlights +
                ", airport city name is " + _city  +
                ", schedule flights are: \n" + flightsScheduleToString();
    }

    private String flightsScheduleToString() {
        if (_flightsSchedule.length == 0) {
            return null;
        }
        String string = new String();
        for (int i = 0; i < _noOfFlights; ++i) {
            if (i > 0) {
                string += '\n';
            }
            string += _flightsSchedule[i].toString();
        }
        return string;
    }
}
