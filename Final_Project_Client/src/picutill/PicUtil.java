/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picutill;

/**
 *
 * @author liuch
 */
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
public class PicUtil implements Serializable {
    static JFileChooser fc;

    public static JFileChooser getFc() {
        return fc;
    }

    public static void setFc(JFileChooser fc) {
        PicUtil.fc = fc;
    }
    public static byte[] readImage(){
        InputStream is = null;
        byte[] bytes = null;
        try{
            File file = new File(fc.getSelectedFile().getAbsolutePath());
            is = new FileInputStream(file);
            long length = file.length();
            if(length > Integer.MAX_VALUE){
                JOptionPane.showMessageDialog(null,"Pic too big, select a smaller one");
                return null;
            }
            bytes = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while(offset< bytes.length&&(numRead = is.read(bytes,offset,bytes.length - offset))>=0){
                offset = offset+numRead;
            }
            if(offset < bytes.length){
                throw new IOException("Could not complete readfile"+file.getName());
                
            }
            is.close();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }finally{
            try{
                is.close();
            } catch(IOException ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        return bytes;
    }
    
    public static ImageIcon getScaledImage(String filename){
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage();
        double h = 300.0/imageIcon.getIconHeight();
        Image newimg = image.getScaledInstance((int)(imageIcon.getIconWidth()*h), (int)(imageIcon.getIconHeight()*h),java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    public static ImageIcon getImage(){
        fc = new JFileChooser();
        FileFilter jpegFilter = new ExtensionFileFilter(null,new String[]{"jPG","jPEG","PNG","GIF"});
        fc.addChoosableFileFilter(jpegFilter);
        fc.setFileFilter(jpegFilter);
        int returnVal = fc.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return getScaledImage(fc.getSelectedFile().getPath());
           
        }
        return null;
    }
    }



