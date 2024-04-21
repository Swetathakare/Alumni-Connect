package buffer;

import java.time.LocalDate;
import java.util.ArrayList;

class Post {

	String Id;

	String Title;

	LocalDate postDate;

	String deadlineOfRegistration;

	LocalDate dateOfEvent;

	String postDescription;

	ArrayList<String> postTags;

	public Post(String Id, String Title, LocalDate postDate, String deadlineOfRegistration, LocalDate dateOfEvent,

			String postDescription, ArrayList<String> postTags) {

		this.Id = Id;

		this.Title = Title;

		this.postDate = postDate;

		this.deadlineOfRegistration = deadlineOfRegistration;

		this.dateOfEvent = dateOfEvent;

		this.postDescription = postDescription;

		this.postTags = postTags;

	}

	public String getId() {

		return Id;

	}

	public String getTitle() {

		return Title;

	}

	public LocalDate getPostDate() {

		return postDate;

	}

	public String getDeadlineOfRegistration() {

		return deadlineOfRegistration;

	}

	public LocalDate getDateOfEvent() {

		return dateOfEvent;

	}

	public String getPostDescription() {

		return postDescription;

	}

	public ArrayList<String> getTags() {

		return postTags;

	}
}

