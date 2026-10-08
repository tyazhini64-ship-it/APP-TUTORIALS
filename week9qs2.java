import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class VehicleModel {
    private String registrationNumber;
    private String vehicleCategory;
    private boolean generalServiceChosen;
    private boolean oilChangeChosen;
    private boolean brakeServiceChosen;
    private boolean batteryCheckChosen;
    private double finalCost;

    public void calculateTotalCost(String regNo, String category, boolean general, boolean oil, boolean brake, boolean battery) {
        this.registrationNumber = regNo;
        this.vehicleCategory = category;
        this.generalServiceChosen = general;
        this.oilChangeChosen = oil;
        this.brakeServiceChosen = brake;
        this.batteryCheckChosen = battery;

        double calculatedSum = 0;
        if (general) calculatedSum += 1000;
        if (oil) calculatedSum += 800;
        if (brake) calculatedSum += 1200;
        if (battery) calculatedSum += 500;
        
        this.finalCost = calculatedSum;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

class VehicleView extends JFrame {
    private JTextField regField = new JTextField(15);
    private JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"Two Wheeler", "Car"});
    private JCheckBox generalBox = new JCheckBox("General Service (₹1,000)");
    private JCheckBox oilBox = new JCheckBox("Oil Change (₹800)");
    private JCheckBox brakeBox = new JCheckBox("Brake Service (₹1,200)");
    private JCheckBox batteryBox = new JCheckBox("Battery Check (₹500)");
    private JButton computeButton = new JButton("Calculate Cost");
    private JLabel costDisplayLabel = new JLabel("Total Cost: ₹0");

    public VehicleView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(8, 1, 5, 5));
        
        JPanel rowOne = new JPanel();
        rowOne.add(new JLabel("Vehicle Reg No:"));
        rowOne.add(regField);
        add(rowOne);

        JPanel rowTwo = new JPanel();
        rowTwo.add(new JLabel("Vehicle Type:"));
        rowTwo.add(typeDropdown);
        add(rowTwo);

        add(generalBox);
        add(oilBox);
        add(brakeBox);
        add(batteryBox);
        add(computeButton);
        add(costDisplayLabel);
    }

    public String getRegNumberInput() {
        return regField.getText();
    }

    public String getSelectedVehicleType() {
        return (String) typeDropdown.getSelectedItem();
    }

    public boolean isGeneralSelected() {
        return generalBox.isSelected();
    }

    public boolean isOilSelected() {
        return oilBox.isSelected();
    }

    public boolean isBrakeSelected() {
        return brakeBox.isSelected();
    }

    public boolean isBatterySelected() {
        return batteryBox.isSelected();
    }

    public void updateCostLabel(String text) {
        costDisplayLabel.setText(text);
    }

    public void addComputeListener(ActionListener listener) {
        computeButton.addActionListener(listener);
    }
}

class VehicleController {
    private VehicleModel vehicleModel;
    private VehicleView vehicleView;

    public VehicleController(VehicleModel vehicleModel, VehicleView vehicleView) {
        this.vehicleModel = vehicleModel;
        this.vehicleView = vehicleView;
        this.vehicleView.addComputeListener(e -> handleCostEstimation());
    }

    private void handleCostEstimation() {
        String regNumber = vehicleView.getRegNumberInput();
        if (regNumber.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vehicleView, "Please type in the vehicle registration number.", "Missing Field", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        vehicleModel.calculateTotalCost(
            regNumber, 
            vehicleView.getSelectedVehicleType(), 
            vehicleView.isGeneralSelected(), 
            vehicleView.isOilSelected(), 
            vehicleView.isBrakeSelected(), 
            vehicleView.isBatterySelected()
        );
        
        vehicleView.updateCostLabel("Total Service Cost: ₹" + vehicleModel.getFinalCost());
    }
}

public class week9qs2 {
    public static void main(String[] args) {
        VehicleModel model = new VehicleModel();
        VehicleView view = new VehicleView();
        new VehicleController(model, view);
        view.setVisible(true);
    }
}