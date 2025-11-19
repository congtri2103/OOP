package observer.pseudocode;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LoggingListener("file.txt"));
        editor.events.subscribe("save", new EmailAlertsListener("admin@example.com"));

        try {
            editor.open("test.txt");
            editor.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}