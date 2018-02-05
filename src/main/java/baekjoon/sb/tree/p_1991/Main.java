package baekjoon.sb.tree.p_1991;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Tree<Character> tree;
		
		if(N > 0) {
			tree = new Tree<Character>('A');
		} else {
			return;
		}
		
		for(int n = 0; n < N; n++) {
			String[] input = sc.nextLine().split(" ");
			Node<Character> node = new Node<Character>();
			for(int i = 0; i < input.length; i++) {
				if(i == 0) {
					node = tree.searchNode(input[i].charAt(0), tree.getRoot());
				} else if(node != null) {
					if(i == 1) {
						node.setLeft(new Node<Character>(input[i].charAt(0)));
					} else if (i == 2) {
						node.setRight(new Node<Character>(input[i].charAt(0)));
					}
				}
			}
		}
		
		tree.preorder(tree.getRoot());
		System.out.println();
		tree.inorder(tree.getRoot());
		System.out.println();
		tree.postorder(tree.getRoot());
	}
}

class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	public Node() {
		
	}
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
	
	public Node<T> getRight() {
		return right;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
}

class Tree<T> {
	private Node<T> root;
	
	public Tree(T data) {
		this.setRoot(new Node<T>(data));
	}
	
	public void preorder(Node<T> root) {
		if(root != null && (Character)root.getData() != '.') {
			System.out.print(root.getData());
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public void inorder(Node<T> root) {
		if(root != null && (Character)root.getData() != '.') {
			inorder(root.getLeft());
			System.out.print(root.getData());
			inorder(root.getRight());
		}
	}
	
	public void postorder(Node<T> root) {
		if(root != null && (Character)root.getData() != '.') {
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData());
		}
	}
	
	public Node<T> searchNode(T data, Node<T> node) {
		if(node != null) {
			if(node.getData().equals(data)) {
				return node;
			} else {
				Node<T> findNode = searchNode(data, node.getLeft());
				if(findNode == null) {
					findNode = searchNode(data, node.getRight());
				}
				return findNode;
			}
		} else {
			return null;
		}
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
}
