
package org.logcod.lojajogos.config.util;

import java.util.Base64;

public class ProtegerPasswordUsuario {
    
    public static String esconderSenha(String senha){
      return Base64.getEncoder().encodeToString(senha.getBytes());
    }
    
    public static String descriptografarPassword(String senha){
      return new String(Base64.getDecoder().decode(senha));
    }
    
}
