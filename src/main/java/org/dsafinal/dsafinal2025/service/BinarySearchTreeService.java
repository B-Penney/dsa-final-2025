package org.dsafinal.dsafinal2025.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BinarySearchTreeService {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public Node createBST(List<Integer> numbers) {
        Node root = null;
        for (int num : numbers) {
            root = insert(root, num);
        }
        return root;
    }

    public void inOrder(Node root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.value);
            inOrder(root.right, list);
        }
    }

    public Node buildBalancedBST(List<Integer> sorted, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(sorted.get(mid));
        node.left = buildBalancedBST(sorted, start, mid - 1);
        node.right = buildBalancedBST(sorted, mid + 1, end);
        return node;
    }

    public Node buildBalancedBST(List<Integer> sorted) {
        return buildBalancedBST(sorted, 0, sorted.size() - 1);
    }

    public Map<String, Object> treeToMap(Node node) {
        if (node == null) return null;
        Map<String, Object> map = new HashMap<>();
        map.put("value", node.value);
        map.put("left", treeToMap(node.left));
        map.put("right", treeToMap(node.right));
        return map;
    }

    public Map<String, Object> processNumbers(List<Integer> numbers) {
        Node bst = createBST(numbers);
        List<Integer> sorted = new ArrayList<>();
        inOrder(bst, sorted);
        Node balanced = buildBalancedBST(sorted);
        return treeToMap(balanced);
    }
}
