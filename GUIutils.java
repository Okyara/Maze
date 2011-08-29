import javax.swing.*;
import java.awt.event.*;
import javax.swing.JMenu;

public class GUIutils {

    /**
     * Creates a JMenu containing items listed in
     * the items array. If a character in an item name is
     * preceeded by an & character, then that character
     * becomes a short cut key for the menu item.
     */
    public static JMenu makeMenu(String name, String[] items, ActionListener al) {

        JMenu result;
        int j = name.indexOf('&');
        if (j != -1) {
            char c = name.charAt(j + 1);
            String s = name.substring(0, j) + name.substring(j + 1);
            result = new JMenu(s);
            result.setMnemonic(c);
        } else {
            result = new JMenu(name);
        }

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                result.addSeparator();
            } else {
                j = items[i].indexOf('&');
                JMenuItem item;
                if (j != -1) {
                    char c = items[i].charAt(j + 1);
                    String s = items[i].substring(0, j)
                            + items[i].substring(j + 1);
                    item = new JMenuItem(s, items[i].charAt(j + 1));
                    item.setAccelerator(
                            KeyStroke.getKeyStroke(c, InputEvent.CTRL_MASK));
                } else { // no accelerator or shortcut key
                    item = new JMenuItem(items[i]);
                }
                item.addActionListener(al);
                result.add(item);
            }
        }
        return result;
    }

    public static void error(String gripe) {
        JOptionPane.showMessageDialog(null,
                gripe,
                "OOPS!",
                JOptionPane.ERROR_MESSAGE);
    }

}//class
