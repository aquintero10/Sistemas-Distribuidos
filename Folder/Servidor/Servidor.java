package Servidor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;

import common.IServidor;
import common.Mensaje;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Servidor implements IServidor {
	
	@Override
	public String filtro(String imageString){
		
		BufferedImage image = null;
		byte[] imageByte;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
			 int color;
			 int width = image.getWidth();
			    int height = image.getHeight();

			    for(int y = 0; y < height; y++){
			      for(int x = 0; x < width; x++){
			        int p = image.getRGB(x,y);

			        int a = (p>>24)&0xff;
			        int r = (p>>16)&0xff;
			        int g = (p>>8)&0xff;
			        int b = p&0xff;

			        int avg = (r+g+b)/3;

			        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

			        image.setRGB(x, y, p);
			      }
			    }
	            
	            return encodeToString(image, "jpg");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "";		
	}
	
	
	public String filtro2(String imageString) {
		
		BufferedImage foto;
		foto = decodeToImage(imageString);
		 int r,g,b;
	     Color color;
		try {
			
			   for(int i=0;i<foto.getWidth();i++){
			          for(int j=0;j<foto.getHeight();j++){
			                
			                color = new Color(foto.getRGB(i, j));

			                r = color.getRed();
			                g = color.getGreen();
			                b = color.getBlue();
			                foto.setRGB(i, j, new Color(255-r,255-g,255-b).getRGB()); 
	
			          	}
			   	}
			   
			   return encodeToString(foto, "jpg");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "";
	}
}
