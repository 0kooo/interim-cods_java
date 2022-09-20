package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //Jframe是窗体和界面
    //子类应该也是窗体和界面
    //GameJFrame这个界面就是游戏界面
    //以后和游戏所有的逻辑都写在这里面

    //3.创立一个二维数组
    //管理数据
    //加载图片时会根据二维数组中的数据顺序加载
    int[][] data = new int[4][4];

    //记录0在二维数组中1的位置
    int x = 0;
    int y = 0;

    //定义一个变量,记录当前展示图片的路径
    String path = "Puzzlegame\\image\\animal\\animal3\\";

    //定义一个二维数组,存储正确数据
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenBar();

        //初始化数据(打乱)
        iniData();

        //初始化图片(根据打乱之后的结果去加载图片)
        iniImage();

        //显示界面,建议写在最后
        this.setVisible(true);
    }


    //初始化数据(打乱)
    private void iniData() {
        //1.定义一个一位数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //4.给二维数组添加数据
        //方法一
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i % 4;
                y = i / 4;
            } else {
                data[i % 4][i / 4] = tempArr[i];
            }
        }
    }

    //初始化图片
    private void iniImage() {
        //清空原来已经出现的所以的图片
        this.getContentPane().removeAll();

        if(victory()){
            JLabel winJLabl = new JLabel(new ImageIcon("E:\\cod\\interim-cods\\Puzzlegame\\image\\win.png"));
            winJLabl.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabl);
        }
        //路径分为
        //绝对路劲:一般从盘符开始 C:\ 或D:\
        //相对路径:不是从盘符开始
        //相对路径是相对项目而言

        //细节:
        //先加载的图片在上方,后加载的图片在下方


        //外层循环 -- 表示换行
        for (int i = 0; i < 4; i++) {
            //内层循环 -- 表示一行的四张图片
            for (int j = 0; j < 4; j++) {
                //创建一个图片Imagecon的对象
                //ImageIcon icon = new ImageIcon("E:\\cod\\interim-cods\\Puzzlegame\\image\\animal\\animal3\\1.jpg");
                int number = data[j][i];
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));
                //指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                //0:让图片凸起来
                //1:让图片凹下去
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("Puzzlegame\\image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    //初始化菜单
    private void initJMenBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上两个选项的对象(功能 关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLonginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLonginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单上
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图游戏 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置,只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        //给整个界面添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当在键盘上按下按键不松时会调用此方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            //把界面中所以的图片全部删除
            this.getContentPane().removeAll();
            //加载第一张完全图片
            JLabel all = new JLabel(new ImageIcon( path + "all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("Puzzlegame\\image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            //把背景图片添加到界面中
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    //当在键盘上按下按键后松开时会调用此方法
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利,如果胜利,直接结束方法,不在执行以下移动代码
        if(victory()){
            return;
        }
        //对上, 下, 左, 右进行判断
        //左: 37, 上: 38, 右: 39, 下: 40
        int cod = e.getKeyCode();
        if (cod == 38) {
            System.out.println("向上移动");
            if(y == 0){
                return;
            }
            //向上的操作实质是将0下面的图片向左移动到0的位置
            //要移动的图片二维数组位置[x][y + 1]
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            //调用方法按照最新的数组加载图片
            iniImage();
        } else if (cod == 37) {
            System.out.println("向左移动");
            if(x == 0){
                return;
            }
            //向上的操作实质是将0下面的图片向上移动到0的位置
            //要移动的图片二维数组位置[x + 1][y]
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            //调用方法按照最新的数组加载图片
            iniImage();
        } else if (cod == 40) {
            System.out.println("向下移动");
            if(y == 3){
                return;
            }
            //向上的操作实质是将0下面的图片向右移动到0的位置
            //要移动的图片二维数组位置[x][y - 1]
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            //调用方法按照最新的数组加载图片
            iniImage();
        } else if (cod == 39) {
            System.out.println("向右移动");
            if(x == 3){
                return;
            }
            //向上的操作实质是将0下面的图片向下移动到0的位置
            //要移动的图片二维数组位置[x - 1][y]
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            //调用方法按照最新的数组加载图片
            iniImage();
        }else if(cod == 65){
            iniImage();
        }else if(cod == 87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            iniImage();
        }
    }

    //判断data数组中的数据是否和win数组中的数据相等
    //如果相等返回true,不相等返回false
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
