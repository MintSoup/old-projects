package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import gfx.Editor;
import gfx.Window;

public class Methods {
	
	private static File lastfile;
	private static Theme theme;
	private static String[] cmdline = {""};
	public static void newFile(File file) throws IOException {
		InputStream in = Methods.class.getResourceAsStream("/bs/sample.bsbat");
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buffer = new byte[1024];
		int x=0;
		while((x = in.read(buffer)) > 0) {
			fos.write(buffer, 0, x);
		}
		
		setLastfile(file);
		fos.close();
		in.close();
		
	}

	public static void newEditor(File selectedFile,Window w) {
		new Editor(selectedFile,w);
		setLastfile(selectedFile);
		
	}

	public static File getLastfile() {
		return lastfile;
	}

	public static void setLastfile(File lastfile) {
		Methods.lastfile = lastfile;
	}
	public static Theme getTheme() {
		return theme;
	}
	public static void setTheme(Theme theme) {
		Methods.theme = theme;
	}

	public static String[] getCmdline() {
		return cmdline;
	}

	public static void setCmdline(String[] cmdline) {
		Methods.cmdline = cmdline;
	}
}
