package flightmanager;
import javax.swing.*;

public class DisplayFlightInfo extends JFrame {
    
    public DisplayFlightInfo(String flightNo, String destination, String departureTime, String arrivalTime) {
        initComponents(flightNo, destination, departureTime, arrivalTime);
    }
    
    private void initComponents(String flightNo, String destination, String departureTime, String arrivalTime) {

        JLabel flightNoLabel = new JLabel("Flight Number: " + flightNo);
        JLabel destinationLabel = new JLabel("Destination: " + destination);
        JLabel departureTimeLabel = new JLabel("Departure Time: " + departureTime);
        JLabel arrivalTimeLabel = new JLabel("Arrival Time: " + arrivalTime);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(flightNoLabel)
                .addComponent(destinationLabel)
                .addComponent(departureTimeLabel)
                .addComponent(arrivalTimeLabel))
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(flightNoLabel)
            .addComponent(destinationLabel)
            .addComponent(departureTimeLabel)
            .addComponent(arrivalTimeLabel));

        setTitle("Flight Information");
        pack();
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
