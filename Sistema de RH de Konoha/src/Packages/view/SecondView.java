package Packages.view;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Packages.bo.Habilidades;
import Packages.bo.Missao;
import Packages.bo.Ninja;
import Packages.connect.ConnectionFactory;
import Packages.controller.HabilidadesController;
import Packages.controller.MissaoController;
import Packages.controller.NinjaController;
import Packages.model.NinjaDAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.Button;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class SecondView extends JFrame {
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField textmat;
	private JTextField textname;
	private JTextField textyear;
	private JTextField textblood;
	private JTextField textrank;
	private JTextField textcod2;
	private JTextField textname2;
	private JTextField textpower;
	private JTextField textrank2;
	private JTextField textconsumo;
	private JTextField textcodmission;
	private JTextField texttipo;
	private JTextField textcliente;
	private JTextField textrank3;
	private JTextField textcomponente;
	private JTextField texttempo_missao;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondView frame = new SecondView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondView() {
		Connection con = ConnectionFactory.getConnection();
		getContentPane().setBackground(new Color(0, 100, 0));
		getContentPane().setLayout(null);
		setSize(1041, 612);
		setLocation(500, 200);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 81, 394, 363);
		getContentPane().add(tabbedPane);
		
		JPanel panelshinobi = new JPanel();
		tabbedPane.addTab("Shinobi", null, panelshinobi, null);
		panelshinobi.setLayout(null);
		
		textmat = new JTextField();
		textmat.setBounds(184, 45, 180, 30);
		panelshinobi.add(textmat);
		textmat.setColumns(10);
		
		textname = new JTextField();
		textname.setBounds(184, 86, 180, 30);
		panelshinobi.add(textname);
		textname.setColumns(10);
		
		textyear = new JTextField();
		textyear.setBounds(184, 129, 180, 30);
		panelshinobi.add(textyear);
		textyear.setColumns(10);
		
		textrank = new JTextField();
		textrank.setBounds(184, 170, 180, 30);
		panelshinobi.add(textrank);
		textrank.setColumns(10);
		
		textblood = new JTextField();
		textblood.setBounds(184, 211, 180, 30);
		panelshinobi.add(textblood);
		textblood.setColumns(10);
		
		JButton btsend = new JButton("Enviar");
        btsend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Ninja ninja = new Ninja();
                ninja.setMatricula(Integer.parseInt(textmat.getText()));
                ninja.setNome(textname.getText());
                ninja.setIdade(Integer.parseInt(textyear.getText()));
                ninja.setRanking(textrank.getText());
                ninja.setTipoSanguineo(textblood.getText());

                NinjaController ninjaInsert = new NinjaController();
                ninjaInsert.create(ninja);
            }
        });
		btsend.setBounds(298, 267, 66, 23);
		panelshinobi.add(btsend);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 106, 14);
		panelshinobi.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 94, 67, 14);
		panelshinobi.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 135, 67, 14);
		panelshinobi.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rank:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 176, 67, 14);
		panelshinobi.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Sanguineo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 217, 164, 24);
		panelshinobi.add(lblNewLabel_4);
		
		JButton btdeleteshinobi = new JButton("Delete");
		btdeleteshinobi.setBounds(184, 301, 76, 23);
        panelshinobi.add(btdeleteshinobi);
        btdeleteshinobi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Ninja ninja = new Ninja();
                ninja.setMatricula(Integer.parseInt(textmat.getText()));

                NinjaController ninjaDelete = new NinjaController();
                ninjaDelete.delete(ninja);
			}
		});
		
		JButton btupshinobi = new JButton("Update");
		btupshinobi.setBounds(184, 267, 77, 23);
		panelshinobi.add(btupshinobi);
		btupshinobi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Ninja ninja = new Ninja();
                ninja.setMatricula(Integer.parseInt(textmat.getText()));
                ninja.setNome(textname.getText());
                ninja.setIdade(Integer.parseInt(textyear.getText()));
                ninja.setRanking(textrank.getText());
                ninja.setTipoSanguineo(textblood.getText());

                NinjaController ninjaUpdate = new NinjaController();
                ninjaUpdate.update(ninja);
			}
        });
        
        JButton btselectshinobi = new JButton("Select");
		btselectshinobi.setBounds(288, 301, 78, 23);
		panelshinobi.add(btselectshinobi);
				
		JPanel panelskills = new JPanel();
		tabbedPane.addTab("Habilidades", null, panelskills, null);
		panelskills.setLayout(null);
		
		textcod2 = new JTextField();
		textcod2.setBounds(205, 45, 159, 30);
		panelskills.add(textcod2);
		textcod2.setColumns(10);
		
		textname2 = new JTextField();
		textname2.setBounds(205, 86, 159, 30);
		panelskills.add(textname2);
		textname2.setColumns(10);
		
		textpower = new JTextField();
		textpower.setToolTipText("");
		textpower.setBounds(205, 127, 159, 30);
		panelskills.add(textpower);
		textpower.setColumns(10);
		
		textrank2 = new JTextField();
		textrank2.setBounds(205, 168, 159, 30);
		panelskills.add(textrank2);
		textrank2.setColumns(10);
		
		textconsumo = new JTextField();
		textconsumo.setBounds(205, 214, 159, 30);
		panelskills.add(textconsumo);
		textconsumo.setColumns(10);
		
		JButton btsend2 = new JButton("Enviar");
        btsend2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Habilidades habilidade = new Habilidades();
                habilidade.setCodigo(Integer.parseInt(textcod2.getText()));
                habilidade.setNome(textname2.getText());
                habilidade.setPoder(Integer.parseInt(textpower.getText()));
                habilidade.setRankingHabilidade(textrank2.getText());
                habilidade.setConsumoChackra(Integer.parseInt(textconsumo.getText()));

                HabilidadesController habilidadeInsert = new HabilidadesController();
                habilidadeInsert.create(habilidade);
            }
        });
		btsend2.setBounds(292, 264, 72, 23);
		panelskills.add(btsend2);
		
		JLabel lblNewLabel_5 = new JLabel("Codigo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 46, 89, 22);
		panelskills.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nome:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(10, 94, 89, 14);
		panelskills.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Poder:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(10, 135, 72, 14);
		panelskills.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Rank:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(10, 176, 89, 14);
		panelskills.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Consumo do Chakra:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(10, 222, 197, 14);
		panelskills.add(lblNewLabel_9);
		
        JButton btnupskills = new JButton("Update");
        btnupskills.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Habilidades habilidade = new Habilidades();
                habilidade.setCodigo(Integer.parseInt(textcod2.getText()));
                habilidade.setNome(textname2.getText());
                habilidade.setPoder(Integer.parseInt(textpower.getText()));
                habilidade.setRankingHabilidade(textrank2.getText());
                habilidade.setConsumoChackra(Integer.parseInt(textconsumo.getText()));

                HabilidadesController habilidadeUpdate = new HabilidadesController();
                habilidadeUpdate.update(habilidade);
			}
		});
		btnupskills.setBounds(203, 264, 79, 23);
		panelskills.add(btnupskills);
		
        JButton btndeleteskill = new JButton("Delete");
        
		btndeleteskill.setBounds(205, 301, 77, 23);
        panelskills.add(btndeleteskill);
        
        JButton btselectskill = new JButton("Select");
		btselectskill.setBounds(292, 301, 72, 23);
		panelskills.add(btselectskill);
		
		JPanel panelmission = new JPanel();
		tabbedPane.addTab("Missão", null, panelmission, null);
		panelmission.setLayout(null);
		
		textcodmission = new JTextField();
		textcodmission.setBounds(205, 21, 159, 30);
		panelmission.add(textcodmission);
		textcodmission.setColumns(10);
		
		texttipo = new JTextField();
		texttipo.setBounds(205, 62, 159, 30);
		panelmission.add(texttipo);
		texttipo.setColumns(10);
		
		textcliente = new JTextField();
		textcliente.setBounds(205, 103, 159, 30);
		panelmission.add(textcliente);
		textcliente.setColumns(10);
		
		textrank3 = new JTextField();
		textrank3.setBounds(205, 144, 159, 30);
		panelmission.add(textrank3);
		textrank3.setColumns(10);
		
		textcomponente = new JTextField();
		textcomponente.setBounds(205, 185, 159, 30);
		panelmission.add(textcomponente);
		textcomponente.setColumns(10);
		
		JButton btsend3 = new JButton("Enviar");
        btsend3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Missao missao = new Missao();
                missao.setCodigo(Integer.parseInt(textcodmission.getText()));
                missao.setTipo(texttipo.getText());
                missao.setCliente(textcliente.getText());
                missao.setComponente(textcomponente.getText());
                 
                MissaoController missaoInsert = new MissaoController();
                missaoInsert.create(missao);
			}
		});
		btsend3.setBounds(292, 267, 72, 23);
		panelmission.add(btsend3);
		
		JLabel lblNewLabel_10 = new JLabel("Codigo:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 22, 159, 22);
		panelmission.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tipo:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_11.setBounds(10, 63, 46, 22);
		panelmission.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Cliente:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_12.setBounds(10, 104, 98, 22);
		panelmission.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Rank:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_13.setBounds(10, 145, 89, 22);
		panelmission.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Componentes:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_14.setBounds(10, 186, 159, 22);
		panelmission.add(lblNewLabel_14);
		
		JButton btnupmission = new JButton("Update");
		btnupmission.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Missao missao = new Missao();
                missao.setCodigo(Integer.parseInt(textcodmission.getText()));
                missao.setTipo(texttipo.getText());
                missao.setCliente(textcliente.getText());
                missao.setComponente(textcomponente.getText());

                MissaoController missaoUpdate = new MissaoController();
                missaoUpdate.update(missao);
			}
		});
		btnupmission.setBounds(205, 267, 78, 23);
		panelmission.add(btnupmission);
		
		JButton btndeletemission = new JButton("Delete");
		btndeletemission.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Missao missao = new Missao();
                missao.setCodigo(Integer.parseInt(textcodmission.getText()));
                missao.setComponente(textcomponente.getText());
                 
                MissaoController missaoDelete = new MissaoController();
                missaoDelete.delete(missao);
			}
		});
		btndeletemission.setBounds(205, 301, 78, 23);
        panelmission.add(btndeletemission);
        
        JButton btselectmission = new JButton("Select");
		btselectmission.setBounds(292, 301, 72, 23);
		panelmission.add(btselectmission);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 100, 536, 344);
		getContentPane().add(scrollPane);

        btselectshinobi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					String query = "SELECT * FROM db_system.NINJA";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
        btselectskill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					String query = "SELECT * FROM db_system.HABILIDADES";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
        
        btselectmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					String query = "SELECT * FROM db_system.MISSAO";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
		table = new JTable();
        scrollPane.setViewportView(table);
	}
}
