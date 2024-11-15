import java.util.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//simula consulta del cliente
		String consulta = "Php";
		
		//LLama al metodo de buscarlibro de la clase accesodatos para buscar libros con esos terminos
		List<String> resultados = AccesoDatos.buscarlibro(consulta);
		
		System.out.println("Cliente consulta: "+ consulta);
		
		//verificar si la lista esta vacia
		if(resultados.isEmpty()) {
			System.out.println("No se encontraron resultados");
		}else { 
			//si se encontraron resultados, imprimir todos
			for (String resultado : resultados) {
				System.out.println("Resultado: " + resultado);
			}
			
		}
	}

}
