package skaterental.strategy_scenarios;

import skaterental.boards.Skateboard;

public class Premium implements Tariff {
    @Override
    public void getDescription() {
        System.out.println("The Premium tariff with discount -20% and start price 0");;
    }

    @Override
    public double percent() {
        return 0.8;
    }

    @Override
    public double startPrice() {
        return 0;
    }

    @Override
    public double pay(Skateboard skateboard, int time) {
        return percent() * time * skateboard.getHourlyRate() + startPrice();
    }

}
