package com.neuedu.pojo;

public class Person {
        Person(){}
        String x="中国" ;
        static String y= getX();

        Person(String x) {
            System.out.println("a");
            this.x=x;
        }
        static {
            System.out.println("a");
        }
        {
            System.out.println("c");
        }
        static String getX(){
            System.out.println("getx");
            return "";
        }
    public static void main(String[] args){
        new Person("9999");
        new Person(); }
}
