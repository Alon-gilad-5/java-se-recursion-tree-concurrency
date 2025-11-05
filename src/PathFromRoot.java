public class PathFromRoot {


    /**
     * Given a string this method finds whether or not there's a path in the binTree that creates this string
     *
     * @param root - Each iteration this param represents a sub-binTree and the method checks if there's a path in this sub-binTree
     * @param str  - Represents the string that we need to find the path for.
     * @return - Returns True whether the path exists and False otherwise.
     */
    public static boolean doesPathExist(BinNode<Character> root, String str) {
        if (str == null || str.equals(""))
            return true;
        if (root == null)
            return false;
        if (root.getData() == str.charAt(0))
            str = str.substring(1,str.length());
        return doesPathExist(root.getLeft(), str) || doesPathExist(root.getRight(), str);
    }
}