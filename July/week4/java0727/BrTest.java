package java0727;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BrTest {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringBuilder sb= new StringBuilder();
		sb.append("hello");
		sb.setLength(3);
		System.out.println(sb.toString());
		
		
		
		
		
		bw.write("hello2");
		bw.flush(); //호스에 hose 물이 남아있으면 밀어준다.
		bw.close();	//out은 꼭 닫아야한다. 안닫으면 고갈 exausted된다.
	}

}
