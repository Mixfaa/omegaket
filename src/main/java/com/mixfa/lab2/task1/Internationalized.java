package com.mixfa.lab2.task1;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public interface Internationalized {
    String toI18NString(Locale locale);

    static <T> Comparator<T> makeAlphabetComparator(Locale locale) {
        return new AlphabetComparator<>(locale);
    }

    class AlphabetComparator<T> implements Comparator<T> {
        private final Collator collator;
        private final Locale locale;

        public AlphabetComparator(Locale locale) {
            this.collator = Collator.getInstance(locale);
            this.locale = locale;
        }

        @Override
        public int compare(T o1, T o2) {

            if (o1 instanceof Internationalized o1i18n && o2 instanceof Internationalized o2i18n)
                return collator.compare(
                        o1i18n.toI18NString(locale),
                        o2i18n.toI18NString(locale)
                );

            return collator.compare(
                    o1.toString(),
                    o2.toString()
            );
        }
    }
}
