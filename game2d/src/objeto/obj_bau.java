package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_bau extends ObjetoMaior {
    public obj_bau() {

        name = "Bau";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/bau.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
