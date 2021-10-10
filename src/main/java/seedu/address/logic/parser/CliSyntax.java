package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_ROLE = new Prefix("r/");
    public static final Prefix PREFIX_SALARY = new Prefix("$/");
    public static final Prefix PREFIX_STATUS = new Prefix("s/");
    public static final Prefix PREFIX_DAY_SHIFT = new Prefix("d/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_INDEX = new Prefix("i/");
    public static final Prefix PREFIX_DASH_INDEX = new Prefix("-i");
    public static final Prefix PREFIX_DASH_NAME = new Prefix("-n");

    /*Edit lookup prefix definitions*/
    public static final Prefix EDIT_PREFIX_INDEX = new Prefix("-i");
    public static final Prefix EDIT_PREFIX_NAME = new Prefix("-n");
    public static final Prefix EDIT_PREFIX_IDENT = new Prefix("-id");

}
