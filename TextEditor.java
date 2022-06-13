/* *****************************************************************************
 *  Solution to leetCode 2296: Design a text editor
 *  For more info on this problem: https://leetcode.com/problems/design-a-text-editor/
 *  The trick to this is to keep in mind StringBuilder is far more efficient at
 *  concatenating strings than String.
 *  The other thing to keep in mind is that one does not need to track the cursor itself
 *  as part of the string, only track its index position.
 **************************************************************************** */

public class TextEditor {
    private StringBuilder curr;
    private int cursorIndex;

    public TextEditor() {
        curr = new StringBuilder();
        cursorIndex = 0;
    }

    public String getText() {
        return curr.toString();
    }

    public void addText(String text) {
        curr.insert(cursorIndex, text);
        cursorIndex += text.length();
    }

    public int deleteText(int k) {
        int deleteNow = Math.min(cursorIndex, k);
        curr.delete(cursorIndex - deleteNow, cursorIndex);
        cursorIndex -= deleteNow;
        return deleteNow;
    }

    public String cursorLeft(int k) {
        int moveNow = Math.min(cursorIndex, k);
        cursorIndex -= moveNow;
        int returnLen = Math.max(cursorIndex, 10);
        return curr.substring(returnLen - 10, cursorIndex);
    }

    public String cursorRight(int k) {
        int moveNow = Math.min(curr.length() - cursorIndex, k);
        cursorIndex += moveNow;
        int returnLen = Math.max(cursorIndex, 10);
        return curr.substring(returnLen - 10, cursorIndex);
    }

    public static void main(String[] args) {
        TextEditor obj = new TextEditor();
        obj.addText("leetcode");
        System.out.println(obj.deleteText(4));
        obj.addText("practice");
        System.out.println(obj.cursorRight(3));
        System.out.println(obj.cursorLeft(8));
        System.out.println(obj.deleteText(10));
        System.out.println(obj.cursorLeft(2));
        System.out.println(obj.cursorRight(6));
    }
}
