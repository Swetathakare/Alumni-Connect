package buffer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	
    private static JPanel mainPanel;
    private JButton[] optionButtons;
    private AlumniDB alumniDB;
    private StudentDB studentDB;

    private boolean loggedIn = false;

    private  void seeAlumniByPreference(int ch) {
		// Options based on alumni preferences
		switch (ch) {
		case 1:
			LinkedList<AlumniTree> almns = AlumniDB.seeAlumniByBranch(AlumniDB.a.root);
			displayPreferenceChoices(almns);
			break;
		case 2:

			almns = AlumniDB.seeAlumniByPassingYear(AlumniDB.a.root);
			displayPreferenceChoices(almns);
			break;
		case 3:
			 almns = AlumniDB.seeAlumniByDomain(AlumniDB.a.root);
			displayPreferenceChoices(almns);
			break;
		case 4:
			
			 almns = AlumniDB.seeAlumniByOrganisation(AlumniDB.a.root);
			displayPreferenceChoices(almns);
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

        // Initialize option buttons array
        optionButtons = new JButton[5];

        // Create the main menu
        displayMainMenu();
    }

    private void displayMainMenu() {
        mainPanel.removeAll();

        // Creating a JLabel to hold the background image
        ImageIcon backgroundImage = new ImageIcon("sample.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // Switching to BoxLayout with Y_AXIS alignment
        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));

        // Adding vertical strut for spacing
        backgroundLabel.add(Box.createVerticalGlue());

        // Creating panel for buttons with BoxLayout Y_AXIS alignment
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally

        // Creating buttons for Alumni and Student options
        JButton alumniButton = new JButton("Alumni");
        alumniButton.setFont(alumniButton.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        alumniButton.setMaximumSize(new Dimension(150, 30)); // Set maximum size
        alumniButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
        alumniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAlumniOptions();
            }
        });
        buttonPanel.add(alumniButton);

        // Adding vertical strut for spacing
        buttonPanel.add(Box.createVerticalStrut(20)); // Adjust spacing as needed

        JButton studentButton = new JButton("Student");
        studentButton.setFont(studentButton.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        studentButton.setMaximumSize(new Dimension(150, 30)); // Set maximum size
        studentButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loggedIn) {
                    displayStudentOptions();
                } else {
                    displayStudentLoginSignup();
                }
            }
        });
        buttonPanel.add(studentButton);

        // Adding button panel to main panel
        backgroundLabel.add(buttonPanel, BorderLayout.CENTER);

        // Adding vertical strut for spacing
        backgroundLabel.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        mainPanel.add(backgroundLabel);

        // Adding vertical strut for spacing
        mainPanel.add(Box.createVerticalGlue());

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void displayStudentLoginSignup() {
        mainPanel.removeAll();
        
        // Creating panel for student options with GridBagLayout
        JPanel studentOptionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing between components
        gbc.anchor = GridBagConstraints.CENTER;
        
        // Adding title label
        JLabel titleLabel = new JLabel("Student Options:");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16)); // Increase font size and make it bold
        studentOptionsPanel.add(titleLabel, gbc);
        
        // Adding login button
        gbc.gridy++;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(loginButton.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        loginButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStudentLogin();
            }
        });
        studentOptionsPanel.add(loginButton, gbc);

        // Adding signup button
        gbc.gridy++;
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(signUpButton.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        signUpButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStudentSignup();
            }
        });
        studentOptionsPanel.add(signUpButton, gbc);

        // Adding back button
        gbc.gridy++;
        JButton backButton = new JButton("Back");
        backButton.setFont(backButton.getFont().deriveFont(Font.PLAIN, 14)); // Decrease font size
        backButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainMenu(); // Call method to display main menu
            }
        });
        studentOptionsPanel.add(backButton, gbc);

        // Add student options panel to main panel
        mainPanel.add(studentOptionsPanel);

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
        	        displayStudentLoginSignup();
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
                displayStudentLoginSignup(); // Go back to the signup/login options
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
        mainPanel.add(new JLabel("Alumni Options:"));

        // Adding buttons for alumni options
        String[] alumniOptions = {"Login", "Sign Up", "Exit"};
        for (int i = 0; i < alumniOptions.length; i++) {
            JButton button = new JButton(alumniOptions[i]);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (finalI == 0) {
                        // Login button clicked
                        handleAlumniLogin();
                    } else if (finalI == 1) {
                        // Sign Up button clicked
                        JOptionPane.showMessageDialog(Main.this, "Alumni Sign Up");
                    } else {
                        // Exit button clicked
                        JOptionPane.showMessageDialog(Main.this, "Exiting Alumni");
                        System.exit(0);
                    }
                }
            });
            optionButtons[i] = button;
            mainPanel.add(button);
        }

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
    private void displayStudentOptions() {
        mainPanel.removeAll();
        
        // Creating panel for student options with GridBagLayout
        JPanel studentOptionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing between components
        gbc.anchor = GridBagConstraints.CENTER;
        
        JLabel titleLabel = new JLabel("Student Options:");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16)); // Increase font size and make it bold
        studentOptionsPanel.add(titleLabel, gbc);
        
        gbc.gridy++;
        
        // Adding buttons for student options
        String[] studentOptions = {"See all alumni", "See alumni based on preference", "See alumni based on username", "See all posts", "Exit"};
        Dimension maxButtonSize = new Dimension(0, 0); // Initial maximum button size
        for (String option : studentOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(300, 50)); // Set preferred size for buttons
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleStudentOption(option);
                }
            });
            studentOptionsPanel.add(button, gbc);
            gbc.gridy++;
        }

        // Set the same size for all buttons by adjusting grid width and height
        gbc.weightx = 1.0; // Make buttons expand horizontally
        gbc.weighty = 1.0; // Make buttons expand vertically
        studentOptionsPanel.setPreferredSize(new Dimension(250, 200)); // Set preferred size for panel
        
        // Add student options panel to main panel
        mainPanel.add(studentOptionsPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }


    private void displayAlumniPreferenceOptions() {
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
                button.addActionListener(e -> displayStudentOptions()); // Display student options on Back button click
            } else {
                button.addActionListener(e -> {
                    handlePreferenceOption(option);
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
      void displayPreferenceChoices(LinkedList<AlumniTree> options) {
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
            	displaySpecificAlumni(option,options);
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


private void handlePreferenceOption(String preferenceOption) {
    switch(preferenceOption) {
        case "Based on branch":
        	seeAlumniByPreference(1);
        	//displaySpecificAlumni(seeAlumniByPreference(1) ) ;
        	break;
        case "Based on passing year":
        	seeAlumniByPreference(2);
            // Implement based on passing year logic
            break;
        case "Based on domain":
        	seeAlumniByPreference(3);
            // Implement based on domain logic
            break;
        case "Based on organization":
        	seeAlumniByPreference(4);
            // Implement based on organization logic
            break;
        default:
            // Handle default case
            break;
    }
}
    // Method to handle student option selection
    private void handleStudentOption(String option) {
        switch(option) {
            case "See all alumni":
                displayAllAlumni();
                break;
            case "See alumni based on preference":
            	displayAlumniPreferenceOptions();
               
                break;
            case "See alumni based on username":
                String uname = JOptionPane.showInputDialog(Main.this, "Enter Alumni Username:");
                alumniDB.displayAlumniDetailsById(uname);
                break;
            case "See all posts":
                alumniDB.printAllPosts();
                break;
            case "Exit":
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
            displayStudentOptions();
        } else {
            JOptionPane.showMessageDialog(Main.this, "Invalid Student Username or Password.");
        }
    }

   
    private void displayAllAlumni() {
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
            alumniButton.addActionListener(e -> displayAlumniDetails(alumni));

            // Set preferred size
            alumniButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

            // Add button to main panel
            gbc.gridx = colIndex;
            gbc.gridy = rowIndex + 1; // Start from row 1 (below the title)
            mainPanel.add(alumniButton, gbc);

            index++;
        }

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

    private void displaySpecificAlumni(String opt, LinkedList<AlumniTree> alumniList) {
    	
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
            alumniButton.addActionListener(e -> displayAlumniDetails(alumni));

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
        	displayAlumniPreferenceOptions();
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

    private void displayAlumniDetails(Alumni alumni) {
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
