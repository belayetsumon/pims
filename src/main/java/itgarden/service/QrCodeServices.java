/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.barcodes.qrcode.QRCodeWriter;
import itgarden.repository.AddressInformationRepository;
import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class QrCodeServices {


    @Autowired
    AddressInformationRepository addressInformationRepository;

//    public static byte[] getQRCodeImage(String text, int width, int height) {
//        try {
//            QRCodeWriter qrCodeWriter = new QRCodeWriter();
//            
//            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//            
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            
//            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
//            
//            return byteArrayOutputStream.toByteArray();
//            
//        } catch (Exception e) {
//            return null;
//        }
//    }

}
