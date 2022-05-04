
package datosestudiantecrud;

import java.sql.SQLException;
import java.util.Scanner;



public class Delete {
    
    Delete() throws SQLException {
        Scanner leer = new Scanner(System.in);
        conexionCRUD utilerias = new conexionCRUD();
        System.out.println("<< ELIMINAR REGISTROS >>");
        
        System.out.println("Ingrese el ID del registro: ");
        String id_estudianteEliminar = leer.next();
        
        String tabla = "bd_registro_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + id_estudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Precionar <<Y>> para confirmar: ");
        String confirmarBorrar = leer.next();
        
        if ("Y".equals(confirmarBorrar)) {
            
            String valoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistro (tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado exitosamente!");
        }
        menu_principal.despliegeMenu();
    }
}
        
       
   