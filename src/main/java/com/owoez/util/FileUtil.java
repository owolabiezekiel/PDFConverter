package com.owoez.util;

/**
 * Author: tobilobaowolabi
 * Date: 11/07/2022
 * Project: PDFConverter
 * IDE: IntelliJ IDEA
 **/
public class FileUtil {
  /**
   * Check if the filePathString submitted through the CLI is valid.
   * @param filePathString String
   * */
  public static boolean isValidPdfFilePath(String filePathString) {
	String[] splitFilePathString = filePathString.split("/");
	System.out.println("Filename is: " + splitFilePathString[splitFilePathString.length -1]);
	String fileNameWithExtension = splitFilePathString[splitFilePathString.length - 1];
	String[] splitFileNameAndExtension = fileNameWithExtension.split("\\.");
	String fileExtension = splitFileNameAndExtension[splitFileNameAndExtension.length - 1];
	return fileExtension.equalsIgnoreCase("pdf");
  }

  /**
   * Determine output file name if the user doesn't pass it as a CLI argument
   * @param filePathString  String
   * */
  public static String getOutputFileName(String filePathString){
	String[] splitFilePathString = filePathString.split("/");
	String fileNameWithExtension = splitFilePathString[splitFilePathString.length - 1];
	String[] splitFileNameAndExtension = fileNameWithExtension.split("\\.");
	String fileName = splitFileNameAndExtension[0];
	String userHomeDir = System.getProperty("user.home");
	return userHomeDir + "/Desktop/" + fileName + ".docx";
  }
}
