package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.exception.ExceptionMessage.AMOUNT_MUST_BE_POSITIVE;

public class MachineCoins {

    private int amountHeld;
    private Map<Coin, Integer> coins = initCoins();

    public MachineCoins(final int amountHeld) {
        validatePositiveAmount(amountHeld);
        this.amountHeld = amountHeld;
    }

    public Map<Coin, Integer> saveCoins() {
        while (amountHeld > 0) {
            int coinAmount = RandomNumberGenerator.generate(Coin.coins());
            amountHeld = putCoinIfAvailable(amountHeld, coinAmount);
        }
        return coins;
    }

    private int putCoinIfAvailable(int amountHeld, final int coinAmount) {
        if (amountHeld % coinAmount == 0) {
            Coin coin = Coin.from(coinAmount);
            amountHeld -= coinAmount;
            coins.put(coin, coins.get(coin) + 1);
        }
        return amountHeld;
    }

    private Map<Coin, Integer> initCoins() {
        Map<Coin, Integer> statistics = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            statistics.put(coin, 0);
        }
        return statistics;
    }

    private void validatePositiveAmount(final int amountHeld) {
        if (amountHeld <= 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_BE_POSITIVE.getMessage());
        }
    }
}