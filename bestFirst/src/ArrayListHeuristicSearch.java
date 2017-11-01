
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class ArrayListHeuristicSearch extends ArrayList<Node> {
    
  public Node getNodeSmallestBF(){
      Node nodeSmallest = this.get(0);
      for(Node node: this){
          if(node.compareValueFunctionHeuristicBF(nodeSmallest) < 0){
              nodeSmallest = node;
          }
      }
      return nodeSmallest;
  }
    
  public int getLastVisit(Node nodeActualVisit) throws StateNotFoundException{
    int nextIndexNodeVisit = 0;     
    nextIndexNodeVisit = this.indexOf(nodeActualVisit) - 1;
    
    if(nextIndexNodeVisit < 0 || this.isEmpty()){
        throw new StateNotFoundException();
    }
    return nextIndexNodeVisit;
  }
  
  public ArrayListHeuristicSearch getListWithoutElemetsVisited(ArrayListHeuristicSearch arrayListBestFirst){
      ArrayListHeuristicSearch thisList = new ArrayListHeuristicSearch();
      thisList.addAll(0, this);      
      for(int i = 0; i < arrayListBestFirst.size(); i++){
          thisList.remove(arrayListBestFirst.get(i));
      }
      return thisList;
  }  
  
  public String toString(ArrayListHeuristicSearch nodes){
      String result = "";
      
      for(Node node : this){
          result += nodes.indexOf(node) + " ";
      }
      
      return result;
  }
}
