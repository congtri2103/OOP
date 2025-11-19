package designpatterns.singleton.chocolate;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance;


    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }
        // pt tĩnh
    public static ChocolateBoiler getInstance() {
        if(uniqueInstance == null){
            System.out.println("Tạo phiên bản duy nhất của Chocolate");
            uniqueInstance = new ChocolateBoiler();
        }
        System.out.println("Trả về phiên bản của Chocolate Boiler");
        return uniqueInstance;

    }
    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = true;
        }
    }
    public void drain(){
        if(!isEmpty()&&!isBoiled()){
            empty = true;
        }

    }

    public void boil(){
        if(!isEmpty()&&!isBoiled()){
            boiled = true;
        }
    }
    public boolean isEmpty(){
        return empty;
    }
    public boolean isBoiled(){
        return boiled;
    }
}
