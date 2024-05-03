import org.junit.jupiter.api.Test;
import org.stepaniuk.DateSorter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateSorterTest {

    @Test
    void sortsDatesWithMonthContainingRFirst() {
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> unsortedDates = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );

        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(Arrays.asList(
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3),
                LocalDate.of(2004, 7, 1)
        ), sortedDates);
    }

    @Test
    void sortsDatesWithMonthNotContainingRLast() {
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2022, 5, 1),
                LocalDate.of(2022, 6, 1),
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 8, 1)
        );

        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(Arrays.asList(
                LocalDate.of(2022, 8, 1),
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 6, 1),
                LocalDate.of(2022, 5, 1)
        ), sortedDates);
    }

    @Test
    void returnsEmptyCollectionWhenNoDatesProvided() {
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> unsortedDates = List.of();

        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(List.of(), sortedDates);
    }
}
