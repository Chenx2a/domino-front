package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import LogicaNegocio.Ficha;
import LogicaNegocio.Jugador;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Estudiante
 */
public class ServicioJugador extends Servicio
{
    private static final String INSERTARJUGADOR = "{call insertarJugador(?,?)}";

    /** Creates a new instance of ServicioLibro */
    public ServicioJugador()
    {
    }


    public void insertarJugador(Jugador elJugador) throws GlobalException, NoDataException
    {
            try
            {
                    conectar();
            }
            catch (ClassNotFoundException e)
            {
                    throw new GlobalException("No se ha localizado el driver");
            }
            catch (SQLException e)
            {
                    throw new NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt = null;

            try
            {

                    pstmt = conexion.prepareCall(INSERTARJUGADOR);
                    pstmt.setInt(1, elJugador.getNumero());
                    pstmt.setInt(2, elJugador.getPuntuacion());
                    boolean resultado = pstmt.execute();
                    if (resultado == true)
                    {
                            throw new NoDataException("No se realizo la inserción");
                    }

            }
            catch (SQLException e)
            {
                    e.printStackTrace();
                    throw new GlobalException("Llave duplicada");
            }
            finally
            {
                    try
                    {
                            if (pstmt != null)
                            {
                                    pstmt.close();
                            }
                            desconectar();
                    }
                    catch (SQLException e)
                    {
                            throw new GlobalException("Estatutos invalidos o nulos");
                    }
            }
    }
}