package greedyProgramming;

import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;

public class ConferenceRoomAssignmentProblem {

	public static LinkedList schedule(LinkedList<Conference> conferenceList) {
		LinkedList<Conference> assignmentList = new LinkedList<Conference>();
		Collections.sort(conferenceList);

		assignmentList.add(conferenceList.getFirst());

		LocalTime lastEndTime = assignmentList.getLast().getEndTime();
		for (int i = 1; i < conferenceList.size(); i++) {
			Conference conference = conferenceList.get(i);
			if (lastEndTime.isBefore(conference.getStartTime())) {
				assignmentList.add(conference);
				lastEndTime = conference.getEndTime();
			}
		}
		return assignmentList;
	}

}
