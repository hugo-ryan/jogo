package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_chave extends ObjetoMaior {

    public obj_chave() {

        name = "Chave";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/chave.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
