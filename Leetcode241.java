import java.util.ArrayList;
import java.util.List;

class Leetcode241{
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> list = new ArrayList();

        return list;
    }

    private void helper(StringBuilder exp,int l,int r,ArrayList<Integer> list){
        if(l<0 && exp.length() <= r){
            // evaluate
            return ;
        }
        if(l<0 || exp.length() <= r)return;

        

    }
}