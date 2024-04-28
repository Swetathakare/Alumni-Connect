package buffer;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;

class Post {



	String Id;



	String Title;



	String postDate;



	String deadlineOfRegistration;



	String dateOfEvent;



	String postDescription;



	ArrayList<String> postTags;

	

	ArrayList<Registration> registeredStudents= new ArrayList<>();



	public Post(String Id, String Title, String postDate, String deadlineOfRegistration, String dateOfEvent,



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



	public String getPostDate() {



		return postDate;



	}



	public String getDeadlineOfRegistration() {



		return deadlineOfRegistration;



	}



	public String getDateOfEvent() {



		return dateOfEvent;



	}



	public String getPostDescription() {



		return postDescription;



	}



	public ArrayList<String> getTags() {

		return postTags;



	}

}
