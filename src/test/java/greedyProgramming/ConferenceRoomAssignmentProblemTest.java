package greedyProgramming;

import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class ConferenceRoomAssignmentProblemTest {

	@Test
	public void testSchedule() {
		LinkedList<Conference> conferenceList = new LinkedList<Conference>();
		for (int i = 0; conferenceList.size() <= 10; i++) {
			LocalTime startTime = LocalTime.of((int) (Math.random() * 24), (int) (Math.random() * 60));
			LocalTime endTime = LocalTime.of((int) (Math.random() * 24), (int) (Math.random() * 60));
			if (startTime.isBefore(endTime)) {
				Conference conference = new Conference(startTime, endTime);
				conferenceList.add(conference);
			}
		}
		
		ConferenceRoomAssignmentProblem conferenRoomAssingment = new ConferenceRoomAssignmentProblem();
		System.out.println("conferenceList");
		System.out.println(conferenceList);
		LinkedList assignmentList  = conferenRoomAssingment.schedule(conferenceList);
		System.out.println("assignmentList");
		System.out.println(assignmentList);

	}

}
