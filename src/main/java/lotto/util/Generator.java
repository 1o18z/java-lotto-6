package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;

public class Generator {

    public static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH));
        Collections.sort(numbers);
        return numbers;
    }
}
