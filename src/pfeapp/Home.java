/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfeapp;

import java.awt.Color;
import java.beans.XMLEncoder;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.util.FileManager;

/**
 *
 * @author ASUS
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    String capteur;
    public void setname(String a){
        name.setText(a);
    }
     public void setcapteur(String a){
        capteur=a;
    }
    
     
    public Home() {
        initComponents();
        this.setSize(362, 482);
        this.setResizable(false);
        
         //kGradientPanel1.setLayout(new BoxLayout(kGradientPanel1, BoxLayout.Y_AXIS));
        
        //remplisage des combobox
        //Combobox 1 
        String monontologie=("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\Ontologie\\Dataset.owl");
		OntModel model = ModelFactory.createOntologyModel();
		InputStream reader = FileManager.get().open(monontologie);
		if (reader == null) {
			throw new IllegalArgumentException("File: "+monontologie +"not found");}
		model.read(reader, "","RDF/XML");
                try{
                         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QueryCollectiveSport_Consult.txt"));
                         String queryString="";
                         String line;
                     while((line=br.readLine()) !=null){
                            queryString+=line+"\n";
                           }
                    br.close();
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query,model);
                ResultSet resultset = qexec.execSelect();
		while (resultset.hasNext()) {
                    QuerySolution row=(QuerySolution)resultset.next();
                    String res = row.get("sport").toString();
                   String resultat = uriobject(res);
                   jComboBox1.addItem(resultat);
		}}
                 catch(Exception e){e.getMessage();}
                
                
                 try{
                         BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QueryIndividualSport_Consult.txt"));
                         String queryString1="";
                         String line;
                     while((line=br1.readLine()) !=null){
                            queryString1+=line+"\n";
                            }
                    br1.close();
		    Query query1 = QueryFactory.create(queryString1);
		    QueryExecution qexec1 = QueryExecutionFactory.create(query1,model);
                    ResultSet resultset1 = qexec1.execSelect();
                  while (resultset1.hasNext()) {
                    QuerySolution row=(QuerySolution)resultset1.next();
                    String res = row.get("sport").toString();
                   String resultat = uriobject(res);
                   jComboBox1.addItem(resultat);
		}}
                  catch(Exception e){e.getMessage();}
           
    }
    
    public String uriobject(String a) {
      int indexslash =  a.lastIndexOf('/');
      String finalchaine = a.substring(indexslash+1,a.length());
      return finalchaine;
    }
    
     public String uriobject1(String a) {
      
      int indexfirst =  a.indexOf('^');
      System.out.println(indexfirst);
      String finalchaine = a.substring(0,indexfirst);
      return finalchaine;
    }
     
      static public Model readInferencedModelFromRuleFile(Model model, String inputRuleFile){
              //InputStream in = FileManager.get().open(inputRuleFile);
              List<Rule> rules = Rule.rulesFromURL(inputRuleFile);
              GenericRuleReasoner reasoner = new GenericRuleReasoner(rules);
              reasoner.setDerivationLogging(true);
              reasoner.setOWLTranslation(true);               // not needed in RDFS case
              reasoner.setTransitiveClosureCaching(true);
              InfModel inf = ModelFactory.createInfModel(reasoner, model);
              return inf;
     }
      
          static public String executeQueryFile(Model model, String filepath) {
        File queryFile = new File(filepath);
        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(filepath);
        if (in == null) {
            System.out.println("Query file: " + filepath + " not found");
            return null;
        } else {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                return null;
            }
        }
        //String queryString = FileTool.getContents(queryFile);
       String queryStringrule=""; 
        try {
        BufferedReader filerule = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\rules\\hardfailedrules.txt"));
        
        String line;
                     while((line=filerule.readLine()) !=null){
                            queryStringrule+=line+"\n";
                            }}
                      catch(Exception e){e.getMessage();}
        System.out.println("query = "+ queryStringrule);
        Query query = QueryFactory.create(queryStringrule);
        // No reasoning
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        return results.toString();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        kButton1 = new keeptoo.KButton();
        name = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Hello ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 30, 68, 30);

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 120, 130, 20);

        jComboBox2.setMaximumRowCount(10);
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(170, 120, 160, 20);

        kButton1.setBackground(new java.awt.Color(255, 255, 255));
        kButton1.setText("OK");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(102, 0, 204));
        kButton1.setkBorderRadius(20);
        kButton1.setkEndColor(new java.awt.Color(102, 0, 204));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 153, 153));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        kButton1.setkPressedColor(new java.awt.Color(255, 153, 153));
        kButton1.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton1.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton1.setMaximumSize(new java.awt.Dimension(67, 23));
        kButton1.setMinimumSize(new java.awt.Dimension(67, 23));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(kButton1);
        kButton1.setBounds(250, 150, 70, 30);

        name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 153, 153));
        getContentPane().add(name);
        name.setBounds(230, 30, 90, 30);

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkEndColor(new java.awt.Color(102, 0, 204));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 153, 102));
        kGradientPanel1.setOpaque(false);
        getContentPane().add(kGradientPanel1);
        kGradientPanel1.setBounds(30, 190, 300, 240);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hometemplate.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 358, 452);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        //Interfacage   
            kGradientPanel1.removeAll();
            kGradientPanel1.revalidate();
            kGradientPanel1.repaint(); 
            int hard=1;
            int soft=0;
            String sport = jComboBox1.getSelectedItem().toString();
            String ind = jComboBox2.getSelectedItem().toString();
            JLabel label = new JLabel();
            label.setForeground(Color.white);
            label.setText("Calculate " + ind + " for "+sport);
            kGradientPanel1.add(label);
            String monontologie=("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\Ontologie\\Dataset.owl");
		OntModel model = ModelFactory.createOntologyModel();
		InputStream reader = FileManager.get().open(monontologie);
		if (reader == null) {
			throw new IllegalArgumentException("File: "+monontologie +"not found");}
		model.read(reader, "","RDF/XML");
                //Selection des Preconditions 
                int i=0;
                String precondition[] = new String[6];
                try{
                BufferedReader bre = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QueryPreCondition_Consult.txt"));
                String queryStringPRC="";
                     String line;
                     while((line=bre.readLine()) !=null){
                            queryStringPRC+=line+"\n";
                            }
                     String queryStringPR = String.format(queryStringPRC, ind);
                    bre.close();
		Query queryPR = QueryFactory.create(queryStringPR);
		QueryExecution qexec2 = QueryExecutionFactory.create(queryPR,model);
                ResultSet resultset2 = qexec2.execSelect();
		while (resultset2.hasNext()) {
                    QuerySolution row=(QuerySolution)resultset2.next();
                    String res = row.get("pre").toString();
                    String resultat = uriobject(res);
                    precondition[i]=resultat;
                    i++;}         
                } 
                  catch(Exception e){e.getMessage();}
        //Sensor Property
                int j=0;
                 String property[] = new String[6]; 
                try{
                BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QuerySensorProp_Consult.txt"));
                String queryStringsensor="";
                     String line;
                     while((line=br1.readLine()) !=null){
                            queryStringsensor+=line+"\n";
                            }
                     String queryStringsensor2 = String.format(queryStringsensor, capteur);
                    br1.close();
		Query querysensor = QueryFactory.create(queryStringsensor2);
		QueryExecution qexecsensor = QueryExecutionFactory.create(querysensor,model);
                ResultSet resultsetsensor = qexecsensor.execSelect();
		while (resultsetsensor.hasNext()) {
                    QuerySolution row=(QuerySolution)resultsetsensor.next();
                    String res = row.get("prop").toString();
                   String observation = uriobject(res);
                   property[j]=observation;
                   j++;
		} }
                 catch(Exception e){e.getMessage();}
                
                //contraint hard
                int ok=0;
                int cmt=0;
                int fin=0;
                while ((fin==0)&(cmt<i))
                {for(int b=0;b<j;b++ )
                {  if (property[b].equals(precondition[cmt]))
                       ok=1 ;
                }
                if (ok!=1)
                    fin=1;
                else 
                    cmt++;
                }
                if (fin==1)
                    hard=0;
                
                 //Microcontoller memory
                 int microcontrollermemory=0;
                  try{
            BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QueryMCMemoryParameter_Consult.txt"));
            String queryStringcontroller="";
                     String line;
                     while((line=br1.readLine()) !=null){
                            queryStringcontroller+=line+"\n";
                            }
                     String queryStringcontroller2 = String.format(queryStringcontroller, capteur);
                    br1.close();
		Query querycontroller = QueryFactory.create(queryStringcontroller2);
		QueryExecution qexeccontroller = QueryExecutionFactory.create(querycontroller,model);
                ResultSet resultsetcontroller = qexeccontroller.execSelect();
		while (resultsetcontroller.hasNext()) {
                    QuerySolution row=(QuerySolution)resultsetcontroller.next();
                    String res = row.get("val").toString();
                   String memory = uriobject1(res);
                   microcontrollermemory =Integer.parseInt(memory);
		} }
                 catch(Exception e){e.getMessage();}
                   
                  //Memoire utiles pour les snippets
                  int snippetmemory=0;
                  try{
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QuerySnippetMemoryParameter_Consult.txt"));
            String querysnippetmemory="";
                     String line;
                     while((line=br2.readLine()) !=null){
                            querysnippetmemory+=line+"\n";
                            }
                     String querysnippet2 = String.format(querysnippetmemory, ind );
                    br2.close();
		Query querysnippet = QueryFactory.create(querysnippet2);
		QueryExecution qexecsnippet = QueryExecutionFactory.create(querysnippet,model);
                ResultSet resultsetsnippet = qexecsnippet.execSelect();
		while (resultsetsnippet.hasNext()) {
                    QuerySolution row=(QuerySolution)resultsetsnippet.next();
                    String res = row.get("val").toString();
                   String memory1 = uriobject1(res);
                    snippetmemory=snippetmemory+Integer.parseInt(memory1);
                   
		} }
                 catch(Exception e){e.getMessage();}
                  
                   
                  
                   if (snippetmemory<=microcontrollermemory)
                   { soft=1;}
                    System.out.println("hard= "+ hard);
                   System.out.println("soft= "+ soft);
                   if (hard==0)
                   {
                      JLabel label1 = new JLabel();
                        label1.setForeground(Color.white);
                        label1.setText("Failed : Hard is not enough.");
                        kGradientPanel1.add(label1);

                   }
                   else {
                   JLabel label1 = new JLabel();
                        label1.setForeground(Color.white);
                        label1.setText("Hard verification is completed with success..");
                        kGradientPanel1.add(label1);
                        
                        
                        
                        if (soft==0)
                            {
                      JLabel label2 = new JLabel();
                        label2.setForeground(Color.white);
                        label2.setText("Failed : Insufficient memory.");
                        kGradientPanel1.add(label2);
                        
                   }
                        else {
                          JLabel label2 = new JLabel();
                        label2.setForeground(Color.white);
                        label2.setText("Memory constraint is checked..");
                        kGradientPanel1.add(label2);
                        //label2.setText("Start your activity..");
                      //  kGradientPanel1.add(label2);
                       
                         //affichage du plan d'exécution
                        JLabel label5 = new JLabel();
                        label5.setForeground(Color.white);
                        label5.setText("                       Execution plan            ");
                        kGradientPanel1.add(label5);
                         try{
                        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QuerySequenceNumber_Consult.txt"));
                        String queryStringsnippets="";
                        String line;
                        while((line=br1.readLine()) !=null){
                            queryStringsnippets+=line+"\n";
                            }
                        String queryStringsnippets2 = String.format(queryStringsnippets, ind );
                        br1.close();
                        Query querysnippets = QueryFactory.create(queryStringsnippets2);
                        QueryExecution qexecsnippets = QueryExecutionFactory.create(querysnippets,model);
                        System.out.println("ok");
                        ResultSet resultsetsnippets = qexecsnippets.execSelect();
                        Plan plan=new Plan(capteur,ind);                 
                        while (resultsetsnippets.hasNext()) {
                        QuerySolution row=(QuerySolution)resultsetsnippets.next();
                        String sq = row.get("num").toString();
                        String  snip= row.get("snp").toString();
                        String sequence = uriobject1(sq);
                        String  snippet = uriobject(snip);
                        plan.snipet(snippet, Integer.parseInt(sequence));
                        JLabel label3 = new JLabel();
                        label3.setForeground(Color.white);
                        label3.setText("             "+sequence + "." +snippet);
                        kGradientPanel1.add(label3);  
		}
                        // rediriger les resultats vers un fichier xml
                         try{
                             try(
                                 FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\plan.xml"));
                                 XMLEncoder encoder = new XMLEncoder(fos)) {
                                 encoder.writeObject(plan);
                                         }
                         } catch(Exception ex){
                            ex.printStackTrace();
                         } }
                 catch(Exception e){e.getMessage();} 
                       
                        } }           
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // remplissage combo  2
        String monontologie=("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\Ontologie\\Dataset.owl");
		OntModel model = ModelFactory.createOntologyModel();
		//model.write(System.out);
		InputStream reader = FileManager.get().open(monontologie);
		if (reader == null) {
			throw new IllegalArgumentException("File: "+monontologie +"not found");}
		model.read(reader, "","RDF/XML");
        try{
                     String sport = jComboBox1.getSelectedItem().toString();
                         BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Samya\\Documents\\NetBeansProjects\\SamrtSensing\\src\\SPARQL_Query\\QueryIndicateurforsport_Consult.txt"));
                         String queryString21="";
                         String line;
                     while((line=br1.readLine()) !=null){
                            queryString21+=line+"\n";
                            }
                     String queryString2 = String.format(queryString21, sport);
                    br1.close();
		Query query2 = QueryFactory.create(queryString2);
		QueryExecution qexec2 = QueryExecutionFactory.create(query2,model);
                ResultSet resultset2 = qexec2.execSelect();
                 jComboBox2.removeAllItems();
		while (resultset2.hasNext()) {
                    QuerySolution row=(QuerySolution)resultset2.next();
                    String res = row.get("performanceindicator").toString();
                   String resultat = uriobject(res);
                   jComboBox2.addItem(resultat);
		}}
                  catch(Exception e){e.getMessage();}
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private keeptoo.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
