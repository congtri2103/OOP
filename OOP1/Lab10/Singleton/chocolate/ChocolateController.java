package designpatterns.singleton.chocolate;

public class ChocolateController {
    public static void main(String[] args) {
        // Lấy thể hiện duy nhất của ChocolateBoiler
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();  // Đổ hỗn hợp sô cô la và sữa vào nồi
        boiler.boil();  // Đun sôi hỗn hợp
        boiler.drain(); // Xả hỗn hợp ra ngoài

        // Kiểm tra nếu gọi getInstance lần nữa, nó sẽ trả về thể hiện hiện có
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();

        // So sánh 2 tham chiếu để kiểm tra tính Singleton
        if (boiler == boiler2) {
            System.out.println("Cả hai tham chiếu đều trỏ tới cùng một thể hiện.");
        } else {
            System.out.println("Có lỗi, hai tham chiếu trỏ tới các thể hiện khác nhau.");
        }
    }
}
