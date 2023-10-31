package seedu.address.model.leave;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.leave.exceptions.EndBeforeStartException;
import seedu.address.model.person.ComparablePerson;
import seedu.address.model.person.Person;

/**
 * Represents a Leave request of an employee in the address book
 */
public class Leave {

    private final ComparablePerson employee;
    private final String title;
    private final String description;
    private final Date start;
    private final Date end;
    private final Status status;

    /**
     * Constructor for Leave object. Takes in a Person object, title and description, start and end date.
     * Requires all fields to be non-null.
     *
     * @param employee
     * @param title
     * @param description
     * @param start
     * @param end
     */
    public Leave(ComparablePerson employee, String title, Date start, Date end, String description)
            throws EndBeforeStartException {

        requireAllNonNull(employee, title, description, start, end);

        if (end.isBefore(start)) {
            throw new EndBeforeStartException();
        }
        this.employee = employee;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.status = Status.getDefault();
    }

    /**
     * Constructor for Leave object without the optional description field.
     *
     * @param employee
     * @param title
     * @param start
     * @param end
     */
    public Leave(ComparablePerson employee, String title, Date start, Date end)
            throws EndBeforeStartException {

        requireAllNonNull(employee, title, start, end);
        if (end.isBefore(start)) {
            throw new EndBeforeStartException();
        }
        this.employee = employee;
        this.title = title;
        this.description = "";
        this.start = start;
        this.end = end;
        this.status = Status.getDefault();
    }

    /**
     * Constructor for Leave object with status.
     *
     * @param employee
     * @param title
     * @param start
     * @param end
     * @param description
     * @param status
     */
    public Leave(ComparablePerson employee, String title, Date start, Date end, String description, Status status)
            throws EndBeforeStartException {

        requireAllNonNull(employee, title, description, start, end, status);

        if (end.isBefore(start)) {
            throw new EndBeforeStartException();
        }
        this.employee = employee;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public ComparablePerson getEmployee() {
        return employee;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getStatus() {
        return status.toString();
    }

    public boolean belongsTo(Person employee) {
        return this.employee.equals(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Leave)) {
            return false;
        }

        Leave otherLeave = (Leave) o;
        return otherLeave.getEmployee().isSamePerson(getEmployee())
                && otherLeave.getTitle().equals(getTitle())
                && otherLeave.getDescription().equals(getDescription())
                && otherLeave.getStart().equals(getStart())
                && otherLeave.getEnd().equals(getEnd())
                && otherLeave.getStatus().equals(getStatus());
    }

    /**
     * Returns true if both leaves have the same identity and data fields.
     */
    public boolean isSameLeave(Leave otherLeave) {
        if (otherLeave == this) {
            return true;
        }

        return otherLeave != null
                && otherLeave.getEmployee().isSamePerson(getEmployee())
                && otherLeave.getStart().equals(getStart())
                && otherLeave.getEnd().equals(getEnd());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Employee: ")
                .append(getEmployee().getName())
                .append(" Title: ")
                .append(getTitle())
                .append(" Start: ")
                .append(getStart())
                .append(" End: ")
                .append(getEnd())
                .append(" Status: ")
                .append(getStatus());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(employee, title, description, start, end);
    }
}