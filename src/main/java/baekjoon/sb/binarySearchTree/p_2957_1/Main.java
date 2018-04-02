package baekjoon.sb.binarySearchTree.p_2957_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수열의 크기
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Tree<Integer> tree = new Tree<>(arr[0]);
		System.out.println(0);
		
		for(int i = 1; i < N; i++) {
			tree.insert(arr[i], tree.getRoot());
			System.out.println(tree.getCnt());
		}
	}

}

class Tree<T> {
	Node<T> root;
	private int cnt = 0;
	
	public Tree(T data) {
		this.root = new Node<T>(data);
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public void insert(T data, Node<T> node) {
		cnt++;
		if((Integer)data < (Integer)node.getData()) {
			if(node.getLeft() == null) {
				node.setLeft(new Node<T>(data));
			} else {
				insert(data, node.getLeft());
			}
		} else {
			if(node.getRight() == null) {
				node.setRight(new Node<T>(data));
			} else {
				insert(data, node.getRight());
			}
		}
	}
	
}

class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
}