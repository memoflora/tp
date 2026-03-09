package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RemarkCommand;
import seedu.address.model.person.Remark;

public class RemarkCommandParserTest {

    private static final String REMARK_STUB = "Some remark";

    private RemarkCommandParser parser = new RemarkCommandParser();

    @Test
    public void parse_indexSpecifiedWithRemark_success() {
        assertParseSuccess(parser, "1 r/" + REMARK_STUB,
                new RemarkCommand(INDEX_FIRST_PERSON, new Remark(REMARK_STUB)));
    }

    @Test
    public void parse_indexSpecifiedEmptyRemark_success() {
        assertParseSuccess(parser, "1 r/",
                new RemarkCommand(INDEX_FIRST_PERSON, new Remark("")));
    }

    @Test
    public void parse_missingIndex_throwsParseException() {
        assertParseFailure(parser, REMARK_STUB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a r/" + REMARK_STUB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE));
    }
}
