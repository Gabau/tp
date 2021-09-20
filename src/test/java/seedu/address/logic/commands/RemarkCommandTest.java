package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

class RemarkCommandTest {

    private Model model;



    @Test
    void execute_addRemarkUnfilteredList_success() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Person remarkedPerson = new PersonBuilder().withRemark("word").build();
        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, remarkedPerson);
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        model.setPerson(model.getFilteredPersonList().get(0), new PersonBuilder().build());
        expectedModel.setPerson(expectedModel.getFilteredPersonList().get(0), remarkedPerson);
        assertCommandSuccess(new RemarkCommand(INDEX_FIRST_PERSON, "word"), model, expectedMessage, expectedModel);

    }

}
