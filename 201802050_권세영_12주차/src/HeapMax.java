public class HeapMax {
        private Node[] list;
        private  int size;
        private int maxsize;

        public HeapMax(int maxsize){
            list = new Node[maxsize];
            size = 0;
        }
        public void add(int num,Object object){
            Node p = new Node(num, object);
            if(maxsize == size+1){
                return;
            }
            if(size == 0){
                list[size+1] = p;
                size ++;
                return;
            }

            int k = size+1;
            list[k] = p;//넣는다
            while(k>0){
                int j = k;
                if(k==1){
                    break;
                }
                if(k%2 == 0){
                    k = k/2;
                }else{
                    k = (k-1)/2;
                }
                if(list[j].priority<=list[k].priority){
                    swap(list,k,j);
                }
            }
            size ++;
            return;
        }
        public Object best(){
            return list[1].elements;//안 지우고 출력
        }

        public void print(){
            for(int i=1; i<size+1; i++){
                System.out.print(list[i].elements + " ");
            }
        }
        public Object removeBest(){
            Node k;
            if(size == 0){
                return null;
            }
            if(size == 1){
                k = list[1];
                list[1] = null;
                return k.elements;
            }
            k = list[1];
            list[1] = list[size];
            list[size+1] = null;
            size--;
            int x =1;
            while(x*2<size+1){
                if(list[x].priority > list[x*2].priority && list[x*2].priority < list[(x*2)+1].priority){
                    swap(list, x,x*2);
                    x = x*2;
                }else if(list[x].priority > list[(x*2)+1].priority && list[x*2].priority > list[(x*2)+1].priority){
                    swap(list,x,(x*2)+1);
                    x = (x*2) +1;
                }else{
                    break;
                }
            }
            return k;//지우면서 출력
        }

        public int size(){
            return size;
        }

        private void swap(Node[] array,int a, int b) {
            Node temp = array[a];
            array[a] = array[b];
            array[b] = temp;

        }
}

class Node{
    int priority;
    Object elements;
    public Node(int priority, Object elements ){
        this.elements = elements;
        this.priority = priority;
    }
}