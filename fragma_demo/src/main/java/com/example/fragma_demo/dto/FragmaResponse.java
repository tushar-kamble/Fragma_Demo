package com.example.fragma_demo.dto;

public class FragmaResponse<T> {

	private String statusMessage;
	private int statusCode;
	private Error error;
	private FragmaResult<T> fragmaResult;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public FragmaResult<T> getFragmaResult() {
		return fragmaResult;
	}

	public void setFragmaResult(FragmaResult<T> fragmaResult) {
		this.fragmaResult = fragmaResult;
	}

}
