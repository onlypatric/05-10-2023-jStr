import java.time.LocalDate;

/**
 * Timer
 */
public class Timer {

    public LocalDate start;
    public LocalDate stop;
    public double duration;
    public Timer(){
        this.start=null;
        this.stop=null;
        this.duration=0;
    }
    public void start(){
        this.start=LocalDate.now();
    }
    public void stop(){
        this.stop=LocalDate.now();
        this.duration=this.stop.toEpochDay()-this.start.toEpochDay();
    }
    public double getDuration(){
        return this.duration;
    }
}