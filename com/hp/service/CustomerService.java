package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TextUitl;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;


    // 1. 查, 登录判断账号密码是否正确
    public void  checkPwd(String cardid, String  cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList  = customerData.getCustomerList();
        // 1. 拿到  carid中的账户名 和 cardPwd  对  list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                // 拿出来这个人
                currentCustomer=  customer;
                // 账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                TextUitl.oneLeveOption();  // 界面
                Scanner scanner = new Scanner(System.in);
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
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                outCard();
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

   //取款
    private void doGetMoney(){
        TextUitl.getMoneyUI();
        //1.让顾客输入
        System.out.println("取款");
        Scanner scanner = new Scanner(System.in);
        String numIN = scanner.nextLine();
        if (numIN.equals("1")){
            //要顾客的钱数减去
            double money = currentCustomer.getMoney();
            money = money-100;
            System.out.println("您的余额是：" + money);
            //取过款项之后更新原有的存款
            currentCustomer.setMoney(money);
        }

    }
    //转账
    public void doTruanMoney(){
        System.out.println("请输入对方的账户号码：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您需要的转账金额:");
        String otherMoney = scanner.nextLine();
        //做计算 自己的钱 - otherMoney，别人的钱+otherMoney
        //自己 减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currentMoney = currentCustomer.getMoney();//自己被减去转账后的钱
        //别人加钱 ， 根据otherAccount 本人账户查询出来别人的余额

        Customer other = null;
        for (Customer customer: customerList) {
            if (customer.getAccount().equals(otherAccount)){
                other=customer;
            }
        }
        double otherOneMoney = other.getMoney() + otherMoneyInt;
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney);//注意：有问题不能创建

    }

    //  存款
    private void doSaveMoney() {

        //  TextUitl.upMoneyUI()
        TextUitl.getMoneyUI();
        // 输入存款金额
        System.out.println("存款");
        Scanner scanner = new Scanner(System.in);
        String numIN = scanner.nextLine();
        if (numIN.equals("1")){
            //要顾客的钱数减去
            double money = currentCustomer.getMoney();
            money = money+100;
            System.out.println("您的余额是：" + money);
            //取过款项之后更新原有的存款
            currentCustomer.setMoney(money);
        }
       /* try {
            double money = sc.nextDouble();
            currentCustomer.setMoney(currentCustomer.getMoney() + money);
            System.out.println("你当前的余额为：" + currentCustomer.getMoney());
        } catch (Exception e) {
            System.out.println("输入的金额不合法，请重新输入");
            doSaveMoney();
        }*/
    }
    //退卡（）
    public void outCard() {
        System.out.println("当前用户已退出！");
        System.exit(0);
    }

}






