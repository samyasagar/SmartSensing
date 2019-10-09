/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfeapp;

/**
 *
 * @author ASUS
 */
public class Plan {
    private String SmartSensor;
    private String Algorithm;
    private String Executionplan[];
public Plan (){}
public Plan (String SmartSensor,String Algorithm) {
    this.SmartSensor=SmartSensor;
    this.Algorithm=Algorithm;
    this.Executionplan = new String[10];
}

public void  snipet (String snip, int num){
    Executionplan[num]=snip;
}
public void  affichetab (){
    for (int i=0; i<Executionplan.length;i++)
        System.out.println(Executionplan[i]);
}
public void affiche (){
    System.out.println(SmartSensor+"&"+Algorithm);
    System.out.println("tab");
    for (int i=0; i<Executionplan.length;i++)
        System.out.println(Executionplan[i]);
}

public String getSmartSensor(){
    return SmartSensor;
}
public String getAlgorithm(){
    return Algorithm;
}
public String[] getExecutionplan(){
    return Executionplan;
}
public void setAlgorithm(String Algorithm){
    this.Algorithm=Algorithm;
}
public void setSmartSensor(String SmartSensor){
    this.SmartSensor=SmartSensor;
}
public void setExecutionplan(String Executionplan[]){
    this.Executionplan=Executionplan;
}
}

