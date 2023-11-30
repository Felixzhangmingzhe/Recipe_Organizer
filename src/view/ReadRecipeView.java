package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;

public class ReadRecipeView extends JFrame implements ActionListener, PropertyChangeListener {

    public final String viewName = "Read Recipe";
    private final JButton backButton;
    private final JButton favoritesButton;
    private final JButton cookedButton;
    private final JButton editButton;

    // Components for displaying recipe information
    private final JLabel recipeNameLabel;
    private final JTextArea recipeContentTextArea;
    private final JLabel caloriesLabel;
    private final JLabel lastEditTimeLabel;
    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    public ReadRecipeView(BackViewModel backViewModel, BackController backController) {
        // Initialize view model and controller
        this.backViewModel = backViewModel;
        this.backController = backController;
        // Initialize components
        recipeNameLabel = new JLabel("Recipe Name");
        recipeContentTextArea = new JTextArea("Recipe Content");
        caloriesLabel = new JLabel("Calories: ");
        lastEditTimeLabel = new JLabel("Last Edited: ");

        // Initialize buttons
        backButton = new JButton("Back");
        favoritesButton = new JButton("Favorites");
        cookedButton = new JButton("Cooked");
        editButton = new JButton("Edit");

        // Add action listeners to buttons
        backButton.addActionListener(this);
        favoritesButton.addActionListener(this);
        cookedButton.addActionListener(this);
        editButton.addActionListener(this);

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(recipeNameLabel, BorderLayout.NORTH);
        add(new JScrollPane(recipeContentTextArea), BorderLayout.CENTER);

        // Create a panel for additional information (calories and last edit time)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.add(caloriesLabel);
        infoPanel.add(lastEditTimeLabel);
        add(infoPanel, BorderLayout.SOUTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(favoritesButton);
        buttonPanel.add(cookedButton);
        buttonPanel.add(editButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        if (e.getSource() == backButton) {
            // Implement action for back button
            // For example, go back to the previous view
        } else if (e.getSource() == favoritesButton) {
            // Implement action for favorites button
            // For example, add the recipe to favorites
        } else if (e.getSource() == cookedButton) {
            // Implement action for cooked button
            // For example, mark the recipe as cooked
        } else if (e.getSource() == editButton) {
            // Implement action for edit button
            // For example, open the edit view for this recipe
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Update view based on property changes
        if (evt.getPropertyName().equals("recipeName")) {
            recipeNameLabel.setText(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("recipeContent")) {
            recipeContentTextArea.setText(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("calories")) {
            caloriesLabel.setText("Calories: " + evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("lastEditTime")) {
            lastEditTimeLabel.setText("Last Edited: " + evt.getNewValue().toString());
        }
    }

    // Add methods to update the view with recipe information
    public void setRecipeName(String recipeName) {
        recipeNameLabel.setText(recipeName);
    }

    public void setRecipeContent(String recipeContent) {
        recipeContentTextArea.setText(recipeContent);
    }

    public void setCalories(int calories) {
        caloriesLabel.setText("Calories: " + calories);
    }

    public void setLastEditTime(String lastEditTime) {
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }
}
