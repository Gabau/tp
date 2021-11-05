package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import seedu.address.logic.commands.SetDefaultShiftTimingsCommand;
import seedu.address.logic.parser.exceptions.ParseException;


public class SetDefaultShiftTimingsCommandParser implements Parser<SetDefaultShiftTimingsCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the SetDefaultShiftTimingsCommand
     * and returns a SetDefaultShiftTimingsCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SetDefaultShiftTimingsCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String[] strTimings = args.trim().split("\\s+");
        if (strTimings.length != 4) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetDefaultShiftTimingsCommand.HELP_MESSAGE));
        }

        LocalTime[] newTimings;
        try {
            newTimings = ParserUtil.parseTimingsArr(strTimings);
        } catch (DateTimeParseException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetDefaultShiftTimingsCommand.HELP_MESSAGE));
        }

        return new SetDefaultShiftTimingsCommand(newTimings);
    }

}
