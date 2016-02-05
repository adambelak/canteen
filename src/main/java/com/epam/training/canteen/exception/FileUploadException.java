package com.epam.training.canteen.exception;

import java.io.IOException;

public class FileUploadException extends IOException {

	private static final long serialVersionUID = -3348463865445511037L;

	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}

	
	
}
