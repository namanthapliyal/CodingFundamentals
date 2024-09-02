package CodingFundamentals.Design_Patterns.ObserverDesignPattern.Observable;

import CodingFundamentals.Design_Patterns.ObserverDesignPattern.Observer.Observer;

public interface Observable {
    public void add();

    public void remove(Observer obj);

    public void notif_y();

    public void setData();

    public int getData();
}
