package skaterental.strategy_scenarios;

import skaterental.boards.Skateboard;

public interface Tariff {
    public void getDescription();
    public double percent();
    public double startPrice();
    public double pay(Skateboard skateboard, int time);
}
