public class BreadthFirstSearch {
	//node visited but not we are looking for
	private Set<Node> marked;

	private Graph graph;


	public BreadthFirstSearch(Graph, graphToSearch){
		//implement set using a hash set
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}

	//BFS Method
	public boolean bfs(String elementToFind, Node start){
		//if the graph does not contain "start" Node then return false
		if(!graph.containsNode(start)){
			return false;
		}

		//if Node start value happened to be what we are looking for
		if(start.getElement().equals(elementToFind)){
			return true;
		}


		Queue<Node> toExplore = new LinkedList<Node>();
		//add to hash set 
		marked.add(start);
		//add to queue
		toExplore.add(start);

		while(!toExplore.isEmpty()){
			//每加入一个neighbor 就remove掉queue里的第一个element

			Node current = toExplore.remove();
			//get all its neighbors
			//BFS核心 遍历node的每一个neighbor
			for (Node neighbor : graph.getNodeNeighbors(current)){

				if(!marked.contains(neighbor)){
					if(neighbor.getElement().equals(elementToFind)){
						return true;
					}
				//if neighbor not been marked
				//add to hash set
				marked.add(neighbor);
				//add to queue
				toExplore.add(neighbor);
				}
			}
		}

		return false;
	}
}
