package algo0808;

public class StackTest {

	public static void main(String[] args) {
		SsafyStack<Integer> st= new SsafyStack<>();
		
		System.out.println(st.isEmpty()+"/"+st.size());
		st.push(3);
		st.push(4);
		System.out.println(st.peek());
		
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.isEmpty()+"/"+st.size());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

}
