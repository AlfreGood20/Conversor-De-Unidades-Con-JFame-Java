package appConversionUnidades;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelConImagen extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image imagen;

    public PanelConImagen(String rutaImagen) {
        try {
            imagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null); // QUITA EL CAMBIO DEL ESTILO DETERMINADO
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0,getWidth(), getHeight(),this);
        }
    }
}
