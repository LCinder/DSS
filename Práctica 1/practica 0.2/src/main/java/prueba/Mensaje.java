package prueba;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name="mensaje", eager=true)
@RequestScoped
public class Mensaje implements Serializable {
    private String mensaje;
    private static final long serialVersionUID = 1L;

    public Mensaje() {
        this.mensaje = "Constructor mensaje";
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
