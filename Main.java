package myPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null); 

      
       
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        frame.add(mainPanel);

       
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();

        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();

        JButton submitButton = new JButton("Submit");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(courseLabel);
        formPanel.add(courseField);
        formPanel.add(new JLabel());
        formPanel.add(submitButton);

     
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        mainPanel.add(formPanel);
        mainPanel.add(scrollPane);


        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String studentID = idField.getText().trim();
                String course = courseField.getText().trim().toUpperCase();

            
                if (!name.contains(" ")) {
                    outputArea.setText("Error: Enter full name (first and last).");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageText);
                    if (age <= 0) {
                        outputArea.setText("Error: Age must be a positive number.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Age must be a number.");
                    return;
                }

                if (studentID.length() != 11 || !studentID.startsWith("24")) {
                    outputArea.setText("Error: Student ID must be 11 digits and start with '24'.");
                    return;
                }

             
                outputArea.setText("Student Information:\n\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Age: " + age + "\n");
                outputArea.append("Student ID: " + studentID + "\n");
                outputArea.append("Course: " + course + "\n");
            }
        });

        frame.setVisible(true);
    }
}
