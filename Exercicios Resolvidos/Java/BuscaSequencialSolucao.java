import java.util.Scanner;
public class BuscaSequencialSolucao{
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
        if(dic.Pesquisa(chaveBusca) == 0){// sem sucesso
            Elem novo = new Elem(chaveBusca);
            dic.Insere(novo);
        }else
            dic.Remove(chaveBusca);
        
        System.out.println(dic.size());       
    }
    static class Dicionario{
        Elem[] elementos;// começa do 1
        int size;
        int capacidade;
        public Dicionario(){
            this.capacidade = 10;
            elementos = new Elem[capacidade+1];
            size = 1;
        }
        public int size(){return this.size-1;}
        public int Pesquisa(int chave){
            elementos[0] = new Elem(chave);
            int i = size-1;
            while(elementos[i].chave != chave)
                i--;
            
            return i;// retorna 0 para busca sem sucesso
        }
        public boolean Insere(Elem elemento){
            if(size >= capacidade)
                this.aumentaCapacidade();
                
            elementos[size++] = elemento;
            return true;
        }
        public boolean Remove(int chave){
            if(size == 1)// tamanho 1 = vazio
                return false;
            int busca = this.Pesquisa(chave);
            if(busca == 0)// nao existe
                return false;  
            for(int i = busca; i < size-1; i++)
                elementos[i] = elementos[i+1];
            size--;
            return true;
        }
        private void aumentaCapacidade(){
            this.capacidade*=2;
            Elem[] novo = new Elem[capacidade+1];// mais um para o elemento pivo
            for(int i = 1; i < size; i++)
                novo[i] = this.elementos[i];
            elementos = novo;
        }
        public void Show(){
            for(int i = 1; i < size; i++)
                System.out.print(elementos[i].chave+" ");
        }
        
    }    
    static class Elem{
        int chave;
        public Elem(int chave){ this.chave = chave;}
    }
}