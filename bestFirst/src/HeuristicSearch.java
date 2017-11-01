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
public abstract class HeuristicSearch {

    protected int indexBeginState;
    protected int indexFinalState;
    protected ArrayListHeuristicSearch nodes;
    protected boolean[][] adjacencyMatrix;
    protected int[][] costMatriz;
    protected ArrayListHeuristicSearch closedNodes;
    protected ArrayListHeuristicSearch openNodes;
    protected int algorithmCost = 0;

    public HeuristicSearch(int indexBeginState, int indexFinalState, FileReaderHeuristiSearch frhs) throws IOException {
        this.indexBeginState = indexBeginState;
        this.indexFinalState = indexFinalState;
        this.nodes           = frhs.getReadNodes();
        this.adjacencyMatrix = frhs.getAdjacencyMatrix();
        this.costMatriz      = frhs.getCostMatrix();
        this.closedNodes     = new ArrayListHeuristicSearch();
        this.openNodes       = new ArrayListHeuristicSearch();
    }

    public abstract int getNextState(int actualState);
    public abstract void runAlgorithm();     
    public abstract ArrayListHeuristicSearch updateOpenNodes(int indexNode);

    public void addNode(Node bestFirstNode) {
        if (!nodes.contains(bestFirstNode)) {
            nodes.add(bestFirstNode);
        }
    }

    public ArrayListHeuristicSearch getClosedNodes() {
        return closedNodes;
    }

    public void setClosedNodes(ArrayListHeuristicSearch closedNodes) {
        this.closedNodes = closedNodes;
    }

    public int getAlgorithmCost() {
        return algorithmCost;
    }

    public void setAlgorithmCost(int algorithmCost) {
        this.algorithmCost = algorithmCost;
    }

    public int getIndexBeginState() {
        return indexBeginState;
    }

    public void setIndexBeginState(int indexBeginState) {
        this.indexBeginState = indexBeginState;
    }

    public int getIndexFinalState() {
        return indexFinalState;
    }

    public void setIndexFinalState(int indexFinalState) {
        this.indexFinalState = indexFinalState;
    }

    public ArrayListHeuristicSearch getNodes() {
        return nodes;
    }

    public void setNodes(ArrayListHeuristicSearch nodes) {
        this.nodes = nodes;
    }

    public boolean[][] getAdjacencyMatriz() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatriz(boolean[][] adjacencyMatriz) {
        this.adjacencyMatrix = adjacencyMatriz;
    }

    public int[][] getCostMatriz() {
        return costMatriz;
    }

    public void setCostMatriz(int[][] costMatriz) {
        this.costMatriz = costMatriz;
    }

    public static void main(String[] args) throws IOException {
        FileReaderHeuristiSearch fileReaderHeuristiSearch = new FileReaderHeuristiSearch("dados.txt");
        fileReaderHeuristiSearch.createData();

        HeuristicSearch heuristicSearch = new HeuristicSearchBF(2, 14, fileReaderHeuristiSearch);
        heuristicSearch.runAlgorithm();
        heuristicSearch = new HeuristicSearchAS(2, 14, fileReaderHeuristiSearch);;
        heuristicSearch.runAlgorithm();      
    }
}
