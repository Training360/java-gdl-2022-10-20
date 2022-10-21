package hello;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.IOException;
import java.nio.file.Path;

public class HelloService {

    /**
     * Returns a welcome message.
     *
     * @param name your name
     * @return a welcome message
     */
   public String sayHello(String name) {
       return "Hello " + name;
   }

   public void writeCodeToFile(String text, Path path) {
       try {
           var matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);
           MatrixToImageWriter.writeToPath(matrix, "png", path);
       }
       catch (WriterException | IOException e) {
           throw new IllegalStateException("Can not create qr code", e);
       }

   }
}
