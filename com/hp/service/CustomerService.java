package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TextUitl;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
   private List<Customer> customerList;
    private Customer currentCustomer;
    private  boolean type;
         //查登录判断密码是否正确
       public  void  checkPwd(String cardid,String cardPwd){



           CustomerData customerData = CustomerData.getInstance();
           List<Customer> customerList = customerData.getCustomerList();
           //customerList  = customerData.getCustomerList();
           // 1. 拿到  carid中的账户名 和 cardPwd  对  list中的数据做对比
           System.out.println("cardid = " + cardid);
           System.out.println("cardPwd = " + cardPwd);

           for (Customer customer : customerList) {
               if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                   currentCustomer=  customer;
                   // 账户正确
                   System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                   TextUitl.oneLeveOption();  // 界面
                   Scanner scanner =new Scanner(System.in);
                   String option = scanner.nextLine();
                   oneOption(option);

               }
           }
       }

    private void oneOption(String option) {
        switch (option) {
            case "1":
                System.out.println("余额查询");
                // 查询余额
                doSelectMoney();
                // 返回到选择界面
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                doGetMoney();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                goOneHome();
                break;

            default:
                System.out.println("你输入的数字有误");
                goOneHome();
                break;
        }
    }


    // 返回一级菜单
    private void goOneHome() {
        //TextUtil.oneLeveOption();
        TextUitl.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  //递归算法
    }


    // 查询余额
    private void doSelectMoney() {

           double money = currentCustomer.getMoney();

        System.out.println("余额是 " + money);
    }

    // 取款
    private void doGetMoney() {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        currentCustomer.setMoney(currentCustomer.getMoney() - money);
        System.out.println("你当前的余额为：" + currentCustomer.getMoney());
    }

    //  存款
    private void doSaveMoney() {
        System.out.println("请输入要存款的金额");
        // 输入存款金额
        Scanner sc = new Scanner(System.in);
        try {
            double money = sc.nextDouble();

            currentCustomer.setMoney(currentCustomer.getMoney() + money);

            System.out.println("你当前的余额为：" + currentCustomer.getMoney());
        } catch (Exception e) {
            System.out.println("输入的金额不合法，请重新输入");
            doSaveMoney();
        }
    }
    // 退卡（）
    public void outCard() {
        System.out.println("当前用户已退出！");

        type = false;

        System.exit(0);
    }



}






