package com.hp.util;

public class TextUitl {

public static  void welcome(){
    System.out.println("*****");
    System.out.println("先生/女士");
    System.out.println("欢迎使用ATM取款机");
    System.out.println("********");

}



    public static void getMoneyUI(){
        System.out.println("*******************");
        System.out.println("****请输入你想取款的数目：****");
        System.out.println("****1.100  2.200****");
        System.out.println("****3.300      4.500****");
        System.out.println("****5.800      ****");
        System.out.println("*********************");
    }

    public static void oneLeveOption(){
        System.out.println("*******************");
        System.out.println("****请输入你想要的操作类型：****");
        System.out.println("****1.余额查询  2.取款****");
        System.out.println("****3.转账      4.存款****");
        System.out.println("****5.退卡      ****");
        System.out.println("*********************");
    }


}
