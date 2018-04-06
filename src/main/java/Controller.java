import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Circle dbStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (false) {
            this.dbStatus.setFill(Color.rgb(107, 244, 66));
        } else {
            this.dbStatus.setFill(Color.rgb(244, 22, 49));
        }
    }
}
