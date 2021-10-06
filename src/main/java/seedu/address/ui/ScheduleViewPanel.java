package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.person.Person;
import seedu.address.model.person.Shift;
import seedu.address.model.person.Slot;

import java.time.DayOfWeek;

import static java.util.Objects.requireNonNull;

public class ScheduleViewPanel extends UiPart<Region>{
    private static final String FXML = "ScheduleViewPanel.fxml";

    //apparently, javafx does not have support for array accesses
    @FXML
    private StackPane monday1Placeholder;

    @FXML
    private StackPane monday2Placeholder;

    @FXML
    private StackPane tuesday1Placeholder;

    @FXML
    private StackPane tuesday2Placeholder;

    @FXML
    private StackPane wed1Placeholder;

    @FXML
    private StackPane wed2Placeholder;

    @FXML
    private StackPane thu1Placeholder;

    @FXML
    private StackPane thu2Placeholder;

    @FXML
    private StackPane fri1Placeholder;

    @FXML
    private StackPane fri2Placeholder;

    @FXML
    private StackPane sat1Placeholder;

    @FXML
    private StackPane sat2Placeholder;

    @FXML
    private StackPane sun1Placeholder;

    @FXML
    private StackPane sun2Placeholder;

    private ObservableList<Person> staffList;

    //convenience variable
    private StackPane[][] gridPanes;



    /**
     * Gets the schedule view from the staffList
     * @param staffList The list of staff to display the schedule of.
     */
    public ScheduleViewPanel(ObservableList<Person> staffList) {
        super(FXML);
        requireNonNull(staffList);
        //set each of the grids.
        this.staffList = staffList;

    }

    @FXML
    public void initialize() {
        setGridPanes();
    }


    private void setGridPanes() {
        this.gridPanes = new StackPane[][] {{monday1Placeholder, monday2Placeholder}
                , {tuesday1Placeholder, tuesday2Placeholder}
                , {wed1Placeholder, wed2Placeholder}
                , {thu1Placeholder, thu2Placeholder}
                , {fri1Placeholder, fri2Placeholder}
                , {sat1Placeholder, sat2Placeholder}};
    }


    /**
     * Set the individual cells in the schedule view panel.
     *
     */
    public void setGrid() {
        setGridPanes();
        DayOfWeek pointer = DayOfWeek.MONDAY;;
        for (int i = 0; i < gridPanes.length; i++) {
            DayOfWeek day = pointer;
            int j = 0;
            for (Slot slot : Slot.values()) {
                ScheduleViewCell node =
                        new ScheduleViewCell(staffList.filtered(staff -> staff.isWorking(day, slot)));
                gridPanes[i][j].getChildren().add(node.getRoot());
                j++;
            }
            //increment the date
            pointer = pointer.plus(1);
        }

    }
}
