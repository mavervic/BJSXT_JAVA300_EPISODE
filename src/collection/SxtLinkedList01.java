package collection;

public class SxtLinkedList01 {
	private Node first;
	private Node last;
	private int size;

	public void add(Object obj) {
		Node node = new Node(obj);
		if (first == null) {
			first = node;
			last = node;

		} else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
		size++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while (temp != null) {
			sb.append(temp.element + ",");
			temp = temp.next;

		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public Node getNode(int index) {
		Node temp = null;
		if (index <= size / 2) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for (int i = size - 1; i > index; i--) {
				temp = temp.previous;
			}
		}
		return temp;
	}
	
	public void remove(int index) {
		Node temp = getNode(index);
		if(temp!=null) {
			Node up = temp.previous;
			Node down = temp.next;
			if(up!=null) {
				up.next = down;
			}
			if(down!=null) {
				down.previous = up;
			}
			if(index == 0) {
				first = down;
			}
			if(index == size-1) {
				last = up;
			}
			size--;
		}
		
	}

	public Object get(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引值不合法" + index);
		}
		
		Node temp = getNode(index);		
		return temp!=null?temp.element:null;
	}

	public static void main(String[] args) {
		SxtLinkedList01 list = new SxtLinkedList01();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
	}

}
