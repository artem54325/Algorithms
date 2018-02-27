package algorithms.grok.algorithms;


import algorithms.grok.algorithms.other.CountedWord;
import algorithms.grok.algorithms.other.ISearch;
import algorithms.grok.algorithms.other.ISort;
import algorithms.grok.algorithms.search.BinarySearch;
import algorithms.grok.algorithms.sort.QuickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainAlgorithms {
    // Краткое описание задачи лежит в readme файле!!

    // Для решение задачи придется применить вида 2 сортировки и 1 поиск
    // Первая будет сортировка будет по алфовиту
    // Вторая сортировка будет по числам, от меньшего к большему.

    private static ISearch search;
    private static ISort sort;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("out\\production\\grok_algorithms\\algorithms\\grok\\algorithms\\test.in"));//C:\Users\Nicee\Desktop\grok_algorithms\src\algorithms\grok\algorithms\test.in
        int listSize = Integer.parseInt(br.readLine());
        Date date = new Date();
        CountedWord[] list = new CountedWord[listSize];
        for (int i=0;i<listSize;i++) {
            list[i] = new CountedWord(br.readLine());
        }
        //Первая сортировка!
        sort = new QuickSort();

        list = sort.sortAlphabet(list);
        int searchSize = Integer.parseInt(br.readLine());
        search = new BinarySearch();
        for (int i=0;i<searchSize;i++){
            //ВАРИАНТ №1

            //Список слов для поиска. Сортировка и показ слов
//            writeConsole(sort.sortNumber(search.findWord(list, br.readLine())));

            //ВАРИАНТ №2

            List<CountedWord> list1 = searchWordsTen(list, br.readLine());
            if (list1==null) continue;
            Collections.sort(list1, (o1, o2) -> o2.getNumber()-o1.getNumber());
            writeConsole(list1);
        }
        System.out.println(new Date().getTime()-date.getTime());
    }

    private static void writeConsole(List<CountedWord> wordList) {
        if (wordList==null&&wordList.size()==0)return;
        for (int i=0;i<10&&i<wordList.size();i++)
            System.out.println(wordList.get(i).toString());
        System.out.println();
    }
    private static List<CountedWord> searchWordsTen(CountedWord[] wordList, String key){
        List<CountedWord> dictionary = new ArrayList<>();
        for (int a = Arrays.binarySearch(wordList, new CountedWord(key, 0), (CountedWord o1, CountedWord o2) -> o1.getWord().compareTo(o2.getWord())); a<wordList.length&&a!=-1&&a>=0; a++){
            if (wordList[a].getWord().contains(key))
                dictionary.add(wordList[a]);
            else
                break;
        }
        return dictionary.size()==0?null:dictionary;
    }
}
