package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import Model.Position;

@SuppressWarnings("serial")
class Vue implements Observer {

    private final JFrame frame;
    private final JButton[][] cases;
    private final JTextField degatsRecus;
    private final JPanel tableau;
    private final JList listCartes;
    private final JList cartesAEnvoyer;
    // Panel that holds any buttons the player needs
    private final JPanel playerOptions;
    // Maps string representation of a piece to its image
    // Displays any information on the game (i.e checks, illegal moves)
    private final JTextField gameStatus;
    private final JMenuBar fileMenuBar;
    private final JMenu fileMenu;
    private final JMenuItem save;
    private final JMenuItem load;


    public Vue() {
        frame = new JFrame("RoboRally");
        tableau = new JPanel(new GridLayout(0, 8));
        fileMenuBar = new JMenuBar();
        fileMenu = new JMenu("Details de Partie");
        save = new JMenuItem("Degats de notre Robot");
        load = new JMenuItem("Nombre de Drapeaus");
        playerOptions = new JPanel();
        listCartes=new JList();
        cartesAEnvoyer=new JList();;
        setupPlayerOptions();
        degatsRecus = new JTextField("");
        gameStatus = new JTextField("");
        gameStatus.setHorizontalAlignment(JTextField.CENTER);

        cases = new JButton[8][8];
  

        addComponentsToFrame();
        configureFrame();
    }

    private void configureFrame() {
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Allows user to select a file from their computer's file menu
    private File getFileFromUser() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            return jfc.getSelectedFile();

        return null;
    }

   /* public void gameOverMessage(GameStatus status, Team team) {
       // if (status == GameStatus.STALEMATE)
            JOptionPane.showMessageDialog(null, "Game has ended in a stalemate");
        else
            JOptionPane.showMessageDialog(null, "Checkmate, " + Team.toString(Team.otherTeam(team)) + " has won");
    }

    // Updates the images displayed on the board for a move
    public void updateTile(Position position, String update) {
    	cases[position.getLigne().getIntValue()][position.getColonne()].setIcon(new ImageIcon(pieceToImage.get(update)));
    }*/

    // Remove image from a tile


    private void addComponentsToFrame() {
        frame.getContentPane().add(BorderLayout.CENTER, tableau);
        frame.getContentPane().add(BorderLayout.SOUTH, playerOptions);
        frame.getContentPane().add(BorderLayout.NORTH, gameStatus);
    }

    private void setupPlayerOptions() {
        playerOptions.add(fileMenuBar);
    }

 

    // Allows user to select pieces for a move
    /*private void addButtonBehaviour(final int row) {
        listCartes[row].addActionListener(actionEvent -> {
            updateType = UpdateType.MOVE;
            setChanged();
            notifyObservers(new Position(row, column));
            updateType = UpdateType.NONE;
        });*/
    

    // Get piece images from file
    private void readRobotImages(Image[][] robotImage) {
        int imageSize = 64;

        try {
            BufferedImage imageBuffer = ImageIO.read(new File("piece_images.png"));
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 6; j++);
                    //robotImages[i][j] = imageBuffer.getSubimage(j * imageSize, i * imageSize, imageSize, imageSize);

        } catch (IOException io) {
            System.out.println("Error with handling images");
            io.printStackTrace();
        }
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}