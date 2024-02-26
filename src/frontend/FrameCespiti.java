package itiscuneo.frontend;

import itiscuneo.backend.CespitiFile;
import itiscuneo.backend.ElencoCespiti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCespiti extends JFrame implements ActionListener
{
    private final ElencoCespiti elencoCespiti;
    private JButton btnNuovo;
    private DefaultTableModel dfmCespiti;
    private JTable tableCespiti;
    private JMenuItem menuItemJson;
    private JMenuItem menuItemCsv;


    public FrameCespiti() throws HeadlessException
    {
        super("Gestione cespiti");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //tracing(line to line, avanzamento codice) and watches(visualizzare stato oggetto)
        elencoCespiti = new ElencoCespiti();
        initComponents();
    }

    private void initComponents()
    {
        this.setLayout(new BorderLayout());

        JPanel panelTable = new JPanel();

        String[] aHeaderTableCespiti = {"codice", "quantità", "data acquisto"};
        dfmCespiti = new DefaultTableModel(aHeaderTableCespiti, 0);
        tableCespiti = new JTable(dfmCespiti);
        panelTable.add(new JScrollPane(tableCespiti));

        JPanel panelCmd = new JPanel();
        btnNuovo = new JButton("Nuovo:");
        panelCmd.add(btnNuovo);
        btnNuovo.addActionListener(this);
        panelCmd.add(btnNuovo);

        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelCmd, BorderLayout.EAST);

        JMenuBar menubar = initMenu();
        this.setJMenuBar(menubar);
    }

    private JMenuBar initMenu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuItemJson = new JMenuItem("esporta json");
        menuFile.add(menuItemJson);
        menuItemJson.addActionListener(this);

        menuItemCsv = new JMenuItem("esporta csv");
        menuFile.add(menuItemCsv);
        menuItemCsv.addActionListener(this);

        return menuBar;
    }

    public ElencoCespiti getElencoCespiti() {
        return elencoCespiti;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnNuovo)
        {
            new DialogCespiti(this).setVisible(true);

        }
        if(e.getSource()==menuItemJson)
        {


        }
        if(e.getSource()==menuItemCsv)
        {
            CespitiFile cespitiFile = new CespitiFile();
            cespitiFile.scriviCsv(this.elencoCespiti);

        }

    }

    public static void main(String[] args)
    {
        new FrameCespiti().setVisible(true);
    }
}