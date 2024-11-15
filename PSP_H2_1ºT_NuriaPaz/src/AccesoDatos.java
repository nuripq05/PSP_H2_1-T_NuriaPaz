import java.io.*;
import java.util.*;

public class AccesoDatos {
	//metodo para buscar los datos en el aarchivo con synchronized
	public static List<String>obtenerLibros(){
		List<String> libros = new ArrayList<>();
		
		//ruta para leer el archivo
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Programas_Java\\PSP_H2_1ºT_NuriaPaz\\src\\archivo.txt"))){
			String linea;
			
			//lee cada linea de archivo.txt hasta el final
			while ((linea = reader.readLine()) != null) {
				libros.add(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de datos" + e.getMessage());
		}
		return libros;//retorna la lista libros
	}
	
	public static List<String> buscarlibro(String nombrelibro) {
		List<String> libros = obtenerLibros();//Obtiene los nombres de el archivo
		List<String> resultados = new ArrayList();// almacena la informacion del archivo
		for(String libro : libros) {
			
			//sirve para que no tengamos problemas  a la hora de buscar la plabra clave ya este en mayusculas o minusculas
			if(libro.toLowerCase().contains(nombrelibro.toLowerCase())){
				resultados.add(libro);
			}
		}
		return resultados;
	}

}
