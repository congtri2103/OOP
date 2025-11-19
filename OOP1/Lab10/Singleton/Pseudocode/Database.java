package Pseudocode;

public class Database {
    private static  Database  instance;
    private  Database(){
        System.out.println("Kết nối cơ sở dữ liệu");
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    public void query(String sql){
        System.out.println(sql);
    }
}
