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
public class ServicioFicha extends Servicio
{

    private static final String LISTARFICHA = "{call listarFicha ()}";
    private static final String CONSULTARFICHAUBICACION = "{?=call consultarFichaUbicacion(?)}";
    private static final String ACTUALIZARFICHA = "{call actualizarFicha(?,?,?,?,?)}";

    /** Creates a new instance of ServicioLibro */
    public ServicioFicha()
    {
    }

    public ArrayList listarFichas() throws GlobalException, NoDataException
    {
            try
            {
                    conectar();
            }
            catch (ClassNotFoundException ex)
            {
                    throw new GlobalException("No se ha localizado el Driver");
            }

            catch (SQLException e)
            {
                    throw new NoDataException("La base de datos no se encuentra disponible");
            }

            ResultSet rs = null;
            ArrayList coleccion = new ArrayList();
            Ficha laFicha = null;
            CallableStatement pstmt = null;
            try
            {
                    pstmt = conexion.prepareCall(LISTARFICHA);
                    pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                    pstmt.execute();
                    rs = (ResultSet)pstmt.getObject(1);
                    while (rs.next())
                    {
                            laFicha = new Ficha(rs.getInt("valor1"),
                                                rs.getInt("valor2"),
                                                rs.getString("imagen"),
                                                rs.getBoolean("visible"),
                                                rs.getInt("ubicacion"));
                            coleccion.add(laFicha);
                    }
            }
            catch (SQLException e)
            {
                    e.printStackTrace();

                    throw new GlobalException("Sentencia no valida");
            }
            finally
            {
                    try
                    {
                            if (rs != null)
                            {
                                    rs.close();
                            }
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
            if (coleccion == null || coleccion.size() == 0)
            {
                    throw new NoDataException("No hay datos");
            }
            return coleccion;
    }

    public void actualizarFicha(Ficha laFicha) throws GlobalException, NoDataException
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

                    pstmt = conexion.prepareCall(ACTUALIZARFICHA);
                    pstmt.setInt(1, laFicha.getValor1());
                    pstmt.setInt(2, laFicha.getValor2());
                    pstmt.setString(3, laFicha.getImagen());
                    pstmt.setBoolean(4, laFicha.isVisible());
                    pstmt.setInt(5, laFicha.getUbicacion());
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

    public Ficha buscarPorCodigo(String codigo) throws GlobalException, NoDataException
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
            ResultSet rs = null;
            ArrayList coleccion = new ArrayList();
            Ficha laFicha = null;
            CallableStatement pstmt = null;
            try
            {
                    pstmt = conexion.prepareCall(CONSULTARFICHAUBICACION);
                    pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                    pstmt.setString(2, codigo);
                    pstmt.execute();
                    rs = (ResultSet)pstmt.getObject(1);
                    while (rs.next())
                    {
                            laFicha = new Ficha(rs.getInt("valor1"),
                                                rs.getInt("valor2"),
                                                rs.getString("imagen"),
                                                rs.getBoolean("visible"),
                                                rs.getInt("ubicacion"));
                            coleccion.add(laFicha);
                    }
            }
            catch (SQLException e)
            {
                    e.printStackTrace();

                    throw new GlobalException("Sentencia no valida");
            }
            finally
            {
                    try
                    {
                            if (rs != null)
                            {
                                    rs.close();
                            }
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
            if (coleccion == null || coleccion.size() == 0)
            {
                    throw new NoDataException("No hay datos");
            }
            return laFicha;
    }
}