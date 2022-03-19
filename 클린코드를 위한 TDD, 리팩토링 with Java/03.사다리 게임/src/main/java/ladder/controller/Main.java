package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Results;
import ladder.dto.AllResultsDto;
import ladder.dto.LadderDto;
import ladder.view.ResponseView;

public class Main {

    public static void main(String[] args) {
        Persons persons = ModelMapper.getPersons();
        int sizeOfPersons = persons.size();
        Results results = ModelMapper.getValidateResults(sizeOfPersons);
        Ladder ladder = ModelMapper.getLadder(sizeOfPersons);

        LadderDto ladderDto = new LadderDto(
                persons.exportPersonsDto(),
                results.exportResultsDto(),
                ladder.exportLinesDto()
        );

        Person all = new Person("all");
        Person person = ModelMapper.getPerson();

        while(!person.equals(all)) {
            int movedPosition = ladder.move(
                    persons.getPosition(person));

            ResponseView.printResult(
                    results.exportResultDto(movedPosition));

            person = ModelMapper.getPerson();
        }

        ResponseView.printAllResults(new AllResultsDto(
                persons.exportPersonsDto(),
                results.exportMoveResultsDto(ladder::move)
        ));

    }


}
