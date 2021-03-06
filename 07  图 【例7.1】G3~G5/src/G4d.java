//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月9日
//7.2   图的表示和实现
//7.3   图的遍历
//7.5.1   非负权值的单源最短路径（Dijkstra算法）
 
public class G4d
{
    public static void main(String args[])
    {
        String[] vertices={"A","B","C","D","E"};
        Triple edges[]={new Triple(0,1,10), new Triple(0,3,30), new Triple(0,4,99),
                        new Triple(1,2,50), new Triple(1,3,40),
                        new Triple(2,4,10), new Triple(3,2,20), new Triple(3,4,60)};
//        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);    //图7.12
        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);//图7.17
        System.out.print("带权有向图G4，"+graph.toString());

/*        //7.3   图的遍历
        System.out.println("深度优先遍历有向图G4：");                //图7.22（b），【思考题7-1~2，习题解答】遍历序列
        for (int i=0; i<graph.vertexCount(); i++)
            graph.DFSTraverse(i);

        System.out.println("广度优先遍历有向图G4：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);
        
        
        //7.5.1   非负权值的单源最短路径（Dijkstra算法）
        System.out.println("带权有向图G4，Dijkstra算法，单源最短路径如下：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法
*/
        
//        graph.shortestPath();                    //调用Floyd算法求带权图每对顶点间的最短路径
    }
}
//@author：Yeheya。2014-8-8
/*
程序运行结果如下：
带权有向图G4，顶点集合：(A, B, C, D, E)               //图7.12
邻接矩阵:  
     0    10     ∞    30    99
     ∞     0    50    40     ∞
     ∞     ∞     0     ∞    10
     ∞     ∞    20     0    60
     ∞     ∞     ∞     ∞     0

带权有向图G4，顶点集合：(A, B, C, D, E)                //图7.17
出边表：
0 -> ((0,1,10),(0,3,30),(0,4,99))
1 -> ((1,2,50),(1,3,40))
2 -> ((2,4,10))
3 -> ((3,2,20),(3,4,60))
4 -> ()

        //7.3   图的遍历
深度优先遍历有向图G4：
{ A B C E D }                                              //【思考题7-1~2，习题解答】遍历序列
{ B C E D } { A }                                          //图7.22（b）
{ C E } { D } { A B } 
{ D C E } { A B } 
{ E } { A B C D } 
广度优先遍历有向图G4：
{ A B D E C } 
{ B C D E } { A } 
{ C E } { D } { A B } 
{ D C E } { A B } 
{ E } { A B D C } 

        //7.5.1   非负权值的单源最短路径（Dijkstra算法）
带权有向图G4，Dijkstra算法，单源最短路径如下：
A的单源最短路径：(A,B)长度10，(A,D,C)长度50，(A,D)长度30，(A,D,C,E)长度60，
B的单源最短路径：(B,A)长度∞，(B,C)长度50，(B,D)长度40，(B,C,E)长度60，
C的单源最短路径：(C,A)长度∞，(C,B)长度∞，(C,D)长度∞，(C,E)长度10，
D的单源最短路径：(D,A)长度∞，(D,B)长度∞，(D,C)长度20，(D,C,E)长度30，
E的单源最短路径：(E,A)长度∞，(E,B)长度∞，(E,C)长度∞，(E,D)长度∞，

vset数组{1,0,0,0,0}	path数组{-1,0,-1,0,0}	dist数组{0,10,∞,30,99}
vset数组{1,1,0,0,0}	path数组{-1,0,1,0,0}	dist数组{0,10,60,30,99}
vset数组{1,1,0,1,0}	path数组{-1,0,3,0,3}	dist数组{0,10,50,30,90}
vset数组{1,1,1,1,0}	path数组{-1,0,3,0,2}	dist数组{0,10,50,30,60}
vset数组{1,1,1,1,1}	path数组{-1,0,3,0,2}	dist数组{0,10,50,30,60}
从顶点A到其他顶点的最短路径如下：
(A,B)长度10，(A,D,C)长度50，(A,D)长度30，(A,D,C,E)长度60

vset数组{0,1,0,0,0}	path数组{-1,-1,1,1,-1}	dist数组{∞,0,50,40,∞}
vset数组{0,1,0,1,0}	path数组{-1,-1,1,1,3}	dist数组{∞,0,50,40,100}
vset数组{0,1,1,1,0}	path数组{-1,-1,1,1,2}	dist数组{∞,0,50,40,60}
vset数组{0,1,1,1,1}	path数组{-1,-1,1,1,2}	dist数组{∞,0,50,40,60}
从顶点B到其他顶点的最短路径如下：
(B,A)长度∞，(B,C)长度50，(B,D)长度40，(B,C,E)长度60

vset数组{0,0,1,0,0}	path数组{-1,-1,-1,-1,2}	dist数组{∞,∞,0,∞,10}
vset数组{0,0,1,0,1}	path数组{-1,-1,-1,-1,2}	dist数组{∞,∞,0,∞,10}
从顶点C到其他顶点的最短路径如下：
(C,A)长度∞，(C,B)长度∞，(C,D)长度∞，(C,E)长度10

vset数组{0,0,0,1,0}	path数组{-1,-1,3,-1,3}	dist数组{∞,∞,20,0,60}
vset数组{0,0,1,1,0}	path数组{-1,-1,3,-1,2}	dist数组{∞,∞,20,0,30}
vset数组{0,0,1,1,1}	path数组{-1,-1,3,-1,2}	dist数组{∞,∞,20,0,30}
从顶点D到其他顶点的最短路径如下：
(D,A)长度∞，(D,B)长度∞，(D,C)长度20，(D,C,E)长度30，

vset数组{0,0,0,0,1}	path数组{-1,-1,-1,-1,-1}	dist数组{∞,∞,∞,∞,0}
从顶点E到其他顶点的最短路径如下：
(E,A)长度为∞，(E,B)长度为∞，(E,C)长度为∞，(E,D)长度为∞


*/ 
/*
带权有向图G6，顶点集合：(A, B, C, D, E) 
邻接矩阵:  
  0  10  ∞  30  99
  ∞  0  50  40  ∞
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  60
  ∞  ∞  ∞  ∞  0
初值path数组
  -1  0  -1  0  0
  -1  -1  1  1  -1
  -1  -1  -1  -1  2
  -1  -1  3  -1  3
  -1  -1  -1  -1  -1
dist数组
  0  10  ∞  30  99
  ∞  0  50  40  ∞
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  60
  ∞  ∞  ∞  ∞  0

以A作为中间顶点
(B,C)路径长度50，替换为(B,A),(A,C)路径长度199998？否
(B,D)路径长度40，替换为(B,A),(A,D)路径长度100029？否
(B,E)路径长度99999，替换为(B,A),(A,E)路径长度100098？否
(C,B)路径长度99999，替换为(C,A),(A,B)路径长度100009？否
(C,D)路径长度99999，替换为(C,A),(A,D)路径长度100029？否
(C,E)路径长度10，替换为(C,A),(A,E)路径长度100098？否
(D,B)路径长度99999，替换为(D,A),(A,B)路径长度100009？否
(D,C)路径长度20，替换为(D,A),(A,C)路径长度199998？否
(D,E)路径长度60，替换为(D,A),(A,E)路径长度100098？否
(E,B)路径长度99999，替换为(E,A),(A,B)路径长度100009？否
(E,C)路径长度99999，替换为(E,A),(A,C)路径长度199998？否
(E,D)路径长度99999，替换为(E,A),(A,D)路径长度100029？否
path数组
  -1  0  -1  0  0
  -1  -1  1  1  -1
  -1  -1  -1  -1  2
  -1  -1  3  -1  3
  -1  -1  -1  -1  -1
dist数组
  0  10  ∞  30  99
  ∞  0  50  40  ∞
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  60
  ∞  ∞  ∞  ∞  0

以B作为中间顶点
(A,C)路径长度99999，替换为(A,B),(B,C)路径长度60？是，d02=60，p02=1
(A,D)路径长度30，替换为(A,B),(B,D)路径长度50？否
(A,E)路径长度99，替换为(A,B),(B,E)路径长度100009？否
(C,A)路径长度99999，替换为(C,B),(B,A)路径长度199998？否
(C,D)路径长度99999，替换为(C,B),(B,D)路径长度100039？否
(C,E)路径长度10，替换为(C,B),(B,E)路径长度199998？否
(D,A)路径长度99999，替换为(D,B),(B,A)路径长度199998？否
(D,C)路径长度20，替换为(D,B),(B,C)路径长度100049？否
(D,E)路径长度60，替换为(D,B),(B,E)路径长度199998？否
(E,A)路径长度99999，替换为(E,B),(B,A)路径长度199998？否
(E,C)路径长度99999，替换为(E,B),(B,C)路径长度100049？否
(E,D)路径长度99999，替换为(E,B),(B,D)路径长度100039？否
path数组
  -1  0  1  0  0
  -1  -1  1  1  -1
  -1  -1  -1  -1  2
  -1  -1  3  -1  3
  -1  -1  -1  -1  -1
dist数组
  0  10  60  30  99
  ∞  0  50  40  ∞
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  60
  ∞  ∞  ∞  ∞  0

以C作为中间顶点
(A,B)路径长度10，替换为(A,B,C),(C,B)路径长度100059？否
(A,D)路径长度30，替换为(A,B,C),(C,D)路径长度100059？否
(A,E)路径长度99，替换为(A,B,C),(C,E)路径长度70？是，d04=70，p04=2
(B,A)路径长度99999，替换为(B,C),(C,A)路径长度100049？否
(B,D)路径长度40，替换为(B,C),(C,D)路径长度100049？否
(B,E)路径长度99999，替换为(B,C),(C,E)路径长度60？是，d14=60，p14=2
(D,A)路径长度99999，替换为(D,C),(C,A)路径长度100019？否
(D,B)路径长度99999，替换为(D,C),(C,B)路径长度100019？否
(D,E)路径长度60，替换为(D,C),(C,E)路径长度30？是，d34=30，p34=2
(E,A)路径长度99999，替换为(E,C),(C,A)路径长度199998？否
(E,B)路径长度99999，替换为(E,C),(C,B)路径长度199998？否
(E,D)路径长度99999，替换为(E,C),(C,D)路径长度199998？否
path数组
  -1  0  1  0  2
  -1  -1  1  1  2
  -1  -1  -1  -1  2
  -1  -1  3  -1  2
  -1  -1  -1  -1  -1
dist数组
  0  10  60  30  70
  ∞  0  50  40  60
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  30
  ∞  ∞  ∞  ∞  0

以D作为中间顶点
(A,B)路径长度10，替换为(A,D),(D,B)路径长度100029？否
(A,B,C)路径长度60，替换为(A,D),(D,C)路径长度50？是，d02=50，p02=3
(A,D,C,E)路径长度70，替换为(A,D),(D,C,E)路径长度60？是，d04=60，p04=2
(B,A)路径长度99999，替换为(B,D),(D,A)路径长度100039？否
(B,C)路径长度50，替换为(B,D),(D,C)路径长度60？否
(B,C,E)路径长度60，替换为(B,D),(D,C,E)路径长度70？否
(C,A)路径长度99999，替换为(C,D),(D,A)路径长度199998？否
(C,B)路径长度99999，替换为(C,D),(D,B)路径长度199998？否
(C,E)路径长度10，替换为(C,D),(D,C,E)路径长度100029？否
(E,A)路径长度99999，替换为(E,D),(D,A)路径长度199998？否
(E,B)路径长度99999，替换为(E,D),(D,B)路径长度199998？否
(E,C)路径长度99999，替换为(E,D),(D,C)路径长度100019？否
path数组
  -1  0  3  0  2
  -1  -1  1  1  2
  -1  -1  -1  -1  2
  -1  -1  3  -1  2
  -1  -1  -1  -1  -1
dist数组
  0  10  50  30  60
  ∞  0  50  40  60
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  30
  ∞  ∞  ∞  ∞  0

以E作为中间顶点
(A,B)路径长度10，替换为(A,D,C,E),(E,B)路径长度100059？否
(A,D,C)路径长度50，替换为(A,D,C,E),(E,C)路径长度100059？否
(A,D)路径长度30，替换为(A,D,C,E),(E,D)路径长度100059？否
(B,A)路径长度99999，替换为(B,C,E),(E,A)路径长度100059？否
(B,C)路径长度50，替换为(B,C,E),(E,C)路径长度100059？否
(B,D)路径长度40，替换为(B,C,E),(E,D)路径长度100059？否
(C,A)路径长度99999，替换为(C,E),(E,A)路径长度100009？否
(C,B)路径长度99999，替换为(C,E),(E,B)路径长度100009？否
(C,D)路径长度99999，替换为(C,E),(E,D)路径长度100009？否
(D,A)路径长度99999，替换为(D,C,E),(E,A)路径长度100029？否
(D,B)路径长度99999，替换为(D,C,E),(E,B)路径长度100029？否
(D,C)路径长度20，替换为(D,C,E),(E,C)路径长度100029？否
path数组
  -1  0  3  0  2
  -1  -1  1  1  2
  -1  -1  -1  -1  2
  -1  -1  3  -1  2
  -1  -1  -1  -1  -1
dist数组
  0  10  50  30  60
  ∞  0  50  40  60
  ∞  ∞  0  ∞  10
  ∞  ∞  20  0  30
  ∞  ∞  ∞  ∞  0

每对顶点间的最短路径如下：
(A,B)长度为10
(A,D,C)长度为50
(A,D)长度为30
(A,D,C,E)长度为60
(B,A)长度为∞
(B,C)长度为50
(B,D)长度为40
(B,C,E)长度为60
(C,A)长度为∞
(C,B)长度为∞
(C,D)长度为∞
(C,E)长度为10
(D,A)长度为∞
(D,B)长度为∞
(D,C)长度为20
(D,C,E)长度为30
(E,A)长度为∞
(E,B)长度为∞
(E,C)长度为∞
(E,D)长度为∞
 * */
