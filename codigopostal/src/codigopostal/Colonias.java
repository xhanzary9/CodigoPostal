package org.codigopostal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
/**
 * Clase exclusivamente para obtener las colonias del codigo postal. 
 * Esta clase lee de un "base de datos" en este caso unos archivos txt. 
*/
public class Colonias {
	/**
	 * @param codigo el codigo postal.  
	 * @param pais el pais al que pertenece. 
	*/
	public static String getColonia(String codigo, String pais) {
		if (pais.equals("Mexico")) {
        	return getColoniaMexico(codigo);
        } else if (pais.replaceAll("\\s+","").equalsIgnoreCase("Estados Unidos".replaceAll("\\s+",""))) {
            //Tenia que hacer lo anterior por los espacios en blanco. 
            return getColoniaUS(codigo);
        } else if (pais.equals("Canada")) {
            return getColoniaCan(codigo);
        } else if (pais.equals("Japon")) {
            return getColoniaJap(codigo);
        } else if (pais.equals("China")) {
            return getColoniaChi(codigo);
        }
        return "Colonia no encontrada";
	}

	/*
	 * Obtiene la colonia exclusivamente de México. 
	 * @param codigo el codigo postal. 
	*/
	private static String getColoniaMexico(String codigo) {
		File file = new File("codigoPostalColoniasMexico.txt");
               
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	//AQUI SE COMPARA TODO. 
		    	String[] parts = text.split(":");
		    	
		       	if (codigo.equals(parts[0])) {
		       		return parts[1];
		       	} 
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} 

		return "Colonia no encontrada";
	}

	/*
	 * Lo mismo pero en US. 
	*/
	private static String getColoniaUS(String codigo) {
		File file = new File("CodigosPostales/codigoPostalColoniasEU.txt");
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	//AQUI SE COMPARA TODO. 
		    	String[] parts = text.split(":");
		    	
		       	if (codigo.equals(parts[0])) {
		       		return parts[1];
		       	} 
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}

		return "Colonia no encontrada";
	}

	/*
	 * Lo mismo pero en Canada. 
	*/
	private static String getColoniaCan(String codigo) {
		File file = new File("CodigosPostales/codigoPostalColoniasCanada.txt");
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	//AQUI SE COMPARA TODO. 
		    	String[] parts = text.split(":");
		    	
		       	if (codigo.equals(parts[0])) {
		       		return parts[1];
		       	} 
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} 

		return "Colonia no encontrada";
	}

	/*
	 * Lo mismo pero en Japon
	*/
	private static String getColoniaJap(String codigo) {
		File file = new File("CodigosPostales/codigoPostalColoniasJapon.txt");
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	//AQUI SE COMPARA TODO. 
		    	String[] parts = text.split(":");
		    	
		       	if (codigo.equals(parts[0])) {
		       		return parts[1];
		       	} 
		    }

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		return "Colonia no encontrada";
	}


	/*
	 * Lo mismo pero en China
	*/
	private static String getColoniaChi(String codigo) {
		File file = new File("CodigosPostales/codigoPostalColoniasChina.txt");
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	//AQUI SE COMPARA TODO. 
		    	String[] parts = text.split(":");
		    	
		       	if (codigo.equals(parts[0])) {
		       		return parts[1];
		       	} 
		    }

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		return "Colonia no encontrada";
	}
	public static void main(String[] args) {
		System.out.println(Colonias.getColonia("100040", "China"));
	}
}

