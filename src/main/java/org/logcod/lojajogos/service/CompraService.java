package org.logcod.lojajogos.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Faturamento;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.repository.RepositoryCompra;

public class CompraService {

    static RepositoryCompra rc = new RepositoryCompra();
    static ApostaService as = new ApostaService();
    static MilharService ms = new MilharService();
    static ConsultasService cs = new ConsultasService();

    public int qtdTalaoInseridos() { 
        return rc.qtdTalaoInseridos();
    }

    public boolean truncarDataTables() {
        return rc.truncarDataTables();
    }

    public boolean verificarSeCompraEstaPaga(Integer key) {
        return rc.verificarSeCompraEstaPaga(key);
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelas() {
        return rc.carregarFaturamentoTotalCartelas();
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasPagasNoGeral() {
        return rc.carregarFaturamentoTotalCartelasPagasNoGeral();
    }

    public int receberPagamentoParcial(int idcompra, double valor) {
        return rc.receberPagamentoParcial(idcompra, valor);
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasParaReceber() {
        return rc.carregarFaturamentoTotalCartelasParaReceber();
    }

    public Vector<Compra> vizualizarPagamentosDoDia() {
        return rc.vizualizarPagamentosDoDia();
    }

    public LinkedHashSet<Compra> vizualizarPagamentosHoje() {
        return rc.vizualizarPagamentosHoje();
    }

    public boolean habilitarCobranca() {
        return rc.habilitarCobranca();
    }

    public Boolean alterarPessoa(int idcompra, int idpessoa) {
        return rc.alterarPessoa(idcompra, idpessoa);
    }

    public Collection<Compra> selecionarComprasPeloSeuMilharDeCadastro(String numero) {
        if (Objects.isNull(numero) || Objects.equals(numero, "")) {
            numero = "";
        }
        return rc.selecionarComprasPeloSeuMilharDeCadastro(numero);
    }

    public Compra pagarCompra(int idcompra, int chave_acesso) {
        return rc.finalizarPagamento(idcompra, chave_acesso);
    }

    public Compra obterCompra(int id) {
        return rc.obterCompra(id);
    }

    public Compra save(Compra jogo, List<Milhar> itens) {
        jogo.setValor(jogo.getValor()-jogo.getDesconto());
        return rc.save(jogo, itens);
    }

    public Compra obterCompraPorClienteId(int idCliente) {
        return rc.obterCompraPorClienteId(idCliente);
    }

    public Compra obterCompraPorClientePorMilharReferencia(String param) {
        return rc.obterCompraPorClientePorMilharReferencia(param);
    }

    public Compra get(int idCompra) {
        return rc.get(idCompra);
    }

    public Compra getPessoa(int _idCompra, int _idPessoa) {
        return rc.getPessoa(_idCompra, _idPessoa);
    }

    public boolean inserirMilharParaPessoa(int idCompra, int idPessoa, List<Milhar> milhars) {
        return rc.inserirMilharParaPessoa(idCompra, idPessoa, milhars);
    }

    public Collection<Compra> comprasAll() {
        return rc.comprasAll();
    }

    public Collection<Compra> consularCompras(int idCompra) {
        return rc.consultarCompras(idCompra);
    }

    public void deleteCompra(int idcompra) {
        rc.deleteCompra(idcompra);
    }

    public int modificarQtd(int idCompra, int qtd, double valor) {
        return rc.modificarQtd(idCompra, qtd, valor);
    }

    public void removerCompras(int idcompra) {
        rc.removerCompras(idcompra);
    }

    public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastro(String endereco) {

        return rc.selecionarComprasPeloSeuEnderecoDeCadastro(endereco);
    }
    
     public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta(String endereco) {
        return rc.selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta(endereco);
    }

    public void alterarMilharPessoa(Aposta aposta, int idmilhar) {
        rc.alterarMilharPessoa(aposta, idmilhar);

    }

    public void voltarPrecoFixo(Integer idCompra, int idPessoa) {
        rc.voltarPrecoFixo(idCompra, idPessoa);

    }

    public int ativarTodosCartelasParaVenda() {
        return rc.ativarTodosCartelasParaVenda();

    }

    public boolean ativarCobrancaCliente(int valueOf) {

        return rc.ativarCobrancaCliente(valueOf);
    }

    public String obterPrecoNormalizado(int key, double valor) {
        return rc.obterPrecoNormalizado(key, valor);
    }

    public Collection<Compra> listaEmabertoCompras() {
        return rc.listaEmabertoCompras();
    }

    public Collection<Compra> catalogodeComprasComsuasApostasEmaberto(int limit, int page) {
        return rc.catalogodeComprasComsuasApostasEmaberto(limit, page);
    }

    public double calcularValorPagamentoCurrenteDate() {
        return rc.calcularValorPagamentoCurrenteDate();
    }

    public List<Compra> joinEnderecoPessoaCompraApostaGerandoPdfEmaberto() {
        return rc.joinEnderecoPessoaCompraApostaGerandoPdfEmaberto();
    }

    public List<Compra> filtrarCompraPorFuncionario(Funcionario funcionario, Local local, String situacao) {
        List<Compra> compras = null;
        switch (situacao) {
            case "aberto":
                compras = rc.filtrarCompraPorFuncionario(funcionario, local, false);
                break;
            case "concluido":
                compras = rc.filtrarCompraPorFuncionario(funcionario, local, true);
                break;
            case "todos":
                compras = rc.filtrarTodasComprasPorFuncionario(funcionario, local);
                break;

        }
        return compras;
    }

    public List<Compra> filtrarTodasComprasPorFuncionario(Funcionario funcionario, Local local) {
        return rc.filtrarTodasComprasPorFuncionario(funcionario, local);
    }

    public List<Compra> consultarMilharClienteQtdEValor(double valor, int qtd) {
        return rc.consultarMilharClienteQtdEValor(valor, qtd);
    }

    public int encontrarQuantidadeDeTaloesDoEndereco(long id) {
        return rc.encontrarQuantidadeDeTaloesDoEndereco(id);
    }

    public List<Compra> buscarCompraClienteMobile(String data) {
        // TODO Auto-generated method stub
        return rc.buscarCompraClienteMobile(data);
    }

    public void alterarNumeroReferencia(String referencia, int idpessoa) {
        rc.alterarNumeroReferencia(referencia, idpessoa);

    }

    public double encontrarValorEmaberto(int idLocal) {
        // TODO Auto-generated method stub
        return rc.encontrarValorEmaberto(idLocal);
    }

    public double encontrarValorEmConcluido(int idLocal) {
        // TODO Auto-generated method stub
        return rc.encontrarValorEmConcluido(idLocal);
    }

    public boolean modificarQtd(int id, int qtd) {
        return rc.modificarQtd(id, qtd);
    }

    public boolean modificarValor(int parseInt, double parseDouble) {
        return rc.modificarValor(parseInt, parseDouble); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  public Set<Compra> listaDeComprasValorDiferenteQtd() {
      return rc.listaDeComprasValorDiferenteQtd();
  }

    public Object valorPerdido() {
      return rc.valorPerdido(); 
    }

    public Compra carregarCompraCliente(String parameter) {
     return rc.carregarCompraCliente(parameter);
    }

    public Compra enviar(Compra compra, LinkedHashSet<Milhar> minhaSacola) {
        ArrayList minhaNovaSacola = new ArrayList(minhaSacola);
       return rc.save(compra,  minhaNovaSacola); 
    }
    
    public LinkedHashSet<Compra> todasComprasComCentenasEhMilharDoCliente()
    {
        return rc.todasComprasComCentenasEhMilharDoCliente();
    }

    public void alterarQtdValor(Compra compra) {
       rc.alterarQtdValor(compra); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
}
