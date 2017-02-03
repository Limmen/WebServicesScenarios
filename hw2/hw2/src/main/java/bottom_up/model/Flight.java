package bottom_up.model;

import java.util.Date;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class Flight {

    private final String departmentCity;
    private final String destinationCity;
    private Date date = new Date();

    public Flight(String departmentCity, String destinationCity) {
        this.departmentCity = departmentCity;
        this.destinationCity = destinationCity;
    }

    public String getDepartmentCity() {
        return departmentCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public Date getDate() {
        return date;
    }
}
