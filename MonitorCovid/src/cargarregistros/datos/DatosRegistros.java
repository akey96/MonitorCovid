package cargarregistros.datos;

import monitor.Registros;

import java.io.*;

public class DatosRegistros {

    private String getPath(){
        File miDir = new File (".");
        String dir="", path, separador = System.getProperty("file.separator");
        try {
            dir= miDir.getCanonicalPath();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        boolean esDesarrollo = false;
        File file2 = new File(dir);
        String[] a = file2.list();
        assert a != null;
        for (String s : a) {
            if (s.equals("src")) {
                esDesarrollo = true;
                break;
            }
        }

        String nombreArchivo = "registros.dat";
        String nombrePaquete = "cargarregistros";
        if ( !esDesarrollo ){
            path = dir+separador+ nombrePaquete +separador+ nombreArchivo;
        } else {
            path = dir+separador+"src"+separador+ nombrePaquete +separador+ nombreArchivo;
        }
        return path;
    }

    public Registros leerDatosRegistros() throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(getPath()));
        Registros registros = (Registros) file.readObject();
        file.close();
        return registros;
    }

    public boolean existeDatosRegistros(){
        File f = new File(getPath());
        return f.exists();
    }

    public void guardarDatosRegistros(Registros registros) throws IOException {
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(getPath()));
        file.writeObject(registros);
        file.close();
    }
}
