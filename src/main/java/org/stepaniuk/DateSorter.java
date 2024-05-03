package org.stepaniuk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class DateSorter {

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> withR = unsortedDates.stream()
                .filter(date -> date.getMonth().name().toLowerCase().contains("r"))
                .sorted(Comparator.naturalOrder())
                .toList();

        List<LocalDate> withoutR = unsortedDates.stream()
                .filter(date -> !date.getMonth().name().toLowerCase().contains("r"))
                .sorted(Comparator.reverseOrder())
                .toList();

        List<LocalDate> sortedDates = new ArrayList<>(withR);
        sortedDates.addAll(withoutR);

        return sortedDates;
    }
}