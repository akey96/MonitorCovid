package cargarsintomas;

import cargarsintomas.datos.DatosSintomas;
import cargarsintomas.gui.VentanaSintomasFrame;
import monitor.Sintoma;
import monitor.Sintomas;

public class CargarSintomas {

    private Sintomas sintomas;

    public CargarSintomas() {
        cargarSintomas();
        cargarSintomasApp();
    }

    private void cargarSintomas() {
        DatosSintomas datosSintomas = new DatosSintomas();
        sintomas = new Sintomas();
        if(datosSintomas.existeDatosSintomas()){
            for(Sintoma s: datosSintomas.leerDatosSintomas()){
                sintomas.add(s);
            }
        }
    }

    private void cargarSintomasApp() {
        new VentanaSintomasFrame(sintomas);
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

}
