package view_test;

import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;


public class ViewManagerTest {

    private ViewManager viewManager;
    private JPanel views;
    private CardLayout cardLayout;
    private ViewManagerModel stubViewManagerModel;

    @Before
    public void setUp() {
        // 创建测试用的 JPanel 和 CardLayout
        views = new JPanel();
        cardLayout = new CardLayout();

        // 创建 ViewManagerModel 的存根
        stubViewManagerModel = new ViewManagerModel() {
            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
                // 可以添加逻辑来存储监听器，如果需要的话
            }
            // 实现其他必要的方法
        };

        // 创建 ViewManager 实例
        viewManager = new ViewManager(views, cardLayout, stubViewManagerModel);
    }

    @Test
    public void testPropertyChange() {
        // 创建 PropertyChangeEvent 存根
        PropertyChangeEvent stubEvent = new PropertyChangeEvent(this, "view", null, "SomeViewModelName");

        // 触发 propertyChange 方法
        viewManager.propertyChange(stubEvent);

        // 测试 cardLayout 是否被正确调用
    }

}
