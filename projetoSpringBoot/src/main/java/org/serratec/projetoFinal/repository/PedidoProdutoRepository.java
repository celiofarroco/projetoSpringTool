package org.serratec.projetoFinal.repository;

import org.serratec.projetoFinal.entidade.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {
}
