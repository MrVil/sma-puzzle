package com.guylplatteau.sma.puzzle.view;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Guyl Bastien on 14/01/2017.
 */

public class Puzzle {

    private JTextField nbPiecesField;
    private JTextField textField2;
    private JButton startBtn;
    private JButton stopBtn;
    private JButton pauseBtn;
    private JLabel nbPiecesLabel;
    private JPanel mainPanel;
    private JPanel toolsPanel;
    private JPanel puzzlePanel;
    private JButton nbPiecesBtnSet;
    private JButton button2;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn21;
    private JButton btn22;
    private JButton btn23;
    private JButton btn31;
    private JButton btn32;
    private JButton btn33;
    private JButton btn41;
    private JButton btn42;
    private JButton btn43;

    public static final int PUZZLE_WIDTH = 3, PUZZLE_HEIGHT = 4;

    public static void main(String[] args) {

        Puzzle puzzle = new Puzzle();
        Image image = null;
        try {
            image = puzzle.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image[][] images = puzzle.cropImage(image);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        /*for(int i = 0; i < images.length; i++)
            for(int j = 0; j < images[i].length; j++)
                puzzle.puzzlePanel.add(new PuzzlePiece(images[i][j]), c);*/

        puzzle.btn11 = new PuzzlePiece(images[0][0]);
        puzzle.btn12 = new PuzzlePiece(images[0][0]);
        puzzle.btn13 = new PuzzlePiece(images[0][0]);

        puzzle.btn21 = new PuzzlePiece(images[0][0]);
        puzzle.btn22 = new PuzzlePiece(images[0][0]);
        puzzle.btn23 = new PuzzlePiece(images[0][0]);

        puzzle.btn31 = new PuzzlePiece(images[0][0]);
        puzzle.btn32 = new PuzzlePiece(images[0][0]);
        puzzle.btn33 = new PuzzlePiece(images[0][0]);

        puzzle.btn41 = new PuzzlePiece(images[0][0]);
        puzzle.btn42 = new PuzzlePiece(images[0][0]);
        puzzle.btn43 = new PuzzlePiece(images[0][0]);



        JFrame frame = new JFrame("Puzzle");
        frame.setContentPane(new Puzzle().mainPanel);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private BufferedImage loadImage() throws IOException {
        return loadImage("icesid.jpg");
    }

    private BufferedImage loadImage(String pathname) throws IOException {
        return ImageIO.read(new File(pathname));
    }

    private Image[][] cropImage(Image image){

        int width = image.getWidth(null), height = image.getHeight(null);

        Image[][] images = new Image[PUZZLE_WIDTH][PUZZLE_HEIGHT];

        for(int i = 0; i < PUZZLE_HEIGHT; i++)
            for(int j = 0; j < PUZZLE_WIDTH; j++)
                images[j][i] = mainPanel.createImage(
                        new FilteredImageSource(
                                image.getSource(),
                                new CropImageFilter(
                                        j * width / PUZZLE_WIDTH,
                                        i * height / PUZZLE_HEIGHT,
                                        (width / PUZZLE_WIDTH),
                                        height / PUZZLE_HEIGHT
                                )
                        )
                );
        return images;
    }

}
