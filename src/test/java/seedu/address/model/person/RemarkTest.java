package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void constructor_validRemark_success() {
        Remark remark = new Remark("Likes to swim.");
        assertEquals("Likes to swim.", remark.value);
    }

    @Test
    public void constructor_emptyRemark_success() {
        Remark remark = new Remark("");
        assertEquals("", remark.value);
    }

    @Test
    public void toString_returnsValue() {
        Remark remark = new Remark("Some remark");
        assertEquals("Some remark", remark.toString());
    }

    @Test
    public void equals() {
        Remark remark = new Remark("Valid Remark");

        // same values -> returns true
        assertTrue(remark.equals(new Remark("Valid Remark")));

        // same object -> returns true
        assertTrue(remark.equals(remark));

        // null -> returns false
        assertFalse(remark.equals(null));

        // different types -> returns false
        assertFalse(remark.equals(5.0f));

        // different values -> returns false
        assertFalse(remark.equals(new Remark("Other Remark")));
    }

    @Test
    public void hashCode_sameValue_sameHashCode() {
        Remark remark1 = new Remark("Same remark");
        Remark remark2 = new Remark("Same remark");
        assertEquals(remark1.hashCode(), remark2.hashCode());
    }
}
