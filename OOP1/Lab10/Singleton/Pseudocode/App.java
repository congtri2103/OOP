package Pseudocode;

import javax.xml.crypto.Data;

public class App {
    public static void main(String[] args) {
        Database foo = Database.getInstance();
        foo.query("SELECT * FROM foo");
        Database bar = Database.getInstance();
        bar.query("SELECT * FROM bar");
    if(foo==bar){
        System.out.println("cùng một đối tượng");
    }else{
        System.out.println("không cùng một đối tượng");
    }
    }

}
