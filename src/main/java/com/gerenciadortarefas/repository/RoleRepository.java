package com.gerenciadortarefas.repository;

import com.gerenciadortarefas.entity.users.Role;
import com.gerenciadortarefas.permissoes.PermissaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNome(PermissaoEnum nome);

}
