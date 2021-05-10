package collection;

public class Node {

	Node previous; 	// 上一節點
	Node next; 		// 下一節點
	Object element; // 元素數據

	public Node(Node previous, Node next, Object element) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = element;
	}

	public Node(Object element) {
		super();
		this.element = element;
	}

}
