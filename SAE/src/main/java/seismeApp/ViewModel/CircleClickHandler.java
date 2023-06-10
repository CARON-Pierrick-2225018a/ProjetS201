package seismeApp.ViewModel;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CircleClickHandler implements EventHandler<MouseEvent> {
    private int id ;

    public CircleClickHandler(int id) {
        this.id = id;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED )){
            System.out.println(id);
        };
    }
}
