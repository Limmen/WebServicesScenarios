package kth.se.id2208.bottom_up.model.data.records;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class PriceEntry {

    private Initiary initiary;
    private float price;

    public PriceEntry(Initiary initiary, float price) {
        this.initiary = initiary;
        this.price = price;
    }

    public Initiary getInitiary() {
        return initiary;
    }

    public float getPrice() {
        return price;
    }
}
