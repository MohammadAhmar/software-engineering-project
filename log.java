import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;
import java.io.IOException;

// transaction log found in src file

public class log {
	public Logger l;
	FileHandler fh;
	
	public log(String filename) throws SecurityException, IOException {
		File f = new File(filename);
		if(!f.exists()) {
			f.createNewFile();
		}
		fh = new FileHandler(filename, true);
		l = Logger.getLogger("test");
		l.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	}

}
