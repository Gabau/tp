package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;


public class ScheduleViewCell extends UiPart<Region> {
    private static final String FXML = "ScheduleViewCell.fxml";

    @FXML
    private ListView<Person> scheduleListView;

    private ObservableList<Person> staffList;



    public ScheduleViewCell(ObservableList<Person> staffList) {
        super(FXML);
        scheduleListView.setItems(staffList);
        scheduleListView.setCellFactory(listView -> new ScheduleListViewCell());


    }

    class ScheduleListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person staff, boolean empty) {
            super.updateItem(staff, empty);
            if (empty || staff == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ScheduleViewCard(staff, getIndex() + 1).getRoot());
            }
        }
    }


}
