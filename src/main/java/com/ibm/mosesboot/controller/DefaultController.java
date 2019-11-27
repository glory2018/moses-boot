package com.ibm.mosesboot.controller;

import com.google.zxing.WriterException;
import com.ibm.mosesboot.util.rich.QRCodeGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String index() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

    @GetMapping("qrcode")
    public String qrcode() {
        return "qrcode";
    }

    @GetMapping(value = "/qrimage")
    public ResponseEntity<byte[]> getQRImage() {
        //二维码内的信息
        String info = "This is my first QR Code";
        byte[] qrcode = null;
        try {
            qrcode = QRCodeGenerator.getQRCodeImage(info, 360, 360);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
    }
}
