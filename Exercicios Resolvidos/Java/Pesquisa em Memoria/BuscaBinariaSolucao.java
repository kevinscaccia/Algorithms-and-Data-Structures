/**
 * @author: Kevin Costa Scaccia
*/
import java.util.Scanner;
public class BuscaBinariaSolucao{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Dicionario dic = new Dicionario();
        int input;
        input = scanner.nextInt();
        while(input >= 0){
            Elem novo = new Elem(input);
            dic.Insere(novo);
            input = scanner.nextInt();
        }
        int chaveBusca = scanner.nextInt();
        if(dic.Pesquisa(chaveBusca) == -1){// sem sucesso
            Elem novo = new Elem(chaveBusca);
            dic.Insere(novo);
        }else
            dic.Remove(chaveBusca);
        
        System.out.println(dic.size()); 
    }
    static class Dicionario{
        Elem[] elementos;
        int size;
        int capacidade;
        public Dicionario(){
            this.capacidade = 10;
            elementos = new Elem[capacidade];
            size = 0;
        }
        public int Pesquisa(int chave){
            if(size == 0)
                return -1;
            int l = 0, r = size-1;
            while(l < r){
                int meio = (l+r)/2;
                if(chave > elementos[meio].chave)
                    l = meio+1;
                else if(chave < elementos[meio].chave)// pesquisa nas subpartes
                    r = meio-1;
                else
                    return meio;
            }
            if(elementos[l].chave == chave)
                return l;
            return -1;
        }
        public boolean Insere(Elem elemento){
            if(size >= capacidade)
                this.aumentaCapacidade();
            // Encontrando o indice [i] para o novo Elemento
            int i = 0;
            while(i < size && elemento.chave > elementos[i].chave)
                i++;
            // Abrindo espaço na posição i
            for(int b = size; b > i; b--)
                elementos[b] = elementos[b-1];
            // Colocando o novo elemento pa posição [i]
            elementos[i] = elemento;
            size++;// Aumenta o numero de elementos
            return true;
        }
        public boolean Remove(int chave){
            if(size == 0)// vazio
                return false;
            int busca = this.Pesquisa(chave);
            if(busca == -1)// Elemento não existe
                return false;  
            for(int i = busca; i < size-1; i++)
                elementos[i] = elementos[i+1];
            size--;
            return true;
        }
        public int size(){ return size;}
        private void aumentaCapacidade(){
            this.capacidade*=2;
            Elem[] novo = new Elem[capacidade];
            for(int i = 0; i < size; i++)
                novo[i] = this.elementos[i];
            elementos = novo;
        }
        public void Show(){
            for(int i = 0; i < size; i++)
                System.out.print(elementos[i].chave+" ");
        }
        
    }
    static class Elem{
        int chave;
        public Elem(int chave){ this.chave = chave;}
    }
}