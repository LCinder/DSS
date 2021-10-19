package prueba;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name="holamundo2", eager=true)
@RequestScoped
public class HolaMundo implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{mensaje}")
	private Mensaje mensajeBean;
	private String mensaje = "Nada aun";

	public String getMensaje() {
		return mensajeBean.getMensaje();
	}

	public void setMensajeBean(Mensaje mensajeBean) {
		this.mensajeBean = mensajeBean;
	}

	public HolaMundo(){
		System.out.println("Hola Mundo ha comenzado!");
	}
	public String getMensajeP(){
		return this.mensaje;
	}
}