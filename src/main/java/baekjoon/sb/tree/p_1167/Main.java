package baekjoon.sb.tree.p_1167;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 개수
		ArrayList<ArrayList<Node>> tree = new ArrayList<>(); 
		
		for(int i = 0; i <= V; i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for(int i = 1; i <= V; i++) {
			int VNum = sc.nextInt();
			int input = sc.nextInt();
			while(input != -1) {
				tree.get(VNum).add(new Node(input, sc.nextInt()));
				input = sc.nextInt();
			}
		}
		
		System.out.println(getDiameterOfTree(tree));
	}
	
	public static int getDiameterOfTree(ArrayList<ArrayList<Node>> tree) {
		boolean[] visited = new boolean[tree.size()+1];
		Arrays.fill(visited, false);
		
		Node node = getFartestNode(tree, visited, 1);
		
		Arrays.fill(visited, false);
		node =  getFartestNode(tree, visited, node.getV());
		
		return node.getD();
	}
	
	public static Node getFartestNode(ArrayList<ArrayList<Node>> tree, boolean[] visited, int start) {
		visited[start] = true;
		
		Node ret = new Node(0, 0);
		ArrayList<Node> list = tree.get(start);
		for(Node n : list) {
			if(!visited[n.getV()]) {
				Node tmp = getFartestNode(tree, visited, n.getV());
				
				if(ret.getD() < n.getD() + tmp.getD()) {
					ret.setV(tmp.getV());
					ret.setD(n.getD() + tmp.getD());
				}
			}
		}
		
		if(ret.getV() == 0) {
			ret.setV(start);
		}
		
		return ret;
	}
}


class Node {
	private int V; // 정점 번호
	private int D; // 정점까지의 거리
	

	public Node(int V, int D) {
		this.V = V;
		this.D = D;
	}
	
	public int getV() {
		return V;
	}
	
	public int getD() {
		return D;
	}

	public void setV(int v) {
		V = v;
	}

	public void setD(int d) {
		D = d;
	}
}