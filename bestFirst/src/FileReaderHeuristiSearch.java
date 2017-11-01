
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class FileReaderHeuristiSearch {
    private String FILE_NAME_NODES;
    private ArrayListHeuristicSearch readNode;
    private int[][] costMatrix;
    private boolean[][] adjacencyMatrix;

    public FileReaderHeuristiSearch(String FILE_NAME_NODES) {
        this.FILE_NAME_NODES = FILE_NAME_NODES;
        this.readNode = new ArrayListHeuristicSearch();
    }   
    
    public void createData() throws IOException{
        getNodesFile();
        createAdjacencyMatrixFile();
        createCostMatrixFile();
    }
    
    private ArrayList<String[]> extractDataFromFile(String FILE_NAME) throws IOException {
        String line;
        BufferedReader in = null;
        int i = 0;
        ArrayList<String[]> informationMatriz = new ArrayList<>();
        
        System.out.println("Obtendo arquivo local em " + FILE_NAME);
        try {
            in = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = in.readLine()) != null) {
                String lineData[] = line.split("\t");
                informationMatriz.add(lineData);
                i++;
            }
        } catch (IOException e) {
            System.err.println("Não foi possível acessar o arquivo.");
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return informationMatriz;                
    }
    
    public ArrayListHeuristicSearch getNodesFile() throws IOException{
        ArrayListHeuristicSearch nodes        = new ArrayListHeuristicSearch();    
        ArrayList<String[]> informationMatrix = extractDataFromFile(FILE_NAME_NODES);
        Random random;
           
        System.out.println("==================== VALOR FUNCÃO HEURISTICA ====================");
        for(int i = 0; i < informationMatrix.size();i++){
            random = new Random();
            String[] infoNode = informationMatrix.get(i);
            Node node = new Node(infoNode[0], random.nextInt(50) % 1570);
            nodes.add(node);
            System.out.println("NODE " + i + " = " + node.getValueHeuristicFunction());
        }  
        
        setReadNode(nodes);
        return nodes;
    }
    
    public int[][] createCostMatrixFile() throws IOException{
        int[][] costMatrix = new int[this.readNode.size()][this.readNode.size()];
        Random random = new Random();    
        System.out.println("==================== MATRIZ DE CUSTOS =========================");
        
        for(int i = 0; i < this.readNode.size(); i++){
            for(int j = 0; j < this.readNode.size(); j++){
                if(adjacencyMatrix[i][j] == true){
                    costMatrix[i][j] = random.nextInt(50);
                }else{
                    costMatrix[i][j] = 0;
                }
                System.out.print(""+costMatrix[i][j] + " ");
            }   
            System.out.println("");
        }
        this.costMatrix = costMatrix;
        return costMatrix;
    }
    
    public boolean[][] createAdjacencyMatrixFile() throws IOException{
        boolean[][] adjacencyMatrix = new boolean[this.readNode.size()][this.readNode.size()];
        Random random = new Random();    
        
        System.out.println("==================== MATRIZ DE ADJACÊNCIA =======================");
        for(int i = 0; i < this.readNode.size(); i++){            
            for(int j = 0; j < this.readNode.size(); j++){                    
                    adjacencyMatrix[i][j] = (random.nextInt(2) == 1)?true:false;
                    if(i == j){
                        adjacencyMatrix[i][j] = false;
                    }
                    System.out.print(""+adjacencyMatrix[i][j]+ " ");
            }   
            System.out.println("");
        }
        this.adjacencyMatrix = adjacencyMatrix;
        return adjacencyMatrix;
    }

    public ArrayListHeuristicSearch getReadNodes() {
        return readNode;
    }

    public void setReadNode(ArrayListHeuristicSearch readNode) {
        this.readNode = readNode;
    }

    public int[][] getCostMatrix() {
        return costMatrix;
    }

    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(boolean[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    
    
    
    public static void main(String[] args) throws IOException{
        FileReaderHeuristiSearch fileReaderHeuristiSearch = new FileReaderHeuristiSearch("dados.txt");
        fileReaderHeuristiSearch.createData();
        ArrayListHeuristicSearch arrayListHeuristicSearch = fileReaderHeuristiSearch.getReadNodes();        
        for(Node node : arrayListHeuristicSearch){
            System.out.println(""+node.getValue() + " "+node.getValueHeuristicFunction());
        }             
    }
}
