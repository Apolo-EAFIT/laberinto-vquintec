import java.util.Scanner;
public class PracticaEDLaberinto{
    
    static int muros=0;
    static char[][] matrizFinal;
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int filas = sc.nextInt();
        int col = filas;
        
        if(filas >= 3 && filas <= 33){
            char[][] tablero = new char[filas][col];
            String linea;
            int f = 0;
            for(int i = 0;i < col;i++){
                linea = sc.next();
                for(int j = 0;j < col;j++){
                    tablero[i][j] = linea.charAt(j);
                }
            }
            if(!resolverLaberinto(0,0,tablero,0,0)){
                //System.out.println("No se encontro la salida empezando desde 0,0");
                resolverLaberinto(tablero.length-1,tablero.length-1,tablero,tablero.length-1,tablero.length-1);
            }
            //imprimirMatriz(matrizFinal);
            muros(matrizFinal);
            
        }
        
        
    
    }
    
    public static boolean resolverLaberinto(int x, int y, char[][] matriz, int posiX, int posiY){
             if (x == -1){
                 return false;
             }else if (y == -1){
                 return false;
             }else if (x == matriz.length){
                 return false;
             }else if (y == matriz.length){
                 return false;
             } else if (matriz[x][y] == '#'){
                 return false;
             }else if (matriz[x][y] == '-'){
                 return false;
             }
             if(posiX == 0 && posiY == 0){
                if (x == matriz.length-1 && y == matriz.length-1){
                    //System.out.println("La salida desde arriba hacia abajo ha sido encontrada");
                    //return true;
                }
             }else{
                 if(x == 0 && y == 0){
                     //System.out.println("La salida desde abajo hacia arriba ha sido encontrada");
                     //return true;
                 }
             }
             matriz[x][y] = '-';
        
       //boolean r = resolverLaberinto(x+1,y,matriz) || resolverLaberinto(x,y+1,matriz) || resolverLaberinto(x-1,y,matriz) || resolverLaberinto(x,y-1,matriz);
       
       boolean r = resolverLaberinto(x,y-1,matriz,posiX,posiY);
       r = r || resolverLaberinto(x-1,y,matriz,posiX,posiY);
       r = r || resolverLaberinto(x+1,y,matriz,posiX,posiY);
       r = r || resolverLaberinto(x,y+1,matriz,posiX,posiY);
       if (r) matriz[x][y] = 'X';
        //imprimirMatriz(matriz);
       matrizFinal = matriz;
       
         return r;
    }
    
    public static void imprimirMatriz(char[][] matriz){
        for(int i = 0;i < matriz.length;i++){
            for(int j = 0;j < matriz.length;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void muros(char[][] matriz ){
   
        for(int i = 0;i < matriz.length;i++){
            for(int j = 0;j < matriz.length;j++){
               
              if (matriz[i][j]== '-'){
              
                  for (int k = 0;k < 4;k++){
                      if(k == 0){
                          if(i+1 == matriz.length){
                              muros++;
                          }else{
                            if(matriz[i+1][j] == '#'){
                                  muros++;
                            }
                          }
                      }
                      if(k == 1){
                          if(i-1 == -1){
                              muros++;
                            
                          }else{
                              if(matriz[i-1][j] == '#'){
                                muros++;
                            }
                          }
                      }
                      if(k == 2){
                          if(j+1 == matriz.length){
                              muros++;
                          }else{
                            if(matriz[i][j+1] == '#'){
                                  muros++;
                            }
                          }
                      }
                      if(k == 3){
                          if(j-1 == -1){
                              muros++;
                          }else{
                              if(matriz[i][j-1] == '#'){
                                muros++;
                            }
                          }
                      }
                      
                  }
                  
              
              }  
            }
        }
        
        System.out.println((muros-4)*9);
    }
    
   
}
