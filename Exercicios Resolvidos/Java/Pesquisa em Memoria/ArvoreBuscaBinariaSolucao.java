/**
 * @author: Kevin Costa Scaccia
*/
import java.util.Scanner;
public class ArvoreBuscaBinariaSolucao{
    public static void main(String[] args){
    	// Entrada de dados
        Scanner scanner = new Scanner(System.in);
        Dicionario dic = new Dicionario();
        int input = scanner.nextInt();
        while(input >= 0){// Enquanto o valor for positivo
            Elem novo = new Elem(input);
            dic.Insere(novo);// Insere um novo Nodo na árvore
            input = scanner.nextInt();
        }
        int chaveBusca = scanner.nextInt();// chave que efetuara a busca
        if(dic.Pesquisa(chaveBusca) == false){// sem sucesso (então insere)
            Elem novo = new Elem(chaveBusca);
            dic.Insere(novo);
        }else// Com sucesso (então remove)
            dic.Remove(chaveBusca);
        // Printa a quantidade de elementos na estrutura
        System.out.println(dic.size()); 
    }
    // Classe que Implementa o Dicionário (Não genérica)
    static class Dicionario{
        Nodo raiz;
        int size;
        public Dicionario(){
            raiz = null;
            size = 0;
        }
        public boolean Pesquisa(int chave){// pesquisa em toda a arvore
        	return (Pesquisa(chave, raiz) != null);
        }
        // Método auxiliar pesquisa recursiva (ém um nó em especial)
        public Nodo Pesquisa(int chave, Nodo no){
        	if(no == null) return null;
        	if(chave > no.elemento.chave){
        		if(no.hasRight())// pesquisa na subarvore direita
        			return Pesquisa(chave, no.right);
        		else// não tem subarvore direita (não tem o registro)
        			return null;
        	}else if(chave < no.elemento.chave){
        		if(no.hasLeft())
        			return Pesquisa(chave, no.left);
        		else
        			return null;
        	}else// Retorna o nodo em que se encontra o registro
        		return no;
        }
        public boolean Insere(Elem elemento){
        	if(raiz == null){
        		raiz = new Nodo(elemento, null, null, null);
        		size++;
        		return true;
        	}
        	return this.Insere(elemento, raiz);
        }
        // Método auxiliar recursivo
        public boolean Insere(Elem elemento, Nodo no){
			// Verifica se a chave é maior
			if(elemento.chave > no.elemento.chave){
				//Se tiver direito, continua continua a busca
				if(no.hasRight())
					Insere(elemento, no.right);
				else{//se não, insere ali
					no.right = new Nodo(elemento, no, null, null);
					size++;
					return true;
				}
			}else{//menor ou igual
				//Se tiver esquerdo, continua continua a busca
				if(no.hasLeft())
					Insere(elemento, no.left);
				else{//se não, insere ali
					no.left = new Nodo(elemento, no, null, null);
					size++;
					return true;
				}
			}
			return false;
		}        
        public boolean Remove(int chave){
        	return Remove(chave, raiz);
        }
        private boolean Remove(int chave, Nodo no){
        	// Pesquisa pela ocorrência da chave na arvore 'no'
        	Nodo p = Pesquisa(chave, no);
        	if(p == null)// Nada encontrado
        		return false;
        	// Se possui somente um descendente:
        	if(p.hasLeft() && !p.hasRight()){// Possui o esquerdo
        		if(p.pai.right == p)// se p é filho direito
        			p.pai.right = p.left;
        		else
        			p.pai.left = p.left;
        	}else if(p.hasRight() && !p.hasLeft()){// Possui o direito
        		if(p.pai.right == p)// se p é filho direito
        			p.pai.right = p.right;
        		else
        			p.pai.left = p.right;
        	}else if(!p.hasRight() && !p.hasLeft()){// Possui nenhum descendente:
        		if(p.pai.right == p)// se p é filho direito
        			p.pai.right = null;// remove
        		else
        			p.pai.left = null;// remove
        	}else{// Possui ambos os filhos
        		// Busca o mais à esquerda da subarvore direita
        		Nodo maiorSubDir = MaiorSubArvoreDir(p.right);
        		
        		
        		maiorSubDir.right = p.right;
        		maiorSubDir.left = p.left;
        		if(p.pai.right == p)// se p é filho direito
        			p.pai.right = maiorSubDir;
        		else
        			p.pai.left = maiorSubDir;	
        		maiorSubDir.pai = p.pai;
        		//System.out.println(maiorSubDir.right.right.elemento.chave);
        	}
        	size--;
        	return true;
        }
        // Método auxiliar encontrar maior da subarvore 
        public Nodo MaiorSubArvoreDir(Nodo no){
        	if(no.left == null)
        		return no;
        	else
        		return MaiorSubArvoreDir(no.left);
        }
        public int size(){ return size;}   
        public void emOrdem(){
        	emOrdem(raiz);
        }
        // Auxiliar Recursivo
        private void emOrdem(Nodo p){
        	if(p == null) return ;
        	emOrdem(p.left);
        	System.out.print(" "+p.elemento.chave+" ");
        	emOrdem(p.right);
        }
    }
    static class Elem{
        int chave;
        public Elem(int chave){ this.chave = chave;}
    }
    static class Nodo{
    	Elem elemento;
    	Nodo left, right, pai;
    	public Nodo(Elem elemento, Nodo pai, Nodo left, Nodo right){
    		this.left = left;
    		this.right = right;
    		this.pai = pai;
    		this.elemento = elemento;
    	}
    	public boolean hasLeft(){return (left != null);}
    	public boolean hasRight(){return (right != null);}
    }
}