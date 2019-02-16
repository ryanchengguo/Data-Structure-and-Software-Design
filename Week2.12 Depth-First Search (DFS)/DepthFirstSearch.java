public class DepthFirstSearch {
	//node visited but not we are looking for
	private Set<Node> marked;

	private Graph graph;


	public DepthFirstSearch(Graph, graphToSearch){
		//implement set using a hash set
		marked = new HashSet<Node>();
		//graph trying to traverse
		graph = graphToSearch;
	}

	//DFS Method
	public boolean dfs(String elementToFind, Node start){
		if(!graph.containsNode(start)){
			return false;
		}
		//if current node equals to element looking for
		if(start.getElement().equals(elementToFind)){
			return true;
		}else{
			marked.add(start);
			for (Node neighbor : graph.getNodeNeighbors(start)){
				if(dfs(elementToFind, neighbor))
				return true;
			}
			return false;
		}


}
