package com.dimipet.jung.simple;

import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;


public class App {
	public static void main(String[] args) {
		
		 Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
	        //Vertexes
	        g.addVertex((Integer) 1);
	        g.addVertex((Integer) 2);
	        g.addVertex((Integer) 3);
	        //Edges
	        g.addEdge("12", 1, 2, EdgeType.UNDIRECTED);
	        g.addEdge("12b", 1, 2, EdgeType.UNDIRECTED);
	        g.addEdge("23", 2, 3, EdgeType.DIRECTED);
	        g.addEdge("32", 3, 2, EdgeType.DIRECTED);
	        g.addEdge("31", 3, 1, EdgeType.UNDIRECTED);
	        g.addEdge("13", 1, 3, EdgeType.DIRECTED);

	        System.out.println("SparseMultigraph G<V,E> \n" + g.toString() + "\n");

	        System.out.println("");
	        System.out.println("\t\tisPredecessor(V1, V2)\tisSuccessor(V1, V2)\tisNeighbor(V1, V2)\tgetEdgeType(V1V2)\tfindEdge(V1, V2)\tfindEdgeSet(V1,V2).size()\tg.findEdgeSet(1, 1)");

	        System.out.println("(1,1)\t\t" + g.isPredecessor(1, 1) + "\t\t\t" + g.isSuccessor(1, 1) + "\t\t\t" + g.isNeighbor(1, 1) + "\t\t\t" + g.getEdgeType("11") + "\t\t" + g.findEdge(1, 1) + "\t\t\t" + g.findEdgeSet(1, 1).size() + "\t\t\t" + g.findEdgeSet(1, 1));
	        System.out.println("(1,2)\t\t" + g.isPredecessor(1, 2) + "\t\t\t" + g.isSuccessor(1, 2) + "\t\t\t" + g.isNeighbor(1, 2) + "\t\t\t" + g.getEdgeType("12") + "\t\t" + g.findEdge(1, 2) + "\t\t\t" + g.findEdgeSet(1, 2).size() + "\t\t\t" + g.findEdgeSet(1, 2));
	        System.out.println("(1,3)\t\t" + g.isPredecessor(1, 3) + "\t\t\t" + g.isSuccessor(1, 3) + "\t\t\t" + g.isNeighbor(1, 3) + "\t\t\t" + g.getEdgeType("13") + "\t\t" + g.findEdge(1, 3) + "\t\t\t" + g.findEdgeSet(1, 3).size() + "\t\t\t" + g.findEdgeSet(1, 3));

	        System.out.println("(2,1)\t\t" + g.isPredecessor(2, 1) + "\t\t\t" + g.isSuccessor(2, 1) + "\t\t\t" + g.isNeighbor(2, 1) + "\t\t\t" + g.getEdgeType("21") + "\t\t" + g.findEdge(2, 1) + "\t\t\t" + g.findEdgeSet(2, 1).size() + "\t\t\t" + g.findEdgeSet(2, 1));
	        System.out.println("(2,2)\t\t" + g.isPredecessor(2, 2) + "\t\t\t" + g.isSuccessor(2, 2) + "\t\t\t" + g.isNeighbor(2, 2) + "\t\t\t" + g.getEdgeType("22") + "\t\t" + g.findEdge(2, 2) + "\t\t\t" + g.findEdgeSet(2, 2).size() + "\t\t\t" + g.findEdgeSet(2, 2));
	        System.out.println("(2,3)\t\t" + g.isPredecessor(2, 3) + "\t\t\t" + g.isSuccessor(2, 3) + "\t\t\t" + g.isNeighbor(2, 3) + "\t\t\t" + g.getEdgeType("23") + "\t\t" + g.findEdge(2, 3) + "\t\t\t" + g.findEdgeSet(2, 3).size() + "\t\t\t" + g.findEdgeSet(2, 3));

	        System.out.println("(3,1)\t\t" + g.isPredecessor(3, 1) + "\t\t\t" + g.isSuccessor(3, 1) + "\t\t\t" + g.isNeighbor(3, 1) + "\t\t\t" + g.getEdgeType("31") + "\t\t" + g.findEdge(3, 1) + "\t\t\t" + g.findEdgeSet(3, 1).size() + "\t\t\t");
	        System.out.println("(3,2)\t\t" + g.isPredecessor(3, 2) + "\t\t\t" + g.isSuccessor(3, 2) + "\t\t\t" + g.isNeighbor(3, 2) + "\t\t\t" + g.getEdgeType("32") + "\t\t" + g.findEdge(3, 2) + "\t\t\t" + g.findEdgeSet(3, 2).size() + "\t\t\t");
	        System.out.println("(3,3)\t\t" + g.isPredecessor(3, 3) + "\t\t\t" + g.isSuccessor(3, 3) + "\t\t\t" + g.isNeighbor(3, 3) + "\t\t\t" + g.getEdgeType("33") + "\t\t" + g.findEdge(3, 3) + "\t\t\t" + g.findEdgeSet(3, 3).size() + "\t\t\t");
	        System.out.println("---");
	        System.out.println("getInEdges(V1).size()" + g.getInEdges(1).size() + "\tgetInEdges(V1)" + g.getInEdges(1));
	        System.out.println("getInEdges(V2).size()" + g.getInEdges(2).size() + "\tgetInEdges(V2)" + g.getInEdges(2));
	        System.out.println("getInEdges(V3).size()" + g.getInEdges(3).size() + "\tgetInEdges(V3)" + g.getInEdges(3));


	        // The Layout<V, E> is parameterized by the vertex and edge types
	        Layout<Integer, String> layout = new CircleLayout(g);
	        layout.setSize(new Dimension(300,300)); // sets the initial size of the layout space
	        // The BasicVisualizationServer<V,E> is parameterized by the vertex and edge types
	        BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
	        vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

	        JFrame frame = new JFrame("Simple Graph View");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(vv);
	        frame.pack();
	        frame.setVisible(true);


	        Graph<Integer, Integer> ug = new SparseGraph<Integer, Integer>();


	        // Note that we can use the same nodes and edges in two different graphs.
	        Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
	        g2.addVertex((Integer) 1);
	        g2.addVertex((Integer) 2);
	        g2.addVertex((Integer) 3);
	        g2.addEdge("Edge-A", 1, 3);
	        g2.addEdge("Edge-B", 2, 3, EdgeType.DIRECTED);
	        g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
	        g2.addEdge("Edge-P", 2, 3); // A parallel edge
	        System.out.println("The graph g2 = " + g2.toString());
		
		
	}
}
