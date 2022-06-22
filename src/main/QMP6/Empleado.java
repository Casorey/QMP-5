package main.QMP6;

import java.util.HashMap;
import java.util.List;

public class Empleado {
  IntermediarioAPI intermediarioAsociado;
  /*QMP6
  Como empleade de QueMePongo, necesito poder disparar un proceso que consulte y actualice la lista de alertas
   publicadas en el sistema para tener control sobre cuándo se publican las mismas
   */
  public void actualizarListaAlertaCon(HashMap<String, List<String>> filaNueva){
    intermediarioAsociado.agregarAlerta(filaNueva);
  }

}
