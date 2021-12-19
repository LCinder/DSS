package practica2Bookshop;

import java.util.HashMap;
import java.util.Map;

import practica2Bookshop.model.Model;

public enum DAO {
	INSTANCE;
	
	private Map<String, Model> contents = new HashMap<String, Model>();
	
	private DAO() {
	}
	
	public Map<String, Model> getModel() {
		return contents;
	}
	
}
