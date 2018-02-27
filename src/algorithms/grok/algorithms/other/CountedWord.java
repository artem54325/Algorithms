package algorithms.grok.algorithms.other;

public class CountedWord implements Comparable<CountedWord> {
    private String word;
    private int number;

    public CountedWord(String string) {
        this.word = string.split(" ")[0];
        this.number = Integer.parseInt(string.split(" ")[1]);
    }

    public CountedWord(String word, int number) {
        this.word = word;
        this.number = number;
    }

    public CountedWord() {
    }

    public String getWord() {
        return word;
    }

    public int getNumber() {
        return number;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return word + " " + number;
    }

    @Override
    public int compareTo(CountedWord o) {
//        return getWord().compareTo(o.getWord());
        return o.getWord().compareTo(getWord());
    }
}
