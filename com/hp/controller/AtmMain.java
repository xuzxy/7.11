package com.hp.controller;

import com.hp.service.CustomerService;
import com.hp.util.TextUitl;


import java.util.Scanner;

public class AtmMain {
    private  static String cardid;
    private  static String cardPwd;
    private  static CustomerService customerService;
    public static void main(String[] args) {
        customerService = new CustomerService();

        //是一个阶段
        TextUitl.welcome();
        int i =0;
        while (i<6){
           doWritePassword();
            doCheckPassword(cardid,cardPwd);
            i++;
        }

    }
        //判断角色和判断密码
        private static void doCheckPassword(String cardid, String  cardPwd) {
            // 1. 先校验角色,  判断 cardid 的长度.
            if (cardid.length()==8) { // 客户
                // 校验密码
                customerService.checkPwd(cardid,cardPwd);
            }


        }
//输入张密
private static void doWritePassword(){
    System.out.println("请输入卡号");
    Scanner scanner = new Scanner(System.in);
    cardid = scanner.nextLine();
    System.out.println("cardid = " + cardid);
    System.out.println("请输入密码");
    cardPwd = scanner.nextLine();
    System.out.println("cardPwd = " + cardPwd);
}


}
