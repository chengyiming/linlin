package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Stu implements Comparable {
    public int weight;
    public  int k;
    Stu(int weight, int k) {
        this.weight = weight;
        this.k = k ;
    }
    @Override
    public int compareTo(Object o) {
        return ((Stu)o).weight - this.weight == 0 ? this.k - ((Stu)o).k : ((Stu)o).weight - this.weight;
    }
}
public class Solution5 {

    public List<Stu> sort(List<Stu> stuList) {
        Collections.sort(stuList);
        //结果
        List<Stu> result = new ArrayList<>();
        for(int i = 0; i <stuList.size(); i++) {
            result.add(stuList.get(i).k, stuList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Stu> stuList = new ArrayList<>();
        stuList.addAll(Arrays.asList(new Stu(8,0), new Stu(4,4),new Stu(8,1),
                new Stu(5,0),new Stu(6,1), new Stu(5,2)));
        Solution5 solution5 = new Solution5();
        List<Stu> sort = solution5.sort(stuList);
        System.out.println(sort);
    }
}
