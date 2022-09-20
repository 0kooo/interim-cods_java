package com.itheima.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    // RegisterJFrame 以后所以关于注册的方法都写在这里吗

    public RegisterJFrame(){
        //设置界面的宽高
        this.setSize(488,500);
        //设置界面的标题
        this.setTitle("拼图游戏 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //显示界面,建议写在最后
        this.setVisible(true);
    }
}
