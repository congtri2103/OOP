package Singleton;

public class Test {
    public static void main(String[] args){
        ThreadSafeSingleton thread1 = ThreadSafeSingleton.getInstance();
        System.out.println(thread1);
        ThreadSafeSingleton thread2 = ThreadSafeSingleton.getInstance();
        System.out.println(thread2);
    }
}
