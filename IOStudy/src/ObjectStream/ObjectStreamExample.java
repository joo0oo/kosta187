package ObjectStream;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

public class ObjectStreamExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String path="example7.ser"; //serialable
		
		
		int age=20;
		double weight= 45.6;
		
		String message= "오브젝트 스트림 실습";
		Calendar today= Calendar.getInstance();
		Frame frame= new Frame("타이틀");
		frame.setSize(500,200);
		
		Account account= new Account("111-2222-3333","김말동",1111,1000);
		Vector<Account> vector=new Vector<>();
		for (int i = 0; i < 5000; i++) {
			vector.addElement(new Account(i+"-2222-3333","김김김",2222,2000));
		}
		
		ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path));
		out.writeObject(age);
		out.writeObject(weight);
		out.writeObject(message);
		out.writeObject(today);
		out.writeObject(frame);
		out.writeObject(account);
		out.writeObject(vector);
		
		if(!(account instanceof Serializable)) {
			throw new NotSerializableException();
		}
		
		
		ObjectInputStream in= new ObjectInputStream(new FileInputStream(path));
		
		
		 age=0;
		weight=0;
		message=null;
		today=null;
		frame=null;
		
		age=(Integer)in.readObject();
		weight=(Double)in.readObject();
		message=(String)in.readObject();
		today=(Calendar)in.readObject();
		frame=(Frame)in.readObject();
		account=(Account)in.readObject();
		
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		System.out.println(today);
		frame.setVisible(true);

		
		System.out.println(account);
		System.out.println(vector.size());
		
		
		
		
		out.flush();
		out.close();
	}
}
