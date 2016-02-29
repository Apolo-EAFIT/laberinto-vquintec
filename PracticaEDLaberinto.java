import java.util.Scanner;
public class PracticaEDLaberinto{
    
    private static int muros = 0;
    private static char[][] matrizFinal;
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int tLaberinto;
        tLaberinto = sc.nextInt();
        
        if(verificarRango(tLaberinto)){
            char[][] laberinto = new char[tLaberinto][tLaberinto];
            String linea;
            
            for(int i = 0;i < tLaberinto;i++){
                linea = sc.next();
                for(int j = 0;j < tLaberinto;j++){
                    laberinto[i][j] = linea.charAt(j);
                }
            }
            if(!resolverLaberinto(0,0,laberinto,0,0)){
                resolverLaberinto(tLaberinto-1,tLaberinto-1,laberinto,tLaberinto-1,tLaberinto-1);
            }
            contarMuros(matrizFinal);
        }
    }
    
    public static boolean verificarRango(int valor){
        return valor >= 3 && valor <= 33;
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
        
        matriz[x][y] = '-';
        
        boolean r = resolverLaberinto(x,y-1,matriz,posiX,posiY);
        r = r || resolverLaberinto(x-1,y,matriz,posiX,posiY);
        r = r || resolverLaberinto(x+1,y,matriz,posiX,posiY);
        r = r || resolverLaberinto(x,y+1,matriz,posiX,posiY);

        matrizFinal = matriz;
       
        return r;
    }
    
    public static void contarMuros(char[][] matriz){
        for(int i = 0;i < matriz.length;i++){
            for(int j = 0;j < matriz.length;j++){
                if (matriz[i][j]== '-'){
                    for (int k = 0;k < 4;k++){
                        if(k == 0)
                            if(i+1 == matriz.length || matriz[i+1][j] == '#')
                                muros++;
                        if(k == 1)
                            if(i-1 == -1 || matriz[i-1][j] == '#')
                                muros++;
                        if(k == 2)
                            if(j+1 == matriz.length || matriz[i][j+1] == '#')
                                muros++;
                        if(k == 3)
                            if(j-1 == -1 || matriz[i][j-1] == '#')
                                muros++;
                    }
                }  
            }
        }
        System.out.println((muros-4)*9);
    }
}
