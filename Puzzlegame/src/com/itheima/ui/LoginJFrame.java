package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame 以后所以关于登录的方法就写在这里面

    public LoginJFrame(){
        //设置界面的宽高
        this.setSize(488,430);
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
