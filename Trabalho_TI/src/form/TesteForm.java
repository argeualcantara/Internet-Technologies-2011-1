package form;

import org.apache.struts.action.ActionForm;

public class TesteForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String desc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
