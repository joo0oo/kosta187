import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String>();
		list.add("박소연");
		list.add("김홍기");
		list.add("류세은");
		//이제 String전용 List가 됨
		
		Iterator<String> it=list.iterator();
		while (it.hasNext()) {
			String name = it.next();
		}
		
		for (String string : list) { //이제 Object가 아니라 String으로 잘 나온다
			System.out.println(string);
			
		}
	}

}
