import java.awt.Color;
import java.awt.EventQueue;
import java.io.InputStream;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import gfx.Window;
import tools.Methods;
import tools.Theme;



public class Launch extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				
				InputStream themestr = getClass().getResourceAsStream("/theme.yml");
				if(themestr!=null) {
					Yaml yaml = new Yaml();
					Map<String,Object> values = (Map<String, Object>) yaml.load(themestr);
					JSONObject json = new JSONObject(values);
					Theme theme = new Theme();
					try {
						theme.bg = new Color(json.getJSONObject("background").getInt("red"),json.getJSONObject("background").getInt("green"),json.getJSONObject("background").getInt("blue"));
						theme.editorBg = new Color(json.getJSONObject("editor-background").getInt("red"),json.getJSONObject("editor-background").getInt("green"),json.getJSONObject("editor-background").getInt("blue"));
						theme.buttonBg = new Color(json.getJSONObject("button").getJSONObject("background").getInt("red"),json.getJSONObject("button").getJSONObject("background").getInt("green"),json.getJSONObject("button").getJSONObject("background").getInt("blue"));
						theme.buttonTxt = new Color(json.getJSONObject("button").getJSONObject("text").getInt("red"),json.getJSONObject("button").getJSONObject("text").getInt("green"),json.getJSONObject("button").getJSONObject("text").getInt("blue"));
						theme.labelFg = new Color(json.getJSONObject("label-foreground").getInt("red"),json.getJSONObject("label-foreground").getInt("green"),json.getJSONObject("label-foreground").getInt("blue"));
						Methods.setTheme(theme);
					}catch(JSONException je) {
						JOptionPane.showMessageDialog(null, "Invalid theme file. Ignoring it", "ERROR", 0);
						je.printStackTrace();
					}
					
				}
	
				Window w = new Window();
				
			}
		});
	
	}
	private Launch(){}
}
