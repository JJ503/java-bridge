package bridge.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator implements RandomGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 10);
    }
}
