package game.Button_layout;

import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Blend;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorInput;
import menu.Globals;
import menu.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Set;

public class Blending {
    public static void Blending(Group group, String URL, Button element ) throws java.io.FileNotFoundException{
        //Instantiating the blend class
        Image image = new Image(Globals.button_wp_1);
        javafx.scene.image.ImageView SetGroupLayout = ImageView.imageView(Globals.button_wp_1,500,500);
        Blend blend = new Blend(BlendMode.SRC_ATOP,null,new ColorInput(0,0,SetGroupLayout.getImage().getWidth(),
                SetGroupLayout.getImage().getHeight(), null));
        blend.setMode(BlendMode.ADD);
        //blend.setBottomInput(ColorInput(0,0));
        //blend.setTopInput();

        //Preparing the to input object



        //setting the top input to the blend object

        //setting the blend mode
        //blend.setMode(BlendMode.SRC_ATOP);


        //Applying the blend effect to circle
        group.setEffect(blend);


    /*    target = (StackPane) lookup("#targetAnchor");
        Image image = IconFactory.getTargetIcon();
        ImageView targetIcon = new ImageView(image);

        ColorAdjust monochrome = new ColorAdjust();
        monochrome.setSaturation(-1.0);

        Blend red = new Blend(BlendMode.MULTIPLY, monochrome,
                new ColorInput(0, 0, targetIcon.getImage().getWidth(), targetIcon.getImage().getHeight(), Color.RED));

        Blend green = new Blend(BlendMode.MULTIPLY, monochrome,
                new ColorInput(0, 0, targetIcon.getImage().getWidth(), targetIcon.getImage().getHeight(), new Color(0, 1, 0, 0.5)));

        targetButton = targetIcon;

        targetIcon.effectProperty().bind(Bindings.when(targetButton.hoverProperty()).then((Effect) green).otherwise((Effect) red));
        targetButton.setId("target_button");
        hideTargetMarker();
        target.getChildren().add(targetButton);
*/

    }
}
