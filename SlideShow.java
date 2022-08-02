



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	
	//Changed the generic placeholder variable with actual images, including sources.
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			//Peter Lauppert, CC BY-SA 3.0 AT <https://creativecommons.org/licenses/by-sa/3.0/at/deed.en>, via Wikimedia Commons
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/Resource/Austria.jpeg") + "'</body></html>";
			System.out.println(image);
		} else if (i==2){
			//Sharada Prasad CS from Berkeley, India, CC BY 2.0 <https://creativecommons.org/licenses/by/2.0>, via Wikimedia Commons
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/Resource/Himalayas.jpeg") + "'</body></html>";
		} else if (i==3){
			//Libânia Pereira from Portugal, CC BY 2.0 <https://creativecommons.org/licenses/by/2.0>, via Wikimedia Commons
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/Resource/Portugal.jpeg") + "'</body></html>";
		} else if (i==4){
			//Ximonic (Simo Räsänen), CC BY-SA 4.0 <https://creativecommons.org/licenses/by-sa/4.0>, via Wikimedia Commons
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/Resource/Spain.jpeg") + "'</body></html>";
		} else if (i==5){
			//Graham Thomson, CC BY 3.0 <https://creativecommons.org/licenses/by/3.0>, via Wikimedia Commons
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("./Resource/Thailand.jpeg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	
	//Changed verabage to use include information for every image used in previous section of code
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Altaussee, Austria sits in an idyllic location on the shores of Lake Altaussee.</font> <br>Spectacular canyon views and hiking.</body></html>";
		} else if (i==2){
			text = "<html><body>#2 The Himalayan foothills offers stunning view and the oppurtunity to heal physically and mentally./body></html>";
		} else if (i==3){
			text = "<html><body>#3 Portugal offers scenic views of the water and allows you to become one with nature.</body></html>";
		} else if (i==4){
			text = "<html><body>#4 The country of Spain offers many options to relax and heal from day to day stresses.</body></html>";
		} else if (i==5){
			text = "<html><body>#5 Thailand is a unique locale that offers a peace and tranquility seldomly found elsewhere.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}
