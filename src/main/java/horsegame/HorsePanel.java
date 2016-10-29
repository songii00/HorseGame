package horsegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HorsePanel extends JPanel {
	Horse[] horses;
	ImageIcon[] imageIcons;
	JLabel [] horseImages;
	CenterPanel centerPanel;
	NorthPanel northPanel;
	
	
	public HorsePanel() {
		this.setSize(Dimen.frameWidthSize, Dimen.frameHeightSize);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		horses = new Horse[Dimen.horseNumber];
		imageIcons = new ImageIcon[Dimen.horseNumber];
		horseImages = new JLabel[Dimen.horseNumber];
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel();
		
		
		add(centerPanel,BorderLayout.CENTER);
		add(northPanel,BorderLayout.NORTH);
		revalidate();
		repaint();

	}
	
	class CenterPanel extends JPanel {
		JLabel [] lines;
		public CenterPanel(){
			setLayout(null); //배치관리자 삭제 setLayout(null);
			setBackground(Color.WHITE);
			
			ImageIcon line = new ImageIcon("src/images/line.png");
			lines= new JLabel[Dimen.horseNumber];
			
			setVisible(true);
			for(int i=0;i<Dimen.horseNumber;i++){
				imageIcons[i] = new ImageIcon("src/images/horse"+i+".gif");
				horseImages[i] = new JLabel(imageIcons[i]);
				horseImages[i].setLocation(100,100+100*i);
				horseImages[i].setSize(70,50);
				
				lines[i]=new JLabel(line);
				lines[i].setSize(750,10);
				lines[i].setLocation(100,150+100*i);
				add(lines[i]);
				add(horseImages[i]);

			}
	
		}
		
		/*@Override public void paint(Graphics g)
	     {
	         Dimension d = this.getSize();

	         g.setColor(Color.BLACK);
	         g.drawLine(0,d.height/2,d.width,d.height/2);
	     }*/
		
	}//Center end
	
	class NorthPanel extends JPanel{
		public NorthPanel(){
			JLabel ment =new JLabel("dd");
			add(ment);
		}
	}//North end
	
	



}


