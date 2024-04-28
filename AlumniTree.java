package buffer;

import java.util.LinkedList;

class AlumniTree {

	String data;
	LinkedList<AlumniTree> child;
	static AlumniTree root;
   
	AlumniTree(String data) {

		this.data = data;
		this.child = new LinkedList<>();

	}

	void initializeTree() {

		root = new AlumniTree("Alumni Tree");
		root.child.add(new AlumniTree("Passing Year"));
		root.child.add(new AlumniTree("Domain"));
		root.child.add(new AlumniTree("Branch"));
		root.child.add(new AlumniTree("Organisation"));

	}

	static void addDomain(String Domain, String Uname) {

		AlumniTree newAlumni = new AlumniTree( Uname );
		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;
		
		for (AlumniTree at : temp){
			if (at.data.equals("Domain")) {
				curr = at;
			}
		}
		AlumniTree par = curr;
		child = curr.child;
		temp = child;
		curr = null;
		boolean isFound = false;

		for (AlumniTree at : temp){
			if (at.data.equals(Domain)){
				isFound = true;
				curr = at;
			}
		}
		if (isFound) {
			curr.child.add(newAlumni);
		} else {
			AlumniTree newYear = new AlumniTree(Domain);
			newYear.child.add(newAlumni);
			par.child.add(newYear);
		}
	}
	static void addBranch(String Branch, String Uname){

		AlumniTree newAlumni = new AlumniTree(Uname);
		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;
		for (AlumniTree at : temp) {
			if (at.data.equals("Branch")) {
				curr = at;
			}
		}
		AlumniTree par = curr;
		child = curr.child;
		temp = child;
		curr = null;
		boolean isFound = false;

		for (AlumniTree at : temp) {
			if (at.data.equals(Branch)) {
				isFound = true;
				curr = at;
			}
		}
		if (isFound) {
			curr.child.add(newAlumni);
		} else {
			AlumniTree newYear = new AlumniTree(Branch);
			newYear.child.add(newAlumni);
			par.child.add(newYear);
		}
	}
	static void addPassingYear(String passYear, String Uname){

		AlumniTree newAlumni = new AlumniTree(Uname);
		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;
		for (AlumniTree at : temp) {
			if (at.data.equals("Passing Year")) {
				curr = at;
			}
		}
		AlumniTree par = curr;
		child = curr.child;
		temp = child;
		curr = null;
		boolean isFound = false;

		for (AlumniTree at : temp) {
			if (at.data.equals(passYear)) {
				isFound = true;
				curr = at;
			}
		}
		if (isFound) {
			curr.child.add(newAlumni);
		} else {
			AlumniTree newYear = new AlumniTree(passYear);
			newYear.child.add(newAlumni);
			par.child.add(newYear);
		}
	}
	 void addOrganisation(String Organisation, String Uname){

		AlumniTree newAlumni = new AlumniTree(Uname);
		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;
		for (AlumniTree at : temp) {
			if (at.data.equals("Organisation")) {
				curr = at;
			}
		}
		AlumniTree par = curr;
		child = curr.child;
		temp = child;
		curr = null;
		boolean isFound = false;

		for (AlumniTree at : temp) {
			if (at.data.equals(Organisation)) {
				isFound = true;
				curr = at;
			}
		}
		if (isFound) {
			curr.child.add(newAlumni);
		} else {
			AlumniTree newYear = new AlumniTree(Organisation);
			newYear.child.add(newAlumni);
			par.child.add(newYear);
		}
	}
	 void deleteOrganisation(String Organisation, String Uname){

		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;
		for (AlumniTree at : temp){
	 	if (at.data.equals("Organisation")) {
				curr = at;
			}
		}
		AlumniTree par = curr;

		child = curr.child;

		temp = child;

		curr = null;

		boolean isFound = false;

		for (AlumniTree at : temp){

			if (at.data.equals(Organisation)){

				isFound = true;

				curr = at;
			}
		}
		if (isFound) {

			for(AlumniTree ct:curr.child){

				if(ct.data.equals(Uname)){

					curr.child.remove(ct);

				}	
			}
		} else {

			System.out.println("Alumni does not exist");
			return;
		}
		
		if(curr.child==null){

			curr=null;
		}	

      }
	
	 void deletePassingYear(String passYear, String Uname)

	{

		LinkedList<AlumniTree> child = root.child;

		LinkedList<AlumniTree> temp = child;

		AlumniTree curr = null;

		

		for (AlumniTree at : temp){

			if (at.data.equals("Passing Year")) {

				curr = at;

			}

		}

		

		AlumniTree par = curr;

		child = curr.child;

		temp = child;

		curr = null;

		boolean isFound = false;

		for (AlumniTree at : temp){

			if (at.data.equals(passYear)){

				isFound = true;

				curr = at;

			}

		}

		

		if (isFound) {

			

			for(AlumniTree ct:curr.child)

			{

				if(ct.data.equals(Uname))

				{

					curr.child.remove(ct);

					

				}

				

			}

		} else {

			System.out.println("Alumni does not exist");

			return;

		}

		

		if(curr.child==null)
		{

			curr=null;
		}
		
	}
	 void deleteBranch(String Branch, String Uname)

	{

		LinkedList<AlumniTree> child = root.child;

		LinkedList<AlumniTree> temp = child;

		AlumniTree curr = null;
		for (AlumniTree at : temp){
			if (at.data.equals("Branch")) {
				curr = at;
			}
		}
		AlumniTree par = curr;

		child = curr.child;

		temp = child;

		curr = null;

		boolean isFound = false;

		for (AlumniTree at : temp){

			if (at.data.equals(Branch)){

				isFound = true;

				curr = at;
				break;
			}
		}

		if (isFound) {

			for(AlumniTree ct:curr.child){

				if(ct.data.equals(Uname)){

					curr.child.remove(ct);
					
					break;
				}
			}
		} else {
			System.out.println("Alumni does not exist");

	     	return;
		}
		if(curr.child==null)
		{
			curr=null;
		}
	}
	 void deleteDomain(String Domain, String Uname)

	{

		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp = child;
		AlumniTree curr = null;

		for (AlumniTree at : temp){

			if (at.data.equals("Domain")) {

				curr = at;

				

			}

		}

		

		AlumniTree par = curr;

		child = curr.child;

		temp = child;

		curr = null;

		boolean isFound = false;

		for (AlumniTree at : temp){

			if (at.data.equals(Domain)){

				isFound = true;

				curr = at;

			}

		}

		if (isFound) {

			for(AlumniTree ct:curr.child)

			{

				if(ct.data.equals(Uname))

				{

					curr.child.remove(ct);

				}
			}

		} else {

			System.out.println("Alumni does not exist");

			return;
		}

	if(curr.child==null)

		{

			curr=null;

		}

		

	}

}
