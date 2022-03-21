package ladder.domain;

import ladder.dto.PersonDto;
import ladder.exception.PersonNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PersonsTest {

    private final List<String> names = Arrays.asList(
            "1",
            "22",
            "333",
            "4444",
            "55555"
    );
    private final Persons persons = names.stream()
            .map(Person::new)
            .collect(collectingAndThen(toList(), Persons::new));

    @Test
    @DisplayName("Person 의 사이즈가 정상적으로 받아져야 한다.")
    void size() {
        assertThat(persons.size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("입력한 이름의 position을 반환해야 한다.")
    void getPosition() {
        assertAll(IntStream.range(0, names.size())
                .boxed()
                .map(index -> () -> assertThat(persons.getPosition(new Person(names.get(index))))
                        .isEqualTo(index)));
    }

    @Test
    @DisplayName("존재하지 않는 사람을 입력할 경우, PersonNotFoundException이 발생한다.")
    void getPosition_PersonNotFound() {
        assertThatExceptionOfType(PersonNotFoundException.class)
                .isThrownBy(() -> persons.getPosition(new Person("zero")));
    }

    @Test
    @DisplayName("PersonDto의 포장을 풀었을 때 값이 일치하는 확인")
    void exportPersonsDto() {
        assertThat(persons.exportPersonsDto()
                .getPersons()
                .stream()
                .map(PersonDto::getName)
                .collect(toList())
        ).isEqualTo(names);
    }

}
