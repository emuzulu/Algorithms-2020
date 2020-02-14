import java.time.LocalTime;
import java.util.ArrayList;

public class Bookings {
    

    
    public static void main(String[] args) {
	ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
	LocalTime start = null;
	LocalTime end= null;
	Schedule king = new Schedule();
	TimeSlot slot;
	
	start = LocalTime.of(9, 00);
	end = LocalTime.of(12, 00);
	slot = new TimeSlot(start, end, "Anthropology");
	slots.add(slot);
	
	
	start = LocalTime.of(9, 00);
	end = LocalTime.of(11, 30);
	slot = new TimeSlot(start, end, "Economics");
	slots.add(slot);
	
	start = LocalTime.of(9, 00);
	end = LocalTime.of(11, 00);
	slot = new TimeSlot(start, end, "Data Structures");
	slots.add(slot);
	
	start = LocalTime.of(12, 10);
	end = LocalTime.of(13, 10);
	slot = new TimeSlot(start, end, "Art");
	slots.add(slot);
	
	start = LocalTime.of(13, 00);
	end = LocalTime.of(14, 10);
	slot = new TimeSlot(start, end, "Dance");
	slots.add(slot);
	
	start = LocalTime.of(11, 50);
	end = LocalTime.of(12, 30);
	slot = new TimeSlot(start, end, "Systems");
	slots.add(slot);
	
	start = LocalTime.of(11, 40);
	end = LocalTime.of(13, 20);
	slot = new TimeSlot(start, end, "Chemistry");
	slots.add(slot);
	
	start = LocalTime.of(13, 30);
	end = LocalTime.of(14, 00);
	slot = new TimeSlot(start, end, "Biology");
	slots.add(slot);
	
	start = LocalTime.of(13, 40);
	end = LocalTime.of(14, 30);
	slot = new TimeSlot(start, end, "Physics");
	slots.add(slot);
	

	
	king.book(slots);
	System.out.println(king.toString());
	
	
	

    }

}
