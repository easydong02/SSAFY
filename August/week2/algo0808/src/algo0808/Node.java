package algo0808;

public class Node<T> {
	public T data;
	public Node<T> link;
	
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link= link;
	}

	public Node(T data) {
		super();
		this.data = data;
	}
	
	
	
}
