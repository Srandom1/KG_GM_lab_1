import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton launchButton;
    private JTextField speedEdit;
    private JTextField fpsEdit;
    private JTextField accelerationEdit;
    private JPanel contentPanel;
    private JPanel panelMain;
    private Window window;

    public MainForm() {
        this.setTitle("FrameMain");
        window = new Window();
        contentPanel = window;

        //initWindow();

        //this.add(contentPanel);
        this.setContentPane(panelMain);
        panelMain.add(contentPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fanSpeed = Double.parseDouble(speedEdit.getText());
                double acceleration = Double.parseDouble(accelerationEdit.getText());
                int fps = Integer.parseInt(fpsEdit.getText());
                window.maxCoolersSpeed = fanSpeed;
                window.acceleration = acceleration;
                window.changeFps(fps);
                window.activateButtonPressed();
            }
        });
    }

}
