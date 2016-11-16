package com.datastructures;

public class OODemo {

    public static void main(String args[]) {
        DerivedClass derivedObj = new DerivedClass();
        BaseClass baseObj = new BaseClass();

        // baseObj = derivedObj;

        derivedObj = (DerivedClass) baseObj;
        System.out.println("Hello");
        
        baseObj.h

    }
}
