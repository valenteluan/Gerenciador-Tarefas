package com.gerenciadortarefas.service;

import com.gerenciadortarefas.entity.tarefa.Tarefa;
import com.gerenciadortarefas.entity.tarefa.TarefaStatusEnum;
import com.gerenciadortarefas.repository.GerenciadorTarefasRepository;
import com.gerenciadortarefas.request.CadastrarTarefaRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GerenciadorTarefasService {

    @Autowired
    private GerenciadorTarefasRepository gerenciadorTarefasRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Tarefa salvarTarefa(CadastrarTarefaRequest request) {
        Tarefa tarefa = Tarefa.builder()
                .quantidadeHorasEstimadas(request.getQuantidadeHorasEstimadas())
                .status(TarefaStatusEnum.CRIADA)
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .criador(usuarioService.obeterUsuarioId(request.getCriadorId()).get())
                .build();

        return gerenciadorTarefasRepository.save(tarefa);
    }
}
