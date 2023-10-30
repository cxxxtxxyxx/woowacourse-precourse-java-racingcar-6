package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @DisplayName("CarName 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"김김김", "최최최", "박박박", "abcde"})
    void createCarNameSuccessTest(String name) {
        CarName carName = new CarName(name);

        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("CarName 생성 실패 테스트 - 공백")
    @Test
    void createCarNameFailTest_1() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @DisplayName("CarName 생성 실패 테스트 - 글자 제한")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바사아자차카타파하"})
    void createCarNameFailTest_2(String name) {
        assertThrows(IllegalArgumentException.class, () -> new CarName(name));
    }
}