package seedu.address.model.person.predicates;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.function.Predicate;

import seedu.address.logic.commands.viewShiftCommand;
import seedu.address.model.person.Person;

public class PersonIsWorkingPredicate implements Predicate<Person> {

    private final DayOfWeek dayOfWeek;
    private final int slotNum;
    private final LocalTime time;

    /**
     * Constructs a PersonIsWorkingPredicate object which tests if a person is working on a specific day, at a
     * specific time or slot number.
     *
     * @param dayOfWeek The day of week that will be checked.
     * @param slotNum The slot number that will be checked. It will be {@code viewShiftCommand.INVALID_SLOT_NUMBER}
     *                if the viewShift is by time.
     * @param time The time that will be checked. It will be null if the viewShift is by slot number.
     */
    public PersonIsWorkingPredicate(DayOfWeek dayOfWeek, int slotNum, LocalTime time) {
        this.dayOfWeek = dayOfWeek;
        this.slotNum = slotNum;
        this.time = time;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonIsWorkingPredicate // instanceof handles nulls
                && (this.dayOfWeek.equals(((PersonIsWorkingPredicate) other).dayOfWeek))
                    && (this.slotNum == ((PersonIsWorkingPredicate) other).slotNum)
                    && (this.time.equals(((PersonIsWorkingPredicate) other).time)));
    }

    @Override
    public boolean test(Person person) {

        if (time != null && dayOfWeek != null) {
            return person.isWorking(dayOfWeek, time);
        } else if (slotNum != viewShiftCommand.INVALID_SLOT_NUMBER && dayOfWeek != null) {
            return person.isWorking(dayOfWeek, slotNum);
        } else {
            return false; // can consider throwing an exception?
        }
    }
}
