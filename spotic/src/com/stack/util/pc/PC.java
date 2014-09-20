package com.stack.util.pc;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.stack.util.date.DateUtil;

public class PC {

	private static String PCIP = "192.168.1.111";
	private static String PCNAME = "DengHuoLanShan";
	private static String PCMAC = "AE:C4:4C:62:11:1F:51:EF:1F:2F:A0:5D:41:29:6B:51:0B:3D:80:C4:69:A1:70:E3";

	/**
	 * @author fuzhengwei
	 * @return
	 */
	static public boolean doVerificationMac() {

		try {
			// 验证ip、name、mac
			/*
			 * if(PCIP.equals(getPCIp()) && PCNAME.equals(getPCName()) &&
			 * PCMAC.equals(getPCMac())){ return true; }
			 */
			// 验证name、mac
			/*
			 * if(PCNAME.equals(getPCName()) && PCMAC.equals(getPCMac())){
			 * return true; }
			 */

			// 验证mac
			if (PCMAC.equals(byte2hex(encryptMode(DateUtil.keyBytes, getPCMac().getBytes())))) {
				return true;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * @author fuzhengwei
	 * @return
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	static public String getPCMac() throws SocketException,
			UnknownHostException {
		byte[] mac = NetworkInterface.getByInetAddress(
				InetAddress.getLocalHost()).getHardwareAddress();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			int temp = mac[i] & 0xff;
			String str = Integer.toHexString(temp);
			if (str.length() == 1) {
				sb.append("0" + str);
			} else {
				sb.append(str);
			}
		}
		return sb.toString();
	}

	/**
	 * @author fuzhengwei
	 * @return
	 * @throws UnknownHostException
	 */
	static public String getPCIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}

	/**
	 * @author fuzhengwei
	 * @return
	 * @throws UnknownHostException
	 */
	static public String getPCName() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

	private static final String Algorithm = "DESede"; // 定义 加密算法,可用

	static public byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	static public String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
 
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }
}
