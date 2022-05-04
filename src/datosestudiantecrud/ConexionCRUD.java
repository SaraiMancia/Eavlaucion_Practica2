
package datosestudiantecrud;

import java.sql.*;

public class ConexionCRUD {
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_registro_estudiante";
    
    private final String usuario = "root";
    
    private final String clave = "";
    
    private final String driverConector = "com.mysql.jdbc.Driver";
    
    private final String Connection conxion;
    
    public ConexionCRUD(){
        try{
            Class.forName(driveConector);
            
            conexion=DriverManager.getConnection(servidor, usuario,clave);
        }catch(ClassNotFoudException | SQLException e) {
            System.out.println("Conexión fallida! Error! : " + e.getMessage());
            
        }
    }
public Connection getConnection(){
return conexion;    
    }
public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
    ConexionCRUD conectar = new ConexionCRUD();
    ConexionCRUD cone = conectar.getConnection();
    try {
        String sqlQueryStmt - " INSERT INTO " + tabla + "("+ camposTabla + ") VALUE (" + valoresCampos + ");";
        
        Statement stmt;
        stmt.executeUpdate(sqlQueryStmt);
        
        stmt.close();
        cone.close();
        System.out.println("Registro guardado correctamente!");
    }catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
    
    ConexionCRUD conectar = new ConexionCRUD();
    Connection cone = conectar.getConnetion();
    try{
        Statement stmt;
        String sqlQueryStmt;
        
        if(valoresCamposNuevos.isEmpty()){
            sqlQueryStmt = "DELETE FROM" +tabla + "WHERE" + condicion + ";";
        }else{
            sqlQueryStmt = "UPDATE" + tabla + "SET" + valoresCamposNuevos + "WHERE" + condicion + ";";
        }
        stmt = cone.createStatement();
        stmt = executeUpdate(sqlQueryStmt);
        stmt.close();
        cone.close();
    }catch(SQLException ex) {
        System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        
        }
    }
}
}