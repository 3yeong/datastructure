public class Sort {

    void heap_sort(int[]a){
        for(int  i = (a.length -1)/2; i>=0; i--)
            heapify(a,i,a.length);
        for(int  j = a.length-1; j>0; j--){
            swap(a,0,j);
            heapify(a,0,j);
        }
    }
    void heapify(int[] a, int i, int n){
        int ai = a[i];
        while(i<n/2){
            int j = 2*i + 1;
            if(j+1<n && a[j+1]>a[j]) ++j;
            if(a[j] <= ai)break;
            a[i] = a[j];
            i = j;
         a[i] = ai;
        }
    }
    void merge_sort(int[] a,int p ,int q ){
        if(q - p <2) return;
        int m = (p+q)/2 ;
        merge_sort(a,p,m);
        merge_sort(a,m,q);
        merge(a,p,m,q);
    }
    void merge(int[] a, int p ,int m, int q){
        if(a[m-1] <=a[m])return;
        int i = p, j = m, k =0;
        int [] aa = new int [q-p];
        while(i<m && j < q)
            if(a[i] < a[j]) aa[k++] = a[i++];
            else aa[k++] = a[j++];
        if(i<m)System.arraycopy(a,i,a,p+k,m-i);
        System.arraycopy(aa,0,a,p,k);
    }
    void quick_sort(int [] a, int p, int q){
        if(q-p<2) return;
        int  j = partition(a,p ,q);
        quick_sort(a,p,j);
        quick_sort(a,j+1,q);
    }
    int partition(int [] a, int p, int q){
        int pivot = a[p], i = p, j = q;
         while(i<j) {
             while (j > i && a[--j] >= pivot) ;
             if (j > i) a[i] = a[j];
             while (i < j && a[++i] <= pivot) ;
             if (i < j) a[j] = a[i];
         }
         a[j] = pivot;
         return j;
    }

    void swap(int[] a, int b,int c){
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    void print(int []a){
        for(int  i = 0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
