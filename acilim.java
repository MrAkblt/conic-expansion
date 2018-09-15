import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class acilim implements ActionListener{

    JTextField[] jtf;
    JLabel[] jlab;
    String[] str;
    JLabel[] jl_sonuc;
    String[] str_sonuc;
    JButton jbtn;
    
    public acilim(){
        str = new String[]{"Kisa Kenar:" , "Uzun Kenar" , "Yukseklik"};
        str_sonuc = new String[]{"R:", "r:","Aci:"};
        JFrame jfrm = new JFrame("Konik Acilim");
        jfrm.setSize(420,350);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jpn_main = new JPanel(new GridLayout(1,3));
        jpn_main.setPreferredSize(new Dimension(420,350));
        
        JPanel jpn1 = new JPanel();
        jpn1.setPreferredSize(new Dimension(150,300));
        JPanel jpn2 = new JPanel();
        jpn2.setPreferredSize(new Dimension(50,300));
        JPanel jpn3 = new JPanel();
        jpn3.setPreferredSize(new Dimension(220,300));
        jlab = new JLabel[3];
        jtf = new JTextField[3];
        jl_sonuc =new JLabel[3];
        for(int i=0; i<3; i++){
            jlab[i]=new JLabel(str[i].toString());
            jlab[i].setPreferredSize(new Dimension(85,20));
            jpn1.add(jlab[i]);

            jtf[i]=new JTextField();
            jtf[i].setPreferredSize(new Dimension(85,20));
            jpn2.add(jtf[i]);

            jl_sonuc[i]=new JLabel(str_sonuc[i]);
            jl_sonuc[i].setPreferredSize(new Dimension(100,20));
            jpn3.add(jl_sonuc[i]);

        }
        jbtn=new JButton("Ac");
        jbtn.addActionListener(this);
		jbtn.setActionCommand("ac");
        jpn2.add(jbtn);
        try{
            BufferedImage myPicture1 = ImageIO.read(new File("C:\\Users\\User\\Desktop\\Murat Yazilim\\acilim\\images\\conic.jpg"));
            JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
            jpn1.add(picLabel1);

            BufferedImage myPicture2 = ImageIO.read(new File("C:\\Users\\User\\Desktop\\Murat Yazilim\\acilim\\images\\acilim.jpg"));
            JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
            jpn3.add(picLabel2);
        }catch(IOException ex){}
        
        jpn_main.add(jpn1);
        jpn_main.add(jpn2);
        jpn_main.add(jpn3);
        jfrm.add(jpn_main);
        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ac")){
            double kisakenar=Double.parseDouble(jtf[0].getText());
            double uzunkenar=Double.parseDouble(jtf[1].getText());
            double yukseklik=Double.parseDouble(jtf[2].getText());

            //double koni_h=(kisakenar*yükseklik)/(uzunkenar-kisakenar)+yukseklik;
            double l=Math.sqrt(Math.pow((uzunkenar-kisakenar)/2 , 2)+Math.pow(yukseklik, 2));
            //Koninin hipotenusu, yani acilimin buyuk yaricapi R
            double r = (kisakenar*l)/(uzunkenar-kisakenar);
            //Kucuk yaricap
            double R = r+l;
            //double R = Math.sqrt(pow(kisakenar/2 , 2)+pow(koni_h , 2));
            //Çemberin kaç derecelik kesileceği
            double aci = (uzunkenar/(2*R))*360;
            //Açılmamış resmin yan yüzeyi, Açılmış resmin levha kalınlığı
            jl_sonuc[0].setText(str_sonuc[0]+String.valueOf(R));
            jl_sonuc[1].setText(str_sonuc[1]+String.valueOf(r));
            jl_sonuc[2].setText(str_sonuc[2]+String.valueOf(aci));
            
        }
    }

    public static void main(String[] args){
        new acilim();
    }
}