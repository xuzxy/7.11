package com.hp.idea;

import java.util.ArrayList;

public class MyJava {
    public static void main(String[] args){
            System.out.println("输出的快捷键是 sout");
            String name = "小黑";
            System.out.println("name = " + name);//souv 可以显示出变量
            System.out.println("MyJava.main");//sout 是输出 方法的名称
            System.out.println("args = ["+ args +"]");//soutp 是输出 方法的参数
            int age = 17;
            //如果 小于18 就显示未成年
            if (age < 18) { //if 快捷键是 ifn
                System.out.println("此仙女未成年");
            }
            ArrayList<String> strings = new ArrayList<>();//万能快捷键 alt+enter
            strings.add("小仙女");                         //ctrl+d 快速复制一行
            strings.add("小仙女");                         //多行编辑 alt+鼠标
            strings.add("小仙女");
            strings.add("小仙女");                         //ctrl + y 是快速删除一行
            //ctrl+z 是 一步撤销 Ctrl+shift+z是多步撤销
            for (String string : strings){               //便利循环的快捷键 iter
                System.out.println("string = " + string);
            }


        //创建 电脑
        Computer c1 = new Computer(); //说明他的构造方法是public
         c1.setPrice(5555.0D);
         c1.setColor("黑色");
         c1.setTypeName("机械革命code555");

        System.out.println("c1 = " + c1); //c1 = com.hp.idea.Computer@677327b6 内存地址
        //内存地址是否一样，是判断对象是否相等的依据
        Computer c2 = new Computer();
        c1.setPrice(5555.0D);
        c1.setColor("黑色");
        c1.setTypeName("机械革命code555");
        System.out.println("c2 = " + c2);

        //判断c1 ,c2是否相等
        System.out.println(c1 ==c2);  //false
       //以上就是对象模式！每次new都会创建一个新对象
        //想要 对象每次new都唯一怎么办


        //测试单例模式
       // Phone p1=new Phone();
       Phone p1 =Phone.getInstance();
       Phone p2 =Phone.getInstance();
        System.out.println(p1 == p2);
    }
    }






