package io.gdiazs.banking.commons;

public class ResponseDTO<E> {
	
	private E data;
	

	public ResponseDTO(E data) {
		super();
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	
	
}
