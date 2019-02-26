package com.itheo.knights.traverse;

import java.util.*;
import java.util.stream.Collectors;

public class DepthFirstSearch <P extends PathNode> {

    public List<P> getNDepthReachingPaths(P rootNode, P targetNode, int depth) {
        return getNDepthSuccessors(rootNode, depth).stream()
                .filter(pNode -> pNode.getCurrent().equals(targetNode.getCurrent()))
                .collect(Collectors.toList());
    }

    public List<P> getNDepthSuccessors(P rootNode, int depth) {
        List<P> nDepthNodes = new LinkedList<>();
        Stack<P> stack = new Stack<>();
        stack.push(rootNode);
        Map<P, Boolean> visited = new HashMap<>();

        while (!stack.empty()) {
            P node = stack.pop();

            if (visited.containsKey(node)) {
                continue;
            }
            visited.put(node, true);
            if (node.getPath().size() == depth) {
                nDepthNodes.add(node);
            } else  if (node.getPath().size() < depth){
                node.getSuccessors().forEach(succNode -> stack.push((P) succNode));
            }
        }
        return nDepthNodes;
    }
}
