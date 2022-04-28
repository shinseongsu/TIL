package graph;

import java.util.*;

class Node {
    String name;
    List<Node> links;
    boolean visited;
    
    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    void link(Node node) {
        links.add(node);
    }

    void visit() {
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Main {
    public static void main(String[] args){

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;
        // BFS
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(a);
//
//        while(!queue.isEmpty()) {
//            Node n = queue.poll();
//            n.visit();
//            System.out.println(n);
//
//            if (n.equals(target)) {
//                System.out.println("Found!! " + n);
//                break;
//            }
//
//           for(Node l: n.links) {
//               if(l.isVisited()) continue;
//               if(queue.contains(l)) continue;
//               queue.offer(l);
//           }
//        }

        // dfs
        Stack<Node> stack = new Stack();
        stack.push(a);

        while(!stack.isEmpty()) {
            Node n = stack.pop();
            n.visit();
            System.out.println(n);

            if (n.equals(target)) {
                System.out.println("Found!! " + n);
                break;
            }

            for(Node l: n.links) {
                if(l.isVisited()) continue;
                if(stack.contains(l)) continue;
                stack.push(l);
            }
        }
    }
}
