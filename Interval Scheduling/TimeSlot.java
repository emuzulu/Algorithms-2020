import java.time.LocalTime;

public class TimeSlot {
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    
    
    public TimeSlot(LocalTime startTime, LocalTime endTime, String name) {
	this.startTime = startTime;
	this.endTime = endTime;
	this.name = name;
    }

    
    
    public LocalTime getStartTime() {
        return startTime;
    }


    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }


    public LocalTime getEndTime() {
        return endTime;
    }


    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    /**
     * 
     * @author Evans
     *@JavaDoc This is a TimeSlot Object Implementation. Private Methods include the getters and setters for the start and end times
     */
    public String toString() {
	return name + " starts at " + startTime.toString() + " and ends at " + endTime.toString();
    }

}
