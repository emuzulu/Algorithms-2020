import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<TimeSlot> schedule;
    
    
    
    public Schedule() {
	this.schedule = new ArrayList<TimeSlot>();
	
    }
    
    public Boolean book(ArrayList<TimeSlot> slots ){
	// TODO Sorting Algorithm;
	sort(slots);
	for (int i = 0; i < slots.size(); i++) {
	    TimeSlot current = slots.get(i);
	    if(schedule.isEmpty()) {
		schedule.add(current);
	    }else {
		if (checkConflict(schedule.get(schedule.size()-1), current )){
		    schedule.add(current);
		}
	    }
	}
	return true;
    }
    
    private Boolean checkConflict(TimeSlot slot1, TimeSlot slot2) {
	if (slot1.getEndTime().isAfter(slot2.getStartTime())) {
	    return false;
	}
	return true;
	/**
	 * @returns false if there is a conflict  and true is there is not conflict
	 */
    }
    
    
    /**
     * 	Implemented Bubble Sort because it was easier, Merge Sort would have a better runtime though.
     * 
     * @param A list of Time Slots that are being requested
     * @return
     */
    private Boolean sort(ArrayList<TimeSlot> slots) {
	int n = slots.size();
	for (int i = 0; i < n-1; i++) {
	    for (int j = 0; j < n-i-1; j++) {
		if (slots.get(j).getEndTime().isAfter(slots.get(j+1).getEndTime())) {
		    TimeSlot temp = slots.get(j);
		    slots.set(j, slots.get(j+1));
		    slots.set(j+1, temp);
		}
	    }
	}
	return true;
    }
    
    
    
    public String toString() {
	String returned = "";
	for(int i = 0; i < schedule.size(); i++) {
	    returned = returned + "\n" + schedule.get(i).toString();
	}
	return returned;
    }
    
}
