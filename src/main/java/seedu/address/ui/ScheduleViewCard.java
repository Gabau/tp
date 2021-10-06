package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

public class ScheduleViewCard extends UiPart<Region> {
    private static final String FXML = "ScheduleViewCard.fxml";

    public final Person staff;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;

    public ScheduleViewCard(Person staff, int displayedIndex) {
        super(FXML);
        this.staff = staff;
        id.setText(displayedIndex + ". ");
        name.setText(staff.getName().fullName);

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ScheduleViewCard)) {
            return false;
        }

        ScheduleViewCard card = (ScheduleViewCard) other;
        return this.staff.equals(card.staff)
                && id.getText().equals(card.id.getText());

    }
}
