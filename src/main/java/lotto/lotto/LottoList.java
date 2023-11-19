package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {

    private final List<Lotto> lottos;

    public LottoList(int amount) {
        lottos = new ArrayList<>();

        while (lottos.size() < amount) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
