import java.util.*;
import java.io.*;
import java.lang.NullPointerException;


public class Thiseas { 

    public static void main(String args[] ) {
        StringStackImpl stack = new StringStackImpl();
        File file = null;
        String l=null;
        BufferedReader br = null;
        try{ 	
            file = new File(args[0]);
        }
        catch (NullPointerException exceptionA) {
            System.err.println("Sorry, file not found...");
        }
        try {
            br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException exceptionB) {
            System.err.println("Sorry, there is an error in opening the file...");
        }  
        try{ 
            String line;  
            int s=1; //plithos grammon apo arxh txt 
            line = br.readLine();
            String E1="0";
            String E2="0";
            String n,m;
            int nInt=0;
            int mInt=0;
            int E1Int=0;
            int E2Int=0;
            while (line != null) {
                if (s==1){
                    n=line.substring(0,1).trim();
                    m=line.substring(2,3).trim();
                    nInt=Integer.parseInt(n); //grammes pinaka se int
                    mInt=Integer.parseInt(m); //stiles pinaka se int 
                    line = br.readLine();
                    s+=1;
                }else if (s==2){
                    E1=line.substring(0,1).trim();
                    E2=line.substring(2,3).trim();
                    E2Int=Integer.parseInt(E1); //grammi poy brisketai to E
                    E2Int=Integer.parseInt(E2); //stili poy brisketai to E
                    line = br.readLine();
                    s+=1;
                }else{      
                    
                    String tharray [][] = new String [nInt][mInt];
                    
                    try{
                    for (int i=0; i<=nInt-1; i++){// ftiaxnoume ton pinaka [i,j]
                        for (int j=0; j<=mInt-1; j++){
                            tharray[s-3][j]= line.substring(2*j,(2*j)+1).trim();// pairnei to kathe stoixeio to topothetei stin antistoixi thesi pinaka
    
                        }
                        line = br.readLine();
                        s+=1;
                    }

                    
                    if (!tharray[E1Int][E2Int].equals("E")){// an i thesi ayti den einai to E 
                        System.out.println(E1Int+" "+E2Int);
                        throw new IllegalArgumentException();
                    }
                    
                    int pointeri=E1Int;//theseis E
                    int pointerj=E2Int;// theseis E
                    tharray[pointeri][pointerj]="#";
                    String pi= Integer.toString(pointeri);
                    String pj= Integer.toString(pointerj);
                    String item= pi+pj ;// ta bazo san string "03"
                    stack.push(item); //apothikeusa sintetagmenes diladi to (0,3) os string "03"
                    
                    int previous=0;
                    boolean done; //an bri adieksodo
                    boolean flag; //flag =false brisko eksodo
                    flag=true;
                    while (flag==true){
                        done=false; //an bri adieksodo false den exei mpei se kanena if 
                        boolean bges; //bges =true otan brw miden piso sto while ston elegxo
                        bges=false; //bges=true gia na min mpei sta ipoloipa if k na ksana kanei elegxous na gurisei sto while
                        if (previous!=1 && bges!=true && flag==true){ // previous mou deixnei apo poia kateythinsi irthe se ayti ti thesi 
                            pointerj++; //elegxo to dejia stoixeio
                            if (pointerj<mInt && pointerj>=0){ 
                                if (tharray[pointeri][pointerj].equals("1")){ 
                                    pointerj--; //ksana stin arxiki thesi
                                }else if (tharray[pointeri][pointerj].equals("0")){
                                    previous=3; //to previous m itan apo aristera
                                    done=true;
                                    pi= Integer.toString(pointeri);
                                    pj= Integer.toString(pointerj);
                                    item= pi+pj ;
                                    stack.push(item);
                                    if (pointerj+1>=mInt || pointeri+1>=nInt || pointerj-1<0 || pointeri-1<0 ){//elegxos na briskesai se akri
                                        tharray[pointeri][pointerj]="#";
                                        l = ("("+pointeri+","+pointerj+")");
                                        flag=false;// gia na min ksanampei sto while
                                    }else{
                                        tharray[pointeri][pointerj]="#"; 
                                        bges=true;
                                    }
                                }
                            }
                        }

                        if(previous!=2 && bges!=true && flag==true){
                            pointeri++; //elegxo to kato stoixeio
                            if (pointeri<nInt && pointeri>=0){
                                if (tharray[pointeri][pointerj].equals("1")){
                                    pointeri--;//ksana stin arxiki thesi
                                }else if (tharray[pointeri][pointerj].equals("0")){
                                    previous=4; //to previous m itan apo pano
                                    done=true;
                                    pi= Integer.toString(pointeri);
                                    pj= Integer.toString(pointerj);
                                    item= pi+pj ;
                                    stack.push(item);
                                    if (pointerj+1>=mInt || pointeri+1>=nInt || pointerj-1<0 || pointeri-1<0 ){
                                        tharray[pointeri][pointerj]="#";
                                        l = ("("+pointeri+","+pointerj+")");
                                        flag=false;
                                    }else{
                                        tharray[pointeri][pointerj]="#";
                                        bges=true;
                                    }
                                    
                                }
                            }
                        }

                        if (previous!=3 && bges!=true && flag==true){
                            pointerj--; //elegxo to aristera stoixeio
                            if (pointerj<mInt && pointerj>=0){
                                if(tharray[pointeri][pointerj].equals("1")){
                                    pointerj++;
                                }else if(tharray[pointeri][pointerj].equals("0")){
                                    previous=1; //to previous m  itan apo dejia
                                    done=true;
                                    pi= Integer.toString(pointeri);
                                    pj= Integer.toString(pointerj);
                                    item= pi+pj ;
                                    stack.push(item);
                                    if (pointerj+1>=mInt || pointeri+1>=nInt || pointerj-1<0 || pointeri-1<0 ){
                                        tharray[pointeri][pointerj]="#";
                                        l = ("("+pointeri+","+pointerj+")");
                                        flag=false;
                                    }else{
                                        tharray[pointeri][pointerj]="#"; 
                                        bges=true;
                                    }
                                }
                            }
                        }

                        if (previous!=4 && bges!=true && flag==true){
                            pointeri--; //elegxo to pano stoixeio
                            if(pointeri>=0 && pointeri<nInt){
                                if(tharray[pointeri][pointerj].equals("1")){
                                    pointeri++;
                                }else if (tharray[pointeri][pointerj].equals("0")){
                                    previous=2; //to previous m itan apo kato
                                    done=true;
                                    pi= Integer.toString(pointeri);
                                    pj= Integer.toString(pointerj);
                                    item= pi+pj ;
                                    stack.push(item);
                                    if (pointerj+1>=mInt || pointeri+1>=nInt || pointerj-1<0 || pointeri-1<0 ){
                                        tharray[pointeri][pointerj]="#";
                                        l = ("("+pointeri+","+pointerj+")");
                                        flag=false;
                                    }else{
                                        tharray[pointeri][pointerj]="#";
                                        bges=true;
                                    }

                                }
                            }                      
                        }  

                        if (done==false){ //den exei bri kanena 0 ara einai se adieksodo
                            //backtracking
                            tharray[pointeri][pointerj]="1";
                            stack.pop();
                            if (stack.isEmpty()==false){
                                pointeri=Integer.parseInt(stack.peek().substring(0,1)); //oi sintetagmenes poy proigoymenoy stoixeoy..girnao piso k ksana elegxo gia alli eksodo
                                pointerj=Integer.parseInt(stack.peek().substring(1));
                                done=true; //oxi aparaitito
                                flag=true; //oxi aparaitito
                            }else{
                                System.out.println("No way out from this maze!");
                                flag=false;
                            }
                        }

                    } //while
                }
                catch(NullPointerException e2){
                    System.out.println("Invalid input."); 
                    System.exit(0);
                }
                catch(StringIndexOutOfBoundsException e3){
                    System.out.println("Invalid input.");
                    System.exit(0);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Invalid input.");
                    System.exit(0);
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Invalid input. ");
                    System.exit(0);
                }
    

                }//if      

            }//while

            br.close();

        } //try 

        catch (IOException e1){
			System.err.println("Error Reading Text File...");
        }
       
        System.out.println(l); //ektiponei ti lisi

    }


}
