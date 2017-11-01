
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
public class HeuristicSearchBF extends HeuristicSearch{
    public HeuristicSearchBF(int indexBeginState, int indexFinalState, FileReaderHeuristiSearch frhs) throws IOException {
        super(indexBeginState, indexFinalState, frhs);
    }      
    
    public void runAlgorithm() {       
        int actualState = this.indexBeginState;
        System.out.println("==================== RESULTADO DO ALGORITMO BEST FIRST =======================");
        while (actualState != getIndexFinalState()) {
            this.closedNodes.add(this.nodes.get(actualState));
            this.openNodes = updateOpenNodes(actualState);
            int newState = 0;
            if (openNodes.size() == 0) {
                try {
                    actualState = this.closedNodes.getLastVisit(this.nodes.get(actualState));
                     continue;
                } catch (StateNotFoundException ex) {
                    System.out.println("STATE NOT FOUND");
                }
            } else {
                newState = getNextState(actualState);
                this.algorithmCost += this.costMatriz[actualState][newState];
            }
            actualState = newState;
            System.out.println("LISTA OPEN: " + openNodes.toString(nodes));
            System.out.println("NODE: " + actualState + " COST: " + this.algorithmCost);
        }
    }
    
    public ArrayListHeuristicSearch updateOpenNodes(int indexNode) {        
        this.openNodes = new ArrayListHeuristicSearch();
        for (int i = 0; i < nodes.size(); i++) {
            if (this.adjacencyMatrix[indexNode][i]) {
                this.openNodes.add(nodes.get(i));
            }
        } 
        Node node = this.nodes.get(indexNode);
        this.openNodes.remove(node);
        this.openNodes.removeAll(this.closedNodes);

        return this.openNodes;
    }
    
    public int getNextState(int actualState){       
        Node nodeSmallest = openNodes.getNodeSmallestBF();                
        return this.nodes.indexOf(nodeSmallest);
    }
}
