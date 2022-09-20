package com.itheima.ui;

import javax.swing.*;

public class Text {
    public static void main(String[] args) {
        //1.创建一个游戏主界面
        JFrame gameJFrame = new JFrame();
        gameJFrame.setSize(603,680);
        gameJFrame.setVisible(true);

        //2.创建一个登录界面
        JFrame loginJFrame = new JFrame();
        loginJFrame.setSize(488,430);
        loginJFrame.setVisible(true);

        //3.创建一个注册界面
        JFrame registerJFrame = new JFrame();
        registerJFrame.setSize(488,500);
        registerJFrame.setVisible(true);
    }
}
