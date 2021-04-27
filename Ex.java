package com.java.mphasis.bankproj;

class Base {}
class Sub extends Base {}
class Sub2 extends Base {}
public class Ex{
    public static void main(String argv[]){
	Base b=new Base();
	Sub s=(Sub) b;
    }
}






