public class Graph<T extends Comparable> {
    Vertex<T> head;

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator=head;
        while(iterator!=null){
            if(iterator.id.compareTo(id)==0){
                return iterator;
            }
            iterator=iterator.nextVertex;
        }
        return null;

    }
    public void addVertex(T id){
        if(findVertex(id)!=null)
        {
            System.out.println("IT ALREADY EXISTS");
            return;
        }
        Vertex<T> newVertex= new Vertex<>(id);
        if (head==null)
            head=newVertex;
        else{
            Vertex<T> iterator=head;
            while(iterator.nextVertex!=null)
                iterator=iterator.nextVertex;
            iterator.nextVertex=newVertex;
        }
    }
    public void addEdge(T startingId, T endId, int w){
        Vertex<T> current=findVertex(startingId);
        Edge<T> newEdge=new Edge<>(endId, w);
        Edge<T> iteratorEdge=current.edgeLink;
        if(iteratorEdge==null)
            current.edgeLink=newEdge;
        else{
            while(iteratorEdge.nextEdge!=null)
                iteratorEdge=iteratorEdge.nextEdge;
            iteratorEdge.nextEdge=newEdge;
        }
    }
    /**
     * Verilen bir kimlik (id) için giden kenar sayısını hesaplayan metod.
     *
     * @param id Kenar sayısı hesaplanacak olan düğümün kimliği.
     * @return Verilen düğümden çıkan kenar sayısı.
     */
    public int outDegree(T id) {
        // Belirtilen id'ye sahip düğümü bul
        Vertex<T> current = findVertex(id);

        int count = 0;
        // Düğümün kenarlarını gez
        Edge<T> iteratorEdge = current.edgeLink;

        while (iteratorEdge != null) {
            // Her kenar için sayacı artır
            iteratorEdge = iteratorEdge.nextEdge;
            count++;
        }

        return count;
    }


    public int inDegree(T id) {
        // Belirtilen id'ye sahip düğümü bul
        Vertex<T> current = findVertex(id);

        int count = 0;

        // Grafiği gez ve her düğümün kenarlarını kontrol et
        for (Vertex<T> vertex : vertices) {
            Edge<T> iteratorEdge = vertex.edgeLink;

            // Her düğümün kenarlarını kontrol et
            while (iteratorEdge != null) {
                // Eğer kenarın hedef düğümü belirtilen düğüm ise, inDegree'yi artır
                if (iteratorEdge.destination == current) {
                    count++;
                }
                iteratorEdge = iteratorEdge.nextEdge;
            }
        }
        return count;
    }



    public void display(){
        Vertex<T> iteratorVertex=head;
        while(iteratorVertex!=null){
            System.out.print(iteratorVertex.id+"->");
            Edge<T> iteratorEdge=iteratorVertex.edgeLink;
            while(iteratorEdge!=null){
                System.out.print(iteratorEdge.vertexId+" ");
                iteratorEdge=iteratorEdge.nextEdge;
            }
            System.out.println();
            iteratorVertex=iteratorVertex.nextVertex;
        }
    }
}