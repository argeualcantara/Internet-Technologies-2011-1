package model;

public class Area {
	
	private int id_area;
	private String descricao;
	
	public Area(int idArea, String descricao) {
		super();
		id_area = idArea;
		this.descricao = descricao;
	}
	
	public int getId_area() {
		return id_area;
	}
	public void setId_area(int idArea) {
		id_area = idArea;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
