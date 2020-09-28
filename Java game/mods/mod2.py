from java.awt import Font
from java.awt import Graphics2D, Rectangle, Color

from org.python.core import PyObject
from src.game.main import Handler, Game, API
from src.game.main.Game import STATE
from src.game.main.gameobject import GameObject
from src.game.main.launch import Launcher
from src.game.util import ID, KeyInput, Utils
from java.awt import Graphics2D

modid = "mod2"
version = "1.2"
displayName = "EXAMPLEMOD 2"
enemy = None

def init_mod2(handler):
    ':type handler: Handler'
    global enemy
    enemy = Enemy(20,20,ID.BasicEnemy)
    handler.add(enemy)
    
def tick_mod2():
    enemy.tick()
   
def render_mod2(g):
    ':type g: Graphics2D'
    enemy.render(g)

class Enemy(GameObject):
    
    image = None
    
    def __init__(self,x,y,id):
        super(Enemy, self).__init__(x,y,id)
        global image
        image = API.getImage("creeper.png")

        
    def tick(self):
        super(Enemy, self).tick()
        
    def render(self,g):
        ':type g: Graphics2D'
        g.drawImage(self.x, self.y, self.image, None)
        
    
