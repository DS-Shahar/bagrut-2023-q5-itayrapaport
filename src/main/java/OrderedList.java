
public class OrderedList {
	private Node<NumCount> lst;

	public void insertNum(int x) {
	Node<NumCount> p= lst;
	Node<NumCount> next= p.getNext();
	if(p==null) {
		NumCount new_in= new NumCount(x,1);
		lst= new Node<NumCount>(new_in);
		return;
	}
	if(x<p.getValue().getNum()) {
		NumCount new_in= new NumCount(x,1);
		Node<NumCount> new_node= new Node<>(new_in);
		new_node.setNext(p.getNext());
		p.setNext(new_node);
		return;
	}
	while(next!=null) {
		if(x==p.getValue().getNum()) {
			p.getValue().setCount(p.getValue().getCount()+1);
			return;
		}
		if(x>p.getValue().getNum() && x<next.getValue().getNum()) {
			NumCount new_in= new NumCount(x,1);
			Node<NumCount> new_node= new Node<>(new_in);
			new_node.setNext(next);
			p.setNext(new_node);
			return;
		}
		p= p.getNext();
		next= next.getNext();
	}
	if(x>p.getValue().getNum()) {
		NumCount new_in= new NumCount(x,1);
		Node<NumCount> new_node= new Node<>(new_in);
		p.setNext(new_node);
	}

	}
	public int valueN(int n) {		
		int sum= 0;
		Node<NumCount>p= lst;
		while(p!=null) {
			sum+=p.getValue().getCount();
			if(sum>=n) {
				return p.getValue().getNum();
			}
			p= p.getNext();
		}
		return -1;
	}
	public void removeNum(int x) {
		Node<NumCount> p= lst;
		Node<NumCount> next= p.getNext();
		if(x== p.getValue().getNum()) {
			if(p.getValue().getCount()==1) {
				p=next;
			}
			else {
				p.getValue().setCount(p.getValue().getCount()-1);
			}
			return;
		}
		while(next!=null) {
			if(x== next.getValue().getNum()) {
				if(next.getValue().getCount()==1) {
					p.setNext(next.getNext());
				}
				else {
					next.getValue().setCount(next.getValue().getCount()-1);
				}
				return;
			}
			p= p.getNext();
			next= next.getNext();
		}
	}
}
