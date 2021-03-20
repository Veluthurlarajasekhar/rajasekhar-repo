import java.util.*;  
import java.io.*;
public class Main{
        public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                HashMap<Integer, String> hm = new HashMap<Integer, String>();
                try{
                        File file = new File("input.txt"); 
                        BufferedReader br = new BufferedReader(new FileReader(file)); 
                        String st;
                        try{ 
                                while ((st = br.readLine()) != null) {
                                        String[] str = st.split(":");
                                        if(str.length != 1){
                                                int a = Integer.parseInt(str[1].substring(1));
                                                hm.put(a, str[0]);
                                        }
                                }
                        }catch(IOException e){System.out.println("Exception 1");}
                }catch(FileNotFoundException e){System.out.println("Exception");}
              //  System.out.println(hm);
                System.out.print("Number of the Employees:");
                int num = s.nextInt();
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int a : hm.keySet()){
                        al.add(a);
                }
                Collections.sort(al);
                //System.out.println(al);
                int min = -1, max = -1;
                int mindiff = 9999999;
                for(int i = 0;i < 10;i++){
                        int j = i + num - 1;
                        if(j >= 10)
                                break;
                        int diff = al.get(j) - al.get(i);
                        //System.out.println(diff);
                        if(diff <= mindiff){
                               
                                mindiff = diff;
                                min = i;
                                max = j;
                                //System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:",mindiff);
                        }
                }
                //System.out.println(min+" "+max);
                ArrayList<Integer> al2 = new ArrayList<Integer>();
                for(int i = min;i <= max;i++){
                        al2.add(al.get(i));
                }
                Integer[] array = new Integer[al2.size()]; 
                array = al2.toArray(array); 
                try{
                        PrintWriter out = new PrintWriter("output.txt");
                        out.println("Here the goodies that are selected for distirbution are :");
                        for(int i = 0;i < array.length;i++){
                                out.println(hm.get(array[i])+":"+array[i]);
                               
                                
                        }
                        out.println("And the difference between the chosen goodies with highest price and the lowest price is : "+mindiff);
                        out.close();
                }catch(FileNotFoundException e){System.out.println(e);}
        }
}