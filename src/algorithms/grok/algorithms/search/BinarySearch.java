package algorithms.grok.algorithms.search;

import algorithms.grok.algorithms.other.CountedWord;
import algorithms.grok.algorithms.other.ISearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch implements ISearch {

    @Override
    public /*CountedWord[]*/ List<CountedWord> findWord(CountedWord[] list, String key) {
//        CountedWord[] words = new CountedWord[list.length];
        if (key==null) return null;
        List<CountedWord> words = new ArrayList<CountedWord>();
        int number = 0;
        for (int i=search(key, list);i<list.length;i++){
            if (i==-1)break;
            if (list[i].getWord().contains(key)){
//                words[number++] = list[i];//318 423 416 359 353 371
                words.add(list[i]);
            }else {
                break;
            }
        }
        return words;
    }

    public static int search(String key, CountedWord[] a) {
        return search(key, a, 0, a.length);
    }
    public static int search(String key, CountedWord[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].getWord().compareTo(key);
        if      (cmp > 0) return search(key, a, lo, mid);
        else if (cmp < 0) return search(key, a, mid+1, hi);
        else              return mid;
    }
}
