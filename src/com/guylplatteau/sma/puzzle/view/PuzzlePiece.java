package com.guylplatteau.sma.puzzle.view;

import javax.swing.*;
import java.awt.*;

public class PuzzlePiece extends JButton {

    PuzzlePiece(Image image){
        super(new ImageIcon(image));
        initUI();
    }

    private void initUI() {
        setBorder(BorderFactory.createLineBorder(Color.gray));
    }

}
