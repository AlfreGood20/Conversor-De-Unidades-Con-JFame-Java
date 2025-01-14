package appConversionUnidades;

public class LogicaConversor {
	private String unidadSelection;
	private String unidadCalcular;
	private double valor;
	
	
	public LogicaConversor(String unidadSelection, String unidadCalcular, double valor) {
		this.unidadSelection = unidadSelection;
		this.unidadCalcular = unidadCalcular;
		this.valor = valor;
	}
	
	public double temperatura() {
		if (unidadSelection.equals("Celsius") && unidadCalcular.equals("Fahrenheit")) {
			return (valor * 9 / 5) + 32;
		} else if (unidadSelection.equals("Fahrenheit") && unidadCalcular.equals("Celsius")) {
			return (valor - 32) * 5 / 9;
		} else if (unidadSelection.equals("Celsius") && unidadCalcular.equals("Kelvin")) {
			return valor + 273.15;
		} else if (unidadSelection.equals("Kelvin") && unidadCalcular.equals("Celsius")) {
			return valor - 273.15;
		} else if (unidadSelection.equals("Fahrenheit") && unidadCalcular.equals("Kelvin")) {
			return ((valor - 32) * 5 / 9) + 273.15;
		} else if (unidadSelection.equals("Kelvin") && unidadCalcular.equals("Fahrenheit")) {
			return ((valor - 273.15) * 9 / 5) + 32;
		} else {
			return valor;
		}
	}

	public float longitud() {
		if (unidadSelection.equals("Metros") && unidadCalcular.equals("Kilometros")) {
			return (float) valor / 1000;
		} else if (unidadSelection.equals("Kilometros") && unidadCalcular.equals("Metros")) {
			return (float) valor * 1000;
		} else if (unidadSelection.equals("Metros") && unidadCalcular.equals("Millas")) {
			return (float) valor/1609;
		} else if (unidadSelection.equals("Millas") && unidadCalcular.equals("Metros")) {
			return (float) valor * 1609;
		} else if (unidadSelection.equals("Kilometros") && unidadCalcular.equals("Millas")) {
			return (float) ((float) valor / 1.609);
		} else if (unidadSelection.equals("Millas") && unidadCalcular.equals("Kilometros")) {
			return (float) ((float) valor * 1.609);
		} else {
			return (float) valor;
		}
	}
	
	public float pesoMasa() {
	    if (unidadSelection.equals("Gramos") && unidadCalcular.equals("Kilogramos")) {
	        return (float) valor / 1000;
	    } else if (unidadSelection.equals("Kilogramos") && unidadCalcular.equals("Gramos")) {
	        return (float) valor * 1000;
	    } else if (unidadSelection.equals("Gramos") && unidadCalcular.equals("Libras")) {
	        return (float) ((float) valor/453.6);
	    } else if (unidadSelection.equals("Libras") && unidadCalcular.equals("Gramos")) {
	        return (float) ((float) valor*453.6);
	    } else if (unidadSelection.equals("Kilogramos") && unidadCalcular.equals("Libras")) {
	        return (float) ((float) valor * 2.205);
	    } else if (unidadSelection.equals("Libras") && unidadCalcular.equals("Kilogramos")) {
	        return (float) ((float) valor/2.205);
	    }
	    return (float) valor;
	}
	
	public double volumen() {
	    if (unidadSelection.equals("Litros") && unidadCalcular.equals("Mililitros")) {
	        return valor*1000.0;
	    } else if (unidadSelection.equals("Mililitros") && unidadCalcular.equals("Litros")) {
	    	return valor/1000.0;
	    } else if (unidadSelection.equals("Litros") && unidadCalcular.equals("Galones")) {
	        return valor / 3.78541;
	    } else if (unidadSelection.equals("Galones") && unidadCalcular.equals("Litros")) {
	        return valor * 3.78541;
	    } else if (unidadSelection.equals("Onzas Líquidas") && unidadCalcular.equals("Litros")) {
	        return valor / 33.814;
	    } else if (unidadSelection.equals("Litros") && unidadCalcular.equals("Onzas Líquidas")) {
	        return valor * 33.814;
	    } else if (unidadSelection.equals("Litros") && unidadCalcular.equals("Cubic Metros")) {
	        return valor / 1000.0;
	    } else if (unidadSelection.equals("Cubic Metros") && unidadCalcular.equals("Litros")) {
	        return valor * 1000.0;
	    }
	    return valor;
	}

