package Functions;

import EDD.LinkedList;

//Clase pública Kosaraju, es un algoritmo que se encarga de mostrar los componentes fuertemente conectados dentro de nuestro gráfico y retorna una lista simplemente enlazada con los componentes
public class Kosaraju 
{    
//Método getSCC, recibe una matriz de booleanos de tipo LinkedList, se encarga de ubicar los componentes fuertemente conectados a través de una búsqueda profunda en la que idetifica cada uno de los elementos visitados, retorna los componentes
    public LinkedList getSCC(boolean [][] matrix)
    {
        LinkedList visited = new LinkedList();
        visited.Construct(matrix.length);
        LinkedList stack = new LinkedList();
        LinkedList scc = new LinkedList();
                
        //FirstDFS
        for (int vertex = 0; vertex < matrix.length; vertex++) 
        {
            if (!visited.CheckIfVisited(vertex))
            {
                findOrder(vertex, stack, matrix, visited);
            }
        }
        
        //Matriz Transpuesta
        transpose(matrix);
        
        //SecondDFS
        visited.Deconstruct();
        while (!stack.isEmpty())
        {
            int vertex = (int) stack.deleteFinal();
            if (!visited.CheckIfVisited(vertex))
            {
                LinkedList currentSCC = new LinkedList();
                currentSCC.Clear();
                dfs(vertex, matrix, visited, currentSCC);
                if (!currentSCC.isEmpty()) 
                {
                    scc.InsertAtEnd(currentSCC);
                }
            }
        }
        return scc;
    }
    
//Método findOrder, recibe un vértice de tipo int, un stack de tipo LinkedList, una matriz de booleanos y una lista visitada simplemente enlazada; se encarga de entrar en cada una de las aristas de la matriz e inserta los vértices en el stack, retorna vacío    
    public static void findOrder(int vertex, LinkedList stack, boolean [][] matrix, LinkedList visited)
    {
        visited.SetAsVisited(vertex);
        for (int i = 0; i < matrix.length; i++) 
        {
            if ((matrix[vertex][i]) && (!visited.CheckIfVisited(i)))
            {
                findOrder(i, stack, matrix, visited);
            }
        }
        stack.InsertAtEnd(vertex);
    }
    
//Método transpose, recibe la matriz de booleanos, se encarga de crear la matriz transpuesta de la ingresada, retorna vacío    
    public static void transpose(boolean [][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix.length; j++) 
            {
                if(matrix[i][j])
                {
                    matrix[i][j]=false;
                    matrix[j][i]=true;
                }
            }
        }
    }
    
//Método dfs, recibe un vértice de tipo int, una matriz de booleanos, una lista visitada simplemente enlazada y una lista simple con los components fuertemente enlazados, este método se encarga de recorrer los vértices dentro de la lista de visitados y los va agregando a nuestra lista de componentes fuertemente conectados, retorna vacío    
    public static void dfs(int vertex, boolean [][] matrix, LinkedList visited, LinkedList currentSCC)
    {
        visited.SetAsVisited(vertex);
        currentSCC.InsertAtEnd(vertex);
        
        for (int i = 0; i < matrix.length; i++) 
        {
            if ((matrix[vertex][i]) && (!visited.CheckIfVisited(i)))
            {
                dfs (i, matrix, visited, currentSCC);
            }
        }
    }
}