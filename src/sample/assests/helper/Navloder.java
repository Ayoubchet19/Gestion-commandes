package sample.assests.helper;

import animatefx.animation.BounceIn;
import animatefx.animation.Jello;
import animatefx.animation.Pulse;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Navloder {
    private Pane View;


    public void NavRouter(String file, BorderPane pane){
        try {
            View = FXMLLoader.load(getClass().getResource("/sample/views/"+file+".fxml"));
            pane.setCenter(View);
            new Pulse(pane.getCenter()).play();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
