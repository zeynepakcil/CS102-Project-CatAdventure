
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.demo.TuruncsAdventure;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1200, 610);
		config.setForegroundFPS(60);
		config.setTitle("Turunc's Adventure");
		config.setResizable(false);
		config.setWindowIcon("assets/WindowIcon.png");
		new Lwjgl3Application(new TuruncsAdventure(), config);
	}
}
