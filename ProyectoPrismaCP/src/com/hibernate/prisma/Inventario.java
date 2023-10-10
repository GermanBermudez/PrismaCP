package com.hibernate.prisma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.*;

@Entity
@Table(name = "Inventario")

public class Inventario {
	
	@Id
	@Column (name = "Id_Inventario")
	private int id_inventario;
	
	@Column (name = "Cantidad")
	private int cantidad;
	
	@Column (name = "Disponibilidad")
	private boolean disponibilidad;
	
	@Column (name = "Materiales_Id_Materiales")
	private int materiales_id;

    public Inventario() {
        // No es necesario agregar lógica aquí, puede estar vacío
    }
    
	public Inventario(int id_inventario, int cantidad, boolean disponibilidad, int materiales_id) {
		super();
		this.id_inventario = id_inventario;
		this.cantidad = cantidad;
		this.disponibilidad = disponibilidad;
		this.materiales_id = materiales_id;
	}

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getMateriales_id() {
		return materiales_id;
	}

	public void setMateriales_id(int materiales_id) {
		this.materiales_id = materiales_id;
	}
	
}

