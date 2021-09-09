package home.KeyChain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import home.password.Password;


public class createFile {
	private static String name = "KeyChain.txt";
	private static String home = System.getProperty("user.home");

	public File setUpFile() {
		try {

			File file = new File(getFile().getAbsolutePath());
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeFile(Password p) {
		try {
			FileWriter myWriter = new FileWriter(getFile(), true);
			if(getFile().length() == 0) {
				myWriter.write(String.format("%20s %20s %20s \r\n", "Website", "Password", "Encoding"));
			}
			myWriter.write(p.toString());
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File getFile() {
		return new File(home + File.separator + "Desktop" + File.separator + name);

	}

	public static Boolean duplicatePasword(String w) throws Exception {
		Password p = null;
		try {
			p = findPassword(w);
		} catch (FileNotFoundException e) {
			return false;
		}
		return p!=null;
	}

	public static Password findPassword(String w) throws Exception {
		File file=new File(getFile().getAbsolutePath()); 
		String[] UserToken = null;
		BufferedReader br = new BufferedReader(new FileReader(file));

		Scanner inputeFile = new Scanner(getFile());

		String website = null;
		String encryption = null;
		String password = null;

		while(inputeFile.hasNext()){
			String str = inputeFile.nextLine().trim().replaceAll(" +", " ");
			UserToken = str.split(" ");


			website = UserToken[0];
			encryption = UserToken[2];
			password = UserToken[1];


			if (website.toLowerCase().equals(w.toLowerCase())) {
				close(br, inputeFile);
				return new Password(password, website, encryption);
			}


		}
		close(br, inputeFile);
		return null;
	}

	private static void close(BufferedReader br, Scanner inputeFile) throws IOException {
		br.close();
		inputeFile.close();
	}



}


