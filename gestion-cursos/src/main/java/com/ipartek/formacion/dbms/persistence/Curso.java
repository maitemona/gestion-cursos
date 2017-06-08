package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;

public class Curso implements Comparable<Curso>, Serializable {
	
	
	public final static int CODIGO_NULO = -1;
	private long id;
	private String nombre;
	private String codigo;
	public Curso() {
		super();
		this.nombre = "";
		this.codigo = "";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	@Override
	public int compareTo(Curso o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
