import processing.core.PApplet;

public class Sketch extends PApplet {
	
  public void settings() {
    size(400, 400);
  }

  float[] circleY = new float[50];
  float[] snowfall = new float[50];
  float[] mousePositionsX = new float[25];
  float[] mousePositionsY = new float[25];
  int speed = 2;
  int num = 25;
  int index = 0;

  public void setup() {
    background(51, 51, 51);

    for (int i = 0; i < 50; i++) {
      circleY[i] = random(height);
    }
    for (int i = 0; i < 50; i++) {
      snowfall[i] = 5;
    }
  }

  public void draw() {
	  background(51, 51, 51);
    
    for (int circleX = 0; circleX < 50; circleX++) {
      ellipse(circleX*8, circleY[circleX], 8, 8);
    }

    for (int i = 0; i < 50; i++) {
      circleY[i] += speed;
      if (circleY[i] >= 400) {
        circleY[i] = 0;
        snowfall[i] += 5;
      }
    }
    
    for (int i = 0; i < 50; i++) {
      fill(255, 255, 255);
      rect(i*8, 400-snowfall[i], 8, 400);
    }

    mousePositionsX[index] = mouseX;
    mousePositionsY[index] = mouseY;
    index = (index + 1) % num;
    for (int i = 0; i < 25; i++) {
      int pos = (index + i) % num;
      ellipse(mousePositionsX[pos], mousePositionsY[pos], i, i);
    }
  }

  public void keyPressed() {
    if (keyCode == UP) {
      speed = 3;
    }
    if (keyCode == DOWN) {
      speed = 1;
    }
  }

  public void keyReleased() {
    speed = 2;
	}
}