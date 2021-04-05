package internalassessment;

import GameCode.Globals;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * InternalAssessment.java - runs the internal assessment project
 *
 * @author Ethan Alexander
 * @since Mar. 5, 2021,10:00:39 a.m.
 */
public class InternalAssessment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        Globals globals = new Globals();
        frame.setSize(globals.screenSize.width, globals.screenSize.height);
        int halfFrameWidth = (int) (frame.getSize().getWidth() / 2);
        int halfFrameHeight = (int) (frame.getSize().getHeight() / 2);
        frame.setLocation((int) (globals.halfWidth - halfFrameWidth),
                (int) (globals.halfHeight - halfFrameHeight));

        frame.setResizable(false);
        frame.setTitle("running simulator");
        frame.setVisible(true);

        frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
    }
}
