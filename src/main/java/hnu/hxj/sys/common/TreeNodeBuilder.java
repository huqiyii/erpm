package hnu.hxj.sys.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNodeBuilder {

    public static List<TreeNode> build(List<TreeNode> list, Integer topid) {
        Map<Integer, TreeNode> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode t : list) {
            map.put(t.getId(), t);
        }
        for (TreeNode t : list) {
            if (t.getPid().equals(topid)) {
                result.add(t);
            } else {
                 TreeNode temp = map.get(t.getPid());
                 if(temp!=null)
                    temp.getChildren().add(t);
            }
        }
        return result;
    }
}
