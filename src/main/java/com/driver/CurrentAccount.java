package com.driver;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }


    public CurrentAccount() {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
          super(name,balance,5000);
          this.tradeLicenseId=tradeLicenseId;

          if(balance<5000)
          {
              throw new Exception("Insufficient Balance");
          }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
              boolean ans= check(tradeLicenseId);
              if(ans==false)
              {
                //  ArrayList<ArrayList<String >> ss= new ArrayList<>();
                  String answer = tradeLicenseId;

                boolean re=  per(answer,"");
                if(re==false)
                {
                    throw new Exception("Valid License can not be generated");
                }

              }
    }
    public  boolean  per(String answer, String path )
    {
        if(answer.length()==0) {
            boolean ans = check(path);
            if (ans) {
                this.tradeLicenseId = path;
                // System.out.println(path);
                return true;

            }
        }
            for(int i=0;i<answer.length();i++)
            {
                char ch= answer.charAt(i);
                String l= answer.substring(0,i);
                String r=answer.substring(i+1);
                String ns=l+r;
                per(ns,path+ch);

            }
            return false;
        }

    public static boolean check( String tradeLicenseId)
    {
        int n= tradeLicenseId.length();
        for(int i=0;i<n-1;i++)
        {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1))
            {
                return false;
            }
        }
        return true;
    }

}
