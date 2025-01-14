package appConversionUnidades;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField campoTexto;
	private JTextField campoResultado;
	private JComboBox<String> comboCategorias;
	private JComboBox<String> comboUnidades;
	private JComboBox<String>coboBoxUnidadesSelec;
	private String categoriaSeleccionada;
	
	public Ventana() {
		setTitle("App");
		setSize(590,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);  
		setResizable(false);
		// AGREGA LA IMAGEN AL FONDO DEL PANEL
		panel = new PanelConImagen("C:/Users/HP/Documents/PROGRAMACION/JAVA GUI/Imagenes/fondoConversor.png"); // LA RUTA DE LA IMAGEN
        setContentPane(panel); // CONFIGURA EL PANEL PRINCIPAL
		componentes();
	}
	
	private void componentes() {
		//panel();
		comboBoxCategoria();
		campoTexto();
		botonCalcular();
		comboBoxUnidades();
		campoTextoResultado();
		coboBoxUnidadesSelec();
		etiquetas();
	}
	
	//private void panel() {
		//panel=new JPanel();
		//panel.setLayout(null);
		//this.getContentPane().add(panel);
	//}
	
	private void campoTexto() {
		campoTexto=new JTextField();
		campoTexto.setBounds(80,150,200,50);
		campoTexto.setBackground(Color.GREEN);
		campoTexto.setDisabledTextColor(Color.WHITE);
		campoTexto.setFont(new Font("Arial",Font.BOLD,25));
		panel.add(campoTexto);
	}
	
	private void comboBoxCategoria() {
		String[]opciones= {"Selecionar Categoria:","Temperatura","Longitud","Peso/Masa","Volumen","Area","Velocidad","Tiempo","Almacenamiento digital"};
		comboCategorias=new JComboBox<String>(opciones);
		comboCategorias.setBounds(80,90,423,30);
		panel.add(comboCategorias);
		
		comboCategorias.addActionListener(evento -> {
			categoriaSeleccionada = (String) comboCategorias.getSelectedItem();

			if (categoriaSeleccionada != "Selecionar Categoria:") {
				comboUnidades.setEnabled(true); // ABRIMOS EL COMBOBOX
				coboBoxUnidadesSelec.setEnabled(true);
				String[] unidades = unidadesString(categoriaSeleccionada); // GUARDAMOS EL ARREGLO
				comboUnidades.removeAllItems(); // LIMPIA EL COMBOBOX
				coboBoxUnidadesSelec.removeAllItems();
				
				for (String cadaUna : unidades) {
					comboUnidades.addItem(cadaUna); // AGREGAMOS CADA UNA EN EL COMBOBOX
					coboBoxUnidadesSelec.addItem(cadaUna);
				}
			} else if (categoriaSeleccionada == "Selecionar Categoria:") {
				campoResultado.setText("");
				comboUnidades.removeAllItems(); // LIMPIA EL COMBOBOX
				coboBoxUnidadesSelec.removeAllItems();
				comboUnidades.setEnabled(false); // CERRAMOS
				coboBoxUnidadesSelec.setEnabled(false);
			}
		});
	}
	
	private void campoTextoResultado() {
		campoResultado=new JTextField();
		campoResultado.setBounds(80,230,200,50);
		campoResultado.setEnabled(false);
		campoResultado.setBackground(Color.DARK_GRAY);
		campoResultado.setDisabledTextColor(Color.WHITE);
		campoResultado.setFont(new Font("Arial",Font.BOLD,25));
		panel.add(campoResultado);
	}
	
	private void botonCalcular() {
		JButton botonCalcular=new JButton("Calcular");
		botonCalcular.setBounds(200,300,150,50);
		panel.add(botonCalcular);
		
		botonCalcular.addActionListener(evento->{
			try {
				double valor=Double.parseDouble(campoTexto.getText());  //GUARDAMOS EL NUMERO A CALCULAR
				String UnidadSelec=(String) coboBoxUnidadesSelec.getSelectedItem(); // GUARDAMOS 
				String unidad=(String) comboUnidades.getSelectedItem();  // GUARDAMOS LAS UNIDADES
				
				LogicaConversor conversor=new LogicaConversor(UnidadSelec,unidad,valor); // CREAMOS EL CONSTRUCTOR
				
				campoResultado.setText(resultado(conversor)); // AL CAMPO TEXTO LE AGREGAMOS EL RETORNO DE ESA FUNCION
			}catch(Exception error) {
				System.out.println("Error: "+error);
			}
		});
	}
	
	private void comboBoxUnidades() {
		comboUnidades = new JComboBox<>();
        comboUnidades.setBounds(300, 230, 200, 50);
        comboUnidades.setEnabled(false);
        panel.add(comboUnidades);
	}
	
	private void coboBoxUnidadesSelec() {
		coboBoxUnidadesSelec=new JComboBox<>();
		coboBoxUnidadesSelec.setBounds(300,150, 200, 50);
		coboBoxUnidadesSelec.setEnabled(false);
        panel.add(coboBoxUnidadesSelec);
	}
	
	// UN MAPEO DE LOS DATOS A REALIZAR
	private String[] unidadesString(String categoria) {
		HashMap<String, String[]> categoriasYUnidades = new HashMap<>();
		categoriasYUnidades.put("Temperatura", new String[] { "Celsius", "Fahrenheit", "Kelvin" });
		categoriasYUnidades.put("Longitud", new String[] { "Metros", "Kilometros", "Millas" });
		categoriasYUnidades.put("Peso/Masa", new String[] { "Gramos", "Kilogramos", "Libras" });
		categoriasYUnidades.put("Volumen", new String[] { "Litros", "Mililitros", "Galones", "Onzas Líquidas", "Cubic Metros" });
	    categoriasYUnidades.put("Area", new String[] { "Metros Cuadrados", "Kilómetros Cuadrados", "Hectáreas", "Acres", "Pies Cuadrados", "Pulgadas Cuadradas" });
	    categoriasYUnidades.put("Velocidad", new String[] { "Metros por Segundo", "Kilómetros por Hora", "Millas por Hora", "Nudos" });
	    categoriasYUnidades.put("Tiempo", new String[] { "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años" });
	    categoriasYUnidades.put("Almacenamiento digital", new String[] { "Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes", "Petabytes" });
		return categoriasYUnidades.getOrDefault(categoria, new String[] {}); // RETORNA EL ARREGLO PARA PODER AGREGARSELO AL COMBOBOX
	}
	
	// ESTA FUNCION RETORNA EL RESULTADO EN STRING
	private String resultado(LogicaConversor conversor) {
		campoResultado.setText(""); //LIMPIA EL CAMPORESULTADO
		switch (categoriaSeleccionada) {
			case "Temperatura": 
				return String.valueOf(conversor.temperatura());
			case "Longitud":
				return String.valueOf(conversor.longitud());
			case "Peso/Masa":
				return String.valueOf(conversor.pesoMasa());
			case "Volumen":
				return String.valueOf(conversor.volumen());
			case "Area":
				return String.valueOf(conversor.area());
			case "Velocidad":
				return String.valueOf(conversor.velocidad());
			case "Tiempo":
				return String.valueOf(conversor.tiempo());
			case "Almacenamiento digital":
				return String.valueOf(conversor.almaDigi());
		}
		return null;
	}
	
	private void etiquetas() {
		JLabel etiqIngrese=new JLabel ("Ingrese valor");
		etiqIngrese.setBounds(135,115,200,50);
		etiqIngrese.setForeground(Color.BLACK);
		etiqIngrese.setFont(new Font("Arial", Font.BOLD,15));
		panel.add(etiqIngrese);
		
		JLabel etiqeResultado=new JLabel("RESULTADO");
		etiqeResultado.setBounds(135,200,200,50);
		etiqeResultado.setForeground(Color.BLACK);
		etiqeResultado.setFont(new Font("Arial", Font.BOLD,15));
		panel.add(etiqeResultado);
	}
}
