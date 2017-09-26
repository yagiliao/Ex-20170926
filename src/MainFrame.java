import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Button btnAdd=new Button("Start");
    private Button btnExit=new Button("Exit");
    private Label lb=new Label(">.0");
    private Timer t1;
    private int count=0,lebX=60,lebY=100,R=0,G=255,B=255;
    boolean a=true;
    public MainFrame(){
         initcomp();
    }
    private void initcomp(){
        this.setLayout(null);
        this.setBounds(100,100,500,400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        lb.setBounds(lebX,lebY,60,60);
        this.add(lb);
        btnAdd.setBounds(100,200,100,60);
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });
        btnExit.setBounds(300,200,100,60);
        this.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
         t1=new Timer(100, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(a==false){
                     G+=1;
                     B+=1;
                     lb.setForeground(new Color(R,G,B));
                     lebX-=5;
                     lb.setLocation(lebX,lebY);
                     if(lebX==60){
                         a=true;
                     }
                 }else if(a==true){
                     G-=1;
                     B-=1;
                     lb.setForeground(new Color(R,G,B));
                     lebX+=5;
                     lb.setLocation(lebX,lebY);
                     if(lebX==440){
                         a=false;
                     }
                 }
                 }
         });
    }
}
