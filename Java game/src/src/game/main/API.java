package src.game.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class API {
	private PythonInterpreter interp;
	private Handler handler;
	private ArrayList<String> modids = new ArrayList<String>();
	public API(Handler h) {
		handler = h;
		interp = new PythonInterpreter();
		File[] mods = new File("mods/").listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				
				return pathname.isFile() && pathname.getName().endsWith(".py")?true : false;
			}
			
		});
		
		for (File mod : mods) {
			FileInputStream fis;
			try {
				fis = new FileInputStream(mod);
				interp.execfile(fis);
				modids.add((String) interp.get("modid").__tojava__(String.class));
			fis.close();
			} catch (Exception e) {
				System.err.println("WTF!?!?!?");
				e.printStackTrace();
			}
		}
	}
	
	public void tick() {
		for (String s : modids) {
			interp.get("tick_"+s).__call__();
		}
	}
	
	public void render(Graphics g) {
		for (String s : modids) {
			interp.get("render_"+s).__call__(Py.java2py(g));
		}
	}
	
	public void init() {
		for (String s : modids) {
			interp.get("init_"+s).__call__(Py.java2py(handler));
		}
	}

	public void keyPressed(int keyCode) {
		for (String s : modids) {
			PyObject kp = interp.get("keyPress_"+s);
			if(kp!=null) {
				kp.__call__(Py.java2py(keyCode));
			}
		}
		
	}

	public void keyReleased(int keyCode) {
		for (String s : modids) {
			PyObject kp = interp.get("keyRelease_"+s);
			if(kp!=null) {
				kp.__call__(Py.java2py(keyCode));
			}
		}
	}
	public PyObject getImage(String name) {
		try {
			return Py.java2py(ImageIO.read(new File(new File("mods"),name)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
