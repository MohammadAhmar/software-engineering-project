import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class main {
	
static BufferedWriter bufferWrite;

	public static void main(String args[]) throws FileNotFoundException, IOException {
		

		gui g = new gui();
		g.setVisible(true);

		phase1 table = new phase1();
		phase1.myHashtable();
		
		//start of phase2 complete
		
		String inputFile = args[0]; // input file that will be used //
		String outputFile = args[1]; // output file info to be stored //
		FileWriter fileWrite = null; // FileWriter object
		try { // check if file exists otherwise thrws excepetion
			fileWrite = new FileWriter(new File(outputFile), true); // set to
																	// true to
																	// allow
																	// addition
																	// of info
																	// to
																	// outputfile
																	// //
			bufferWrite = new BufferedWriter(fileWrite);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		BufferedReader bufferRead = null;
		try {
			String line; // variable for read each line of input file of url's
			bufferRead = new BufferedReader(new FileReader(inputFile));
			int cLinks = 0; // count the links/urls from input file

			while ((line = bufferRead.readLine()) != null) { // read everything
																// in file while
																// not empty
				URL link = new URL(line); // link created to get connection and
											// info about each link //
				URLConnection connect = link.openConnection(); // gets a
																// connection
																// from url //
				connect.connect();
				getinfo(connect); // geturl info
				printinfo(connect, "link " + cLinks); // prints url info //
				System.out.println("Sucess: " + connect.getURL()); // shows if
																	// the
																	// information
																	// was
																	// extracted
																	// sucessfully
																	// for each
																	// link
				cLinks++;
			}
			bufferWrite.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.exit(0);

	}
	
	public static void getinfo(URLConnection x) throws IOException {
		bufferWrite.write("Last Updated: " + new Date(x.getLastModified()));
		bufferWrite.newLine();
		bufferWrite.write("Length: " + x.getContentLength()); // gets all
																// information
																// about links
		bufferWrite.newLine();
		bufferWrite.write("To String: " + x.toString());
		bufferWrite.newLine();
		bufferWrite.write("Permission settings: " + x.getPermission()); // permission
		bufferWrite.newLine();
		bufferWrite.write(x.getURL().toExternalForm() + "= ");
		bufferWrite.newLine(); // create a new line
		bufferWrite.write("Type: " + x.getContentType());
		bufferWrite.newLine();
	}

	public static void printinfo(URLConnection x, String file) throws MalformedURLException, IOException {
		Pattern pat = Pattern.compile(".*" + getExtension(x) + ".*"); // compiles
																		// ext
																		// of
																		// link
		Matcher img = pat.matcher("([^\\s]+(\\.(?i)(jpg/jpeg/gif))$)"); // matcher
																		// created
																		// to
																		// idnetify
																		// img
																		// files
		if (img.matches()) { // if the pattern matches
			bufferWrite.write("Saved to: " + file + ".img");
			getImage(x, file + ".jpg"); // method to save image in a file
		} else { // if not do this
			bufferWrite.write("Saved to: " + file + ".txt , Lines:" + write(x, file + ".txt")); // write
																								// stored
																								// content
																								// in
																								// file
		}
		bufferWrite.newLine();
	}

	public static int write(URLConnection x, String file) {
		try {
			File f = new File(file); // create a file
			BufferedReader br = new BufferedReader(new InputStreamReader(x.getInputStream()));

			if (!f.exists()) { // if there is not file create 1
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			String line = "";
			int countLines = 0; // line count
			while ((line = br.readLine()) != null) { // read line up to the end
														// of url
				bw.write(line);
				bw.newLine();
				countLines++;
			}
			bw.close();
			return countLines;
		} catch (Exception e) { // no file found
			return 0;
		}
	}

	public static void getImage(URLConnection x, String file) {
		File output = new File(file); // file to store image
		BufferedImage image = null;
		try {
			image = ImageIO.read(x.getURL());
			ImageIO.write(image, "jpg", output); // write image to file
		} catch (IOException e) {
		}
	}

	public static String getExtension(URLConnection x) {
		String link = x.getURL().toExternalForm(); // string version of link
		int last = link.lastIndexOf(".");
		if (last >= 0) {
			return link.substring(last); // gets link type html/img
		}
		return null;
		
	}
	
	// end of phase 2
		
	} //end of main


