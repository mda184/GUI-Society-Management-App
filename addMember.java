import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class addMember {
	
	public void addMember(String society , String name){
		try {

			String content = name;

			File file = new File(society + ".txt");

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
