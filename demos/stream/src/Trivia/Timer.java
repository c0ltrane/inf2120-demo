package Trivia;

/**
 * Created by thomas on 10/19/17.
 */
public class Timer {
    private long start;

    public Timer() {
        this.start = System.nanoTime();
    }

    public long getElapsedTime(){
       return System.nanoTime() - start;
    }

    public void restart(){
        start = System.nanoTime();
    }
}
