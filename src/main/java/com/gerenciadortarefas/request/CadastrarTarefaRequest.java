package com.gerenciadortarefas.request;


import com.gerenciadortarefas.entity.tarefa.TarefaStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarTarefaRequest {

    //DTO para cadastrar Tarefa

    private String titulo;
    private String descricao;
    private Long criadorId;
    private int quantidadeHorasEstimadas;

}
