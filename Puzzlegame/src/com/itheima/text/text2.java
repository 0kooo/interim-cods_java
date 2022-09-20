package com.itheima.text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class text2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(603,680);
        //设置界面的标题
        jFrame.setTitle("拼图游戏 v1.0");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置,只有取消了才会按照XY轴的形式添加组件
        jFrame.setLayout(null);

        //创建一个按钮对象
        JButton jtb = new JButton("单击");
        //设置位置和宽高
        jtb.setBounds(0,0,100,50);
        //给按钮添加动作监听
        //jtb:组件对象,表示你要给那个组件添加事件
        //addActionListener: 表示我要给组件添加哪个事件监听(动作监听:鼠标左键点击,空格)
        //参数:表示事件被触发之后执行的代码
        //jtb.addActionListener(new MyaddActionListener());
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了!");
            }
        });

        //把按钮添加到界面
        jFrame.getContentPane().add(jtb);

        //显示界面,建议写在最后
        jFrame.setVisible(true);
    }
}
