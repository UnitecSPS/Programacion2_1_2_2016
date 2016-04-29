/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Docente
 */
public class RecursionLibrary {
   
   public void printRec(int n){
       if(n > 1)
           printRec(n-1);
       System.out.println(n);
   } 
   
   public void printRec2(int x, int n){
       if(x <= n){
           System.out.println(x);
           printRec2(x+1, n);
       }
   }
   
   public int sumaUp(int n){
       if(n >= 1)
           return sumaUp(n-1)+n;
       return 0;
   }
   
   public int sumaDown(int n){
       return sumaDown(n,0);
   }
   
   private int sumaDown(int n, int suma){
       if(n >= 1)
           return sumaDown(n-1, suma+n);
       return suma;
   }
   
   public int potencia(int b, int e){
       if(e > 0)
           return b * potencia(b,e-1);
       return 1;
   }
   
   public int potDown(int b,int e){
       return potDown(b,e,1);
   }
   
   private int potDown(int b, int e, int pot){
       if( e >= 1)
           return potDown(b,e-1,pot * b );
       return pot;
   
   }

   public int mcd(int n1, int n2) {
       return mcd(n1, n2, 2);
   }

    private int mcd(int n1, int n2, int d) {
        if(n1 >= d && n2 >= d){
            if(n1 % d == 0 && n2 % d == 0)
                return mcd(n1/d,n2/d,d) * d;
            return mcd(n1,n2,d+1);
        }
        return 1;
    }
    
    public boolean search(int array[], int val){
        return search(array, val, 0);
    }

    private boolean search(int[] array, int val, int pos) {
        if( pos < array.length ){
            if(array[pos] == val)
                return true;
             return search(array, val, pos+1);
        }
        return false;
    }
    
    public boolean palindromo(String cad){
        return palindromo(cad,0,cad.length()-1);
    }

    private boolean palindromo(String cad, int inicio, int fin) {
        if(inicio < fin){
            if(cad.charAt(inicio) == cad.charAt(fin))
                return palindromo(cad,inicio+1,fin-1);
            return false;
        }
        return true;
    }
    
    public int fibonacci(int n){
        if(n > 1)
            return fibonacci(n-1)+fibonacci(n-2);
        return n;
    }
}
