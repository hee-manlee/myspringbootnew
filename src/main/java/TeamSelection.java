
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamSelection {
	public static void main(String[] args) throws Exception {
		String[] array = {"고예원", "권수현", "김민채", "김병욱", "노은호", "박민호", 
						  "박윤호", "박정훈", "박지겸", "서지현", "안병주", "어성준", 
						  "이정민", "정성범", "정준안", "조계연", "주영민", "김준하", 
						  "차민정", "하성민", "허지서", "이재빈", "박윤정", "이동민"};
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		for(String str : array) {
			list.add(str);
		}
		Random random = new Random();
		while(list.size()!=0) {
			int temp = random.nextInt(list.size());
			//System.out.println(temp);
			result.add(list.remove(temp));
		}
		//System.out.println(result);
		int count = 0;
		System.out.println("Start of Program!");
		Thread.sleep(2000);
		for(String name: result) {
			System.out.print(name + "\t");
			count++;
			if(count%4==0) {
				System.out.println();
				Thread.sleep(2000);
			}
		}
		System.out.println("End of Program!");
	}
}
