package lotto.domain;

import lotto.enums.LottoRankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    Lottos lottos;
    LottoResult result;
    @BeforeEach
    void initialize(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos = new Lottos(lottoList);
        result = new LottoResult(lottos, winningLotto);
    }

    @Test
    @DisplayName("LottoResult 당첨 개수 테스트")
    void LottoResult_당첨_개수_테스트(){
        assertThat(result.winningCountByWinningType(LottoRankType.FIRST)).isEqualTo(1);
        assertThat(result.winningCountByWinningType(LottoRankType.SECOND)).isEqualTo(1);
        assertThat(result.winningCountByWinningType(LottoRankType.THIRD)).isEqualTo(1);
        assertThat(result.winningCountByWinningType(LottoRankType.FOURTH)).isEqualTo(1);

    }

    @Test
    @DisplayName("LottoResult 수익률 테스트")
    void LottoResult_수익률_테스트(){
        System.out.println();
        assertThat(result.getProfitRate()).isEqualTo(
                (double) (LottoRankType.FIRST.getPrice()
                        + LottoRankType.SECOND.getPrice()
                        + LottoRankType.THIRD.getPrice()
                        + LottoRankType.FOURTH.getPrice()) / (lottos.size() * 1000)
        );

    }
}
