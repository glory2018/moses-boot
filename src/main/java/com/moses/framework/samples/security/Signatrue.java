package com.moses.framework.samples.security;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Set;

public class Signatrue {
    /**
     * Description
     *
     * @param value Description
     * @return value Description
     * @since 1.0
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String prefix = "Signature.";
        Provider[] pros = Security.getProviders();
        int len = pros.length;
        for (int i = 0; i < len; i++) {
            Provider p = pros[i];
            System.out
                    .println("Provider " + p.getName() + " " + p.getVersion());
            System.out.println("   Surported Signatrue algoritms:");
            Set keys = p.keySet();
            Iterator ite = keys.iterator();
            while (ite.hasNext()) {
                String name = (String) ite.next();
                if (name.startsWith(prefix)) {
                    System.out
                            .println("    " + name.substring(prefix.length()));
                }
            }// while
        }// for
    }
}
