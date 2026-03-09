package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonCardTest {

    @BeforeAll
    public static void initJfx() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            Platform.startup(latch::countDown);
        } catch (IllegalStateException e) {
            // toolkit already initialized
            latch.countDown();
        }
        latch.await();
    }

    @Test
    public void display_remarkShown() throws InterruptedException {
        Person person = new PersonBuilder().withRemark("Likes to swim.").build();
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<PersonCard> cardRef = new AtomicReference<>();

        Platform.runLater(() -> {
            cardRef.set(new PersonCard(person, 1));
            latch.countDown();
        });

        latch.await();
        assertEquals("Likes to swim.", cardRef.get().person.getRemark().value);
    }

    @Test
    public void display_emptyRemarkShown() throws InterruptedException {
        Person person = new PersonBuilder().withRemark("").build();
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<PersonCard> cardRef = new AtomicReference<>();

        Platform.runLater(() -> {
            cardRef.set(new PersonCard(person, 1));
            latch.countDown();
        });

        latch.await();
        assertEquals("", cardRef.get().person.getRemark().value);
    }
}
