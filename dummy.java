package bufferpackage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bufferpackage.Main2.DisplayRegisteredStudentsPage;


import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Main extends JFrame {
	
    private static JPanel mainPanel;
    private JButton[] optionButtons;
    private AlumniDB alumniDB;
    private AlumniTree alumniTree;
    private StudentDB studentDB;

    private boolean loggedIn = false;

    private  void seeAlumniByPreference(int ch,Student s) {
		// Options based on alumni preferences
		switch (ch) {
		case 1:
			LinkedList<AlumniTree> almns = AlumniDB.seeAlumniByBranch(AlumniDB.a.root);
			displayPreferenceChoices(almns,s);
			break;
		case 2:

			almns = AlumniDB.seeAlumniByPassingYear(AlumniDB.a.root);
			displayPreferenceChoices(almns,s);
			break;
		case 3:
			 almns = AlumniDB.seeAlumniByDomain(AlumniDB.a.root);
			displayPreferenceChoices(almns,s);
			break;
		case 4:
			
			 almns = AlumniDB.seeAlumniByOrganisation(AlumniDB.a.root);
			displayPreferenceChoices(almns,s);
			break;
		
		}
		
	}

    public Main() {
        setTitle("Alumni and Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to full-screen mode

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        add(mainPanel);

        alumniDB = new AlumniDB();
        studentDB = new StudentDB();
        alumniTree = new AlumniTree("");
        // Initialize option buttons array
        optionButtons = new JButton[5];

        // Create the main menu
        displayMainMenu();
    }
    private void displayMainMenu() {
        mainPanel.removeAll();

        // Creating a panel with a custom paintComponent method for drawing the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("C:/Users/garge/OneDrive/Buffer 5.0/buffer/src/buffer/CumminsImage.png");
                // Draw the background image
                g.drawImage(backgroundImage.getImage(), 0, 0,getWidth(), getHeight(), this);
                // Draw a translucent overlay
                g.setColor(new Color(255, 255, 255, 190)); // Set color with 180 (out of 255) alpha value
                g.fillRect(0, 0, getWidth(), getHeight()); // Fill the entire panel with the overlay color
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        // Creating a heading label
        JLabel headingLabel = new JLabel("Cummins Connect");
        headingLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 56)); // Set font and size
        headingLabel.setForeground(Color.BLACK); // Set font color
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally

        // Creating panel for buttons with BoxLayout Y_AXIS alignment
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally

        // Creating buttons for Alumni and Student options
        JButton alumniButton = new JButton("Alumni");
        setupButton(alumniButton);
        alumniButton.addActionListener(e -> displayAlumniOptions());
        buttonPanel.add(alumniButton);

        // Adding vertical strut for spacing
        buttonPanel.add(Box.createVerticalStrut(20)); // Adjust spacing as needed

        JButton studentButton = new JButton("Student");
        setupButton(studentButton);
        studentButton.addActionListener(e -> {
            
            	displayStudentLoginPage();
       
        });
        buttonPanel.add(studentButton);

        // Adding vertical glue to center the buttonPanel vertically
        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(headingLabel);
        backgroundPanel.add(Box.createVerticalStrut(20)); // Adjust spacing as needed
        backgroundPanel.add(buttonPanel);
        backgroundPanel.add(Box.createVerticalGlue());

        // Adding a border to the background panel with rounded corners and increased size
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true)); // Increase border thickness here

        // Setting minimum size of the background panel to ensure its creation
        backgroundPanel.setMinimumSize(new Dimension(800, 600)); // Adjust size according to your needs

        // Adding the background panel to the main panel
        mainPanel.add(backgroundPanel);

        // Repaint the main panel
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Method to setup button properties
    private void setupButton(JButton button) {
        button.setBackground(Color.BLACK); // Set background color to black
        button.setForeground(Color.WHITE); // Set font color to white
        button.setFont(button.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        button.setMaximumSize(new Dimension(150, 30)); // Set maximum size
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
    }
    private void handleAlumniSignUp() {
        mainPanel.removeAll();

        // Creating panel for signup form with GridBagLayout
        JPanel signupFormPanel = new JPanel(new GridBagLayout());
        signupFormPanel.setBackground(Color.WHITE); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Increased spacing between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Adding form fields
        JLabel nameLabel = new JLabel("Name:");
        signupFormPanel.add(nameLabel, gbc);
        gbc.gridx++;
        JTextField nameField = new JTextField(20);
        signupFormPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel branchLabel = new JLabel("Branch:");
        signupFormPanel.add(branchLabel, gbc);
        gbc.gridx++;
        JComboBox<String> branchDropdown = new JComboBox<>(new String[]{"Electrical Engineering", "Information Technology", "Mechanical Engineering", "Computer Science"});
        signupFormPanel.add(branchDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passingYearLabel = new JLabel("Passing Year:");
        signupFormPanel.add(passingYearLabel, gbc);
        gbc.gridx++;
        // Dynamically generate years from 1990 to current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer[] years = new Integer[currentYear - 1989];
        for (int i = 1990; i <= currentYear; i++) {
            years[i - 1990] = i;
        }
        JComboBox<Integer> passingYearDropdown = new JComboBox<>(years);
        signupFormPanel.add(passingYearDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel domainLabel = new JLabel("Domain:");
        signupFormPanel.add(domainLabel, gbc);
        gbc.gridx++;
        JTextField domainField = new JTextField(20);
        signupFormPanel.add(domainField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        signupFormPanel.add(passwordLabel, gbc);
        gbc.gridx++;
        JPasswordField passwordField = new JPasswordField(20);
        signupFormPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel organisationLabel = new JLabel("Organisation:");
        signupFormPanel.add(organisationLabel, gbc);
        gbc.gridx++;
        JTextField organisationField = new JTextField(20);
        signupFormPanel.add(organisationField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel tagsLabel = new JLabel("Tags:");
        signupFormPanel.add(tagsLabel, gbc);
        gbc.gridx++;
        JTextField tagsField = new JTextField(20);
        signupFormPanel.add(tagsField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("ID:");
        signupFormPanel.add(idLabel, gbc);
        gbc.gridx++;
        JTextField idField = new JTextField(20);
        signupFormPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel gmailLabel = new JLabel("Gmail:");
        signupFormPanel.add(gmailLabel, gbc);
        gbc.gridx++;
        JTextField gmailField = new JTextField(20);
        signupFormPanel.add(gmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel contactLabel = new JLabel("Contact:");
        signupFormPanel.add(contactLabel, gbc);
        gbc.gridx++;
        JTextField contactField = new JTextField(20);
        signupFormPanel.add(contactField, gbc);

        // Adding submit button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Spanning two columns
        gbc.anchor = GridBagConstraints.CENTER; // Align button to the center
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN); // Set button background color
        submitButton.setForeground(Color.BLACK); // Set button text color
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        submitButton.setFocusPainted(false); // Remove focus border
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String branch = (String) branchDropdown.getSelectedItem();
                Integer  passingYear = (int)passingYearDropdown.getSelectedItem();
                String domain = domainField.getText();
                String password = new String(passwordField.getPassword());
                String organisation = organisationField.getText();
                String id = idField.getText();
                String gmail = gmailField.getText();
                String contact = contactField.getText();
                String tagsString = tagsField.getText();
                ArrayList<String> tags = new ArrayList<>(Arrays.asList(tagsString.split("\\s*,\\s*")));

                // Validate input...
                if (name.isEmpty() || branch.isEmpty() ||domain.isEmpty() ||
                    password.isEmpty() || organisation.isEmpty() || tags.isEmpty() || id.isEmpty() ||
                    gmail.isEmpty() || contact.isEmpty()) {
                	
                    JOptionPane.showMessageDialog(mainPanel, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(alumniDB.alumniMap.containsKey(id)) {
                	JOptionPane.showMessageDialog(mainPanel, "Username Alreaady Registered!.");
                	return ;
                }
                if(alumniDB.alumniMap.containsKey(gmail)) {
                	JOptionPane.showMessageDialog(mainPanel, "E-mail Id Alreaady Registered!.");
                	return ;
                }
                // Further validation can be added as needed

                // Add alumni to database or perform any other action here
                // For demonstration purposes, let's print the entered data
//                System.out.println("Alumni Details:");
//                System.out.println("Name: " + name);
//                System.out.println("Branch: " + branch);
//                System.out.println("Passing Year: " + passingYear);
//                System.out.println("Domain: " + domain);
//                System.out.println("Organisation: " + organisation);
//                System.out.println("Tags: " + tags);
//                System.out.println("ID: " + id);
//                System.out.println("Gmail: " + gmail);
//                System.out.println("Contact: " + contact);
                
                
                alumniDB.alumniMap.put(id,new Alumni( name,branch ,passingYear.toString(),domain,organisation,new ArrayList<>(),id,gmail,contact,password));
                
                alumniTree.addDomain(id,domain);
                alumniTree.addOrganisation(id,domain);
                alumniTree.addPassingYear(id,passingYear.toString());
                alumniTree.addBranch(id,branch);

                JOptionPane.showMessageDialog(mainPanel, "Account successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
                displayAlumniOptions();
            }
        });

        signupFormPanel.add(submitButton, gbc);

        // Adding cancel button
        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); // Set button background color
        cancelButton.setForeground(Color.WHITE); // Set button text color
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        cancelButton.setFocusPainted(false); // Remove focus border
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAlumniOptions(); // Go back to the signup/login options
            }
        });
        signupFormPanel.add(cancelButton, gbc);

        // Add signup form panel to main panel
        mainPanel.add(signupFormPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void handleStudentSignup() {
        mainPanel.removeAll();

        // Creating panel for signup form with GridBagLayout
        JPanel signupFormPanel = new JPanel(new GridBagLayout());
        signupFormPanel.setBackground(Color.WHITE); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Increased spacing between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Adding form fields
        JLabel rollNumLabel = new JLabel("Roll Number:");
        signupFormPanel.add(rollNumLabel, gbc);
        gbc.gridx++;
        JTextField rollNumField = new JTextField(20);
        signupFormPanel.add(rollNumField, gbc);

        // Repeat the same pattern for other form fields...
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        signupFormPanel.add(nameLabel, gbc);
        gbc.gridx++;
        JTextField nameField = new JTextField(20);
        signupFormPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel contactNoLabel = new JLabel("Contact Number:");
        signupFormPanel.add(contactNoLabel, gbc);
        gbc.gridx++;
        JTextField contactNoField = new JTextField(20);
        signupFormPanel.add(contactNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        signupFormPanel.add(emailLabel, gbc);
        gbc.gridx++;
        JTextField emailField = new JTextField(20);
        signupFormPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel branchLabel = new JLabel("Branch:");
        signupFormPanel.add(branchLabel, gbc);
        gbc.gridx++;
        JTextField branchField = new JTextField(20);
        signupFormPanel.add(branchField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel yearLabel = new JLabel("Year of Study:");
        signupFormPanel.add(yearLabel, gbc);
        gbc.gridx++;
        JTextField yearField = new JTextField(20);
        signupFormPanel.add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel gpaLabel = new JLabel("GPA:");
        signupFormPanel.add(gpaLabel, gbc);
        gbc.gridx++;
        JTextField gpaField = new JTextField(20);
        signupFormPanel.add(gpaField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel interestLabel = new JLabel("Area of Interest:");
        signupFormPanel.add(interestLabel, gbc);
        gbc.gridx++;
        JTextField interestField = new JTextField(20);
        signupFormPanel.add(interestField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel workExpLabel = new JLabel("Work Experience:");
        signupFormPanel.add(workExpLabel, gbc);
        gbc.gridx++;
        JTextField workExpField = new JTextField(20);
        signupFormPanel.add(workExpField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        signupFormPanel.add(passwordLabel, gbc);
        gbc.gridx++;
        JPasswordField passwordField = new JPasswordField(20);
        signupFormPanel.add(passwordField, gbc);

        // Adding submit button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Spanning two columns
        gbc.anchor = GridBagConstraints.CENTER; // Align button to the center
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN); // Set button background color
        submitButton.setForeground(Color.BLACK); // Set button text color
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        submitButton.setFocusPainted(false); // Remove focus border
        	submitButton.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	        String rollNum = rollNumField.getText();
        	        String name = nameField.getText();
        	        String contactNo = contactNoField.getText();
        	        String email = emailField.getText();
        	        String branch = branchField.getText();
        	        String yearOfStudyStr = yearField.getText();
        	        String gpaStr = gpaField.getText();
        	        String areaOfInterest = interestField.getText();
        	        String workExperience = workExpField.getText();
        	        String password = new String(passwordField.getPassword());

        	        // Validate input...
        	        if (rollNum.isEmpty() || name.isEmpty() || contactNo.isEmpty() || email.isEmpty() ||
        	            branch.isEmpty() || yearOfStudyStr.isEmpty() || gpaStr.isEmpty() || areaOfInterest.isEmpty() ||
        	            workExperience.isEmpty() || password.isEmpty()) {
        	            JOptionPane.showMessageDialog(mainPanel, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	        }

        	        // Parse year of study as integer
        	        int yearOfStudy;
        	        try {
        	            yearOfStudy = Integer.parseInt(yearOfStudyStr);
        	            if (yearOfStudy < 1 || yearOfStudy > 5) {
        	                throw new NumberFormatException();
        	            }
        	        } catch (NumberFormatException ex) {
        	            JOptionPane.showMessageDialog(mainPanel, "Please enter a valid year of study (1-5).", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	        }

        	        // Validate GPA
        	        double gpa;
        	        try {
        	            gpa = Double.parseDouble(gpaStr);
        	            if (gpa < 0 || gpa > 10) {
        	                throw new NumberFormatException();
        	            }
        	        } catch (NumberFormatException ex) {
        	            JOptionPane.showMessageDialog(mainPanel, "Please enter a valid GPA between 0 and 10.", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	        }

        	        // Validate email
        	        if (!isValidEmail(email)) {
        	            JOptionPane.showMessageDialog(mainPanel, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	        }
        	        StudentDB.studentsList.add(new Student(rollNum, name,contactNo, email,
        					branch, yearOfStudy, gpa,areaOfInterest ,workExperience ,password));
        	        System.out.println(StudentDB.studentsList.get(StudentDB.studentsList.size()-1).name+" "+StudentDB.studentsList.get(StudentDB.studentsList.size()-1).name  );
        	        JOptionPane.showMessageDialog(mainPanel, "Account successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
        	        StudentDB st=new StudentDB();
        	        Student s=st.retriveStudent(email);
        	        displayStudentOptions(s);
        	        // Open new frame or perform any other action here
        	    }
        	});

        signupFormPanel.add(submitButton, gbc);

        // Adding cancel button
        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); // Set button background color
        cancelButton.setForeground(Color.WHITE); // Set button text color
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        cancelButton.setFocusPainted(false); // Remove focus border
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      //ERROR
            	
            	// displayStudentOptions(); // Go back to the signup/login options
            }
        });
        signupFormPanel.add(cancelButton, gbc);

        // Add signup form panel to main panel
        mainPanel.add(signupFormPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

 // Define a method to validate email format
    private boolean isValidEmail(String email) {
        // You can use regular expressions or other methods for email validation
        // Here's a simple check for demonstration
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
    private void displayAlumniOptions() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Add some padding
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Alumni Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 46)); // Increase the font size to 36
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Login", "Sign Up", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(200, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            // Change button background color here
            button.setBackground(new Color(41, 128, 185)); // Orange color
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside the button

            button.addActionListener(e -> {
                switch (option) {
                    case "Login":
                        handleAlumniLogin();
                        break;
                    case "Sign Up":
                    	handleAlumniSignUp();
                        break;
                    case "Back":
                        displayMainMenu();
                        break;
                }
            });

            gbc.gridy++;
            mainPanel.add(button, gbc);
        }

        // Add border to mainPanel
        Border border = BorderFactory.createLineBorder(new Color(41, 128, 185), 2);
        mainPanel.setBorder(border);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void displayStudentLoginPage() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Add some padding
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Student Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 46)); // Increase the font size to 36
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Login", "Sign Up", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(200, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            // Change button background color here
            button.setBackground(new Color(41, 128, 185)); // Orange color
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside the button

            button.addActionListener(e -> {
                switch (option) {
                    case "Login":
                        handleStudentLogin();
                        break;
                    case "Sign Up":
                        handleStudentSignup();
                        break;
                    case "Back":
                        displayMainMenu();
                        break;
                }
            });

            gbc.gridy++;
            mainPanel.add(button, gbc);
        }

        // Add border to mainPanel
        Border border = BorderFactory.createLineBorder(new Color(41, 128, 185), 2);
        mainPanel.setBorder(border);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    static boolean checkStudent(String username, String password) {
		for (Student s : StudentDB.studentsList) {
			if (s.emailId.equals(username) && s.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
    private void displayStudentOptions(Student s) {
        mainPanel.removeAll();
        
        // Creating panel for student options with GridBagLayout
        JPanel studentOptionsPanel = new JPanel(new GridBagLayout());
        studentOptionsPanel.setBackground(new Color(240, 240, 240)); // Light gray background
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some spacing between components
        gbc.anchor = GridBagConstraints.CENTER;
        
        JLabel titleLabel = new JLabel("Student Options:");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20)); // Increase font size and make it bold
        titleLabel.setForeground(new Color(41, 128, 185)); // Set text color
        studentOptionsPanel.add(titleLabel, gbc);
        
        gbc.gridy++;
        
        // Adding buttons for student options
        String[] studentOptions = {"See all alumni", "See alumni based on preference", "See alumni based on username", "See all posts", "Back"};
        Dimension buttonSize = new Dimension(300, 50); // Set the size for all buttons
        for (String option : studentOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(buttonSize); // Set preferred size for buttons
            button.setBackground(new Color(41, 128, 185)); // Set button background color
            button.setForeground(Color.WHITE); // Set button text color
            button.setFont(button.getFont().deriveFont(Font.BOLD, 16)); // Set button text font
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(option.equals("Back")) 
                	    displayStudentLoginPage();
                	else
                        handleStudentOption(option,s);
                }
            });
            studentOptionsPanel.add(button, gbc);
            gbc.gridy++;
        }

        // Set the same size for all buttons by adjusting grid width and height
        gbc.weightx = 1.0; // Make buttons expand horizontally
        gbc.weighty = 1.0; // Make buttons expand vertically
        studentOptionsPanel.setPreferredSize(new Dimension(350, 300)); // Set preferred size for panel
        
        // Add student options panel to main panel
        mainPanel.add(studentOptionsPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }


    private void handlePostSignup(String u_name) {
        mainPanel.removeAll();

        // Creating panel for post signup form with GridBagLayout
        JPanel postSignupFormPanel = new JPanel(new GridBagLayout());
        postSignupFormPanel.setBackground(new Color(255, 240, 245)); // Light pink background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Increased spacing between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Adding form fields
        
        // Adding form fields
        JLabel alumniIdLabel = new JLabel("Alumni Id:");
        alumniIdLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(alumniIdLabel, gbc);
        gbc.gridx++;
        JTextField alumniIdField = new JTextField(20);
        alumniIdField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        alumniIdField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(alumniIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(idLabel, gbc);
        gbc.gridx++;
        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        idField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(idField, gbc);

        // Repeat the same pattern for other form fields...
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(titleLabel, gbc);
        gbc.gridx++;
        JTextField titleField = new JTextField(20);
        titleField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        titleField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel dateOfEventLabel = new JLabel("Date of Event:");
        dateOfEventLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(dateOfEventLabel, gbc);
        gbc.gridx++;
        JLabel yearLabel = new JLabel("(YYYY-MM-DD)    Year:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(yearLabel, gbc);
        gbc.gridx++;
        // Using dropdowns for year, month, and date
        // For demonstration purposes, assuming years from 2024 to 2030
        String[] years = {"2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(yearComboBox, gbc);
        gbc.gridx++;
        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(monthLabel, gbc);
        gbc.gridx++;
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(monthComboBox, gbc);
        gbc.gridx++;
        JLabel dayLabel = new JLabel("Day:");
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(dayLabel, gbc);
        gbc.gridx++;
        // For simplicity, assuming 31 days in all months
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", i + 1);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(dayComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel deadlineLabel = new JLabel("Deadline of Registration:");
        deadlineLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineLabel, gbc);
        gbc.gridx++;
        JLabel deadlineYearLabel = new JLabel("(YYYY-MM-DD)    Year:");
        deadlineYearLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineYearLabel, gbc);
        gbc.gridx++;
        // Ensure deadline is after the current date
        LocalDate currentDate = LocalDate.now();
        String[] deadlineYears = new String[7]; // 7 years from current year
        for (int i = 0; i < 7; i++) {
            deadlineYears[i] = String.valueOf(currentDate.getYear() + i);
        }
        JComboBox<String> deadlineYearComboBox = new JComboBox<>(deadlineYears);
        deadlineYearComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineYearComboBox, gbc);
        gbc.gridx++;
        JLabel deadlineMonthLabel = new JLabel("Month:");
        deadlineMonthLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineMonthLabel, gbc);
        gbc.gridx++;
        JComboBox<String> deadlineMonthComboBox = new JComboBox<>(months);
        deadlineMonthComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineMonthComboBox, gbc);
        gbc.gridx++;
        JLabel deadlineDayLabel = new JLabel("Day:");
        deadlineDayLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineDayLabel, gbc);
        gbc.gridx++;
        JComboBox<String> deadlineDayComboBox = new JComboBox<>(days);
        deadlineDayComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(deadlineDayComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Post Description:");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(descriptionLabel, gbc);
        gbc.gridx++;
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(200, 100)); // Adjust width and height
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(descriptionField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel tagsLabel = new JLabel("Post Tags (comma-separated):");
        tagsLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(tagsLabel, gbc);
        gbc.gridx++;
        JTextField tagsField = new JTextField(20);
        tagsField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        tagsField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        postSignupFormPanel.add(tagsField, gbc);

        // Adding submit button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4; // Spanning four columns
        gbc.anchor = GridBagConstraints.CENTER; // Align button to the center
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(124, 252, 200)); // Light green color
        submitButton.setForeground(Color.WHITE); // Set button text color
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        submitButton.setFocusPainted(false); // Remove focus border
        submitButton.setFont(new Font("Arial", Font.BOLD, 16)); // Setting font
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 if (idField.getText().isEmpty() || titleField.getText().isEmpty() || descriptionField.getText().isEmpty() || tagsField.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(mainPanel, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                 } 
            	
            	 else {
                	 String id = idField.getText();
                     String title = titleField.getText();
                     String alumniId = alumniIdField.getText();
                     String description = descriptionField.getText();
                     String tagsInput = tagsField.getText();
                     String[] tagsArray = tagsInput.split("\\s*,\\s*");
                     ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tagsArray));

                     String year = (String) yearComboBox.getSelectedItem();
                     String month = (String) monthComboBox.getSelectedItem();
                     String day = (String) dayComboBox.getSelectedItem();
                     String deadlineYear = (String) deadlineYearComboBox.getSelectedItem();
                     String deadlineMonth = (String) deadlineMonthComboBox.getSelectedItem();
                     String deadlineDay = (String) deadlineDayComboBox.getSelectedItem();
                     LocalDate currentDate = LocalDate.now();
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                     String CurrentDate = currentDate.format(formatter);
                     
                     alumniDB.alumniMap.get(alumniId).posts.add(new Post(id,title,CurrentDate, (deadlineYear + "-" + deadlineMonth + "-" + deadlineDay),(year + "-" + month + "-" + day),description,tagsList));
                     JOptionPane.showMessageDialog(mainPanel, "Posted Successfully !");
                     showAlumniOptions(u_name);
                     
                 }            
            }
        });
        postSignupFormPanel.add(submitButton, gbc);

        // Adding cancel button
        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); // Set button background color
        cancelButton.setForeground(Color.WHITE); // Set button text color
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding
        cancelButton.setFocusPainted(false); // Remove focus border
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16)); // Setting font
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAlumniOptions(u_name);
            }
        });
        postSignupFormPanel.add(cancelButton, gbc);

        // Add post signup form panel to main panel
        mainPanel.add(postSignupFormPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showAlumniOptions(String u_name) {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Add some padding
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Alumni Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 46)); // Increase the font size
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Create a post", "Update Account", "Delete Account", "See Registrations", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(250, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            // Change button background color here
            button.setBackground(new Color(41, 128, 185)); // Orange color
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside the button

            button.addActionListener(e -> {
                switch (option) {
                    case "Create a post":
                    	handlePostSignup(u_name);
                    	break;
                    case "Update Account":
                    	handleUpdateAccount(alumniDB.alumniMap.get(u_name));
                        // Implement logic for updating account
                        break;
                    case "Delete Account":
                    	 String enteredUsername = JOptionPane.showInputDialog(mainPanel, "Enter Username:");
                    	    String enteredPassword = JOptionPane.showInputDialog(mainPanel, "Enter Password:");

                    	    // Check if entered username and password match the alumni's credentials
                    	    if (enteredUsername != null && enteredPassword != null) {
                    	        if (alumniDB.alumniMap.containsKey(u_name) && enteredUsername.equals(u_name) && enteredPassword.equals(alumniDB.alumniMap.get(u_name).password)) {
                    	        	Alumni a = alumniDB.alumniMap.get(u_name);
                    	        	
                    	        	alumniTree.deleteDomain(a.domain,a.id);
                    	        	alumniTree.deleteOrganisation(a.organisation,a.id);
                    	        	alumniTree.deleteBranch(a.branch,a.id);
                    	        	alumniTree.deletePassingYear(a.passingYear,a.id);
                    	        	
                    	        	alumniDB.alumniMap.remove(u_name);
                    	            JOptionPane.showMessageDialog(mainPanel, "Alumni account deleted successfully!");
                    	        } else {
                    	            // Display error message if username or password is incorrect
                    	            JOptionPane.showMessageDialog(mainPanel, "Incorrect username or password. Please try again.");
                    	        }
                    	    } else {
                    	        // Display error message if username or password is empty
                    	        JOptionPane.showMessageDialog(mainPanel, "Please enter both username and password.");
                    	    }
                        break;
                    case "See Registrations":
                        // Implement logic for seeing registrations
                        break;
                    case "Back":
                    	displayAlumniOptions();
                        break;
                }
            });

            gbc.gridy++;
            mainPanel.add(button, gbc);
        }

        // Add border to mainPanel
        Border border = BorderFactory.createLineBorder(new Color(41, 128, 185), 2);
        mainPanel.setBorder(border);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    private void handleUpdateAccount(Alumni alumniToUpdate) {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        // Creating form panel with GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(255, 240, 245)); // Light pink background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Increased spacing between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Add labels and text fields for each attribute
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(alumniToUpdate.name, 20);
        nameField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        nameField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        JLabel domainLabel = new JLabel("Domain:");
        domainLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(domainLabel, gbc);

        JTextField domainField = new JTextField(alumniToUpdate.domain, 20);
        domainField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        domainField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(domainField, gbc);

     
        // Adding "Organisation" label and text field
        JLabel organisationLabel = new JLabel("Organisation:");
        organisationLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(organisationLabel, gbc);

        JTextField organisationField = new JTextField(alumniToUpdate.organisation, 20);
        organisationField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        organisationField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(organisationField, gbc);

        // Adding "ID" label and text field
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(idLabel, gbc);

        JTextField idField = new JTextField(alumniToUpdate.id, 20);
        idField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        idField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        // Adding "Gmail" label and text field
        JLabel gmailLabel = new JLabel("Gmail:");
        gmailLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(gmailLabel, gbc);

        JTextField gmailField = new JTextField(alumniToUpdate.gmail, 20);
        gmailField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        gmailField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(gmailField, gbc);

        // Adding "Contact" label and text field
        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(contactLabel, gbc);

        JTextField contactField = new JTextField(alumniToUpdate.contact, 20);
        contactField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        contactField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(contactField, gbc);

        // Adding "Password" label and text field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField(alumniToUpdate.password, 20);
        passwordField.setPreferredSize(new Dimension(200, 30)); // Adjust width and height
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16)); // Setting font
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        mainPanel.add(formPanel);

        // Adding buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(124, 252, 200)); // Light green color
        updateButton.setForeground(Color.WHITE); // Set button text color
        updateButton.setFont(new Font("Arial", Font.BOLD, 16)); // Setting font
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to update alumni account
            	   String updatedName = nameField.getText();
                   String updatedDomain = domainField.getText();
                   String updatedOrganisation = organisationField.getText();
                   String updatedID = idField.getText();
                   String updatedGmail = gmailField.getText();
                   String updatedContact = contactField.getText();
                   String updatedPassword = passwordField.getText();

                   // Check if any of the values have changed
                   boolean changed = false;
                   if (!updatedID.equals(alumniToUpdate.id)) {
                       if(!alumniDB.alumniMap.containsKey(updatedID)) {
                    	   
                    	   alumniDB.alumniMap.remove(updatedID);
                    	   alumniDB.alumniMap.put(updatedID,new Alumni(updatedName ,alumniToUpdate.branch,alumniToUpdate.passingYear,alumniToUpdate.domain,updatedOrganisation,alumniToUpdate.tags,updatedID,updatedGmail,updatedContact,updatedPassword));
                    	   alumniTree.deleteDomain(alumniToUpdate.domain,alumniToUpdate.id);
                    	   alumniTree.deleteOrganisation(alumniToUpdate.organisation,alumniToUpdate.id);
                    	   alumniTree.deletePassingYear(alumniToUpdate.passingYear,alumniToUpdate.id);
                    	   alumniTree.deleteBranch(alumniToUpdate.branch,alumniToUpdate.id);
                    	   
                    	   alumniTree.addDomain(updatedDomain,updatedID);
                    	   alumniTree.addOrganisation(updatedOrganisation,updatedID);
                    	   alumniTree.addPassingYear(alumniToUpdate.passingYear,updatedID);
                    	   alumniTree.addBranch(alumniToUpdate.branch,updatedID);
                    	   
                       }
                   }else {
                	   
                   if (!updatedName.equals(alumniToUpdate.name)) {
                	   
                       alumniToUpdate.name = updatedName;
                       changed = true;
                   }
                   if (!updatedDomain.equals(alumniToUpdate.domain)) {
                	   
                	   alumniTree.deleteDomain(alumniToUpdate.domain,alumniToUpdate.id);
                	   alumniTree.addDomain(updatedDomain,alumniToUpdate.id);

                       alumniToUpdate.domain = updatedDomain;
                       
                       changed = true;
                   }
                   if (!updatedOrganisation.equals(alumniToUpdate.organisation)) {
                	   
                	   alumniTree.deleteOrganisation(alumniToUpdate.organisation,alumniToUpdate.id);
                	   alumniTree.addOrganisation(updatedOrganisation,alumniToUpdate.id);
                	   
                       alumniToUpdate.organisation = updatedOrganisation;

                	   changed = true;
                   }
                  
                   if (!updatedGmail.equals(alumniToUpdate.gmail)) {
                       alumniToUpdate.gmail = updatedGmail;
                       changed = true;
                   }
                   if (!updatedContact.equals(alumniToUpdate.contact)) {
                       alumniToUpdate.contact = updatedContact;
                       changed = true;
                   }
                   if (!updatedPassword.equals(alumniToUpdate.password)) {
                       alumniToUpdate.password = updatedPassword;
                       changed = true;
                   }
                   }
   	            JOptionPane.showMessageDialog(mainPanel, "U");
                   showAlumniOptions(updatedID);
                }                          
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 99, 71)); // Tomato color
        cancelButton.setForeground(Color.WHITE); // Set button text color
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16)); // Setting font
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to go back to the main page
                // For example, if mainPanel is the container for the main page, you can set it visible here
                showAlumniOptions(idField.getText());
                // You may need to hide or dispose the current window/dialog where the update form is displayed
            }
        });

        buttonsPanel.add(updateButton);
        buttonsPanel.add(cancelButton);
        mainPanel.add(buttonsPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }


    private void displayAlumniPreferenceOptions(Student s) {
        String[] preferenceOptions = {
            "Based on branch",
            "Based on passing year",
            "Based on domain",
            "Based on organization",
            "Back"
        };
        
        JPanel preferencePanel = new JPanel(new GridBagLayout()); // Using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding
        
        for (String option : preferenceOptions) {
            JButton button = new JButton(option);
            if (option.equals("Back")) {
                button.addActionListener(e -> displayMainMenu()); // Display student options on Back button click
            } else {
                button.addActionListener(e -> {
                    handlePreferenceOption(option,s);
                });
            }
            button.setPreferredSize(new Dimension(300, 60)); // Set preferred button size
            preferencePanel.add(button, gbc);
            gbc.gridy++; // Move to the next row
        }
        
        // Add preference panel to main panel
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(preferencePanel), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
      void displayPreferenceChoices(LinkedList<AlumniTree> options,Student s) {
        JPanel optionsPanel = new JPanel(new GridBagLayout()); // Using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding
        
        for (AlumniTree o : options) {
        	String option = o.data;
            JButton button = new JButton(option);
            button.addActionListener(e -> {
                // Handle the action when the button is clicked
            	displaySpecificAlumni(option,options,s);
            });
            button.setPreferredSize(new Dimension(300, 60)); // Set preferred button size
            optionsPanel.add(button, gbc);
            gbc.gridy++; // Move to the next row
        }
        
        // Add options panel to main panel
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(optionsPanel), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }


private void handlePreferenceOption(String preferenceOption,Student s) {
    switch(preferenceOption) {
        case "Based on branch":
        	seeAlumniByPreference(1,s);
        	break;
        case "Based on passing year":
        	seeAlumniByPreference(2,s);
            break;
        case "Based on domain":
        	seeAlumniByPreference(3,s);
            break;
        case "Based on organization":
        	seeAlumniByPreference(4,s);
            break;
        case "Back":
        	displayMainMenu();
            break;
    }
}
    // Method to handle student option selection
    private void handleStudentOption(String option,Student s) {
        switch(option) {
            case "See all alumni":
                displayAllAlumni(s);
                break;
            case "See alumni based on preference":
            	displayAlumniPreferenceOptions(s);
               
                break;
            case "See alumni based on username":
                String uname = JOptionPane.showInputDialog(Main.this, "Enter Alumni Username:");
                if(alumniDB.alumniMap.containsKey(uname))
                displayAlumniDetails(alumniDB.alumniMap.get(uname),s);
                else
                    JOptionPane.showMessageDialog(Main.this, "Incorrect Username");

                break;
            case "See all posts":
                alumniDB.printAllPosts();
                break;
            case "Back":
                JOptionPane.showMessageDialog(Main.this, "Exiting Student Options");
                break;
            default:
                // Handle default case
                break;
        }
    }

    private void handleAlumniLogin() {
        String username = JOptionPane.showInputDialog(Main.this, "Enter Alumni Username:");
        String password = JOptionPane.showInputDialog(Main.this, "Enter Alumni Password:");
        // Check credentials
        if (alumniDB.checkAlumni(username, password)) {
            JOptionPane.showMessageDialog(Main.this, "Alumni Login Successful!");
            showAlumniOptions(username);
            // Add your logic to proceed with alumni logged in
        } else {
            JOptionPane.showMessageDialog(Main.this, "Invalid Alumni Username or Password.");
        }
    }

    private void handleStudentLogin() {
        String username = JOptionPane.showInputDialog(Main.this, "Enter Student Username:");
        String password = JOptionPane.showInputDialog(Main.this, "Enter Student Password:");
        
        // Check credentials
        if (checkStudent(username, password)) {
            JOptionPane.showMessageDialog(Main.this, "Student Login Successful!");
            loggedIn = true;
            // Display student options after successful login
            StudentDB st=new StudentDB();
            Student S=null;
            for (Student s:st.studentsList)
            {
            	if((s.emailId).equals(username))
            	{
            		S=s;
            		break;
            	}
            }
            
            
            
            
            displayStudentOptions(S);
        } else {
            JOptionPane.showMessageDialog(Main.this, "Invalid Student Username or Password.");
        }
    }

    private void displayAllAlumni(Student s) {
        mainPanel.removeAll();

        // Set layout to GridBagLayout
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align components
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding

        // Add title JLabel
        JLabel titleLabel = new JLabel("All Alumni From Cummins College");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        titleLabel.setForeground(Color.WHITE); // Text color (white)
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Add padding

        // Add background color and border
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); // Dark blue background color
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Outer border color (black)
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Inner padding
        ));

        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width

        int columnCount = 2; // Number of columns
        int rowCount = (int) Math.ceil((double) AlumniDB.alumniMap.size() / columnCount); // Number of rows

        // Calculate preferred button size
        int preferredWidth = 250;
        int preferredHeight = 150;

        // Retrieve all alumni
        int index = 0;
        for (String a : AlumniDB.alumniMap.keySet()) {
            int rowIndex = index / columnCount;
            int colIndex = index % columnCount;

            Alumni alumni = AlumniDB.alumniMap.get(a);

            // Create button for alumni profile
            JButton alumniButton = new JButton("<html><b>Name:</b> " + alumni.name + "<br>" +
                    "<b>Branch:</b> " + alumni.branch + "<br>" +
                    "<b>Passing Year:</b> " + alumni.passingYear + "<br>" +
                    "<b>Domain:</b> " + alumni.domain + "<br>" 
                    );

            // Set button properties
            alumniButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
            alumniButton.setFocusPainted(false); // Remove focus border
            alumniButton.setForeground(Color.WHITE); // Text color (white)
            alumniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
            alumniButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Outer border color (black)
            alumniButton.setBackground(new Color(64, 64, 64)); // Dark gray background color
            alumniButton.setOpaque(true); // Make the button opaque

            // Add ActionListener to display alumni details when clicked
            alumniButton.addActionListener(e -> displayAlumniDetails(alumni,s));

            // Set preferred size
            alumniButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

            // Add button to main panel
            gbc.gridx = colIndex;
            gbc.gridy = rowIndex + 1; // Start from row 1 (below the title)
            mainPanel.add(alumniButton, gbc);

            index++;
        }

        // Add a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> displayStudentOptions(s));
        gbc.gridx = 0;
        gbc.gridy = rowCount + 1; // Place the back button after the alumni buttons
        gbc.gridwidth = 2; // Span across 2 columns
        mainPanel.add(backButton, gbc);

        // Add the panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scroll pane to the frame
        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }

    
    private void displaySpecificAlumni(String opt, LinkedList<AlumniTree> alumniList,Student s) {
    	
        AlumniTree lst = null;
        for (AlumniTree o : alumniList) {
            lst = o;
            if (o.data.equals(opt)) {
                break;
            }
        }
        // Clear the panel
        mainPanel.removeAll();

        // Set layout to GridBagLayout
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align components
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding

        // Add title JLabel
        JLabel titleLabel = new JLabel("-------------Alumni---------------");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        titleLabel.setForeground(Color.WHITE); // Text color (white)
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Add padding

        // Add background color and border
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); // Dark blue background color
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Outer border color (black)
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Inner padding
        ));

        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width

        int columnCount = 2; // Number of columns
        int rowCount = (int) Math.ceil((double) alumniList.size() / columnCount); // Number of rows
        // Calculate preferred button size
        int preferredWidth = 250;
        int preferredHeight = 150;

        // Retrieve all alumni
        int index = 0;
        for (AlumniTree a : lst.child) {
            Alumni alumni = AlumniDB.alumniMap.get(a.data);

            int rowIndex = index / columnCount;
            int colIndex = index % columnCount;

            // Create button for alumni profile
            JButton alumniButton = new JButton("<html><b>Name:</b> " + alumni.name + "<br>" +
                    "<b>Branch:</b> " + alumni.branch + "<br>" +
                    "<b>Passing Year:</b> " + alumni.passingYear + "<br>" +
                    "<b>Domain:</b> " + alumni.domain + "<br>" +
                    "<b>Organisation:</b> " + alumni.organisation + "<br>" +
                    "<b>Contact:</b> " + alumni.contact + "<br>" +
                    "<b>Gmail:</b> " + alumni.gmail + "</html>");

            // Set button properties
            alumniButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
            alumniButton.setFocusPainted(false); // Remove focus border
            alumniButton.setForeground(Color.WHITE); // Text color (white)
            alumniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
            alumniButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Outer border color (black)
            alumniButton.setBackground(new Color(64, 64, 64)); // Dark gray background color
            alumniButton.setOpaque(true); // Make the button opaque

            // Add ActionListener to display alumni details when clicked
            alumniButton.addActionListener(e -> displayAlumniDetails(alumni,s));

            // Set preferred size
            alumniButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

            // Add button to main panel
            gbc.gridx = colIndex;
            gbc.gridy = rowIndex + 1; // Start from row 1 (below the title)
            mainPanel.add(alumniButton, gbc);

            index++;
        }

        // Add the back button to the upper left corner
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
        	displayAlumniPreferenceOptions(s);
        });
        gbc.gridx = 0; // Align to the first column
        gbc.gridy = rowCount + 1; // Place after the last row
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align to the upper left corner
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        mainPanel.add(backButton, gbc); // Add button with constraints

        // Add the panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scroll pane to the frame
        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }

    private void displayAlumniDetails(Alumni alumni,Student s) {
        // Create a new frame to display alumni details
        JFrame detailsFrame = new JFrame("Alumni Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to full-screen mode

        // Create a panel to hold the details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(Color.WHITE); // Set background color
        detailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Add labels for each detail with custom styling
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = createLabel("<html><font size='8'><b><u>" + alumni.name + "</u></b></font></html>");
        detailsPanel.add(nameLabel, gbc);
        
        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Branch:</b> " + alumni.branch + "</html>"), gbc);

        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Passing Year:</b> " + alumni.passingYear + "</html>"), gbc);

        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Domain:</b> " + alumni.domain + "</html>"), gbc);

        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Organisation:</b> " + alumni.organisation + "</html>"), gbc);

        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Contact:</b> " + alumni.contact + "</html>"), gbc);

        gbc.gridy++;
        detailsPanel.add(createLabel("<html><b>Gmail:</b> " + alumni.gmail + "</html>"), gbc);

        // Check if alumni has any posts
        if (!alumni.posts.isEmpty()) {
            // Add heading for posts
            gbc.gridy++;
            JLabel postsLabel = createLabel("<html><font size='6' color='#800080'><b>Posts</b></font></html>");
            detailsPanel.add(postsLabel, gbc);

            // Add the alumni's posts as buttons
            for (Post post : alumni.posts) {
                gbc.gridy++;
                JButton postButton = new JButton("<html><b>Title:</b> " + post.Title + "<br>" +
                        "<b>Post Date:</b> " + post.postDate + "<br>" +
                        "<b>Deadline of Registration:</b> " + post.deadlineOfRegistration + "</html>");
                postButton.setHorizontalAlignment(SwingConstants.LEFT);
                postButton.setVerticalAlignment(SwingConstants.TOP);
                postButton.setPreferredSize(new Dimension(300, 80)); // Set preferred size for each button
                postButton.setBackground(new Color(200, 160, 220)); // Set background color (lavender/purple)
                
                // Add ActionListener to display post details on a new page
                postButton.addActionListener(e -> displayPostDetails(alumni,post,s));
                
                detailsPanel.add(postButton, gbc);
            }
        }

        // Wrap the details panel in a scroll pane
        JScrollPane scrollPane = new JScrollPane(detailsPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        detailsFrame.add(scrollPane);

        // Make the frame visible
        detailsFrame.setVisible(true);
    }
    private void displayPostDetails(Alumni alumni, Post post,Student s) {
        // Create a new frame to display post details
        JFrame postDetailsFrame = new JFrame("Post Details");
        postDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postDetailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set full-screen mode
        postDetailsFrame.setLocationRelativeTo(null); // Center the frame

        // Create a panel to hold the post details
        JPanel postDetailsPanel = new JPanel();
        postDetailsPanel.setLayout(new BorderLayout()); // Use BorderLayout for better organization
        postDetailsPanel.setBackground(Color.WHITE); // Set background color

        // Details Panel with Post Details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(6, 1)); // 6 rows, 1 column for post details
        detailsPanel.setBackground(Color.WHITE); // Set background color

        // Add labels for post details with center alignment
        addDetailLabel(detailsPanel, "Title:", post.getTitle(), SwingConstants.CENTER);
        addDetailLabel(detailsPanel, "Post Date:", post.getPostDate(), SwingConstants.CENTER);
        addDetailLabel(detailsPanel, "Deadline of Registration:", post.getDeadlineOfRegistration(), SwingConstants.CENTER);
        addDetailLabel(detailsPanel, "Description:", post.getPostDescription(), SwingConstants.CENTER);

        // Create a panel for tags with center alignment
        JPanel tagsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel tagsLabel = new JLabel("Tags:");
        tagsLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Normal font for tags label
        tagsPanel.add(tagsLabel);
        for (String tag : post.getTags()) {
            JLabel tagLabel = new JLabel(tag);
            tagLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font for tags
            tagLabel.setForeground(Color.BLUE); // Blue color for tags
            tagsPanel.add(tagLabel);
        }
        detailsPanel.add(tagsPanel); // Add the tags panel to the details panel

        // Add components to the postDetailsPanel using BorderLayout
        postDetailsPanel.add(detailsPanel, BorderLayout.CENTER); // Details panel in the center

        // Add a button to register on the post
        JButton registerButton = new JButton("Register on this Post");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font for button text
        registerButton.setForeground(Color.WHITE); // Text color (white)
        registerButton.setBackground(new Color(51, 102, 153)); // Dark blue background color
        registerButton.setFocusPainted(false); // Remove focus border
        registerButton.addActionListener(e -> {
            postDetailsFrame.dispose(); // Close the post details frame
            registerToEvent(postDetailsFrame,post, alumni,s); // Open the registration frame
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);
        buttonPanel.setBackground(Color.WHITE); // Set background color for button panel
        postDetailsPanel.add(buttonPanel, BorderLayout.SOUTH); // Button at the bottom

        // Add a button to view registered students
        JButton viewStudentsButton = new JButton("View Registered Students");
        viewStudentsButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font for button text
        viewStudentsButton.setForeground(Color.WHITE); // Text color (white)
        viewStudentsButton.setBackground(new Color(51, 102, 153)); // Dark blue background color
        viewStudentsButton.setFocusPainted(false); // Remove focus border
        viewStudentsButton.addActionListener(e -> {
            // Display registered students in a new frame
        	ArrayList<Registration> registeredStudents=post.registeredStudents;
        	DisplayRegisteredStudentsPage a=new DisplayRegisteredStudentsPage();
        	a.displayRegisteredStudents(registeredStudents);
        });
        JPanel viewStudentsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewStudentsPanel.add(viewStudentsButton);
        viewStudentsPanel.setBackground(Color.WHITE); // Set background color for button panel
        postDetailsPanel.add(viewStudentsPanel, BorderLayout.NORTH); // Button at the top

        // Add postDetailsPanel to postDetailsFrame and make it visible
        postDetailsFrame.add(postDetailsPanel);
        postDetailsFrame.setVisible(true);
    }

    
    
  
    public class DisplayRegisteredStudentsPage extends JFrame {
        private JTable table;
        private DefaultTableModel model;

        public void displayRegisteredStudents(ArrayList <Registration> studentsList) {
            // Set frame properties
            setTitle("Registered Students");
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to fullscreen
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            // Create table model with column names
            String[] columns = {"Roll No", "Name"};
            model = new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Disable editing in the table
                }
            };

            // Populate table model with student data
            for (Registration student : studentsList) {
                Object[] rowData = {student.rollNum, student.name};
                model.addRow(rowData);
            }

            // Create table with the model
            table = new JTable(model);
            table.setFont(table.getFont().deriveFont(Font.BOLD, 16)); // Set font to bold and increase size
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            // Customize cell renderer for specific columns
            table.getColumnModel().getColumn(0).setCellRenderer(new CustomCellRenderer());
            table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());

            // Add table to scroll pane with spacing
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add spacing
            add(scrollPane);

            // Set frame visible
            setVisible(true);
        }

        // Custom cell renderer for styling specific columns
        private class CustomCellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Customize appearance as needed
                if (column == 0 || column == 1) {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN, 14)); // Set font style and size
                    component.setForeground(Color.BLUE); // Set text color
                }
                return component;
            }
        }
    }
    
   // Helper method to create formatted detail labels with specified alignment
    private void addDetailLabel(JPanel panel, String labelText, String detailText, int alignment) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font for labels
        JLabel detailLabel = new JLabel(detailText);
        detailLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Normal font for details
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(label);
        labelPanel.add(detailLabel);
        labelPanel.setBackground(Color.WHITE); // Set background color for label panel
        panel.add(labelPanel);
    }

    // Helper method to create formatted detail labels with specified alignment
   


    public void registerToEvent(JFrame registrationFrame, Post p, Alumni a, Student S) {
        try {
            Registration r = new Registration(S.rollNum, S.name, S.contactNo, S.emailId);
            if (p.registeredStudents == null) {
                p.registeredStudents = new ArrayList<>(); // Initialize the list if null
            }
            p.registeredStudents.add(r);

            // Show registration success frame and back button
            JFrame successFrame = new JFrame("Registration Successful");
            successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            successFrame.setSize(300, 200); // Set a small size for the frame
            successFrame.setLocationRelativeTo(null); // Center the frame
            successFrame.getContentPane().setBackground(Color.WHITE); // Set background color to white

            // Create a panel for success message and back button
            JPanel successPanel = new JPanel();
            successPanel.setLayout(new GridLayout(2, 1));
            successPanel.setBackground(Color.WHITE); // Set background color to white

            // Add success message label
            JLabel successLabel = new JLabel("Registration Successful!");
            successLabel.setHorizontalAlignment(SwingConstants.CENTER);
            successLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Increased font size for better visibility
            successLabel.setForeground(Color.BLACK); // Set font color to black
            successPanel.add(successLabel);

            // Add back button
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> {
                successFrame.dispose(); // Close the success frame
                registrationFrame.dispose();
                
                displayAlumniDetails(a, S); // Close the registration frame

                // Optionally, you can reload or refresh the display post page here
            });
            backButton.setForeground(Color.BLACK); // Set button text color to black
            successPanel.add(backButton);

            successFrame.add(successPanel);
            successFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace for debugging
            JOptionPane.showMessageDialog(registrationFrame, "Error occurred during registration.");
        }
    }

       
   

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font style and size
        label.setForeground(Color.BLACK); // Set text color
        return label;
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Main mainGUI = new Main();
                mainGUI.setVisible(true);
            }
        });
    }
}
