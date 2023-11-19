package lotto.matching;

import java.util.List;
import lotto.lotto.Bonus;
import lotto.lotto.LottoList;
import lotto.lotto.WinningLotto;
import lotto.result.Grade;
import lotto.lotto.Lotto;
import lotto.result.Result;

public class Matcher {

    public Result match(WinningLotto winningLotto, LottoList lottoList, Bonus bonus) {
        Result result = new Result();
        List<Lotto> lottos = lottoList.getLottos();

        lottos.forEach(lotto -> {
            long count = lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean hasBonus = lotto.getNumbers().contains(bonus.getNumber());

            Grade grade = Grade.of((int) count, hasBonus);
            result.addResult(grade);
        });
        return result;
    }
}
