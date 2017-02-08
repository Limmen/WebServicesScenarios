package kth.se.id2208.hw3.model.faults;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class TicketNotAvailable extends Exception {

    public TicketNotAvailable(String reason){
        super(reason);
    }
}
