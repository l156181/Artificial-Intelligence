
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class HeuristicSearchAS extends HeuristicSearch {
    
    public HeuristicSearchAS(int indexBeginState, int indexFinalState, FileReaderHeuristiSearch frhs) throws IOException {
        super(indexBeginState, indexFinalState, frhs);
    }    
    @Override
    public ArrayListHeuristicSearch updateOpenNodes(int indexNode) {        
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (this.adjacencyMatrix[indexNode][i] && !this.openNodes.contains(node)) {
                this.openNodes.add(node);
            }
        }
        
        Node node = this.nodes.get(indexNode);
        this.openNodes.remove(node);
        this.openNodes.removeAll(this.closedNodes);

        return this.openNodes;
    }
    
    public int getNextState(int actualState){    
        Node nodeSmallest = getNodeSmallest(actualState);                
        return this.nodes.indexOf(nodeSmallest);
    }

    @Override
    public void runAlgorithm() {
        int actualState = this.indexBeginState;
        System.out.println("==================== RESULTADO DO ALGORITMO A* =======================");
        while (actualState != getIndexFinalState()) {
            this.closedNodes.add(this.nodes.get(actualState));
            updateOpenNodes(actualState);
            int newState = 0;
            
            newState            = getNextState(actualState);
            this.algorithmCost += this.costMatriz[actualState][newState];            
            actualState         = newState;
            
            System.out.println("NODE: " + actualState + " COST: " + this.algorithmCost);
        }
    }
    
    public Node getNodeSmallest(int actualState){
        Node nodeSmallest = this.openNodes.get(0);
        System.out.print("LISTA OPEN: ");
        for(Node node: openNodes){
            int costNode     = algorithmCost + costMatriz[actualState][nodes.indexOf(nodeSmallest)];
            int costNextNode = algorithmCost + costMatriz[actualState][nodes.indexOf(node)];
            System.out.print(nodes.indexOf(node) + " ");
            if(nodeSmallest.compareValueFunctionHeuristicAS(costNode, node, costNextNode) < 0){
                nodeSmallest = node;
            }
        }
        System.out.println("");
        return nodeSmallest;
    }
}
