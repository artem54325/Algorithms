package algorithms.grok.algorithms.other;

import java.util.List;

public interface ISort {
    CountedWord[] sortAlphabet(CountedWord[] list);
    CountedWord[] sortNumber(CountedWord[] list);
    List<CountedWord> sortNumber(List<CountedWord> array);
}
