import java.util.*;

public class LevelMostOccurrences {
    public static int getLevelWithMostOccurrences(BinNode<Integer> root, int num) {

        Deque<Integer> occurrencesPerLevel = new ArrayDeque<>();

        Deque<BinNode> nodesForCurrentLevel = new ArrayDeque<>();
        nodesForCurrentLevel.add(root);

        while (!nodesForCurrentLevel.isEmpty()){

            int currentOccurrences = 0;
            Deque<BinNode> temp = new ArrayDeque<>();

            for (BinNode node : nodesForCurrentLevel){
                if (num == (Integer) node.getData())
                    currentOccurrences++;

                if (node.getLeft() != null)
                    temp.add(node.getLeft());
                if (node.getRight() != null)
                    temp.add(node.getRight());
            }

            nodesForCurrentLevel = temp;

            occurrencesPerLevel.add(currentOccurrences);
        }

        int levelWithMostOccurrences = -1 , maxOccurrences = 0 , treeDepth = occurrencesPerLevel.size();
        for (int i=0 ; i<treeDepth ; i++){
            int currentOccurrences = occurrencesPerLevel.removeFirst();
            if (currentOccurrences > maxOccurrences){
                maxOccurrences = currentOccurrences;
                levelWithMostOccurrences = i;
            }
        }

        return levelWithMostOccurrences;
    }
}
