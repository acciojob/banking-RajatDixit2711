package com.driver;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws  Exception {
       CurrentAccount c= new CurrentAccount("RAJAT",50000, "jappan");
       c.validateLicenseId();


    }
}