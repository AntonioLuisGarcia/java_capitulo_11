package estadisticas;

public class Word implements Comparable<Word>{

    private String text;
    private int count;

    public Word(String text, int count){
        this.text = text;
        this.count = count;
    }

    
    public String getText() {
        return text;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int c){
        this.count = c;
    }

    public int inc(){
        return this.count++;
    }

    public int dec(){
        return this.count--;
    }
    
    @Override
    public int compareTo(Word o) {
        return this.text.compareTo(o.getText());
    }

    @Override
    public boolean equals(Object o){
        return (this == o || ( o.getClass() == this.getClass() && this.text.equals( ((Word) o).text)));
    }

    @Override
    public String toString(){
        return this.text + " " + this.count + " veces";
    }

}
