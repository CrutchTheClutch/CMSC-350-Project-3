package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Filename:    P3GUI
 * Author:      William Crutchfield
 * Date:        6/27/2017
 * Description: Takes a List of Integers, or Fractions, and build a BST that is the output as a String in
 * Ascending Order, or Descending Order.
 */
public class P3GUI extends JFrame {

    // Variables
    private String list;
    private String result;

    /**
     * Constructs the GUI and handles Action Listeners
     */
    private P3GUI() {
        // Set Title
        super ("Binary Search Tree Sort");

        // Create Panels
        JPanel main = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        JPanel performPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel sortPanel = new JPanel();
        JPanel numericPanel = new JPanel();

        // Set Layout
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        performPanel.setLayout(new GridBagLayout());
        optionsPanel.setLayout(new GridLayout());
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.Y_AXIS));
        numericPanel.setLayout(new BoxLayout(numericPanel, BoxLayout.Y_AXIS));

        // Create Components
        JLabel inputLabel = new JLabel("Original List");
        JTextField inputTxt = new JTextField(null,20);
        JLabel outputLabel = new JLabel("Sorted List");
        JTextField outputTxt = new JTextField(null,20);
        JButton performBtn = new JButton("Perform Sort");
        JRadioButton ascendingRBtn = new JRadioButton("Ascending");
        JRadioButton descendingRBtn = new JRadioButton("Descending");
        JRadioButton integerRBtn = new JRadioButton("Integer");
        JRadioButton fractionRBtn = new JRadioButton("Fraction");

        // Add Input Components
        inputPanel.add(inputLabel);
        inputPanel.add(inputTxt);
        inputPanel.setPreferredSize(new Dimension(500,65));

        // Add Output Components
        outputPanel.add(outputLabel);
        outputPanel.add(outputTxt);
        outputTxt.setEditable(false);

        // Add Perform Components
        performPanel.add(performBtn);

        // Add Sort Components
        sortPanel.setBorder(BorderFactory.createTitledBorder("Sort Order"));
        sortPanel.add(ascendingRBtn);
        sortPanel.add(descendingRBtn);

        // Group Sort Buttons
        ButtonGroup sortGroup = new ButtonGroup();
        sortGroup.add(ascendingRBtn);
        sortGroup.add(descendingRBtn);

        // Add Numeric Components
        numericPanel.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
        numericPanel.add(integerRBtn);
        numericPanel.add(fractionRBtn);

        // Group Numeric Buttons
        ButtonGroup numericGroup = new ButtonGroup();
        numericGroup.add(integerRBtn);
        numericGroup.add(fractionRBtn);

        // Add Options Components
        optionsPanel.add(sortPanel);
        optionsPanel.add(numericPanel);

        // Add Panels to main
        main.add(inputPanel);
        main.add(outputPanel);
        main.add(performPanel);
        main.add(optionsPanel);

        // Add main to JFrame
        add(main);

        // JFrame Settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // Set Default Radio Buttons
        ascendingRBtn.setSelected(true);
        integerRBtn.setSelected(true);
        ascendingRBtn.doClick();
        integerRBtn.doClick();

        // "Perform" Button Handler
        performBtn.addActionListener((ActionEvent e) -> {
            list = inputTxt.getText();

            try {
                // Ensures List has a value
                if (list.isEmpty()) {
                    throw new NullPointerException();
                }

                // Tokenize String
                String[] tokens = list.split(" ");

                // Integer BST
                if (integerRBtn.isSelected()) {

                    // Creates Integer BST instance
                    BST<Integer> bst = new BST<>();

                    // Tokenize and add to BST
                    for (String token : tokens) {
                        bst.insertNode(Integer.parseInt(token));
                    }

                    // Outputs Integer BST in either Ascending or Descending Order
                    if (ascendingRBtn.isSelected()) {
                        result = bst.getAscending();
                    } else if (descendingRBtn.isSelected()) {
                        result = bst.getDescending();
                    }
                }

                // Fraction BST
                if (fractionRBtn.isSelected()) {

                    // Creates String BST instance
                    BST<Fraction> bst = new BST<>();

                    // Tokenize and add to BST
                    for (String token : tokens) {
                        Fraction fraction = new Fraction(token);
                        bst.insertNode(fraction);
                    }

                    // Outputs Fraction BST in either Ascending or Descending Order
                    if (ascendingRBtn.isSelected()) {
                        result = bst.getAscending();
                    } else if (descendingRBtn.isSelected()) {
                        result = bst.getDescending();
                    }
                }

                // Outputs result as a String
                outputTxt.setText(result);

            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(null, "A List is required.","Error",JOptionPane.ERROR_MESSAGE);
            } catch (MalformedFractionException e1) {
                JOptionPane.showMessageDialog(null, "Invalid Fraction used: " + e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Non-Numeric Input.","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new P3GUI();
    }
}
