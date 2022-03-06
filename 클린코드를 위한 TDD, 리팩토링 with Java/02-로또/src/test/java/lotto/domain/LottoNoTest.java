package lotto.domain;

import lotto.exception.LottoRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNoTest {

    @Test
    @DisplayName("숫자 로또 번호의 성공 케이스")
    void constructor_num_success() {
        Stream<Executable> executables = IntStream.rangeClosed(
                LottoNo.MIN,
                LottoNo.MAX
        ).mapToObj((int no) -> (Executable) () -> assertThat(
                new LottoNo(no)
        ).isEqualTo(new LottoNo(no)));
        Assertions.assertAll(executables);
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자로 LottoNo을 만들면, LottoRangeException이 발생한다.")
    @ValueSource(ints = {-1,0,46})
    public void constructor_int_fail(int lottoNo) {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> new LottoNo(lottoNo));
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아니면, LottoRangeException이 발생한다.")
    @CsvSource(value = { "0$true", "1$false", "45$false", "46$true" }, delimiter = '$')
    public void validate(int lottoNo, boolean badRange) {
        if (badRange) {
            assertThatExceptionOfType(LottoRangeException.class)
                    .isThrownBy(() -> LottoNo.validate(lottoNo));
            return;
        }
        Assertions.assertDoesNotThrow(() -> LottoNo.validate(lottoNo));
    }

    private List<LottoNo> convertToList(Integer[] lottoNos) {
        return Arrays.stream(lottoNos)
                .map((Integer no) -> new LottoNo(no))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Collections.sort를 하면, 로또 번호의 크기 순서대로 정령이 된다.")
    public void sort() {
        Integer[] lottoNos = new Integer[]{45, 5, 2, 8, 3, 9, 15, 1};
        List<LottoNo> lottoNoList = convertToList(lottoNos);
        Arrays.sort(lottoNos);
        List<LottoNo> sortedList = convertToList(lottoNos);

        Collections.sort(lottoNoList);
        assertThat(lottoNoList)
                .isEqualTo(sortedList);
    }



}
