import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;


class MosaicFrame extends JFrame implements ActionListener{
    private ArrayList<LetterTile> letterTileList;

    MosaicFrame() {
        System.out.println("MosaicFrame starting up...");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        setTitle("Mosaic");
        setDefaultLookAndFeelDecorated(true);
        setBounds(400, 10, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton randomButton = new JButton("Randomize Button");
        container.add(randomButton, BorderLayout.SOUTH);

        randomButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                for(LetterTile myTile : letterTileList) {
                    myTile.RandomProperties();
                    System.out.println("Start paint***");
                    System.out.println(myTile.toStringShape());
                    System.out.println(myTile.toStringLetter());
                    System.out.println(myTile.toStringColor());
                    System.out.println(myTile.toStringColorContrast());
                }
                repaint();
            }
        });
        
        JPanel letterTileGridPanel = new JPanel();
        container.add(letterTileGridPanel, BorderLayout.CENTER);
        letterTileGridPanel.setLayout(new GridLayout(12,12));

        letterTileList = new ArrayList<LetterTile>();
        for (int i = 1; i < 145; i++) { //should have 144 total tiles
            LetterTile myTile = new LetterTile();
            letterTileList.add(myTile);
            letterTileGridPanel.add(myTile);
            System.out.println("Start paint***");
            System.out.println(myTile.toStringShape());
            System.out.println(myTile.toStringLetter());
            System.out.println(myTile.toStringColor());
            System.out.println(myTile.toStringColorContrast());
        }
    }

    public void actionPerformed(ActionEvent e) { //can use a string to randomize shape
        for(LetterTile tile : letterTileList) {
            tile.RandomProperties();
        }
        repaint();
    }
}