
public class Main {

    public static void main(String[] args) {
        // write your test code here
        A a = new A();
        B b = new B();
        C c = new C();

        a.a();
        b.b();
        c.c();
        
        System.out.println();
        C cExtended = new C();
        
        c.a();
        c.b();
        c.c();
    }
}
    