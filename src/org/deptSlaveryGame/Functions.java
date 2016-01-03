package org.deptSlaveryGame;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Functions {
	public static String getMD5(String s)
    {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        m.update(s.getBytes(),0,s.length());

        return new BigInteger(1,m.digest()).toString(16);
    }
}
