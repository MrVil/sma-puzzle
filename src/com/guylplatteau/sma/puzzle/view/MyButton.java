package com.guylplatteau.sma.puzzle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyButton extends JButton {

    private boolean isLastButton;

    MyButton() {

        super();

        initUI();
    }

    MyButton(Image image) {

        super(new ImageIcon(image));

        initUI();
    }

    private void initUI() {

        isLastButton = false;
        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }

    void setLastButton() {

        isLastButton = true;
    }

    boolean isLastButton() {

        return isLastButton;
    }
}