package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;

import seedu.address.model.leave.Date;
import seedu.address.model.leave.Leave;
import seedu.address.model.leave.Status;
import seedu.address.model.person.ComparablePerson;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Leave objects.
 */
public class LeaveBuilder {
    public static final String DEFAULT_TITLE = "Alice's Maternity Leave";
    public static final String DEFAULT_DESCRIPTION = "Alice's Maternity Leave Description";
    public static final Person DEFAULT_PERSON = ALICE;
    public static final Status DEFAULT_STATUS = Status.getDefault();

    private String title;
    private String description;
    private ComparablePerson employee;
    private Date start;
    private Date end;
    private Status status;
    /**
     * Creates a {@code LeaveBuilder} with the default details.
     */
    public LeaveBuilder() {
        title = DEFAULT_TITLE;
        description = DEFAULT_DESCRIPTION;
        employee = DEFAULT_PERSON;
        status = DEFAULT_STATUS;
        // start = LocalDate.of(2020, 1, 1);
        // end = LocalDate.of(2020, 1, 2);
    }

    /**
     * Initializes the LeaveBuilder with the data of {@code leaveToCopy}.
     */
    public LeaveBuilder(Leave leaveToCopy) {
        employee = leaveToCopy.getEmployee();
        title = leaveToCopy.getTitle();
        description = leaveToCopy.getDescription();
        start = leaveToCopy.getStart();
        end = leaveToCopy.getEnd();
        status = Status.of(leaveToCopy.getStatus());
    }

    /**
     * Sets the {@code start} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withStart(Date start) {
        this.start = start;
        return this;
    }

    /**
     * Sets the {@code end} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withEnd(Date end) {
        this.end = end;
        return this;
    }

    /**
     * Sets the {@code employee} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withEmployee(ComparablePerson employee) {
        this.employee = employee;
        return this;
    }

    /**
     * Sets the {@code title} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the {@code description} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the {@code status} of the {@code Leave} that we are building.
     */
    public LeaveBuilder withStatus(String status) {
        this.status = Status.of(status);
        return this;
    }

    public Leave build() {
        return new Leave(employee, title, start, end, description, status);
    }
}