package org.dsafinal.dsafinal2025.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BinarySearchTreeServiceTest {

    @Autowired
    private BinarySearchTreeService bstService;

    @Test
    public void testProcessNumbers_BalancedTree() {
        // Input list: unsorted
        List<Integer> numbers = Arrays.asList(10, 5, 15, 3, 7, 12, 18);
        Map<String, Object> treeMap = bstService.processNumbers(numbers);
        assertNotNull(treeMap);
        // For the sorted list [3, 5, 7, 10, 12, 15, 18], the balanced BST root is expected to be 10.
        assertEquals(10, treeMap.get("value"));
    }

    @Test
    public void testInOrderTraversal() {
        List<Integer> numbers = Arrays.asList(7, 3, 9, 1, 5);
        BinarySearchTreeService.Node bst = bstService.createBST(numbers);
        List<Integer> inOrder = new ArrayList<>();
        bstService.inOrder(bst, inOrder);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9);
        assertEquals(expected, inOrder);
    }
}
