package org.example;

class A{

    public A(){
        System.out.println("A constructor");
    }

    public String get(){
        return "A";
    }

    public A clone(){
        return new A();
    }

}

class B extends A{

    public String get(){
        return "B";
    }

    public B(){
        System.out.println("B construtoir");
    }

}

class C{

    public C get(){
        return this;
    }
    public C(){
    }

}
 class Test {
    @Override
    public Test clone() throws CloneNotSupportedException{
        return (Test) super.clone();
    }

}

public class Sample1 {

    public static void main(String[] args) throws CloneNotSupportedException {

        Test test = new Test();
        test = test.clone();

    }
}
