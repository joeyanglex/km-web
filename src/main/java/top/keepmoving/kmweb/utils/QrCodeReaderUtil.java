package top.keepmoving.kmweb.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>@Author:Vince
 * <p>@Date:2018-11-22
 * <p>@Description:读取二维码内容
 */
public final class QrCodeReaderUtil {

	private QrCodeReaderUtil() {
		super();
	}

	public static String decodeQRCode(File qrCodeimage) throws IOException {
		FileInputStream qrCodeImage = new FileInputStream(qrCodeimage);
		return decodeQRCode(qrCodeImage);
	}

	public static String decodeQRCode(InputStream qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}
}