	public double area() {
	    if (unidadSelection.equals("Metros Cuadrados") && unidadCalcular.equals("Kilómetros Cuadrados")) {
	        return valor /1e+6;
	    } else if (unidadSelection.equals("Kilómetros Cuadrados") && unidadCalcular.equals("Metros Cuadrados")) {
	        return valor * 1e+6;
	    } else if (unidadSelection.equals("Metros Cuadrados") && unidadCalcular.equals("Hectáreas")) {
	        return valor / 10000;
	    } else if (unidadSelection.equals("Hectáreas") && unidadCalcular.equals("Metros Cuadrados")) {
	        return valor * 10000;
	    } else if (unidadSelection.equals("Hectáreas") && unidadCalcular.equals("Acres")) {
	        return valor * 2.471;
	    } else if (unidadSelection.equals("Acres") && unidadCalcular.equals("Hectáreas")) {
	        return valor / 2.471;
	    } else if (unidadSelection.equals("Pies Cuadrados") && unidadCalcular.equals("Pulgadas Cuadradas")) {
	        return valor*144;
	    } else if (unidadSelection.equals("Pulgadas Cuadradas") && unidadCalcular.equals("Pies Cuadrados")) {
	        return valor / 144;
	    }
	    return valor;
	}
	
	public double velocidad() {
	    if (unidadSelection.equals("Metros por Segundo") && unidadCalcular.equals("Kilómetros por Hora")) {
	        return valor * 3.6;
	    } else if (unidadSelection.equals("Kilómetros por Hora") && unidadCalcular.equals("Metros por Segundo")) {
	        return valor / 3.6;
	    } else if (unidadSelection.equals("Kilómetros por Hora") && unidadCalcular.equals("Millas por Hora")) {
	        return valor / 1.609;
	    } else if (unidadSelection.equals("Millas por Hora") && unidadCalcular.equals("Kilómetros por Hora")) {
	        return valor * 1.609;
	    } else if (unidadSelection.equals("Nudos") && unidadCalcular.equals("Kilómetros por Hora")) {
	        return valor * 1.852;
	    } else if (unidadSelection.equals("Kilómetros por Hora") && unidadCalcular.equals("Nudos")) {
	        return valor / 1.852;
	    }
	    return valor;
	}
	
	public double tiempo() {
	    if (unidadSelection.equals("Segundos") && unidadCalcular.equals("Minutos")) {
	        return valor / 60;
	    } else if (unidadSelection.equals("Minutos") && unidadCalcular.equals("Segundos")) {
	        return valor * 60;
	    } else if (unidadSelection.equals("Minutos") && unidadCalcular.equals("Horas")) {
	        return valor / 60;
	    } else if (unidadSelection.equals("Horas") && unidadCalcular.equals("Minutos")) {
	        return valor * 60;
	    } else if (unidadSelection.equals("Horas") && unidadCalcular.equals("Días")) {
	        return valor / 24;
	    } else if (unidadSelection.equals("Días") && unidadCalcular.equals("Horas")) {
	        return valor * 24;
	    } else if (unidadSelection.equals("Días") && unidadCalcular.equals("Semanas")) {
	        return valor / 7;
	    } else if (unidadSelection.equals("Semanas") && unidadCalcular.equals("Días")) {
	        return valor * 7;
	    } else if (unidadSelection.equals("Meses") && unidadCalcular.equals("Años")) {
	        return valor / 12;
	    } else if (unidadSelection.equals("Años") && unidadCalcular.equals("Meses")) {
	        return valor * 12;
	    }
	    return valor;
	}
	
	public double almaDigi() {
	    if (unidadSelection.equals("Bytes") && unidadCalcular.equals("Kilobytes")) {
	        return valor / 1024;
	    } else if (unidadSelection.equals("Kilobytes") && unidadCalcular.equals("Bytes")) {
	        return valor * 1000;
	    } else if (unidadSelection.equals("Kilobytes") && unidadCalcular.equals("Megabytes")) {
	        return valor / 1000;
	    } else if (unidadSelection.equals("Megabytes") && unidadCalcular.equals("Kilobytes")) {
	        return valor * 1000;
	    } else if (unidadSelection.equals("Megabytes") && unidadCalcular.equals("Gigabytes")) {
	        return valor / 1000;
	    } else if (unidadSelection.equals("Gigabytes") && unidadCalcular.equals("Megabytes")) {
	        return valor * 1000;
	    } else if (unidadSelection.equals("Gigabytes") && unidadCalcular.equals("Terabytes")) {
	        return valor / 1000;
	    } else if (unidadSelection.equals("Terabytes") && unidadCalcular.equals("Gigabytes")) {
	        return valor * 1000;
	    }else if(unidadSelection.equals("Bytes") && unidadCalcular.equals("Megabytes")) {
	    	return valor / 1e+6;
	    }else if(unidadSelection.equals("Bytes") && unidadCalcular.equals("Gigabytes")) {
	    	return valor / 1e+9;
	    }else if(unidadSelection.equals("Bytes") && unidadCalcular.equals("Terabytes")) {
	    	return valor / 1e+12;
	    }else if(unidadSelection.equals("Bytes") && unidadCalcular.equals("Petabytes")) {
	    	return valor / 1e+15;
	    }
	    return valor;
	}
}
