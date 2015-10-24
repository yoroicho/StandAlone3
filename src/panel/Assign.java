package panel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;

public class Assign extends JFrame {

	private JPanel contentPane;
	private JTextField textComment;
	private JTextField textLetters;
	private JComboBox<Object> cmbTitle;
	private JComboBox<Object> cmbLength;
	private JComboBox<String> cmbClassify;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assign frame = new Assign();
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
	public Assign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cmbTitle = new JComboBox<Object>();


		cmbTitle.setModel(new DefaultComboBoxModel<Object>(new String[] {""}));

		setItems();
		
		cmbTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("変更されました");
				setItems();
			}
		});
		cmbTitle.setEditable(true);
		cmbTitle.setBounds(10, 10, 412, 21);
		contentPane.add(cmbTitle);

		JButton btnEntry = new JButton("ENTRY");
		btnEntry.setBounds(10, 182, 91, 21);
		contentPane.add(btnEntry);

		JButton btnErase = new JButton("ERASE");
		btnErase.setBounds(113, 182, 91, 21);
		contentPane.add(btnErase);

		JLabel lblLen = new JLabel("LENGTH");
		lblLen.setBounds(10, 56, 69, 13);
		contentPane.add(lblLen);

		JLabel lblCLASSIFY = new JLabel("CLASSIFY");
		lblCLASSIFY.setBounds(181, 56, 69, 13);
		contentPane.add(lblCLASSIFY);

		cmbLength = new JComboBox<Object>();
		cmbLength.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		cmbLength.setBounds(78, 52, 91, 21);
		contentPane.add(cmbLength);

		textComment = new JTextField();
		textComment.setBounds(78, 151, 344, 21);
		contentPane.add(textComment);
		textComment.setColumns(10);

		textLetters = new JTextField();
		textLetters.setBounds(78, 86, 344, 21);
		contentPane.add(textLetters);
		textLetters.setColumns(10);

		cmbClassify = new JComboBox<String>();
		cmbClassify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cmbClassify.getSelectedItem().equals("Letters")){
					textLetters.setEditable(false);
				}else{
					textLetters.setEditable(true);
				}
			}
		});

		cmbClassify.setModel(new DefaultComboBoxModel<String>(new String[] {"Letters", "Alphanumeric", "Ascii", "Alphabetic", "Numeric"}));
		cmbClassify.setBounds(240, 52, 182, 21);
		contentPane.add(cmbClassify);

		JButton btnIssue = new JButton("ISSUE");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new main.Barcodes().createPdf("temp.pdf",
													cmbTitle.getSelectedItem().toString(),
													Integer.parseInt(cmbLength.getSelectedItem().toString()),
													cmbClassify.getSelectedItem().toString(),
													textLetters.getText(),
													textComment.getText());
				} catch (NumberFormatException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});
		btnIssue.setBounds(331, 182, 91, 21);
		contentPane.add(btnIssue);



		JLabel lblComment = new JLabel("COMMENT");
		lblComment.setBounds(10, 159, 69, 13);
		contentPane.add(lblComment);

		JLabel lblLetters = new JLabel("LETTERS");
		lblLetters.setBounds(10, 89, 66, 13);
		contentPane.add(lblLetters);


	}

	void setItems(){
		System.out.println();
		// 設定ファイルがあれば読み込み
				File file = new File("Properties.xml");
				if (file.exists()){
				    System.out.println("設定ファイルは存在します");
				    // 設定ファイルの読み込み
				    //DOMの準備をする
				      DocumentBuilderFactory dbf
				         = DocumentBuilderFactory.newInstance();
				      DocumentBuilder db = null;
					try {
						db = dbf.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				      //文書を読み込む
				      Document doc = null;
					try {
						doc = db.parse(new FileInputStream("Properties.xml"));
					} catch (FileNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

/*				      //文書を新規作成する
				      Document doc2 = db.newDocument();

				      //ルート要素を追加する
				      Element root = doc2.createElement("cars");
				      doc2.appendChild(root);*/

				      //要素を取り出す
				      NodeList lst = doc.getElementsByTagName("item");
				      if(cmbTitle.getSelectedItem().equals("")){
				      cmbTitle.removeAllItems();
				      cmbTitle.addItem("");
				      }
				      for(int i=0; i<lst.getLength(); i++){



				         Node n = lst.item(i);

				         if(cmbTitle.getSelectedItem().equals("")){
				        	 cmbTitle.addItem(n.getAttributes().getNamedItem("id").getNodeValue());
				         }


					if(n.getAttributes().getNamedItem("id").getNodeValue().equals(cmbTitle.getSelectedItem())){


				         for(Node ch = n.getFirstChild();
				                  ch != null;
				                  ch = ch.getNextSibling()){



				        	 System.out.println(ch.getNodeName());

				        	 System.out.println(ch.getChildNodes().item(0).getNodeValue());
				        	 if(ch.getNodeName().equals("length")){
				        		 cmbLength.setSelectedItem(ch.getChildNodes().item(0).getNodeValue());
				        	 }
				        	 if(ch.getNodeName().equals("classify")){
				        		 cmbClassify.setSelectedItem(ch.getChildNodes().item(0).getNodeValue());
				        	 }
				        	 if(ch.getNodeName().equals("letters")){
				        		 textLetters.setText(ch.getChildNodes().item(0).getNodeValue());
				        	 }
				        	 if(ch.getNodeName().equals("comment")){
				        		 textComment.setText(ch.getChildNodes().item(0).getNodeValue());
				        	 }
				         }
				        	 // 各々の子要素を取り出す
				   /*     	  NodeList subLst = ch.getChildNodes();
							for(int j=0;j<subLst.getLength();j++){


								Node sn = lst.item(i);

						         for(Node sch = sn.getFirstChild();
						                  sch != null;
						                  sch = sch.getNextSibling()){
						        	 System.out.println(sch.getUserData("length"));
						         }
				        	  }*/

				         /*   Element elm = doc2.createElement("name");
				            Text txt = doc2.createTextNode(ch.getNodeValue());
				            elm.appendChild(txt);
				            root.appendChild(elm);*/
				         }
				      }
				}else{
				    System.out.println("設定ファイルは存在しません");
				}
	}
}
