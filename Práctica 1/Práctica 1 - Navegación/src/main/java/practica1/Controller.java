package main.java.practica1;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "controladorNavegacion", eager = true)
@RequestScoped
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String moverHaciaPagina1() {
		return "pagina1";
	}

	public String procesarPagina1() {
		return "pagina";
	}

	public String procesarPagina2() {
		return "pagina";
	}

	public String mostrarPagina() {
		switch (pageId) {
			case "1":
				return "pagina1";
			case "2":
				return "pagina2";
			default:
				return "home";
		}
	}
}