package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import lotto.result.Grade;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.ERROR;
import static lotto.util.Constant.INVALID_BONUS_NUMBER;
import static lotto.util.Constant.INVALID_LOTTO_UNIT;
import static lotto.util.Constant.INVALID_NUMBER;

public class OutputView {

    public static void newLine() {
        System.out.println();
    }

    public static void purchaseAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void winningStatistics(Map<Grade, Integer> resultMap) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        System.out.println("당첨 통계\n---");

        Arrays.stream(Grade.values())
                .filter(grade -> grade != Grade.NONE)
                .sorted(Comparator.comparing(Grade::ordinal).reversed())
                .forEach(grade -> {
                    Integer count = resultMap.getOrDefault(grade, DEFAULT_VALUE);
                    String price = numberFormat.format(grade.getPrice());
                    String message = getMessageForGrade(grade, price, count);
                    System.out.println(message);
                });
    }

    public static void profitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static String getMessageForGrade(Grade grade, String price, Integer count) {
        if (grade == Grade.SECOND) {
            return String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개", price, count);
        }
        return String.format("%d개 일치 (%s원) - %d개", grade.getMatchCount(), price, count);
    }

    public static void printInvalidBonusNumber() {
        System.out.println(ERROR + INVALID_BONUS_NUMBER);
    }

    public static void printInvalidPurchasePriceUnit() {
        System.out.println(ERROR + INVALID_LOTTO_UNIT);
    }

    public static void printInvalidFormat() {
        System.out.println(ERROR + INVALID_NUMBER);
    }
}
