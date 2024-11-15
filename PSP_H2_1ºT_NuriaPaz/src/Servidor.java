import java.util.*;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Servidor en funcionamiento...");
		
		//Simulador de clientes
		for(int i = 0; i < 5;i++) {
			final int clienteID = i +1;
			
			//Nuevo hilo para cada cliente que este
			Thread clienteThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						
						//llama al metodo controlador de clientes
						controlarCliente(clienteID);
					} catch (Exception e) {
						System.out.println("error!! AL CONTROLAR AL CLIENTE "+  clienteID);
					}
				}
			});
			clienteThread.start();
		}
	}
	
	public static void controlarCliente(int clienteID) {
		
		//sincroniza la salida del sistema para que no se mezclan entre hilos
		synchronized(System.out) {
			try {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Atendiendo al cliente" + clienteID);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				
				//Simula la consulta de un cliente con la palabra "Java"
				String consulta = "Python";
				List<String> resultados = AccesoDatos.buscarlibro(consulta);
				
				//muestra los mensajes de confirmacion de que el odigo funciona correctamente
				System.out.println("Cliente "+ clienteID+" conculta "+ consulta);
				if(resultados.isEmpty()) {
					System.out.println("No se encontraron resultados");
				}else { 
					for (String resultado : resultados) {
						System.out.println("Resultado: " + resultado);
					}
					
				}
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}catch (Exception e) {
				System.out.println("error!! al atender al cleinte" + clienteID + ":"+ e.getMessage());
			}
		
		}
	}

}
