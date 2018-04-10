package rmi;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.imageio.ImageIO;

import common.IServidor;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MainCliente {
	
	private static IServidor servidor;

	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry();
		servidor = (IServidor)registry.lookup("Servidor");
		
		BufferedImage image = ImageIO.read( new File( "imagen.jpg" ) ); 
		String imagen = encodeToString(image, "jpg");
		
		 System.out.println("SELECCIONE EL FITRO\n");
		 System.out.println("1: Filtro blanco y negro \n");
		 System.out.println("2: Filtro negativo");
		
		Scanner sc = new Scanner(System.in);
		int seleccion = sc.nextInt();
		String imgStr = "";
		String imgnombre = ""; 
	   
		if(seleccion == 1) {
			imgStr = servidor.filtro(imagen);
			imgnombre = "imgBlancoNegro.jpg";
		}
		else if(seleccion ==2) {
			imgStr = servidor.filtro2(imagen);
			imgnombre = "imgNegativo.jpg";
		}
		
	    BufferedImage img = decodeToImage(imgStr);
	        
	    File f = new File(imgnombre);
	    ImageIO.write(img, "JPEG", f);
	    
	    System.out.println("OK ... Verifique imagen en directorio del proyecto");
	    System.out.println("Presione una tecla para salir");
		System.in.read();		
			
	}
	
	static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
 
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
 
            bos.close();
     
        return imageString;
    }
	
	static BufferedImage decodeToImage(String imageString) {
		 
        BufferedImage image = null;
        byte[] imageByte;
      
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
      
        return image;
    }

}
