package com.owoez;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

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
	String destinationFilePath;


	//Check if user supplied the input file location as an argument or not
	if (args.length <= 0) {
	  System.out.println("You need to pass the file location as an argument");
	  return;
	}

	String filePathString = args[0];


	//Check that the filepath doesn't contain special characters like space
	System.out.println("Checking input file path....");
	if (!isValidPdfFilePath(filePathString)){
	  System.out.println("Invalid file path. Please make sure to escape all special characters in file path");
	  return;
	}


	//Load the source file
	System.out.println("Loading input file....");
	Document document = new Document(filePathString);
	System.out.println("File load complete.....");


	/*Check if the user supplied the final destination of the output file.
	 * If they didn't, use the file name of the input file and set the destination to the users Desktop
	 * Note: If a file with the same name already exists, the file gets overwritten*/
	System.out.println("Determining output file destination");
	if (args.length <= 1) {
	  System.out.println("User didnt set output file destination...");
	  destinationFilePath = getOutputFileName(filePathString);
	  System.out.println("Proceeding to save file on users desktop..." + destinationFilePath);
	} else {
	  destinationFilePath = args[1];
	  System.out.println("Proceeding to save file on..." + destinationFilePath);
	}


	//Save output file
	System.out.println("Converting PDF and writing output......");
	document.save(destinationFilePath, SaveFormat.DocX);
	System.out.println("Conversion done!");
  }

  static boolean isValidPdfFilePath(String filePathString) {
	String[] splitFilePathString = filePathString.split("/");
	System.out.println("Filename is: " + splitFilePathString[splitFilePathString.length -1]);
	String fileNameWithExtension = splitFilePathString[splitFilePathString.length - 1];
	String[] splitFileNameAndExtension = fileNameWithExtension.split("\\.");
	String fileExtension = splitFileNameAndExtension[splitFileNameAndExtension.length - 1];
	return fileExtension.equalsIgnoreCase("pdf");
  }

  static String getOutputFileName(String filePathString){
	String[] splitFilePathString = filePathString.split("/");
	String fileNameWithExtension = splitFilePathString[splitFilePathString.length - 1];
	String[] splitFileNameAndExtension = fileNameWithExtension.split("\\.");
	String fileName = splitFileNameAndExtension[0];
	String userHomeDir = System.getProperty("user.home");
	return userHomeDir + "/Desktop/" + fileName + ".docx";
  }
}
