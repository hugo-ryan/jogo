package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_porta extends ObjetoMaior {

    public obj_porta() {

        name = "Porta";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/porta.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
