package kth.se.id2208.hw3.server.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kim Hammar on 2017-02-07.
 */
@XmlRootElement
public class HelloWorldPOJO {

    private String greeting;

    public HelloWorldPOJO(String greeting) {
        this.greeting = greeting;
    }

    public HelloWorldPOJO() {
    }

    @XmlElement(name="greeting")
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString(){
        return greeting;
    }
}
