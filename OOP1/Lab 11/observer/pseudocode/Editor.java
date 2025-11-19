package observer.pseudocode;

import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open","save");
    }

    public void open(String file) {
        this.file = new File(file);
        events.notify("open",this.file);
    }

    public void save() throws Exception {
        if (this.file != null) {
            events.notify("save",file);
        } else {
            throw new Exception("please open the file first.");
        }
    }
}
