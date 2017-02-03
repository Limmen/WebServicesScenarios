package kth.se.id2208.bottom_up.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name="Flight")
public class Flight {

    private String departmentCity;
    private String destinationCity;

    public String getDepartmentCity() {
        return departmentCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    @XmlElement(name = "DepartmentCity")
    public void setDepartmentCity(String departmentCity) {
        this.departmentCity = departmentCity;
    }
    @XmlElement(name = "DestinationCity")
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public boolean equals(Object obj) {
        Flight flight = (Flight) obj;
      return flight.getDepartmentCity().equalsIgnoreCase(departmentCity) && flight.getDestinationCity().equalsIgnoreCase(destinationCity);
    }

    @Override
    public String toString(){
        return departmentCity + " - " + destinationCity;
    }
}
