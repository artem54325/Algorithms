package algorithms.grok.algorithms.readyMadeProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class JapanEditor {
    public static class ComparePrefixWithFreq implements Comparator {
        @Override
        public int compare( Object obj1, Object obj2 )
        {
            int cmp = ((WordItem) obj2).count - ((WordItem) obj1).count; // compare in reverse frequencies
            if ( cmp != 0 ) // texts are not equals
                return cmp;
            return((WordItem)obj1).word.compareTo( ((WordItem)obj2).word ); // if freqs are equal, compare lexicographically
        }
    }

    /**
     * Class to store vocabulary item and make it comparable only  lexicographically
     */
    public static class WordItem implements Comparable
    {
        public String word;
        public int count;

        public WordItem( String word, int count )
        {
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo( Object obj )
        {
            return this.word.compareTo( ((WordItem)obj).word );
        }
    }

    /**
     * Обработки ошибок НЕТ
     * @param args путь_к_файлу_с_данными, где хранится задание
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        long start = new Date().getTime();
        BufferedReader brd  = new BufferedReader( new FileReader("out\\production\\grok_algorithms\\algorithms\\grok\\algorithms\\test.in"));
        // читаем число слов
        int wordCnt = Integer.parseInt( brd.readLine() );
        WordItem[] wordArr = new WordItem[wordCnt];
        // Читаем все слова и их частоты
        for(int i = 0; i < wordCnt; i++)
        {
            String[] elems = brd.readLine().split( " " );
            wordArr[ i ] = new WordItem( elems[0], Integer.parseInt( elems[1] )  );
        }
        // сортируем массив словаря
        Arrays.sort( wordArr );

        // сортировщик по частоте
        ComparePrefixWithFreq compareWithFrequence = new ComparePrefixWithFreq();

        // считываем и обрабатываем каждый префикс один за другим
        int prefCnt = Integer.parseInt( brd.readLine() );
        System.out.printf( "Счётчик слов %d, счётчик префиксов %d\n", wordCnt, prefCnt );
        System.out.printf( "Словарь считан и отсортирован за %,d млс.\n\n", new Date().getTime() - start );
        int summaryWordCount = 0;
        WordItem prefixItem = new WordItem( null, 1 );
        for(int i = 0; i < prefCnt; i++)
        {
            String prefix = brd.readLine().trim();
            prefixItem.word = prefix;
            int pos = Arrays.binarySearch(wordArr, prefixItem ); // if positive, point to a word in vocabulary started from prefix or equal to it
            if ( pos < 0) // no precise prefix value found in vocabulary
                pos = -(pos + 1); // pos to the first element starting from prefix
            if ( pos >= wordCnt) // префикс отсутствует в словаре
                continue;

            if ( wordArr[pos].word.startsWith( prefix )) // Если префикс есть, ищем его конец в словаре
            {
                char nextLastChar = prefix.charAt( prefix.length() - 1 );
                prefixItem.word = prefix.substring( 0, prefix.length() -1 ) + (++nextLastChar); // готовим следующую не строку
                int pos1 = Arrays.binarySearch( wordArr, pos, wordCnt, prefixItem );  // ищем последнее вхождение префикса в словаре
                if ( pos1 < 0)
                    pos1 = -pos1;
                if ( pos1 > wordCnt)
                    pos1 = wordCnt;
                summaryWordCount += pos1 - pos;
                // pos -> first word with prefix, pos1 -> first word without prefix
                WordItem[] wordsWithPrefix = Arrays.copyOfRange( wordArr, pos, pos1 );
                Arrays.sort( wordsWithPrefix, compareWithFrequence );
                int wordWithPrefCnt = Math.min( wordsWithPrefix.length, 10 );
                for( int j = 0; j < wordWithPrefCnt; j++ )
//                    System.out.printf("%s %d\n", item.word, item.count); // debug output
                    System.out.println( wordsWithPrefix[j].word + " " + wordsWithPrefix[j].count);
                System.out.println(""); // add empty line according to the task requirements
            }
        }
        brd.close();
        System.out.printf( ">>> Длительность обработки %,d млс., средний размер выборки по каждому префиксу %d\n", new Date().getTime() - start, summaryWordCount / prefCnt);
    }
}
