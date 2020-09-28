package src.game.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import src.game.util.HighscoreManager.Highscore;

public class HighscoreManager{
	
	private static ArrayList<Highscore> highscores;
	
	
	public static void load() {
		File f = new File("highscores.dll");
		if(!f.isFile() || !f.exists()) {
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			highscores = new ArrayList<Highscore>();
		}
		else {
			try {
				if(f.length() > 0) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					highscores = (ArrayList<Highscore>) ois.readObject();
					ois.close();
				}
				else {
					highscores = new ArrayList<Highscore>();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				f.delete();
				load();
			}
		}
	}
	
	public static void save() {
		File f = new File("highscores.dll");
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(highscores);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void add(Highscore h) {
		highscores.add(h);
	}
	static public void remove(Highscore h) {
		highscores.remove(h);
	}
	
	
	public static class Highscore implements java.io.Serializable{

		private int score;
		private int level;
		private String name;
		
		public Highscore(int level,int score,String name) {
			while(score >= 600) {
				level++;
				score-=600;
			}
			this.score = score;
			this.level = level;
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		


	}
	public static ArrayList<Highscore> highscores() {
		return highscores;
	}
}
