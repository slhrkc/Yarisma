import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThirdQuestion {
	public static class Node {
		private int value;
		public Node leftChild;
		public Node rightChild;
		public Node parent;
		public boolean isVisited = false;
		public int floor=1;
		public boolean hasChild(){
			if(leftChild ==null){
				return false;
			}
			return true;
		}
		

		public Node(int value, int floor) {
			this.value = value;
			this.floor = floor;

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int BOUND = 30;
		Node currentNode;
		Node root;
		boolean skippedOnce = false;
		
		int nodeAdded = 0; // Floor control
		int floor =1;
		
		ArrayList<Node> visitedNodes = new ArrayList<Node>();
		ArrayList<Node> nodeArray = new ArrayList<Node>();
		ArrayList<Integer> valueArray = new ArrayList<Integer>();
		valueArray.add(99999999);
		nodeArray.add(null);

		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(new FileReader("yollar.txt"));
			while (in.hasNext()) {
				valueArray.add(in.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i < valueArray.size(); i++) {
			if(nodeAdded == floor){
				nodeAdded = 0;
				floor++;
			}
			
			nodeArray.add(new Node(valueArray.get(i).intValue(),floor));
			nodeAdded++;
		}

		for (int i = 1; i < nodeArray.size(); i++) {
			if ( nodeArray.get(i).floor + i +1 < nodeArray.size()) {
				nodeArray.get(i).leftChild = nodeArray.get(nodeArray.get(i).floor + i);
				

				nodeArray.get(i).rightChild = nodeArray.get(nodeArray.get(i).floor + i+1);

			}

		}
		
		root = nodeArray.get(1);
		
		currentNode = root;
		
		//Begin traversing
		while( currentNode.floor <= floor){
			currentNode.isVisited = true;
			
				visitedNodes.add(currentNode);
				


			
			
			if(!currentNode.hasChild()){
				floor =-1;
			}

			
			if(currentNode.hasChild()){
				if((currentNode.leftChild.value > currentNode.rightChild.value && !currentNode.leftChild.isVisited ) || currentNode.rightChild.isVisited){
					if((currentNode.leftChild.value >= BOUND) || skippedOnce){
						currentNode.leftChild.parent = currentNode ;
						currentNode = currentNode.leftChild;
					}
					else{
						skippedOnce = true;
						currentNode = currentNode.parent;
					}
				}
				
				else{
					if(currentNode.rightChild.value >= BOUND || skippedOnce){
						currentNode .rightChild.parent = currentNode ;
						currentNode = currentNode.rightChild;
					}
					else{
						skippedOnce = true;
						currentNode = currentNode.parent;
					}
				}
			}

		}
		
		BufferedOutputStream out;
		StringBuilder temp = new StringBuilder();
		try {
			out = new BufferedOutputStream(new FileOutputStream("cikti.txt"));
			for(Node n:visitedNodes){
				temp.append(n.value);
				temp.append(System.getProperty("line.separator"));
				System.out.println(n.value );
			}
			out.write(temp.toString().getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
	
		
		
		

	}

}
