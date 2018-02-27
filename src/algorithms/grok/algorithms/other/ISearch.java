package algorithms.grok.algorithms.other;

import java.util.List;

public interface ISearch {
    List<CountedWord> findWord(CountedWord[] list, String searchWord);
}
