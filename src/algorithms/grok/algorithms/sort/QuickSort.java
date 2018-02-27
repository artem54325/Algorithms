package algorithms.grok.algorithms.sort;

import algorithms.grok.algorithms.other.CountedWord;
import algorithms.grok.algorithms.other.ISort;

import java.util.List;

public class QuickSort implements ISort {// Быстрая сортировка
    private CountedWord[] array = null;
    private List<CountedWord> list = null;
    @Override
    public CountedWord[] sortAlphabet(CountedWord[] list) {
        array = list;
        doSortAlphabet(0, array.length-1);
        return array;
    }
    private void doSortAlphabet(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i].getWord().compareTo(array[cur].getWord())<=0)) {
                i++;
            }
            while (j > cur && (array[cur].getWord().compareTo(array[j].getWord())<=0)) {
                j--;
            }
            if (i < j) {
                CountedWord temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortAlphabet(start, cur);
        doSortAlphabet(cur+1, end);
    }

    @Override
    public CountedWord[] sortNumber(CountedWord[] list) {
        if (list==null) return null;
        array = list;
        doSort(0, array.length-1);
        return array;
    }

    @Override
    public List<CountedWord> sortNumber(List<CountedWord> array) {//Не сохраняется порядок. Смысла использовать тут быструю сортировку нету((
        if (array==null) return null;
        this.list = array;
        doSortList(0, this.list.size()-1);
        return list;
    }
    private void doSortList(int start, int end) {//Не сохраняется порядок. Смысла использовать тут быструю сортировку нету((
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (list.get(i).getNumber() >= list.get(cur).getNumber())) {
                i++;
            }
            while (j > cur && (list.get(cur).getNumber() >= list.get(j).getNumber())) {
                j--;
            }
            if (i < j) {
                CountedWord temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortList(start, cur);
        doSortList(cur+1, end);
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i].getNumber() <= array[cur].getNumber())) {
                i++;
            }
            while (j > cur && (array[cur].getNumber() <= array[j].getNumber())) {
                j--;
            }
            if (i < j) {
                CountedWord temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }
}
