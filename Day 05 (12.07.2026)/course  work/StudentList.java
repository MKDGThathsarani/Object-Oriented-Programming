class StudentList{
	private Node first;

	public boolean add(Student student){ //Insertion order
		return addLast(student); //add(size(),data)
	}
	public boolean add(int index, Student student){
		if(index>=0 && index<=size()){
			Node n1=new Node(student);
			if(index==0){
				n1.next=first;
				first=n1;
			}else{
				int count=0;
				Node temp=first;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				n1.next=temp.next;
				temp.next=n1;
			}
			return true;
		}
		return false;
	}
	public boolean addLast(Student student){
		return add(size(),student);
	}
	public boolean addFirst(Student student){
		return add(0,student);		
	}
	public void removeLast(){
		remove(size()-1);
	}
	public void removeFirst(){
		remove(0);
	}
	public void remove(int index){
		if(!isEmpty() && index>=0 && index<size()){
			if(index==0){
				first=first.next;
			}else{
				int count=0;
				Node temp=first;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
		}
	}
	public Student get(int index){
		if(index>=0 && index<size()){
			int count=0;
			Node temp=first;
			while(count<index-1){
				count++;
				temp=temp.next;
			}
			return temp.student;
		}
		return null;
	}
	public void printList(){
		System.out.print("{");
		Node temp=first;
		while(temp!=null){
			System.out.print(temp.student+", ");
			temp=temp.next;
		}
		System.out.println(isEmpty() ?"empty]":"\b\b]");
	}
	public int size(){
		Node temp=first;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void clear(){
		first=null;
	}
	public int search(Student student){
		Node temp=first;
		int index=0;
		while(temp!=null){
			if(temp.student.equals(student)){
				return index;
			}
			index++;
			temp=temp.next;
		}
		return -1;
	}
	public Student[] toArray(){
		Student[] studentArray=new Student[size()];
		Node temp=first;
		for (int i = 0; i < studentArray.length; i++)	{
			studentArray[i]=temp.student;
			temp=temp.next;
		}
		return studentArray;
	}
	
	//------Inner classes--------------------------
	public Student search(String id){
		Node temp=first;
		while(temp!=null){
			if(temp.student.getId().equalsIgnoreCase(id)){
				return temp.student;
			}
		}
		return null;
	}
	class Node{
		private Student student;
		private Node next;
		Node(Student student){this.student=student;}
	}
}


