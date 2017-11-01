
import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class Node {
    private String value;
    private int valueHeuristicFunction;

    public Node(String value,int valueFunctionHeuristic) {
        this.value = value;
        this.valueHeuristicFunction = valueFunctionHeuristic;       
    }
    
    public Node(String value) {
        this.value = value;
        this.valueHeuristicFunction = 0;
    }
    
    public int compareValueFunctionHeuristicBF(Node bestFirstNode){
        return bestFirstNode.getValueHeuristicFunction() - getValueHeuristicFunction(); 
    }
    
    public int compareValueFunctionHeuristicAS(int costNode,Node nextNode, int costNextNode){
        System.out.print(" F(X) = " + nextNode.getValueHeuristicFunction() + " // ");
        return (nextNode.getValueHeuristicFunction() + costNextNode) - (getValueHeuristicFunction()+ costNode); 
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public int getValueHeuristicFunction() {
        return valueHeuristicFunction;
    }

    public void setValueHeuristicFunction(int valueHeuristicFunction) {
        this.valueHeuristicFunction = valueHeuristicFunction;
    }     

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final Node other = (Node) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }           
}
