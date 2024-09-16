package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.CompraService;

public class EnviaCentenaGratisinha implements InvokeSubControllers {

    CentenaGratisService cgs = new CentenaGratisService();
    CompraService cs = new CompraService();

    @Override
    public String invokePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            Compra pegar = cs.obterCompra(Integer.parseInt(request.getParameter("id_compra")));
            String centenas = request.getParameter("recebe_valor");
            String msg = "";
            String valid = "";
            int qtd = 0;
            String guardar[] = new String[30];
            String vendidos[] = new String[10];
            int vcount = 0;
            if (centenas.length() > 0) {
                String todasCentenas[] = centenas.split(" ");
                if (Objects.nonNull(todasCentenas)) {
                    for (String data : todasCentenas) {
                        CentenaGratisinha centenaGratis = new CentenaGratisinha();
                        if (Objects.isNull(cgs.obterTwo(data))) {
                        centenaGratis.setNumero(data);
                        centenaGratis.setCompra(pegar);
                            cgs.enviaCentenaGratis(centenaGratis);
                            vendidos[vcount++] = data;
                        } else {
                            qtd++;
                            guardar[qtd] = data;
                        }
                    }
                }

                if (qtd > 0) {
                    String repitidas = "";
                    for (int i = 1; i <= qtd; i++) {
                        String cem = guardar[i];
                        repitidas += ", " + cem;
                    }
                    valid = "A(As) centena(s) gratisinha " + repitidas.replaceFirst(",", "") + " não esta disponível";
                } else {
                    String inserido = "";
                    for (int j = 0; j < vcount; j++) {
                        inserido += ", " + vendidos[j];
                    }
                    msg = "A(s) Centena(s) "+inserido.replaceFirst(",", "")+" gratisinha enviada com sucesso. Para "
                            + pegar.getPessoa().getNome()
                            +" do(a) "+pegar.getPessoa().getLocal().getDescricao();
                }
            }
            qtd = 0;
            vcount = 0;
            request.setAttribute("msg", msg);
            request.setAttribute("valid", valid);

            return "controller?operacao=CentenasGratis";
        } catch (Exception e) {
            System.out.println(e);
            return "controller?operacao=CentenasGratis";
        }
    }

}
