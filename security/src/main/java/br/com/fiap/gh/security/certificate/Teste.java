package br.com.fiap.gh.security.certificate;

import java.security.PrivateKey;

public class Teste {
    public static void main(String[] args) {

        PrivateKey key = PemUtils.loadPrivateKey("private-key.pem");
        System.out.println(key.getAlgorithm());
        System.out.println("RSA".equals(key.getAlgorithm()) ? "funcionou" : "defina a key em resources");
    }

}
