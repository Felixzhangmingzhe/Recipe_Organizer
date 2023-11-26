package view;
import entity.Recipe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class ViewManager {
    private JFrame mainFrame;

    public ViewManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void changeView(JPanel newView) {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(newView);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void showWarehouseView(List<Recipe> recipes) {
        WarehouseView warehouseView = new WarehouseView();
        warehouseView.setRecipes(recipes);
        changeView(warehouseView);
    }
}

