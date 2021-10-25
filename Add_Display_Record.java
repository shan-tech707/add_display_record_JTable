import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Add_Display_Record extends JFrame {
    // Component Declaration
    JLabel lbl_Id,lbl_Name,lbl_Salary,lbl_Address;
    JTextField txt_Id,txt_Name,txt_Salary;
    JTextArea txtArea_Address;
    JButton btn_Add;
    JTable table_Data;
    DefaultTableModel model;
    JScrollPane scrollPane;
    Add_Display_Record(){
        // Component initialization
        lbl_Id=new JLabel("Enter the ID ");
        lbl_Name=new JLabel("Enter the Name ");
        lbl_Salary=new JLabel("Enter the Salary ");
        lbl_Address=new JLabel("Enter the Address ");
        txt_Id=new JTextField(12);
        txt_Name=new JTextField(12);
        txt_Salary=new JTextField(12);
        txtArea_Address=new JTextArea(3,12);
        txtArea_Address.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        btn_Add=new JButton("ADD");
        // JTable initialization and default table model
        table_Data=new JTable();
        model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Salary");
        model.addColumn("Address");
        table_Data.setModel(model);
        // Scroll Panel initialization and set table as view port
        scrollPane=new JScrollPane(table_Data);
        table_Data.setPreferredScrollableViewportSize(new Dimension(300,150));
        //scrollPane.setViewportView(table_Data);

        // Declaring Container and setting LayOut
        Container pane=this.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(5,5,5,5);
        // First Row
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        pane.add(lbl_Id,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=1;
        pane.add(txt_Id,gbc);
        // Second Row
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        pane.add(lbl_Name,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        pane.add(txt_Name,gbc);
        // Third Row
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        pane.add(lbl_Salary,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=1;
        pane.add(txt_Salary,gbc);
        // Forth Row
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        pane.add(lbl_Address,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=1;
        pane.add(txtArea_Address,gbc);
        // Fifth Row
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=2;
        pane.add(btn_Add,gbc);
        //  Scroll panel Table Addition in frame container
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridheight=6;
        pane.add(scrollPane,gbc);

        this.pack();
        this.setVisible(true);
        // Action
        btn_Add.addActionListener(e -> {
            if(!txt_Id.getText().equals("") && !txt_Name.getText().equals("") && !txt_Salary.getText().equals("") && !txtArea_Address.getText().equals("")) {
                String[] data = {txt_Id.getText(), txt_Name.getText(), txt_Salary.getText(), txtArea_Address.getText()};
                model.addRow(data);
                txt_Id.setText("");
                txt_Name.setText("");
                txt_Salary.setText("");
                txtArea_Address.setText("");
            }
        });

    }
    public static void main(String[] args) {
        new Add_Display_Record();
    }
}
