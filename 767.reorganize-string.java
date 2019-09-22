import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */
class Solution {
    class Pair{
        int count;
        char c;
        public Pair(char a,int b){
            count = b;
            c = a;
        }
        
    }
    public String reorganizeString(String S) {
        //yext
        //string
        //用最大堆存Pair(字符，个数)
        //推出堆顶两个元素存入sb
        //个数减1推回堆
        //剪枝如果个数大于一半，返回空string
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
           @Override
           public int compare(Pair a,Pair b){
               return b.count-a.count;
           }

        });
        int[] map = new int[26];
        for(char c:S.toCharArray()){
            map[c-'a']++;
        }
        for(int i = 0;i < map.length;i++){
            if(map[i] != 0){
                pq.add(new Pair((char)(i+'a'),map[i]));
            }    
        }
        if(pq.peek().count > (S.length()+1)/2){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2){
            Pair a = pq.poll();
            Pair b = pq.poll();
           
            sb.append(a.c);
            sb.append(b.c);
            if(a.count-1 > 0){
                a.count--;
                pq.add(a);
            }
            if(b.count-1 > 0){
                b.count--;
                pq.add(b);
            }
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll().c);
        }
        return sb.toString();
    }
}

