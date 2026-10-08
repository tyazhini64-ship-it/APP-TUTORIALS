import javax.swing.*;

public class week8qs6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Editor Application");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem itemNew = new JMenuItem("New");
        itemNew.addActionListener(e -> textArea.setText(""));
        
        JMenuItem itemClear = new JMenuItem("Clear");
        itemClear.addActionListener(e -> textArea.setText(""));

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));

        fileMenu.add(itemNew);
        fileMenu.add(itemClear);
        fileMenu.addSeparator();
        fileMenu.add(itemExit);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem itemCut = new JMenuItem("Cut");
        itemCut.addActionListener(e -> textArea.cut());
        
        JMenuItem itemCopy = new JMenuItem("Copy");
        itemCopy.addActionListener(e -> textArea.copy());

        JMenuItem itemPaste = new JMenuItem("Paste");
        itemPaste.addActionListener(e -> textArea.paste());

        editMenu.add(itemCut);
        editMenu.add(itemCopy);
        editMenu.add(itemPaste);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}