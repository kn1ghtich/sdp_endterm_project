package skaterental;

import skaterental.boards.Skateboard;
import skaterental.strategy_scenarios.Tariff;

public class PaymentTariffStrategy {
    private Tariff tariff;

    public PaymentTariffStrategy(Tariff tariff) {
        this.tariff = tariff;
    }

    public double pay(Skateboard skateboard, int time){
        return tariff.pay(skateboard, time);
    }

}
