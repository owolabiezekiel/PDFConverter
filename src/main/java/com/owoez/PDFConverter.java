package com.owoez;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

import java.util.Locale;

import com.owoez.util.FileUtil;

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
	if (!FileUtil.isValidPdfFilePath(filePathString)){
	  System.out.println("Invalid file path. Please make sure to escape all special characters in file path");
	  return;
	}


	//Load the source file
	System.out.println("Loading input file....");
	Document document = new Document();
	try {
	  document = new Document(filePathString);
	}catch (Exception e){
	  System.out.println("Could not load file....\nPossible reason(s): File does not exist | Typo error in file name");
	  return;
	}
	System.out.println("File load complete.....");


	/*Check if the user supplied the name of the output file.
	 * If they didn't, use the file name of the input file and set the destination to the users Desktop
	 * Note: If a file with the same name already exists, the file gets overwritten*/
	System.out.println("Determining output file destination");
	if (args.length <= 1) {
	  System.out.println("User didnt set output file destination...");
	  destinationFilePath = FileUtil.getOutputFileName(filePathString);
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



}
