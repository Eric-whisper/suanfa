import java.util.*;

public class Demo2 {
    public static void main(String[] args){
        System.out.println("start");
        Graph graph = new Graph();
        //加节点
        Node nodeA = new Node("A",1);
        Node nodeB = new Node("B",2);
        Node nodeC = new Node("C",2);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        //加边
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        int path = graph.getMostLongPathResult("A","C", new ArrayList<>());
        System.out.println("最长路径是:"+ path);
        /**
         *在建立的这个图中，不管是加入一条B到A的边或者C到A的边，
         *使之形成环路，在算法中都能绕过去，并给出正确的答案。
         *遇到闭环直接跳出，并提示
         **/
    }
}

class Graph {
    private Map<String,Node> nodeMap = new HashMap<String, Node>();
    //用一个node名字，跟node节点表示一个map中的一个node
    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }
    public void addNode(Node node){
        if(node==null){
            System.out.println("空节点!");
        }
        this.nodeMap.put(node.getName(),node);
    }

    public void addEdge(String startNodeName,String endNodeName){
        if(nodeMap==null) {
            System.out.println("没有新建map");
        }
        if(nodeMap.get(startNodeName)==null){
            System.out.println("起始节点名字为空");
        }
        if(nodeMap.get(endNodeName)==null){
            throw new RuntimeException("尾节点名字为空");
        }
        Node node = nodeMap.get(startNodeName);
        node.addEdges(endNodeName);
    }

    public Boolean isVisited(List<String> vistedList, String nodeName){
        for (String str: vistedList){
            if(str.equals(nodeName)){
                return true;
            }
        }
        return false;
    }

    /** *
     *  * -1表示两个节点之间没有路径
     * 递归查找
     *遇到闭环直接跳出，并提示
     * */
    public int getMostLongPathResult(String fromNodeName,String toNodeName,List<String> pathList){
        if(fromNodeName.equals(toNodeName)){
            System.out.println("起始尾节点一致");
            return -1;
        }
        Node fromNode = nodeMap.get(fromNodeName);
        List<Edge> edges = fromNode.getEdges();
        if(edges==null ){
            return -1;
        }
        boolean isVisted = isVisited(pathList, fromNodeName);
        if(isVisted){
            System.out.println("出现闭环"+"起始节点:"+fromNodeName);
            return 0;
            /** *
             *  * 这块，发现了闭环，在这里做了提醒
             * 避免调入环路的坑，返回了0，依然能给出从起始节点到最终节点最长的路径值
             * 即在提醒之后，依然给与准确的值。
             * */
        }

        pathList.add(fromNodeName);
        int path = 0;

        for (Edge edge :edges){
            List<String> temp2 = new ArrayList<>();
            temp2.addAll(pathList);
            int tempPath = fromNode.getWeight();
            String endNodeName = edge.getEndNode();
            if(!endNodeName.equals(toNodeName)){
                int mostPath = getMostLongPathResult(endNodeName, toNodeName,temp2);
                if(mostPath==-1){
                    continue;
                }
                tempPath+=mostPath;
            }else {
                tempPath+=nodeMap.get(endNodeName).getWeight();
                temp2.add(toNodeName);
            }
            if(path<tempPath){
                path=tempPath;
                pathList.clear();
                pathList.addAll(temp2);
            }
        }
        return path;
    }
}
class Node {
    private String name;
    private Integer weight;
    private List<Edge> edges = new ArrayList<Edge>();

    public Node(String name, Integer weight){
        setName(name);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdges(String endNode) {
        Edge edge = new Edge();
        edge.setStartNode(this.getName());
        edge.setEndNode(endNode);
        this.edges.add(edge);
    }
}
class Edge {
    private String startNode;
    private String endNode;
    public String getStartNode() {

        return startNode;
    }
    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }
    public String getEndNode() {
        return endNode;
    }
    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }
}