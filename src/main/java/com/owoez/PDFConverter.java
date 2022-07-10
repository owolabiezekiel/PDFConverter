package com.owoez;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

/**
 * Author: tobilobaowolabi
 * Date: 10/07/2022
 * Project: PDFConverter
 * IDE: IntelliJ IDEA
 **/
public class PDFConverter {
  public static void main(String[] args) {
	com.aspose.pdf.LocaleOptions.setLocale(new Locale("en", "US"));

	//Check if user supplied the file location as an argument or not
	if (args.length <= 0) {
	  System.out.println("You need to pass the file location as an argument");
	  return;
	}

	//Get the filePathString and split it go get the name of the file which should be the last argument
	String filePathString = args[0];

	/*Check if the user supplied the final destination of the output file.
	* If they didn't, use the file name of the input file and set the destination to the users Desktop
	* Note: If a file with the same name already exists, the file gets overwritten*/
	String[] splitFilePathString = filePathString.split("/");
	String fileNameWithExtension = splitFilePathString[splitFilePathString.length - 1];
	System.out.println("FileNameWithExtension: " + fileNameWithExtension);
	String[] splitFileNameAndExtension = fileNameWithExtension.split("\\.");
	String fileName = splitFileNameAndExtension[0];
	String userHomeDir = System.getProperty("user.home");
	System.out.printf("The User Home Directory is %s", userHomeDir);
	String destinationFilePath = userHomeDir + "/Desktop/" + fileName + ".docx";


	//Load the source PDF file and save the resulting docx file
	Document document = new Document(filePathString);
	document.save(destinationFilePath, SaveFormat.DocX);

  }
}
