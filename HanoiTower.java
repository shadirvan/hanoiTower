//package towerusingstack;

import java.util.Scanner;

class LinkedList {
	int size = 0;
	
	

	Node top;

	class Node {
		int data;
		Node prevNode;

		Node(int data, Node prevNode) {
			this.data = data;
			this.prevNode = prevNode;
		}
	}

	void push(int data) {

		if (top == null) {
			top = new Node(data, top);
			size++;
			return;
		}

		Node newNode = new Node(data, top);
		top = newNode;
		size++;

	}
	int pop() {
		
			int tempData = top.data;
			top = top.prevNode;
			size--;
			return tempData;
		
		
		
	}

	void printList() {

		Node tempTop = top;
		while (tempTop != null) {

			System.out.print(tempTop.data + "-->");
			tempTop = tempTop.prevNode;

		}
		System.out.println("End of Stack!");
	}
	

	int currentNoOfDisks() {
		
		return size;
	}
	
	boolean isEmpty() {
		if(top==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean isSolved (LinkedList t1, LinkedList t2){
		
		if(t1.top == null && t2.top == null && top.data == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	boolean isPushableTo(LinkedList tower) {
		if(top != null) {
			if(tower.top == null || top.data < tower.top.data) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

public class HanoiTower {
	
static void printTowers(LinkedList t1, LinkedList t2, LinkedList t3) {
		
		
		t1.printList();
		t2.printList();
		t3.printList();
	}
	
	public static void main(String args[]) {
		
		int step = 1;

		LinkedList tower1 = new LinkedList();
		LinkedList tower2 = new LinkedList();
		LinkedList tower3 = new LinkedList();

//		list.printList();
		System.out.println("Enter the number of disk: ");
		Scanner sc = new Scanner(System.in);
		int disks = sc.nextInt();
		
		sc.close();

		for (int i = disks; i >= 1; i--) {
			tower1.push(i);
		}
		
		LinkedList currentTower = tower1;
		LinkedList evenToTower;
		LinkedList oddToTower;
		
		System.out.println("Current Tower: ");
		printTowers(tower1, tower2, tower3);
		System.out.println("**********************\n");
		System.out.println("Solving.....\n");
		
		while(!tower3.isSolved(tower1, tower2)) {
			
			
			
			if(currentTower == tower1)
			{
				evenToTower = tower2;
				oddToTower = tower3;
			}
			else if (currentTower == tower2) {
				evenToTower = tower1;
				oddToTower = tower3;
			}
			else {
				evenToTower = tower1;
				oddToTower = tower2;
			}
			
			while(currentTower.isPushableTo(oddToTower) || currentTower.isPushableTo(evenToTower) ) {
				
				System.out.println("Step " + step);
				System.out.println("++++++");
				
				
				if(currentTower.size % 2 == 0) {
					step++;
					evenToTower.push(currentTower.pop());
					printTowers(tower1, tower2, tower3);
					System.out.println("----------------------------");
				}
				else {
					step++;
					oddToTower.push(currentTower.pop());
					printTowers(tower1, tower2, tower3);
					System.out.println("----------------------------");
				}
			}
			if(currentTower.isEmpty() || currentTower.size % 2 ==0) {
				currentTower = evenToTower;
			}
			else {
				currentTower = oddToTower;
			}

	}
	
		System.out.println("Hanoi Tower Solved !");
}
}
