package skaterental.strategy_scenarios;

import skaterental.boards.Skateboard;

public class Default implements Tariff {
    @Override
    public void getDescription() {
        System.out.println("The Default tariff with no discount and start price 100");;
    }

    @Override
    public double percent() {
        return 0;
    }

    @Override
    public double startPrice() {
        return 100;
    }

    @Override
    public double pay(Skateboard skateboard, int time) {
        return percent() * time * skateboard.getHourlyRate() + startPrice();
    }

}
