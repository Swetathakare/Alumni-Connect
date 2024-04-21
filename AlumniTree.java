package buffer;

import java.util.LinkedList;

class AlumniTree {

	String data;
	LinkedList<AlumniTree> child;
	AlumniTree root;

	AlumniTree(String data) {

		this.data = data;
		this.child = new LinkedList<>();

	}

	void initializeTree() {

		root.data = "Alumni Tree";
		root.child.add(new AlumniTree("Passing Year"));
		root.child.add(new AlumniTree("Domain"));
		root.child.add(new AlumniTree("Branch"));
		root.child.add(new AlumniTree("Organisation"));

	}

	void addPassingYear(String passYear, String Uname) {

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
}

