package algorithms.grok.algorithms.sort;

import algorithms.grok.algorithms.other.CountedWord;
import algorithms.grok.algorithms.other.ISort;

import java.util.List;

public class CocktailSort implements ISort {
    @Override
    public CountedWord[] sortAlphabet(CountedWord[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i =0; i<=array.length-2;i++) {
                if (array[i].getWord().compareTo(array[i + 1].getWord())>0) {
                    //test whether the two elements are in the wrong order
                    CountedWord temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //we can exit the outer loop here if no swaps occurred.
                break;
            }
            swapped = false;
            for (int i= array.length - 2;i>=0;i--) {
                if (array[i].getWord().compareTo(array[i + 1].getWord())>0) {
                    CountedWord temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            //if no elements have been swapped, then the list is sorted
        } while (swapped);
        return array;
    }

    @Override
    public CountedWord[] sortNumber(CountedWord[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i =0; i<=  array.length  - 2;i++) {
                if (array[ i ].getNumber() > array[ i + 1 ].getNumber()) {
                    //test whether the two elements are in the wrong order
                    CountedWord temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //we can exit the outer loop here if no swaps occurred.
                break;
            }
            swapped = false;
            for (int i= array.length - 2;i>=0;i--) {
                if (array[ i ].getNumber() > array[ i + 1 ].getNumber()) {
                    CountedWord temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            //if no elements have been swapped, then the list is sorted
        } while (swapped);
        return array;
    }//«Шейкерная» сортировка

    @Override
    public List<CountedWord> sortNumber(List<CountedWord> array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i=0; i< array.size()-2;i++) {//Очень долго всё выполняет
                if (array.get(i).getNumber() < array.get(i+1).getNumber()) {
                    //test whether the two elements are in the wrong order
                    CountedWord temp = array.get(i);
                    array.set(i,array.get(i+1));
                    array.set(i+1,temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                //we can exit the outer loop here if no swaps occurred.
                break;
            }
            swapped = false;
            for (int i= array.size() - 2;i>=0;i--) {
                if (array.get(i).getNumber() < array.get(i+1).getNumber()) {
                    CountedWord temp = array.get(i);
                    array.set(i,array.get(i+1));
                    array.set(i+1,temp);
                    swapped = true;
                }
            }
            //if no elements have been swapped, then the list is sorted
        } while (swapped);
        return array;
    }

}
