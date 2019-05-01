import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintAllAnagramsTogether {
    static final int NO_OF_CHARS = 26;

    static class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[NO_OF_CHARS];
        List<Integer> head;
        public TrieNode() {
            head = new LinkedList<>();
            isEnd = false;
            for (int i = 0; i < NO_OF_CHARS; i++) {
                child[i] = null;
            }
        }

    }


    static class Location {
        int x;
        int y;

        public Location() {

        }
    }

    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cell)) {
                return false;
            }

            Cell cell = (Cell) o;

            if (x != cell.x) {
                return false;
            }
            return y == cell.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String ar[]) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        List<Integer> l5 = new ArrayList<>();


        l1.add(2);
        l1.add(3);
        l1.add(4);
        l2.add(1);
        l2.add(0);
        l2.add(0);
        l3.add(1);
        l3.add(9);
        l3.add(1);
//        l4.add(1);3

//        l4.add(1);
//        l4.add(9);
//        l4.add(1);
//        l5.add(0);
//        l5.add(0);
//        l5.add(1);
//        l5.add(1);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        //list.add(l4);
        // list.add(l5);


        System.out.println(getMinimumSeconds(l1, 5, 2, 3));
    }


    static int minimumDistance(int r, int c, List<List<Integer>> a) {
        int ans = 0;
        LinkedList<Cell> queue = new LinkedList<>();
        if (a.get(0).get(0) == 0) {
            return -1;
        }
        if (a.get(0).get(0) == 9) {
            return 0;
        }
        Cell start = new Cell(0, 0);
        queue.add(start);
        //queue.add(null);
        HashSet<Cell> set = new HashSet<>();
        set.add(start);

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
//            queue.remove(0);
//
//            if (cell == null) {
//                if (!queue.isEmpty()) {
//                    queue.add(null);
//                    ans++;
//                }
//            } else {
            if (a.get(cell.x).get(cell.y) == 9) {
                return ans;
            }
            if ((cell.x + 1 < r) && !set.contains(new Cell(cell.x + 1, cell.y)) && ((a.get(cell.x + 1).get(cell.y) == 1) || (a.get(cell.x + 1).get(cell.y) == 9))) {
                Cell right = new Cell(cell.x + 1, cell.y);
                queue.add(right);
                set.add(right);
            }
            if ((cell.y + 1 < c) && !set.contains(new Cell(cell.x, cell.y + 1)) && (a.get(cell.x).get(cell.y + 1) == 1 || a.get(cell.x).get(cell.y + 1) == 9)) {
                Cell down = new Cell(cell.x, cell.y + 1);
                queue.add(down);
                set.add(down);
            }
            if ((cell.x - 1 >= 0) && !set.contains(new Cell(cell.x - 1, cell.y)) && (a.get(cell.x - 1).get(cell.y) == 1 || a.get(cell.x - 1).get(cell.y) == 9)) {
                Cell left = new Cell(cell.x - 1, cell.y);
                queue.add(left);
                set.add(left);
            }
            if ((cell.y - 1 >= 0) && !set.contains(new Cell(cell.x, cell.y - 1)) && (a.get(cell.x).get(cell.y - 1) == 1 || a.get(cell.x).get(cell.y - 1) == 9)) {
                Cell up = new Cell(cell.x, cell.y - 1);
                queue.add(up);
                set.add(up);
            }


            //  }


        }

        return ans + 1;


    }


    static int getMinimumSeconds(List<Integer> arr, int h, int u, int v) {
        Collections.sort(arr);
        int time = 0;
        int i = 0;
        int n = arr.size() - 1;
//        for(i = 0;i<n;i++){
//
//        }

        while (i <= n) {
            int sum = arr.get(i) + arr.get(n);
            if (sum < h && i != n) {
                time = time + v;
                i = i + 1;
                n = n - 1;
            } else {
                time = time + u;
                n = n - 1;
            }

        }
//            if(i == n-1){
//                if(arr.get(i) < h){
//                    time = time + u;
//                    i = i+1;
//                    continue;
//                }
//            }
//
//            int sum = arr.get(i) + arr.get(i+1);
//            if(sum < h){
//                time = time+ v;
//                i = i + 2;
//            }else{
//                time = time + u;
//                i = i+1;
//            }
//        }

        return time;

    }


    static int goldHunt(List<List<Character>> box, int k) {
        int ans = 0;
        k = k - 1;
        for (int i = 0; i < box.size(); i++) {
            for (int j = 0; j < box.get(i).size(); j++) {
                if (box.get(i).get(j) != '#') {
                    int flag = 0;
                    for (int l = i; l <= i + k; l++) {
                        if (l >= box.size() || box.get(l).get(j) == '#') {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
        }
        return ans;

    }

    interface Drawable{
        public void draw();
    }

}





