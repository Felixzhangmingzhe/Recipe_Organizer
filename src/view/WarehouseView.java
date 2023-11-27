package view;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WarehouseView {
    JPanel WarehousePanel; // 创建总收藏夹面板，显示所有收藏夹

    public WarehouseView() {
        WarehousePanel = new JPanel();

        try {
            // 替换成你的 JSON 文件路径
            File jsonFile = new File("path/to/your/recipes.json");

            JSONParser jsonParser = new JSONParser();
            JSONArray recipes = (JSONArray) jsonParser.parse(new FileReader(jsonFile));

            int i = 1;

            for (Object recipeObj : recipes) {
                JSONObject recipe = (JSONObject) recipeObj;
                String recipeName = (String) recipe.get("name");

                JLabel recipeLabel = new JLabel("菜谱 " + i + ": " + recipeName);
                recipeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                WarehousePanel.add(recipeLabel);

                i++;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public JPanel getWarehousePanel() {
        return WarehousePanel;
    }

    public static void main(String[] args) {
        WarehouseView warehouseView = new WarehouseView();

        JFrame frame = new JFrame("Warehouse View");
        frame.getContentPane().add(warehouseView.getWarehousePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
