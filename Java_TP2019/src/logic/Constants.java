package logic;

public class Constants {
	  public static final String UPLOAD_DIRECTORY = "upload";
	  public static final String DEFAULT_FILENAME = "default.file";

	  public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
	  public static final int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
	  public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB
}

/*
 * These constants will be used to configure upload settings.
          UPLOAD_DIRECTORY: name of the directory on the server where upload file will be stored. The directory is chosen to be relative to the web application’s directory.
          MEMORY_THRESHOLD: file that has size less than this threshold value will be saved into memory. If the size is greater than this value, it will be stored on disk, temporarily. The value is measured in bytes.
          MAX_FILE_SIZE: specifies the maximum size of an upload file. We define this constant to hold a file up to 40MB.
          MAX_REQUEST_SIZE: specifies the maximum size of a HTTP request which contains the upload file and other form’s data, so this constant should be greater than the MAX_FILE_SIZE.
 * */
 