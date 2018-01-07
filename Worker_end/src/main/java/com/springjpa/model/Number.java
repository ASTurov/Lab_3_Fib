package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Number implements Serializable {

//	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private int last;
	private int preLast;

	protected Number() {
	}

	public Number(int last, int preLast)
	{
		this.last = last;
		this.preLast = preLast;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPreLast() {
		return preLast;
	}

	public void setPreLast(int preLast) {
		this.preLast = preLast;
	}

	@Override
	public String toString() {
		return String.format("Last value: %s", last);
	}
}