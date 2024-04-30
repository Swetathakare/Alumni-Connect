package buffer;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.geom.RoundRectangle2D;
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

    private  void seeAlumniByPreference(int ch,String name) {

    	switch (ch) {
		case 1:
			LinkedList<AlumniTree> almns = AlumniDB.seeAlumniByBranch(AlumniDB.a.root);
			displayPreferenceChoices(almns,name);
			break;
		case 2:
			almns = AlumniDB.seeAlumniByPassingYear(AlumniDB.a.root);
			displayPreferenceChoices(almns,name);
			break;
		case 3:
			 almns = AlumniDB.seeAlumniByDomain(AlumniDB.a.root);
			displayPreferenceChoices(almns,name);
			break;
		case 4:
			
			 almns = AlumniDB.seeAlumniByOrganisation(AlumniDB.a.root);
			displayPreferenceChoices(almns,name);
			break;
		}
	}

    public Main() {
    	
        setTitle("Alumni and Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        add(mainPanel);

        alumniDB = new AlumniDB();
        studentDB = new StudentDB();
        alumniTree = new AlumniTree("");
        optionButtons = new JButton[5];


       
        displayMainMenu();
        
    }
    private void displayMainMenu() {
        mainPanel.removeAll();

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Sweta Thakre\\Desktop\\Buffer\\Buffer\\src\\buffer\\CumminsImage.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0,getWidth(), getHeight(), this);
                g.setColor(new Color(255, 255, 255, 190)); 
                g.fillRect(0, 0, getWidth(), getHeight());             }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        JLabel headingLabel = new JLabel("Cummins Connect");
        headingLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 56)); 
        headingLabel.setForeground(Color.BLACK); 
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); 
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        // Creating buttons for Alumni and Student options
        JButton alumniButton = new JButton("Alumni");
        setupButton(alumniButton);
        alumniButton.addActionListener(e -> displayAlumniOptions());
        buttonPanel.add(alumniButton);

        buttonPanel.add(Box.createVerticalStrut(20)); 

        JButton studentButton = new JButton("Student");
        setupButton(studentButton);
        studentButton.addActionListener(e -> {
            
            	displayStudentLoginPage();
       
        });
        buttonPanel.add(studentButton);

        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(headingLabel);
        backgroundPanel.add(Box.createVerticalStrut(20)); 
        backgroundPanel.add(buttonPanel);
        backgroundPanel.add(Box.createVerticalGlue());

        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true)); 
        backgroundPanel.setMinimumSize(new Dimension(800, 600)); 

        mainPanel.add(backgroundPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void setupButton(JButton button) {
        button.setBackground(Color.BLACK); 
        button.setForeground(Color.WHITE); 
        button.setFont(button.getFont().deriveFont(Font.PLAIN, 14)); 
        button.setMaximumSize(new Dimension(150, 30));
        button.setAlignmentX(Component.CENTER_ALIGNMENT); 
    }
    private void handleAlumniSignUp() {
        mainPanel.removeAll();

        JPanel signupFormPanel = new JPanel(new GridBagLayout());
        signupFormPanel.setBackground(Color.WHITE); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST; 

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

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN); 
        submitButton.setForeground(Color.BLACK); 
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); 
        submitButton.setFocusPainted(false); 
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

        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); 
        cancelButton.setForeground(Color.WHITE); 
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); 
        cancelButton.setFocusPainted(false); 
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

        JPanel signupFormPanel = new JPanel(new GridBagLayout());
        signupFormPanel.setBackground(Color.WHITE); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST; 

        JLabel rollNumLabel = new JLabel("Roll Number:");
        signupFormPanel.add(rollNumLabel, gbc);
        gbc.gridx++;
        JTextField rollNumField = new JTextField(20);
        signupFormPanel.add(rollNumField, gbc);

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

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN); 
        submitButton.setForeground(Color.BLACK); 
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); 
        submitButton.setFocusPainted(false); 
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

        	        if (!isValidEmail(email)) {
        	            JOptionPane.showMessageDialog(mainPanel, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	        }
        	        StudentDB.studentsList.add(new Student(rollNum, name,contactNo, email,
        					branch, yearOfStudy, gpa,areaOfInterest ,workExperience ,password));
        	        System.out.println(StudentDB.studentsList.get(StudentDB.studentsList.size()-1).name+" "+StudentDB.studentsList.get(StudentDB.studentsList.size()-1).name  );
        	        JOptionPane.showMessageDialog(mainPanel, "Account successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
                	displayStudentLoginPage();
        	    }
        	});

        signupFormPanel.add(submitButton, gbc);

        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); 
        cancelButton.setForeground(Color.WHITE); 
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); 
        cancelButton.setFocusPainted(false); 
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudentOptions(""); 
            }
        });
        signupFormPanel.add(cancelButton, gbc);

        mainPanel.add(signupFormPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private boolean isValidEmail(String email) {
        
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
    private void displayAlumniOptions() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Alumni Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 46)); 
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Login", "Sign Up", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(200, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            button.setBackground(new Color(41, 128, 185));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

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
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Student Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 35)); 
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Login", "Sign Up", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(200, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            button.setBackground(new Color(41, 128, 185)); 
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
    private void displayStudentOptions(String u_name) {
        mainPanel.removeAll();
        
        JPanel studentOptionsPanel = new JPanel(new GridBagLayout());
        studentOptionsPanel.setBackground(new Color(240, 240, 240)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        JLabel titleLabel = new JLabel("Student Options");
        titleLabel.setForeground(new Color(9, 8, 20)); 
        titleLabel.setFont(new Font("Montserrat",Font.BOLD, 40)); 

        studentOptionsPanel.add(titleLabel, gbc);
        
        gbc.gridy++;
        
        String[] studentOptions = {"See all alumni", "See alumni based on preference", "See alumni based on username", "See all posts", "Show Profile", "Back"};
        Dimension buttonSize = calculateButtonSize(studentOptions);
        for (String option : studentOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(buttonSize); 
            button.setBackground(new Color(41, 128, 185)); 
            button.setForeground(Color.WHITE); 
            button.setFont(button.getFont().deriveFont(Font.BOLD, 16)); 
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(option.equals("Back")) 
                        displayStudentLoginPage();
                    else if(option.equals("Show Profile")) {
                    	showProfile(u_name);
                    }
                    else
                        handleStudentOption(option,u_name);
                }
            });
            studentOptionsPanel.add(button, gbc);
            gbc.gridy++;
        }

        mainPanel.add(studentOptionsPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    private void showProfile(String emailId) {
        Student student = null;
        for (Student s : StudentDB.studentsList) {
            if (s.emailId.equals(emailId)) {
                student = s;
                break;
            }
        }

        JFrame profileFrame = new JFrame("Student Profile");
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        profileFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        profileFrame.setUndecorated(true); 

        JPanel profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setBackground(new Color(240, 248, 255)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel profileHolderLabel = new JLabel(student.name);
        Font profileHolderFont = new Font("Brush Script MT", Font.BOLD, 60);
        profileHolderLabel.setFont(profileHolderFont);
        profileHolderLabel.setForeground(new Color(47, 79, 79)); 

        profilePanel.add(profileHolderLabel, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; 
        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        JLabel nameValueLabel = new JLabel(student.name);
        nameValueLabel.setFont(labelFont);
        JLabel rollNumLabel = new JLabel("Roll Number:");
        rollNumLabel.setFont(labelFont);
        JLabel rollNumValueLabel = new JLabel(student.rollNum);
        rollNumValueLabel.setFont(labelFont);
        JLabel contactNoLabel = new JLabel("Contact Number:");
        contactNoLabel.setFont(labelFont);
        JLabel contactNoValueLabel = new JLabel(student.contactNo);
        contactNoValueLabel.setFont(labelFont);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        JLabel emailValueLabel = new JLabel(student.emailId);
        emailValueLabel.setFont(labelFont);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        JLabel passwordValueLabel = new JLabel(student.password);
        passwordValueLabel.setFont(labelFont);
        JLabel branchLabel = new JLabel("Branch:");
        branchLabel.setFont(labelFont);
        JLabel branchValueLabel = new JLabel(student.branch);
        branchValueLabel.setFont(labelFont);
        JLabel yearOfStudyLabel = new JLabel("Year of Study:");
        yearOfStudyLabel.setFont(labelFont);
        JLabel yearOfStudyValueLabel = new JLabel(String.valueOf(student.yearOfStudy));
        yearOfStudyValueLabel.setFont(labelFont);
        JLabel GPALabel = new JLabel("GPA:");
        GPALabel.setFont(labelFont);
        JLabel GPAValueLabel = new JLabel(String.valueOf(student.GPA));
        GPAValueLabel.setFont(labelFont);
        JLabel areaOfInterestLabel = new JLabel("Area of Interest:");
        areaOfInterestLabel.setFont(labelFont);
        JLabel areaOfInterestValueLabel = new JLabel(student.areaOfInterest);
        areaOfInterestValueLabel.setFont(labelFont);

        profilePanel.add(nameLabel, gbc);
        gbc.gridx++;
        profilePanel.add(nameValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(rollNumLabel, gbc);
        gbc.gridx++;
        profilePanel.add(rollNumValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(contactNoLabel, gbc);
        gbc.gridx++;
        profilePanel.add(contactNoValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(emailLabel, gbc);
        gbc.gridx++;
        profilePanel.add(emailValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(passwordLabel, gbc);
        gbc.gridx++;
        profilePanel.add(passwordValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(branchLabel, gbc);
        gbc.gridx++;
        profilePanel.add(branchValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(yearOfStudyLabel, gbc);
        gbc.gridx++;
        profilePanel.add(yearOfStudyValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(GPALabel, gbc);
        gbc.gridx++;
        profilePanel.add(GPAValueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        profilePanel.add(areaOfInterestLabel, gbc);
        gbc.gridx++;
        profilePanel.add(areaOfInterestValueLabel, gbc);

        JButton backButton = new JButton("Back");
        backButton.setFont(labelFont);
        backButton.setPreferredSize(new Dimension(100, 40)); 
        backButton.setBackground(new Color(30, 144, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false); 
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudentOptions(emailId); 
                profileFrame.dispose(); 

            }
        });

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        profilePanel.add(backButton, gbc);

        profileFrame.add(profilePanel);

        profileFrame.setVisible(true);
    }
    private Dimension calculateButtonSize(String[] options) {
        int maxWidth = 0;
        int maxHeight = 0;
        FontMetrics metrics = new JLabel().getFontMetrics(new JButton().getFont());

        for (String option : options) {
            int width = metrics.stringWidth(option);
            int height = metrics.getHeight();
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return new Dimension(350, maxHeight + 20); 
    }
    
    private void handlePostSignup(String u_name) {
        mainPanel.removeAll();

        JPanel postSignupFormPanel = new JPanel(new GridBagLayout());
        postSignupFormPanel.setBackground(new Color(255, 240, 245)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST; 

     
        JLabel alumniIdLabel = new JLabel("Alumni Id:");
        alumniIdLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(alumniIdLabel, gbc);
        gbc.gridx++;
        JTextField alumniIdField = new JTextField(20);
        alumniIdField.setPreferredSize(new Dimension(200, 30)); 
        alumniIdField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(alumniIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(idLabel, gbc);
        gbc.gridx++;
        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(200, 30)); 
        idField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(titleLabel, gbc);
        gbc.gridx++;
        JTextField titleField = new JTextField(20);
        titleField.setPreferredSize(new Dimension(200, 30)); 
        titleField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel dateOfEventLabel = new JLabel("Date of Event:");
        dateOfEventLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(dateOfEventLabel, gbc);
        gbc.gridx++;
        JLabel yearLabel = new JLabel("(YYYY-MM-DD)    Year:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(yearLabel, gbc);
        gbc.gridx++;

        String[] years = {"2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(yearComboBox, gbc);
        gbc.gridx++;
        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(monthLabel, gbc);
        gbc.gridx++;
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(monthComboBox, gbc);
        gbc.gridx++;
        JLabel dayLabel = new JLabel("Day:");
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(dayLabel, gbc);
        gbc.gridx++;
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", i + 1);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(dayComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel deadlineLabel = new JLabel("Deadline of Registration:");
        deadlineLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(deadlineLabel, gbc);
        gbc.gridx++;
        JLabel deadlineYearLabel = new JLabel("(YYYY-MM-DD)    Year:");
        deadlineYearLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        postSignupFormPanel.add(deadlineYearLabel, gbc);
        gbc.gridx++;

        LocalDate currentDate = LocalDate.now();
        String[] deadlineYears = new String[7];
        for (int i = 0; i < 7; i++) {
            deadlineYears[i] = String.valueOf(currentDate.getYear() + i);
        }
        JComboBox<String> deadlineYearComboBox = new JComboBox<>(deadlineYears);
        deadlineYearComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(deadlineYearComboBox, gbc);
        gbc.gridx++;
        JLabel deadlineMonthLabel = new JLabel("Month:");
        deadlineMonthLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(deadlineMonthLabel, gbc);
        gbc.gridx++;
        JComboBox<String> deadlineMonthComboBox = new JComboBox<>(months);
        deadlineMonthComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        postSignupFormPanel.add(deadlineMonthComboBox, gbc);
        gbc.gridx++;
        JLabel deadlineDayLabel = new JLabel("Day:");
        deadlineDayLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(deadlineDayLabel, gbc);
        gbc.gridx++;
        JComboBox<String> deadlineDayComboBox = new JComboBox<>(days);
        deadlineDayComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(deadlineDayComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Post Description:");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        postSignupFormPanel.add(descriptionLabel, gbc);
        gbc.gridx++;
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(200, 100)); 
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 16));
        postSignupFormPanel.add(descriptionField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel tagsLabel = new JLabel("Post Tags (comma-separated):");
        tagsLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(tagsLabel, gbc);
        gbc.gridx++;
        JTextField tagsField = new JTextField(20);
        tagsField.setPreferredSize(new Dimension(200, 30)); 
        tagsField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        postSignupFormPanel.add(tagsField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4; 
        gbc.anchor = GridBagConstraints.CENTER; 
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(124, 252, 200));
        submitButton.setForeground(Color.WHITE); 
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        submitButton.setFocusPainted(false); 
        submitButton.setFont(new Font("Arial", Font.BOLD, 16)); 
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

        gbc.gridy++;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY); 
        cancelButton.setForeground(Color.WHITE); 
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        cancelButton.setFocusPainted(false); 
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16)); 
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAlumniOptions(u_name);
            }
        });
        postSignupFormPanel.add(cancelButton, gbc);

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
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Alumni Options");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 46)); 
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;

        String[] alumniOptions = {"Create a post", "Update Account", "Delete Account", "See Registrations", "Back"};
        for (String option : alumniOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(250, 40));
            button.setFont(new Font("Palatino", Font.BOLD, 18));
            button.setBackground(new Color(41, 128, 185)); 
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

            button.addActionListener(e -> {
                switch (option) {
                    case "Create a post":
                    	handlePostSignup(u_name);
                    	break;
                    case "Update Account":
                    	handleUpdateAccount(alumniDB.alumniMap.get(u_name));
                        break;
                    case "Delete Account":
                    	 String enteredUsername = JOptionPane.showInputDialog(mainPanel, "Enter Username:");
                    	    String enteredPassword = JOptionPane.showInputDialog(mainPanel, "Enter Password:");

                    	    if (enteredUsername != null && enteredPassword != null) {
                    	        if (alumniDB.alumniMap.containsKey(u_name) && enteredUsername.equals(u_name) && enteredPassword.equals(alumniDB.alumniMap.get(u_name).password)) {
                    	            int deleteConfirmation = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to delete your account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    	            if (deleteConfirmation == JOptionPane.YES_OPTION) {
                    	                Alumni a = alumniDB.alumniMap.get(u_name);
                    	                alumniTree.deleteDomain(a.domain,a.id);
                    	                alumniTree.deleteOrganisation(a.organisation,a.id);
                    	                alumniTree.deleteBranch(a.branch,a.id);
                    	                alumniTree.deletePassingYear(a.passingYear,a.id);
                    	                alumniDB.alumniMap.remove(u_name);
                    	                JOptionPane.showMessageDialog(mainPanel, "Alumni account deleted successfully!");
                    	                displayAlumniOptions();
                    	            } else {
                    	                JOptionPane.showMessageDialog(mainPanel, "Account deletion cancelled.");
                    	                showAlumniOptions(u_name);
                    	            }
                    	        } else {
                    	            JOptionPane.showMessageDialog(mainPanel, "Incorrect username or password. Please try again.");
                    	        }
                    	    } else {
                    	        JOptionPane.showMessageDialog(mainPanel, "Please enter both username and password.");
                    	    }
                        break;
                    case "See Registrations":
                        displayspecificPosts(u_name);
                        break;
                    case "Back":
                    	displayAlumniOptions();
                        break;
                }
            });

            gbc.gridy++;
            mainPanel.add(button, gbc);
        }
        
        Border border = BorderFactory.createLineBorder(new Color(41, 128, 185), 2);
        mainPanel.setBorder(border);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    private void handleUpdateAccount(Alumni alumniToUpdate) {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(255, 240, 245)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST; 
   
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(alumniToUpdate.name, 20);
        nameField.setPreferredSize(new Dimension(200, 30)); 
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        JLabel domainLabel = new JLabel("Domain:");
        domainLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(domainLabel, gbc);

        JTextField domainField = new JTextField(alumniToUpdate.domain, 20);
        domainField.setPreferredSize(new Dimension(200, 30)); 
        domainField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        formPanel.add(domainField, gbc);

     
        JLabel organisationLabel = new JLabel("Organisation:");
        organisationLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(organisationLabel, gbc);

        JTextField organisationField = new JTextField(alumniToUpdate.organisation, 20);
        organisationField.setPreferredSize(new Dimension(200, 30)); 
        organisationField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 1;
        formPanel.add(organisationField, gbc);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(idLabel, gbc);

        JTextField idField = new JTextField(alumniToUpdate.id, 20);
        idField.setPreferredSize(new Dimension(200, 30));
        idField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        
        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        JLabel gmailLabel = new JLabel("Gmail:");
        gmailLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(gmailLabel, gbc);

        JTextField gmailField = new JTextField(alumniToUpdate.gmail, 20);
        gmailField.setPreferredSize(new Dimension(200, 30)); 
        gmailField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        formPanel.add(gmailField, gbc);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(contactLabel, gbc);

        JTextField contactField = new JTextField(alumniToUpdate.contact, 20);
        contactField.setPreferredSize(new Dimension(200, 30)); 
        contactField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        formPanel.add(contactField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField(alumniToUpdate.password, 20);
        passwordField.setPreferredSize(new Dimension(200, 30)); 
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        mainPanel.add(formPanel);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(124, 252, 200)); 
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Arial", Font.BOLD, 16));
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   String updatedName = nameField.getText();
                   String updatedDomain = domainField.getText();
                   String updatedOrganisation = organisationField.getText();
                   String updatedID = idField.getText();
                   String updatedGmail = gmailField.getText();
                   String updatedContact = contactField.getText();
                   String updatedPassword = passwordField.getText();

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
   	            JOptionPane.showMessageDialog(mainPanel, "Updated Sucessfully !");
                   showAlumniOptions(updatedID);
                }                          
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 99, 71)); 
        cancelButton.setForeground(Color.WHITE); 
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16)); 
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                showAlumniOptions(idField.getText());
            }
        });

        buttonsPanel.add(updateButton);
        buttonsPanel.add(cancelButton);
        mainPanel.add(buttonsPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void displayAlumniPreferenceOptions(String name) {
        String[] preferenceOptions = {
            "Based on branch",
            "Based on passing year",
            "Based on domain",
            "Based on organization",
            "Back"
        };

        JPanel preferencePanel = new JPanel(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); 

        for (String option : preferenceOptions) {
            JButton button = new JButton(option);
            button.setPreferredSize(new Dimension(300, 60)); 

            if (option.equals("Back")) {
                button.setBackground(new Color(77, 12, 7)); 
                button.addActionListener(e -> displayStudentOptions(name));
            } else {
                button.setBackground(new Color(10, 18, 54));
                button.addActionListener(e -> {
                    handlePreferenceOption(option,name);
                });
            }
            button.setForeground(new Color(235, 227, 82));
            preferencePanel.add(button, gbc);
            gbc.gridy++; 
        }

        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(preferencePanel), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

      void displayPreferenceChoices(LinkedList<AlumniTree> options,String name) {
    	  JPanel optionsPanel = new JPanel(new GridBagLayout()); 
    	  GridBagConstraints gbc = new GridBagConstraints();
    	  gbc.gridx = 0;
    	  gbc.gridy = 0;
    	  gbc.fill = GridBagConstraints.HORIZONTAL;
    	  gbc.insets = new Insets(5, 5, 5, 5); 

    	  Color blueColor = new Color(11, 18, 48); 
    	  Color redColor = new Color(89, 25, 5); 
    	  Color mustardColor = new Color(172, 181, 7); 

    	  Font buttonFont = new Font("Arial", Font.BOLD, 14); 
    	  Font labelFont = new Font("Times New Roman", Font.ITALIC, 40); 

    	  JLabel optionLabel = new JLabel(" Your choice ");
    	  optionLabel.setFont(labelFont); 
    	  optionLabel.setForeground(mustardColor);
    	  optionsPanel.add(optionLabel, gbc);
    	  gbc.gridy++; 
    	  for (AlumniTree o : options) {
    	      String option = o.data;
    	      JButton button = new JButton(option);
    	      button.addActionListener(e -> {
    	          displaySpecificAlumni(option, options, name);
    	      });
    	      button.setPreferredSize(new Dimension(300, 60)); 
    	      button.setBackground(blueColor); 
    	      button.setForeground(mustardColor); 
    	      button.setFont(buttonFont);
    	      optionsPanel.add(button, gbc);
    	      gbc.gridy++; 
    	  }

    	  gbc.weighty = 1; 
    	  JButton backButton = new JButton("Back");
    	  backButton.addActionListener(e -> {
    	          displayStudentOptions(name);
    	  });
    	  backButton.setPreferredSize(new Dimension(100, 30)); 
    	  backButton.setBackground(redColor);
    	  backButton.setForeground(mustardColor);
    	  backButton.setFont(buttonFont); 
    	  optionsPanel.add(backButton, gbc);

    	  mainPanel.removeAll();
    	  mainPanel.setLayout(new BorderLayout());
    	  mainPanel.add(new JScrollPane(optionsPanel), BorderLayout.CENTER);
    	  mainPanel.revalidate();
    	  mainPanel.repaint();

    }


private void handlePreferenceOption(String preferenceOption,String name) {
    switch(preferenceOption) {
        case "Based on branch":
        	seeAlumniByPreference(1,name);
        	break;
        case "Based on passing year":
        	seeAlumniByPreference(2,name);
            break;
        case "Based on domain":
        	seeAlumniByPreference(3,name);
            break;
        case "Based on organization":
        	seeAlumniByPreference(4,name);
            break;
        case "Back":
        	displayStudentOptions(name);
            break;
    }
}
    private void handleStudentOption(String option,String name) {
        switch(option) {
            case "See all alumni":
                displayAllAlumni(name);
                break;
            case "See alumni based on preference":
            	displayAlumniPreferenceOptions(name);
               
                break;
            case "See alumni based on username":
                String uname = JOptionPane.showInputDialog(Main.this, "Enter Alumni Username:");
                if(alumniDB.alumniMap.containsKey(uname))
                displayAlumniDetails(alumniDB.alumniMap.get(uname),name);
                else
                    JOptionPane.showMessageDialog(Main.this, "Incorrect Username");

                break;
            case "See all posts":

                displayAllPosts(name);
                break;
            case "Back":
                JOptionPane.showMessageDialog(Main.this, "Exiting Student Options");
                break;
            default:
            	
                break;
        }
    }
    private void displayspecificPosts(String u_name) {
        mainPanel.removeAll();

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("All Posts");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
       
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); 

        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); 
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), 
                BorderFactory.createEmptyBorder(10, 20, 10, 20) 
        ));

        mainPanel.add(titleLabel, gbc);

        int preferredWidth = 470;
        int preferredHeight = 100; 

        int index = 0;
       
            for (Post post : alumniDB.alumniMap.get(u_name).posts) {
                JButton postButton = new JButton("<html><b>Title:</b> " + post.getTitle() + "<br>" +
                        "<b>Date of Event:</b> " + post.getDateOfEvent() + "</html>");

                postButton.setFont(new Font("Arial", Font.BOLD, 16)); 
                postButton.setFocusPainted(false); 
                postButton.setForeground(new Color(245, 160, 49)); 
                postButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
                postButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                postButton.setBackground(new Color(10, 26, 54)); 
                postButton.setOpaque(true);
                Border roundedBorder = new EmptyBorder(20, 20, 20, 20) {
                    @Override
                    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                        g.setColor(Color.BLACK);
                        ((Graphics2D) g).draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, 20, 20));
                    }
                };
                postButton.setBorder(roundedBorder);
                postButton.addActionListener(e -> displaySpecificPostDetails(post,u_name));
                postButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

                gbc.gridx = 0;
                gbc.gridy = index + 1; 
                gbc.gridwidth = 1; 
                mainPanel.add(postButton, gbc);

                index++;
            
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> showAlumniOptions(u_name));
        gbc.gridx = 0;
        gbc.gridy = index + 1;
        gbc.gridwidth = 2; 
        mainPanel.add(backButton, gbc);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }
    private void displayAllPosts(String name) {
        mainPanel.removeAll();

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("All Posts");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); 
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); 
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), 
                BorderFactory.createEmptyBorder(10, 20, 10, 20) 
        ));

        mainPanel.add(titleLabel, gbc);
        int preferredWidth = 470; 
        int preferredHeight = 100; 

        int index = 0;
        for(String a: alumniDB.alumniMap.keySet()) {
            for (Post post : alumniDB.alumniMap.get(a).posts) {
                // Create button for post
                JButton postButton = new JButton("<html><b>Title:</b> " + post.getTitle() + "<br>" +
                        "<b>Date of Event:</b> " + post.getDateOfEvent() + "</html>");

                // Set button properties
                postButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set font and style
                postButton.setFocusPainted(false); // Remove focus border
                postButton.setForeground(new Color(245, 160, 49)); // Text color (RGB 145, 82, 0)
                postButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
                postButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add inner padding
                postButton.setBackground(new Color(10, 26, 54)); // Light gray background color
                postButton.setOpaque(true); // Make the button opaque

                // Make button corners rounded
                Border roundedBorder = new EmptyBorder(20, 20, 20, 20) {
                    @Override
                    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                        g.setColor(Color.BLACK);
                        ((Graphics2D) g).draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, 20, 20));
                    }
                };
                postButton.setBorder(roundedBorder); 
                postButton.addActionListener(e -> displayPostDetails(post,name));
                postButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

                gbc.gridx = 0;
                gbc.gridy = index + 1;
                gbc.gridwidth = 1; 
                mainPanel.add(postButton, gbc);

                index++;
            }
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> displayStudentOptions(name));
        gbc.gridx = 0;
        gbc.gridy = index + 1; 
        gbc.gridwidth = 2; 
        mainPanel.add(backButton, gbc);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }


    private void handleAlumniLogin() {
        String username = JOptionPane.showInputDialog(Main.this, "Enter Alumni Username:");
        String password = JOptionPane.showInputDialog(Main.this, "Enter Alumni Password:");
        if (alumniDB.checkAlumni(username, password)) {
            JOptionPane.showMessageDialog(Main.this, "Alumni Login Successful!");
            showAlumniOptions(username);
        } else {
            JOptionPane.showMessageDialog(Main.this, "Invalid Alumni Username or Password.");
        }
    }

    private void handleStudentLogin() {
        String username = JOptionPane.showInputDialog(Main.this, "Enter Student Username:");
        String password = JOptionPane.showInputDialog(Main.this, "Enter Student Password:");
        if (checkStudent(username, password)) {
            JOptionPane.showMessageDialog(Main.this, "Student Login Successful!");
            loggedIn = true;
            displayStudentOptions(username);
        } else {
            JOptionPane.showMessageDialog(Main.this, "Invalid Student Username or Password.");
        }
    }

    private void displayAllAlumni(String name) {
        mainPanel.removeAll();

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("All Alumni From Cummins College");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); 
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), 
                BorderFactory.createEmptyBorder(10, 20, 10, 20) 
        ));

        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1; 

        int columnCount = 2; 
        int rowCount = (int) Math.ceil((double) AlumniDB.alumniMap.size() / columnCount); // Number of rows

        int preferredWidth = 250;
        int preferredHeight = 150;

        int index = 0;
        for (String a : AlumniDB.alumniMap.keySet()) {
            int rowIndex = index / columnCount;
            int colIndex = index % columnCount;

            Alumni alumni = AlumniDB.alumniMap.get(a);

            JButton alumniButton = new JButton("<html><b>Name:</b> " + alumni.name + "<br>" +
                    "<b>Branch:</b> " + alumni.branch + "<br>" +
                    "<b>Passing Year:</b> " + alumni.passingYear + "<br>" +
                    "<b>Domain:</b> " + alumni.domain + "<br>" 
                    );

            alumniButton.setFont(new Font("Arial", Font.PLAIN, 14)); 
            alumniButton.setFocusPainted(false); 
            alumniButton.setForeground(Color.WHITE); 
            alumniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
            alumniButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            alumniButton.setBackground(new Color(64, 64, 64));
            alumniButton.setOpaque(true); 
         
            alumniButton.addActionListener(e -> displayAlumniDetails(alumni,name));

            alumniButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

            gbc.gridx = colIndex;
            gbc.gridy = rowIndex + 1; 
            mainPanel.add(alumniButton, gbc);

            index++;
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> displayStudentOptions(name));
        gbc.gridx = 0;
        gbc.gridy = rowCount + 1; 
        gbc.gridwidth = 2; 
        mainPanel.add(backButton, gbc);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }

    
    private void displaySpecificAlumni(String opt, LinkedList<AlumniTree> alumniList,String name) {
    	
        AlumniTree lst = null;
        for (AlumniTree o : alumniList) {
            lst = o;
            if (o.data.equals(opt)) {
                break;
            }
        }
        mainPanel.removeAll();

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("Alumni");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(51, 102, 153)); 
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20) 
        ));

        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1; 

        int columnCount = 2; 
        int rowCount = (int) Math.ceil((double) alumniList.size() / columnCount); 
        int preferredWidth = 250;
        int preferredHeight = 150;

        int index = 0;
        for (AlumniTree a : lst.child) {
            Alumni alumni = AlumniDB.alumniMap.get(a.data);

            int rowIndex = index / columnCount;
            int colIndex = index % columnCount;

            JButton alumniButton = new JButton("<html><b>Name:</b> " + alumni.name + "<br>" +
                    "<b>Branch:</b> " + alumni.branch + "<br>" +
                    "<b>Passing Year:</b> " + alumni.passingYear + "<br>" +
                    "<b>Organisation:</b> " + alumni.organisation + "<br>" );
                    

              alumniButton.setFont(new Font("Arial", Font.PLAIN, 14)); 
            alumniButton.setFocusPainted(false); 
            alumniButton.setForeground(Color.WHITE); 
            alumniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
            alumniButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
            alumniButton.setBackground(new Color(64, 64, 64)); 
            alumniButton.setOpaque(true); 

            alumniButton.addActionListener(e -> displayAlumniDetails(alumni,name));

            alumniButton.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

            gbc.gridx = colIndex;
            gbc.gridy = rowIndex + 1; 
            mainPanel.add(alumniButton, gbc);

            index++;
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
        	displayAlumniPreferenceOptions(name);
        });
        gbc.gridx = 0; 
        gbc.gridy = rowCount + 1; 
        gbc.anchor = GridBagConstraints.NORTHWEST; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        mainPanel.add(backButton, gbc); 

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().removeAll();
        getContentPane().add(scrollPane);
        revalidate();
        repaint();
    }
    private void displayAlumniDetails(Alumni alumni, String name) {
        JFrame detailsFrame = new JFrame("Alumni Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        Color darkBlue = new Color(148, 16, 25);
        Color mustard = new Color(7, 10, 23);
        Color lightBlue = new Color(223, 243, 247);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(lightBlue);
        detailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER; 

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = createLabel("<html><font size='8' color='" + darkBlue.getRGB() + "'><b><u>" + alumni.name + "</u></b></font></html>");
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

        if (!alumni.posts.isEmpty()) {
            gbc.gridy++;
            JLabel postsLabel = createLabel("<html><font size='6' color='" + darkBlue.getRGB() + "'><b>Posts</b></font></html>");
            detailsPanel.add(postsLabel, gbc);

            for (Post post : alumni.posts) {
                gbc.gridy++;
                JButton postButton = new JButton("<html><b>Title:</b> " + post.Title + "<br>" +
                        "<b>Post Date:</b> " + post.postDate + "<br>" +
                        "<b>Deadline of Registration:</b> " + post.deadlineOfRegistration + "</html>");
                postButton.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
                postButton.setVerticalAlignment(SwingConstants.CENTER); // Center text vertically
                postButton.setPreferredSize(new Dimension(400, 100)); // Set preferred size for each button
                postButton.setBackground(mustard); // Set background color (mustard)
                postButton.setForeground(Color.WHITE); // Set font color to dark blue
                postButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
                postButton.setBorder(BorderFactory.createLineBorder(darkBlue)); // Add border

                postButton.addActionListener(e -> {
                    displayPostDetails(post, name);
                });

                detailsPanel.add(postButton, gbc);
            }
        }
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.fill = GridBagConstraints.NONE; 
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
          
            detailsFrame.dispose();
        });
        backButton.setPreferredSize(new Dimension(150, 40)); 
        backButton.setBackground(darkBlue); 
        backButton.setForeground(Color.WHITE); 
        backButton.setFont(new Font("Arial", Font.BOLD, 16)); 
        backButton.setBorderPainted(false); 
        backButton.setFocusPainted(false); 
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

        detailsPanel.add(backButton, gbc);

        JScrollPane scrollPane = new JScrollPane(detailsPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        detailsFrame.add(scrollPane);

        detailsFrame.setLocationRelativeTo(null);

        detailsFrame.setVisible(true);
    }


    private void displayPostDetails(Post post,String name) {
        JFrame detailsFrame = new JFrame("Post Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(new Color(30, 30, 60)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; 
        gbc.insets = new Insets(5, 10, 5, 10); 

        JLabel titleLabel = new JLabel(post.getTitle());
        titleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 50)); 
        titleLabel.setForeground(Color.WHITE); 
        detailsPanel.add(titleLabel, gbc);

        gbc.gridy++;

        addDetailLabel(detailsPanel, gbc, "Post Date:", post.getPostDate());
        addDetailLabel(detailsPanel, gbc, "Deadline of Registration:", post.getDeadlineOfRegistration());
        addDetailLabel(detailsPanel, gbc, "Date of Event:", post.getDateOfEvent());
        addDetailLabel(detailsPanel, gbc, "Description:", post.getPostDescription());
        addDetailLabel(detailsPanel, gbc, "Tags:", String.join(", ", post.postTags));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setBackground(new Color(30, 30, 60)); 
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.RED); 
        backButton.setForeground(Color.WHITE); 
        backButton.setFont(new Font("Helvetica", Font.BOLD, 16)); 
        backButton.addActionListener(e -> {
           displayStudentOptions(name);
           detailsFrame.setVisible(false);
           
        });
        buttonsPanel.add(backButton);

        JButton registerButton = new JButton("Register Now");
        registerButton.setBackground(Color.RED); 
        registerButton.setForeground(Color.WHITE); 
        registerButton.setFont(new Font("Helvetica", Font.BOLD, 16));
        registerButton.addActionListener(e -> {
        	    String email = JOptionPane.showInputDialog(detailsFrame, "Enter your email:");
        	    String password = JOptionPane.showInputDialog(detailsFrame, "Enter your password:");
        	    Student st = null;
        	    boolean f= false;
        	    for(Student s:StudentDB.studentsList){
        	    	if(s.emailId.equals(email) &&s.password.equals(password) ){
        	    		st=s;
        	    		f= true;
        	    		break;
        	    	}
        	    }
        	    if(!f) {
        	    	JOptionPane.showMessageDialog(detailsFrame, "Incorrect Credentials");
        	    	return;
        	    }
        	    boolean alreadyRegistered = false;
        	    
        	    for (Registration registration : post.registeredStudents) {
        	        if (registration.emailId.equals(email)) {
        	            alreadyRegistered = true;
        	            break;
        	        }
        	    }

        	    if (alreadyRegistered) {
        	        JOptionPane.showMessageDialog(detailsFrame, "You are already registered for this post.");
        	    } else {
        	    	
        	    	post.registeredStudents.add(new Registration(st.rollNum,st.name,st.contactNo,st.emailId));
        	    	JOptionPane.showMessageDialog(detailsFrame, "Registered sucessfully");
        	       displayStudentOptions(name);
        	    }
        });
        buttonsPanel.add(registerButton);

        gbc.gridy++;
        detailsPanel.add(buttonsPanel, gbc);

        ArrayList<Registration> registrations = post.registeredStudents;
        if (!registrations.isEmpty()) {
            JLabel registrationsLabel = new JLabel("Registrations:");
            registrationsLabel.setFont(new Font("Arial", Font.BOLD, 16));
            registrationsLabel.setForeground(Color.WHITE);
            gbc.gridy++;
            detailsPanel.add(registrationsLabel, gbc);

            gbc.gridy++;

            int maxWidth = 0;
            for (Registration registration : registrations) {
                JButton tempButton = new JButton(registration.name); 
                int width = tempButton.getPreferredSize().width;
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }

            for (Registration registration : registrations) {
                JButton registrationButton = new JButton(registration.name); 
                registrationButton.setPreferredSize(new Dimension(maxWidth, registrationButton.getPreferredSize().height));
                registrationButton.setFont(new Font("Arial", Font.PLAIN, 14));
                registrationButton.setForeground(Color.WHITE);
                registrationButton.setBackground(new Color(100, 100, 100)); 
                registrationButton.addActionListener(e -> {
                });
                detailsPanel.add(registrationButton, gbc);
                gbc.gridy++;
            }
        }

        detailsFrame.add(detailsPanel);

        detailsFrame.setVisible(true);
    }

    private void displaySpecificPostDetails(Post post,String name) {
        JFrame detailsFrame = new JFrame("Post Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(new Color(30, 30, 60)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; 
        gbc.insets = new Insets(5, 10, 5, 10); 

        JLabel titleLabel = new JLabel(post.getTitle());
        titleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 50)); 
        titleLabel.setForeground(Color.WHITE); 
        detailsPanel.add(titleLabel, gbc);

        gbc.gridy++;

        addDetailLabel(detailsPanel, gbc, "Post Date:", post.getPostDate());
        addDetailLabel(detailsPanel, gbc, "Deadline of Registration:", post.getDeadlineOfRegistration());
        addDetailLabel(detailsPanel, gbc, "Date of Event:", post.getDateOfEvent());
        addDetailLabel(detailsPanel, gbc, "Description:", post.getPostDescription());
        addDetailLabel(detailsPanel, gbc, "Tags:", String.join(", ", post.postTags));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setBackground(new Color(30, 30, 60)); 
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.RED); 
        backButton.setForeground(Color.WHITE); 
        backButton.setFont(new Font("Helvetica", Font.BOLD, 16)); 
        backButton.addActionListener(e -> {
           showAlumniOptions(name);
           detailsFrame.setVisible(false);
           });
        buttonsPanel.add(backButton);

        gbc.gridy++;
        detailsPanel.add(buttonsPanel, gbc);

        ArrayList<Registration> registrations = post.registeredStudents;
        if (!registrations.isEmpty()) {
            JLabel registrationsLabel = new JLabel("Registrations:");
            registrationsLabel.setFont(new Font("Arial", Font.BOLD, 16));
            registrationsLabel.setForeground(Color.WHITE);
            gbc.gridy++;
            detailsPanel.add(registrationsLabel, gbc);

            gbc.gridy++;

            int maxWidth = 0;
            for (Registration registration : registrations) {
                JButton tempButton = new JButton(registration.name); 
                int width = tempButton.getPreferredSize().width;
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }

            for (Registration registration : registrations) {
                JButton registrationButton = new JButton(registration.name); 
                registrationButton.setPreferredSize(new Dimension(maxWidth, registrationButton.getPreferredSize().height));
                registrationButton.setFont(new Font("Arial", Font.PLAIN, 14));
                registrationButton.setForeground(Color.WHITE);
                registrationButton.setBackground(new Color(100, 100, 100)); 
             
                detailsPanel.add(registrationButton, gbc);
                gbc.gridy++;
            }
        }

        detailsFrame.add(detailsPanel);

        detailsFrame.setVisible(true);
    }

    private  void addDetailLabel(JPanel panel, GridBagConstraints gbc, String label, String value) {
        JLabel detailLabel = createLabel("<html><b>" + label + "</b> " + value + "</html>");
        detailLabel.setForeground(Color.YELLOW); 
        panel.add(detailLabel, gbc);
        gbc.gridy++;
    }
   
    private JLabel createLabel2(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 18)); 
        label.setForeground(new Color(145, 82, 0)); 
        return label;
    }


    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14)); 
        label.setForeground(Color.BLACK); 
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
