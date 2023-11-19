package lotto.result;

import java.util.Map;
import lotto.view.OutputView;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.PERCENT_BASE;
import static lotto.util.Constant.RATE;

public class Calculator {

    public void getProfitRate(Map<Grade, Integer> resultMap, int purchasedPrice) {
        double profitRate = calculateProfitRate(resultMap, purchasedPrice);
        OutputView.profitRate(profitRate);
    }

    public double calculateProfitRate(Map<Grade, Integer> resultMap, int purchasedPrice) {
        long sum = DEFAULT_VALUE;

        for (Grade grade : Grade.values()) {
            sum += grade.getPrice() * resultMap.getOrDefault(grade, DEFAULT_VALUE);
        }

        double profitRate = sum * PERCENT_BASE / purchasedPrice;
        return Math.round(profitRate * RATE) / RATE;
    }

    public void getStatistics(Map<Grade, Integer> resultMap) {
        OutputView.winningStatistics(resultMap);
    }
}
